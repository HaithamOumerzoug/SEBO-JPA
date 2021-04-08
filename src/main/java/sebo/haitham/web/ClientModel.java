package sebo.haitham.web;

import java.util.ArrayList;
import java.util.List;

import sebo.haitham.metier.Client;

public class ClientModel {
	private List<Client> clients = new ArrayList<Client>();

	public ClientModel() {
		super();
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
