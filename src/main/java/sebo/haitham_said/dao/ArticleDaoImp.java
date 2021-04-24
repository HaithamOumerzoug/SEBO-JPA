package sebo.haitham_said.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sebo.haitham_said.metier.Article;
import sebo.haitham_said.metier.Categorie;

public class ArticleDaoImp implements IArticleDao{
	
	EntityManager em = sebo.haitham_said.util.HibernateUtil.getEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticles(Long id) {
		List<Article> articles = new ArrayList<Article>();
		if(id==null) {
				articles = em.createQuery("from Article", Article.class).getResultList();		
		}else {
			Query query = em.createQuery("SELECT a FROM Article a where a.id = :codeArticle");
	          query.setParameter("codeArticle", id);
	          articles = query.getResultList();

		}
		
		return articles;
	}

	@Override
	public List<Categorie> getCategories() {
		List<Categorie> categories = new ArrayList<Categorie>();
		categories = em.createQuery("from Categorie", Categorie.class).getResultList();
		return categories;
	}

	@Override
	public Long getCatId(String cat) {
		Long cat_id=null;
		Query query = em.createQuery("SELECT c.refcat FROM Categorie c where c.cat  = :category");
		query.setParameter("category", cat);
		cat_id = (long) query.getSingleResult();
		return cat_id;
	}

	@Override
	public Article getArticle(Long CodeArticle) {
		Article article =new Article();
		Query query = em.createQuery("SELECT a FROM Article a where a.id = :codeArticle");
		query.setParameter("codeArticle", CodeArticle);
		article = (Article) query.getSingleResult();
		return article;
	}

	@Override
	public String getCat(Long id) {
		String cat_name="";
		Query query = em.createQuery("SELECT c.cat FROM Categorie c LEFT JOIN c.articles a where a.id = :codeA");
		query.setParameter("codeA", id);
		cat_name = (String) query.getSingleResult(); 
		return cat_name;
	}
	
	@Override
	public Categorie getCategory(Long id) {
		Categorie cat = new Categorie();
		try {
			Query query = em.createQuery("SELECT a.category FROM Article a WHERE a.id = :artId");
			query.setParameter("artId", id);
			cat = (Categorie) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cat;
	}
}
