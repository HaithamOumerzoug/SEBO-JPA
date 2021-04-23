package sebo.haitham_said.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.*;

import sebo.haitham_said.dao.ClientDaoImp;



public class Main {
   
	public static void main(String[] args) {
	
		
		
		/*
		 * EntityManager entMan = null; EntityManagerFactory entManFac =null; try {
		 * System.out.println("Welcome !"); entManFac =
		 * Persistence.createEntityManagerFactory("SEBO"); entMan =
		 * entManFac.createEntityManager();
		 * 
		 * } catch(Exception e) { e.printStackTrace(); }
		 */
		 
		 
		
		/*
		 * sebo.haitham_said.metier.Client client = new
		 * sebo.haitham_said.metier.Client(); client.setPrenom("SAID");
		 * client.setNom("BACHAR"); client.setEmail("said@gmail.com");
		 * client.setAdresse("hhdsbkdjfg"); client.setCodepostal(40090);
		 * client.setVille("Agadir"); client.setMotdepasse("Said");
		 */
		ClientDaoImp Adao = new ClientDaoImp(); 
		  System.out.println(Adao.emailUnique("haithaam@gmail.com"));
		
}
}
