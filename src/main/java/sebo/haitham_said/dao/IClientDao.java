package sebo.haitham_said.dao;

import java.util.List;

import sebo.haitham_said.metier.Client;

public interface IClientDao {
	public Client addClient(Client client);
	public boolean emailUnique(String email);
	public boolean passwordCheck(String password);
	public Client identifier(String email,String motdepasse);
	
	//Test
	public List<Client> getClients();
}
