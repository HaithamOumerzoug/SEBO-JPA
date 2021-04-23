package sebo.haitham_said.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sebo.haitham_said.metier.Client;

public class ClientDaoImp implements IClientDao{
	
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
			Query query = em.createQuery("SELECT c FROM Client c WHERE c.email = :mail AND c.motdepasse = :mdp");
			query.setParameter("mail", email);
			query.setParameter("mdp", motdepasse);
			client = (Client) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> getClients() {
		List<Client> clients = new ArrayList<Client>();
		try {
			clients = em.createQuery("from Client", Client.class).getResultList();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
	
}
