package sebo.haitham.dao;

import java.sql.Connection;
import java.util.List;

import sebo.haitham.metier.Article;

public class ArticleDaoImp implements IArticleDao{
	private Connection con = DbConnection.getConnection();
	
	@Override
	public List<Article> getArticles() {
		
		return null;
	}

}
