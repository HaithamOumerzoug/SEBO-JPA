package sebo.haitham.dao;

import java.util.List;

import sebo.haitham.metier.Article;
import sebo.haitham.metier.Categorie;

public interface IArticleDao {
	public List<Article> getArticles(Long id);
	public Article getArticle(Long CodeArticle);
	public List<Categorie> getCategories();
	public Long getCatId(String cat);
}
