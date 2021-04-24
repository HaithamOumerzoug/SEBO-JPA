package sebo.haitham_said.dao;

import java.util.List;

import sebo.haitham_said.metier.Article;
import sebo.haitham_said.metier.Categorie;

public interface IArticleDao {
	public List<Article> getArticles(Long id);
	public Article getArticle(Long CodeArticle);
	public List<Categorie> getCategories();
	public Long getCatId(String cat);
	public String getCat(Long id);
	public Categorie getCategory(Long id);
}
