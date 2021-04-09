package sebo.haitham.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sebo.haitham.metier.Article;
import sebo.haitham.metier.Categorie;

public class ArticleDaoImp implements IArticleDao{
	private Connection con = DbConnection.getConnection();
	
	@Override
	public List<Article> getArticles(Long id) {
		List<Article> articles = new ArrayList<Article>();
		if(id==null) {
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
		}else {
			try {
				PreparedStatement ps =con.prepareStatement("SELECT * FROM ARTICLES WHERE CATEGORIE=?");
				ps.setLong(1, id);
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
		}
		
		return articles;
	}

	@Override
	public List<Categorie> getCategories() {
		List<Categorie> categories = new ArrayList<Categorie>();
		try {
			PreparedStatement ps =con.prepareStatement("SELECT * FROM CATEGORIES");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Categorie categorie = new Categorie(rs.getString("CAT"));
				categorie.setRefCat(rs.getLong("RefCat"));
				categories.add(categorie);
			}
			ps.close();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return categories;
	}

	@Override
	public Long getCatId(String cat) {
		Long cat_id=null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT RefCat FROM Categories WHERE Cat=?");
			ps.setString(1, cat);
			ResultSet rs=ps.executeQuery();
			if(rs.next())cat_id=rs.getLong("RefCat");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat_id;
	}

	@Override
	public Article getArticle(Long CodeArticle) {
		Article article =new Article();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ARTICLES WHERE CodeArticle=?");
			ps.setLong(1, CodeArticle);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				article.setId(rs.getLong("CodeArticle"));
				article.setDesignation(rs.getString("DESIGNATION"));
				article.setPrix(rs.getDouble("PRIX"));
				article.setStock(rs.getInt("STOCK"));
				article.setId_cat(rs.getLong("CATEGORIE"));
				article.setPhoto(rs.getString("PHOTO"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}
}
