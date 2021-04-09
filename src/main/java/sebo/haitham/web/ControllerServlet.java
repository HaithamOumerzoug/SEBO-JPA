package sebo.haitham.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sebo.haitham.dao.ArticleDaoImp;
import sebo.haitham.dao.ClientDaoImp;
import sebo.haitham.dao.DbConnection;
import sebo.haitham.dao.IArticleDao;
import sebo.haitham.dao.IClientDao;
import sebo.haitham.metier.Article;
import sebo.haitham.metier.Client;

public class ControllerServlet extends HttpServlet{
	private IClientDao metier; 
	private IArticleDao article_metier; 
	private Map<String,String> erreurs;
	@Override
	public void init() throws ServletException {
		metier=new ClientDaoImp();
		article_metier=new ArticleDaoImp();
		erreurs = new HashMap<String, String>();
		erreurs.put("nom","");
		erreurs.put("prenom","");
		erreurs.put("email","");
		erreurs.put("general","");
		erreurs.put("motdepasse","");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			case "/index.sebo": {
				HttpSession session = req.getSession();
				Enumeration clients = session.getAttributeNames();
				if(clients.hasMoreElements()) {
					res.sendRedirect("accueil.sebo");
				}else {
					req.getRequestDispatcher("index.jsp").forward(req, res);
				}
				break;
			}
			case "/identifier.sebo": {
				HttpSession session = req.getSession();
				Enumeration clients = session.getAttributeNames();
				if(clients.hasMoreElements()) {
					res.sendRedirect("accueil.sebo");
				}else {
					erreurs.replace("nom","");
					erreurs.replace("prenom","");
					erreurs.replace("email","");
					erreurs.replace("motdepasse","");
					erreurs.replace("general","");
					req.setAttribute("erreurs", erreurs);
					req.getRequestDispatcher("identifier.jsp").forward(req, res);
				}
				break;
			}
			case "/inscrire.sebo": {
				HttpSession session = req.getSession();
				Enumeration clients = session.getAttributeNames();
				if(clients.hasMoreElements()) {
					res.sendRedirect("accueil.sebo");
				}else {
					//Vider les erreurs si le client refreche la page
					erreurs.replace("nom","");
					erreurs.replace("prenom","");
					erreurs.replace("email","");
					erreurs.replace("motdepasse","");
					req.setAttribute("erreurs", erreurs);
					req.setAttribute("client", new Client());
					req.getRequestDispatcher("inscrire.jsp").forward(req, res);
				}
				break;
			}
			case "/accueil.sebo": {
				HttpSession session = req.getSession();
				Enumeration clients = session.getAttributeNames();
				if(!clients.hasMoreElements()) {
					res.sendRedirect("index.sebo");
				}else {
					while(clients.hasMoreElements()) {
						String client = (String) clients.nextElement();
						String value = session.getAttribute(client).toString();
						req.setAttribute(client, value);
					}
				req.getRequestDispatcher("accueil.jsp").forward(req, res);
				}
				
				break;
			}
			case "/decx.sebo": {
				HttpSession session = req.getSession();
				session.invalidate();
				req.getSession(false);
				res.sendRedirect("index.sebo");
				
				break;
			}
			case "/catalogue.sebo": {
				ArticleModel model=new ArticleModel();
				CategorieModel cat_model = new CategorieModel();
				model.setArticles(article_metier.getArticles(null));
				cat_model.setCategories(article_metier.getCategories());
				req.setAttribute("model", model);
				req.setAttribute("cat_model", cat_model);
				req.getRequestDispatcher("catalogue.jsp").forward(req, res);
				break;
			}
			case "/detail.sebo": {
				Long CodeArticle = Long.parseLong(req.getParameter("CodeArticle"));
				System.out.println(CodeArticle);
				Article article =article_metier.getArticle(CodeArticle);
				req.setAttribute("article", article);
				req.getRequestDispatcher("detail.jsp").forward(req, res);
				break;
			}
			default:
				req.getRequestDispatcher("NotFound.jsp").forward(req, res);
			}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if(path.equals("/inscrire.sebo")) {
			//Vider les erreurs
			erreurs.replace("nom","");
			erreurs.replace("prenom","");
			erreurs.replace("email","");
			erreurs.replace("motdepasse","");
			
			//Recuperer les params
			String nom=req.getParameter("nom");
			String prenom=req.getParameter("prenom");
			String email=req.getParameter("email");
			String adresse=req.getParameter("adresse");
			int codepostal=req.getParameter("codepostal").equals("")?0:Integer.parseInt(req.getParameter("codepostal"));
			String ville=req.getParameter("ville");
			String motdepasse=req.getParameter("motdepasse");
			Client client = new Client(nom, prenom, email, adresse, codepostal, ville, motdepasse);
			
			//Si l'un des champs est vide
			if(email.equals("") || motdepasse.equals("") || nom.equals("") || prenom.equals("")) {
				if(nom.equals("")) 
					erreurs.put("nom", "Nom obligatoire!");
				if(prenom.equals("")) 
					erreurs.put("prenom", "Prénom obligatoire!");
				if(email.equals(""))
					erreurs.put("email", "E-mail obligatoire!");
				if(motdepasse.equals(""))
					erreurs.put("motdepasse", "Mot de passe obligatoire!");
				
				req.setAttribute("client", client);//Garder les champs saisie
				req.setAttribute("erreurs", erreurs);
				req.getRequestDispatcher("inscrire.jsp").forward(req, res);
				
			}else {
				if(!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) erreurs.put("email", "E-mail erroné!");
				else {
					if(metier.emailUnique(email) || !metier.passwordCheck(motdepasse)) {
						//Si email est déjà existe dans la BD
						if(metier.emailUnique(email)) erreurs.put("email", "E-mail déja existe!");
						//Si le mot de passe est incorrect
						if(!metier.passwordCheck(motdepasse)) erreurs.put("motdepasse", "Mot de passe doit être supérieur à 3 caractères!");
						
						req.setAttribute("client", client);
						req.setAttribute("erreurs", erreurs);
						req.getRequestDispatcher("inscrire.jsp").forward(req, res);
					}else {
						//Ajouter le client dans la BD
						client = metier.addClient(client);
						
						//Créer la session
						HttpSession session = req.getSession();
						session.setAttribute("client_name", nom+" "+prenom);
						session.setAttribute("client_nameid", client.getId());
						//Redirection vers la acceuil
						res.sendRedirect("accueil.sebo");
					}	
					
				}
					
			}
		}
		else if(path.equals("/identifier.sebo")) {
			String email=req.getParameter("email");
			String motdepasse=req.getParameter("motdepasse");
			Client client = metier.identifier(email, motdepasse);
			
			//Vider les erreurs
			erreurs.replace("general","");
			erreurs.replace("email","");
			erreurs.replace("motdepasse","");
			
			if(email.equals("") || motdepasse.equals("")) {
				if(email.equals(""))
					erreurs.put("email", "E-mail obligatoire!");
				if(motdepasse.equals(""))
					erreurs.put("motdepasse", "Mot de passe obligatoire!");
				
				//req.setAttribute("client", client);//Garder les champs saisie
				req.setAttribute("erreurs", erreurs);
				req.setAttribute("email", email);
				req.getRequestDispatcher("identifier.jsp").forward(req, res);
			}
			else {
				if(client!=null) {
					HttpSession session = req.getSession();
					session.setAttribute("client_name", client.getNom()+" "+client.getPrenom());
					session.setAttribute("client_id", client.getId());
					res.sendRedirect("accueil.sebo");
				}else {
					erreurs.put("general","E-mail ou mot de passe est invalide!");
					req.setAttribute("erreurs", erreurs);
					req.setAttribute("email", email);
					req.getRequestDispatcher("identifier.jsp").forward(req, res);
				}
			}
			
		}else if(path.equals("/catalogue.sebo")) {
			String cat_name=req.getParameter("categorie");
			Long cat_id=article_metier.getCatId(cat_name);
			
			ArticleModel model=new ArticleModel();
			CategorieModel cat_model = new CategorieModel();
			
			model.setArticles(article_metier.getArticles(cat_id));
			cat_model.setCategories(article_metier.getCategories());
			
			req.setAttribute("model", model);
			req.setAttribute("cat_model", cat_model);
			req.setAttribute("old_value", cat_name);
			req.getRequestDispatcher("catalogue.jsp").forward(req, res);
		}
	}	
}
