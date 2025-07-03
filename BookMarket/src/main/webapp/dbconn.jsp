<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%> 
<%
	Connection conn = null;	

	try { //오류가 나올 확률 있을때 예외처리
		String url = "jdbc:mysql://192.168.111.101:3306/bookmarketdb";
		String user = "mbcBook";
		String password = "mbc1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		
		//jdbc 1,2단계 연결용
		
	} catch (SQLException ex) {
		out.println("데이터베이스 연결이 실패되었습니다.<br>");
		out.println("SQLException: " + ex.getMessage());
	}
		
%>