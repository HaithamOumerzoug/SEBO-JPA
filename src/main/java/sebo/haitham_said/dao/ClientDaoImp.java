package sebo.haitham_said.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sebo.haitham_said.metier.Client;

public class ClientDaoImp implements IClientDao{
	private Connection con = DbConnection.getConnection();
	EntityManager em = sebo.haitham_said.util.HibernateUtil.getEntityManager();
	
	@Override
	public Client addClient(Client client) {
		
		try {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		return client;
	}

	@Override
	public boolean emailUnique(String email) {
		try {
			Query q = em.createQuery("select c.email from Client c where c.email like :email");
			q.setParameter("email", email);
			String e =(String) q.getSingleResult();
			if(e!=null)return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean passwordCheck(String motdepasse) {
		if(motdepasse.length()<3)return false;
		return true;
	}

	@Override
	public Client identifier(String email, String motdepasse) {
		Client client=null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM clients WHERE EMAIL = ? AND MOTPASSE = ?");
			ps.setString(1, email);
			ps.setString(2, motdepasse);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				client = new Client();
				client.setId(rs.getLong("ID"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				client.setEmail(rs.getString("EMAIL"));
				client.setAdresse(rs.getString("ADRESSE"));
				client.setCodepostal(rs.getInt("CODEPOSTAL"));
				client.setAdresse(rs.getString("VILLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> getClients() {
		List<Client> clients = new ArrayList<Client>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM clients");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Client client = new Client();
				client.setId(rs.getLong("ID"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				client.setEmail(rs.getString("EMAIL"));
				client.setAdresse(rs.getString("ADRESSE"));
				client.setCodepostal(rs.getInt("CODEPOSTAL"));
				client.setAdresse(rs.getString("VILLE"));
				clients.add(client);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
	
}
