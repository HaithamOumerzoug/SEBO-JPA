package sebo.haitham_said.web.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sebo.haitham_said.dao.ArticleDaoImp;
import sebo.haitham_said.dao.IArticleDao;
import sebo.haitham_said.metier.Article;
import sebo.haitham_said.web.models.ArticleModel;
import sebo.haitham_said.web.models.CategorieModel;

/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet("/CatalogueServlet")
public class CatalogueServlet extends HttpServlet {
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
		String path = req.getServletPath();
		switch (path) {
		case "/catalogue": {
			if(session.getAttribute("client_id")==null)res.sendRedirect(req.getContextPath()+"/");
			else{
				ArticleModel model=new ArticleModel();
				CategorieModel cat_model = new CategorieModel();
				model.setArticles(article_metier.getArticles(null));
				cat_model.setCategories(article_metier.getCategories());
				req.setAttribute("model", model);
				req.setAttribute("cat_model", cat_model);
				req.getRequestDispatcher("catalogue.jsp").forward(req, res);
			}
			break;
		}
		case "/detail": {
			if(session.getAttribute("client_id")==null)res.sendRedirect(req.getContextPath()+"/");
			else {
				Long CodeArticle = Long.parseLong(req.getParameter("CodeArticle"));
				Article article =article_metier.getArticle(CodeArticle);
				req.setAttribute("article", article);
				req.getRequestDispatcher("detail.jsp").forward(req, res);
			}
			break;
		}
		default:
			req.getRequestDispatcher("NotFound.jsp").forward(req, res);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
