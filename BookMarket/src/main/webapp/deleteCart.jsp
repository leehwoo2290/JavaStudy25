<%@page import="dao.CartDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@ include file="dbconn.jsp" %>

<%
	String id = request.getParameter("cartId");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("cart.jsp");
		return;
	}
	
	/* PreparedStatement pstmt = null;
	try {
		
		String sql = "delete from cart where c_accountId=?";	
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, (String)session.getAttribute("sessionId"));
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
	}  */
	CartDAO dao = CartDAO.getInstance();
	dao.deleteCart((String)session.getAttribute("sessionId"));
	/* session.invalidate(); */
	response.sendRedirect("cart.jsp");
%>

