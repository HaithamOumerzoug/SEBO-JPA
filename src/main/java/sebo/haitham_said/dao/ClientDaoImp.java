package sebo.haitham_said.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sebo.haitham_said.metier.Client;

public class ClientDaoImp implements IClientDao{
	private Connection con = DbConnection.getConnection();
	
	@Override
	public Client addClient(Client client) {
		try {
			PreparedStatement ps = con.prepareStatement
					("INSERT INTO CLIENTS(NOM,PRENOM,EMAIL,ADRESSE,CODEPOSTAL,VILLE,TEL,MOTPASSE) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, client.getNom());
			ps.setString(2,client.getPrenom() );
			ps.setString(3,client.getEmail());
			ps.setString(4,client.getAdresse());
			ps.setInt(5,client.getCodepostal());
			ps.setString(6,client.getVille());
			ps.setString(7,client.getTel());
			ps.setString(8,client.getMotdepasse());
			ps.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement("SELECT MAX(ID) AS ID FROM CLIENTS");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()){
				client.setId(rs.getLong("ID"));
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}

	@Override
	public boolean emailUnique(String email) {
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM CLIENTS WHERE EMAIL LIKE ?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) return true;
		} catch (SQLException e) {
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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTS WHERE EMAIL = ? AND MOTPASSE = ?");
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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTS");
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
