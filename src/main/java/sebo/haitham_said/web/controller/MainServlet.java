package sebo.haitham_said.web.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String path = req.getServletPath();
		switch (path) {
			case "/index": {
				HttpSession session = req.getSession();
				Long id =(Long)session.getAttribute("client_id");
				//Enumeration clients = session.getAttributeNames();
				if(id!=null) {
					res.sendRedirect(req.getContextPath()+"/accueil");
					
				}else {
					
					req.getRequestDispatcher("index.jsp").forward(req, res);
				}
				break;
			}
			
			case "/accueil": {
				HttpSession session = req.getSession();
				Enumeration clients = session.getAttributeNames();
				Long id =(Long)session.getAttribute("client_id");
				if(id==null) {
					res.sendRedirect(req.getContextPath()+"/index");
				}else {
					while(clients.hasMoreElements()) {
						String client = (String) clients.nextElement();
						if(client.equals("client_id") || client.equals("client_name")) {
							String value = session.getAttribute(client).toString();
							req.setAttribute(client, value);
						}
					}
				req.getRequestDispatcher("accueil.jsp").forward(req, res);
				}
				
				break;
			}
			
			default:
				req.getRequestDispatcher("NotFound.jsp").forward(req, res);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("client_id");
		session.removeAttribute("client_name");
		res.sendRedirect(req.getContextPath()+"/index");
	}

}
