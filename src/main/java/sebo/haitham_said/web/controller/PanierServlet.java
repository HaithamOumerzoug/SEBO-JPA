package sebo.haitham_said.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sebo.haitham_said.dao.ArticleDaoImp;
import sebo.haitham_said.dao.IArticleDao;
import sebo.haitham_said.metier.Article;

/**
 * Servlet implementation class PanelServlet
 */
@WebServlet("/PanelServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IArticleDao article_metier;
    
	public void init() throws ServletException {
		article_metier=new ArticleDaoImp();
	}
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("client_id")==null) res.sendRedirect(req.getContextPath()+"/");
		else {Article article = (Article)session.getAttribute("article");
		req.setAttribute("article", article);
		req.getRequestDispatcher("panier.jsp").forward(req, res);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long CodeArticle = Long.parseLong(req.getParameter("CodeArticle"));
		HttpSession session = req.getSession();
		if(session.getAttribute("client_id")==null) res.sendRedirect(req.getContextPath()+"/");
		else {
			Article article =article_metier.getArticle(CodeArticle);
			session.setAttribute("article", article);
			res.sendRedirect(req.getContextPath()+"/detail?CodeArticle="+CodeArticle);
		}
	}

}
