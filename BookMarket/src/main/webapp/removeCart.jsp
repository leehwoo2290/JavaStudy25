<%@page import="dao.CartDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@ include file="dbconn.jsp" %>

<%
	String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("books.jsp");
		return;
	}

	/* BookRepository dao = BookRepository.getInstance();
	
	Book book = dao.getBookById(id);
	if (book == null) {
		response.sendRedirect("exceptionNoBookId.jsp");
	}
	
	PreparedStatement pstmt = null;
	try {
		
		String sql = "delete from cart where c_accountId=? and c_bookId=?";	
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, (String)session.getAttribute("sessionId"));
		pstmt.setString(2, id);
		pstmt.executeUpdate();

	} catch (Exception ex) {
		System.out.println("deleteBoard()  : " + ex);
	} finally {
		try {										
			if (pstmt != null) 
				pstmt.close();				
			if (conn != null) 
				conn.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}		
	} */
	
	CartDAO dao = CartDAO.getInstance();
	dao.removeCart((String)session.getAttribute("sessionId"), id);
	response.sendRedirect("cart.jsp");
%>
ml>