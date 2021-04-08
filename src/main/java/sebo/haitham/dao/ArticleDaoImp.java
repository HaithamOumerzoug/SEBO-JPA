package sebo.haitham.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sebo.haitham.metier.Article;

public class ArticleDaoImp implements IArticleDao{
	private Connection con = DbConnection.getConnection();
	
	@Override
	public List<Article> getArticles() {
		List<Article> articles = new ArrayList<Article>();
		try {
			PreparedStatement ps =con.prepareStatement("SELECT * FROM ARTICLES");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Article article= new Article(rs.getString("DESIGNATION"),rs.getDouble("PRIX"),rs.getInt("STOCK"),rs.getLong("CATEGORIE"),rs.getString("PHOTO"));
				article.setId(rs.getLong("CodeArticle"));
				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articles;
	}

}
