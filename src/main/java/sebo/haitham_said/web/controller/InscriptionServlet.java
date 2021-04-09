package sebo.haitham_said.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sebo.haitham_said.dao.ArticleDaoImp;
import sebo.haitham_said.dao.ClientDaoImp;
import sebo.haitham_said.dao.IArticleDao;
import sebo.haitham_said.dao.IClientDao;
import sebo.haitham_said.metier.Client;

public class InscriptionServlet extends HttpServlet{
	private IClientDao metier; 
	private Map<String,String> erreurs;
	@Override
	public void init() throws ServletException {
		metier=new ClientDaoImp();
		erreurs = new HashMap<String, String>();
		erreurs.put("nom","");
		erreurs.put("prenom","");
		erreurs.put("email","");
		erreurs.put("general","");
		erreurs.put("motdepasse","");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//Enumeration clients = session.getAttributeNames();
		Long id =(Long)session.getAttribute("client_id");
		if(id!=null) {
			res.sendRedirect(req.getContextPath()+"/accueil");
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
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
					res.sendRedirect(req.getContextPath()+"/accueil");
				}	
				
			}
				
		}
	}
}