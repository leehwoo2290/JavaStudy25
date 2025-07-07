<%@page import="dao.CartDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ include file="dbconn.jsp" %>

<%

/* 	request.setCharacterEncoding("UTF-8"); // post 메서드 한글 지원 필수코드

	// 파일업로드 처리용 코드 추가
	String filename="";
	String realFolder=application.getRealPath("/resources/images"); // 톰켓이 관리하는 실제경로
						 // http://192.168.111.101:8080/BookMarket
	int maxSize = 5 * 1024 * 1024 ; // 5메가까지 저장
	String encType = "utf-8";		// 파일명이 한글일수 있음.
		
	MultipartRequest multipartRequest = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	// 만약 오류발생시 cos.jar 버전 확인 -> 마이그레이션 cos_2.jar 삽입
	// enctype="multipart/form-data" 하면 request영역이 아닌 multipartRequest으로 전달됨.
	
	// String bookId = request.getParameter("bookId"); -> multipartRequest로 변경함!!! 중요!!!
	String c_accountId = multipartRequest.getParameter("c_accountId");
	String c_bookId = multipartRequest.getParameter("c_bookId");
	String c_unitPrice = multipartRequest.getParameter("c_unitPrice");
	String c_amount = multipartRequest.getParameter("c_amount");
	 */
	 
	/* String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("products.jsp");
		return;
	}
	
	BookRepository dao = BookRepository.getInstance();

	Book product = dao.getBookById(id);
	if (product == null) {
		response.sendRedirect("exceptionNoBookId.jsp");
	}

	ArrayList<Book> goodsList = dao.getAllBooks();
	Book goods = new Book();
	for (int i = 0; i < goodsList.size(); i++) {
		goods = goodsList.get(i);
		if (goods.getBookId().equals(id)) { 			
			break;
		}
	}
	
	ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("cartlist");
	if (list == null) { 
		list = new ArrayList<Book>();
		session.setAttribute("cartlist", list);
	}

	int cnt = 0;
	Book goodsQnt = new Book();
	for (int i = 0; i < list.size(); i++) {
		goodsQnt = list.get(i);
		if (goodsQnt.getBookId().equals(id)) {
			cnt++;
			int orderQuantity = goodsQnt.getQuantity() + 1;
			goodsQnt.setQuantity(orderQuantity);
		}
	}
	
	if (cnt == 0) { 
		goods.setQuantity(1);
		list.add(goods);
	}
	
	PreparedStatement pstmt = null;	
	ResultSet rs = null;
	
	try {

		String sql = "select * from cart where c_bookId = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		
		if (rs.next()){
			
			sql = "update cart set c_amount=?, c_unitTotalPrice=? where c_bookId=?";
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, goods.getQuantity());
			pstmt.setInt(2, goods.getQuantity() * goods.getUnitPrice());
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}
		else{
			sql = "insert into cart values(?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)session.getAttribute("sessionId"));
			pstmt.setString(2, id);	
			pstmt.setInt(3, goods.getUnitPrice());
			pstmt.setString(4, goods.getName());	
			pstmt.setInt(5, goods.getQuantity() * goods.getUnitPrice());
			pstmt.setInt(6,goods.getQuantity());
			pstmt.executeUpdate();
		}
			
	

		
	} catch (Exception ex) {
		System.out.println("updateHit() ���� : " + ex);
	} finally {
		try {
			if (rs != null) 
				rs.close();							
			if (pstmt != null) 
				pstmt.close();				
			if (conn != null) 
				conn.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}			
	} 
 */
	String bookId = request.getParameter("id");
	CartDAO dao = CartDAO.getInstance();
	dao.addToCart((String)session.getAttribute("sessionId"), bookId);
	response.sendRedirect("book.jsp?id=" + bookId);
%>