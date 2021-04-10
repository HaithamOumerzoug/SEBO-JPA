package sebo.haitham_said.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sebo.haitham_said.dao.ArticleDaoImp;
import sebo.haitham_said.dao.IArticleDao;
import sebo.haitham_said.metier.Article;


@WebServlet("/PanelServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IArticleDao article_metier;
    
	public void init() throws ServletException {
		article_metier=new ArticleDaoImp();
	}
       
    

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("client_id")==null) res.sendRedirect(req.getContextPath()+"/index");
		else {
			List<Article> articles = new ArrayList<Article>();
			Enumeration<String> keys=session.getAttributeNames();
			while(keys.hasMoreElements()) {
				String key = (String)keys.nextElement();
				if(key.startsWith("article_")) {	
					Article article =(Article) session.getAttribute(key);
					articles.add(article);
				}
			}
			req.setAttribute("articles", articles);
			req.getRequestDispatcher("panier.jsp").forward(req, res);}
		}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long CodeArticle = Long.parseLong(req.getParameter("CodeArticle"));
		HttpSession session = req.getSession();
		if(session.getAttribute("client_id")==null) res.sendRedirect(req.getContextPath()+"/index");
		else {
			Article article =article_metier.getArticle(CodeArticle);
			session.setAttribute("article_"+CodeArticle, article);
			//Redirect to catalogue
			res.sendRedirect(req.getContextPath()+"/catalogue");
		}
	}

}
