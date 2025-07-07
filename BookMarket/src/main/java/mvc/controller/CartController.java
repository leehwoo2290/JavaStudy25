package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.CartDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final int LISTCOUNT = 5; 

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
	
		if (command.equals("/CartAddAction.cart")) {//카트에 물품 추가
			requestCartAddAction(request, response);

		} else if (command.equals("/CartRemoveAction.cart")) { //물품 하나 제거
				requestCartRemove(request);
				response.sendRedirect("cart.jsp");			
		} else if (command.equals("/CartDeleteAction.cart")) {//물품 전체 제거
				requestCartDelete(request);
				response.sendRedirect("cart.jsp");					
		}
	}

	private void requestCartDelete(HttpServletRequest request) {

		String accountId = request.getParameter("accountid");
		
		CartDAO dao = CartDAO.getInstance();
		dao.deleteCart(accountId);
	}

	private void requestCartRemove(HttpServletRequest request) {

		String accountId = request.getParameter("accountid");
		String bookId = request.getParameter("bookid");
		
		CartDAO dao = CartDAO.getInstance();
		dao.removeCart(accountId, bookId);	
	}

	private void requestCartAddAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String accountId = request.getParameter("accountid");
		String bookId = request.getParameter("bookid");
		CartDAO dao = CartDAO.getInstance();
		System.out.println("requestCartAddActionrequestCartAddAction:" + accountId + "|| " + bookId);
		dao.addToCart(accountId, bookId);
		response.sendRedirect("book.jsp?id=" + bookId);	
	}
	
}
