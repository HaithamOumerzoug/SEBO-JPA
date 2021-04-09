package sebo.haitham_said.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sebo.haitham_said.dao.ArticleDaoImp;
import sebo.haitham_said.dao.ClientDaoImp;
import sebo.haitham_said.dao.IArticleDao;
import sebo.haitham_said.dao.IClientDao;
import sebo.haitham_said.metier.Client;

/**
 * Servlet implementation class IdentificationServlet
 */
@WebServlet("/IdentificationServlet")
public class IdentificationServlet extends HttpServlet {
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
	
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//Enumeration clients = session.getAttributeNames();
		Long id =(Long)session.getAttribute("client_id");
		if(id!=null) {
			res.sendRedirect(req.getContextPath()+"/accueil");
		}else {
			erreurs.replace("nom","");
			erreurs.replace("prenom","");
			erreurs.replace("email","");
			erreurs.replace("motdepasse","");
			erreurs.replace("general","");
			req.setAttribute("erreurs", erreurs);
			req.getRequestDispatcher("identifier.jsp").forward(req, res);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
				res.sendRedirect(req.getContextPath()+"/accueil");
			}else {
				erreurs.put("general","E-mail ou mot de passe est invalide!");
				req.setAttribute("erreurs", erreurs);
				req.setAttribute("email", email);
				req.getRequestDispatcher("identifier.jsp").forward(req, res);
			}
		}
	}

}
