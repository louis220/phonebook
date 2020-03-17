package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phonebook.dao.PhoneBookDAO;
import phonebook.dao.PhoneBookDAOImpl;
import phonebook.vo.PhoneBookVO;


@WebServlet("/")
public class HomeServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		if ("form".equals(action)) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/users/form.jsp");
				rd.forward(req, resp);
		} else if ("search".equals(action)) {
			
			String name = req.getParameter("name");
			PhoneBookDAO dao= new PhoneBookDAOImpl();
			List<PhoneBookVO> phone_book = dao.getSearchList(name);
			req.setAttribute("phone_book", phone_book);
	        RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/home.jsp");
	        rd.forward(req, resp);
			
		} else {
			PhoneBookDAO dao= new PhoneBookDAOImpl();
			List<PhoneBookVO> phone_book = dao.getList();
			req.setAttribute("phone_book", phone_book);
			RequestDispatcher rd = getServletContext()
				.getRequestDispatcher("/WEB-INF/views/home.jsp");
			rd.forward(req, resp);
		}
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		if("insert".equals(action)) {
	         String name = req.getParameter("name");
	         String hp = req.getParameter("hp");
	         String tel = req.getParameter("tel");
	         
	         PhoneBookVO vo = new PhoneBookVO(name, hp, tel);
	         PhoneBookDAO dao = new PhoneBookDAOImpl();
	         
	         boolean isSuccess = dao.insert(vo);

			if (isSuccess) {resp.sendRedirect(req.getContextPath()+"/");
			}
		} else if ("delete".equals(action)) {
			String id = req.getParameter("id"); 
			PhoneBookDAO dao= new PhoneBookDAOImpl();
			boolean isSuccess = dao.delete(Long.valueOf(id));

			if (isSuccess) {
				resp.sendRedirect(req.getContextPath()+"/");
			}
		} else{

	            resp.sendRedirect("/");

	        }
			   
	
			
			
			
			
		}
	
	}	
	

