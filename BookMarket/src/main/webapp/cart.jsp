<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<%
	String cartId = session.getId();
%>
<title>장바구니</title>
</head>
<body>

<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">장바구니</h1>
        <p class="col-md-8 fs-4">Cart</p>      
      </div>
    </div>
  	
	 <div class="row align-items-md-stretch ">	 	
		<div class="row">
			<table width="100%">
				<tr>
					<%-- <td align="left"><a href="./deleteCart.jsp?cartId=<%=cartId%>" class="btn btn-danger">삭제하기</a></td> --%>
					<td align="left"><a href="./CartDeleteAction.cart?accountid=<%=sessionId%>" class="btn btn-danger">삭제하기</a></td>
					<td align="right"><a href="./shippingInfo.jsp?cartId=<%= cartId %>" class="btn btn-success">주문하기</a></td>
				</tr>
			</table>
		</div>
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
				<%@ include file="dbconn.jsp" %>
					
				<%		
					
				    PreparedStatement pstmt = null;
					ResultSet rs = null;
								
					String sql = "select * from cart where c_accountId = ?";				
					pstmt = conn.prepareStatement(sql); //3단계	
					
					pstmt.setString(1, (String)session.getAttribute("sessionId"));
					
					rs = pstmt.executeQuery();
					int sum = 0;
					//4단계
					while (rs.next()) {					//resultset 표에 1~마지막행까지 true반환		
					sum = sum + rs.getInt("c_unitTotalPrice");
					/* int sum = 0;
					ArrayList<Book> cartList = (ArrayList<Book>) session.getAttribute("cartlist");
					if (cartList == null)
						cartList = new ArrayList<Book>();

					for (int i = 0; i < cartList.size(); i++) { // 상품리스트 하나씩 출력하기
						Book book = cartList.get(i);
						int total = book.getUnitPrice() * book.getQuantity();
						sum = sum + total; */
				%>
				<tr>
					<td class="nav-item"><a href="./book.jsp?id=<%=rs.getString("c_bookId")%>" class="nav-link" >
					<%=rs.getString("c_bookId")%>-  <%=rs.getString("c_bookName")%></a></td>
					<td><%=rs.getString("c_unitPrice")%></td>
					<td><%=rs.getString("c_amount")%></td>
					<td><%=rs.getString("c_unitTotalPrice")%></td>
					<td><a href="./CartRemoveAction.cart?accountid=<%=sessionId%>&bookid=<%=rs.getString("c_bookId")%>" class="badge text-bg-danger">삭제</a></td>
					<%-- <td><a href="./removeCart.jsp?id=<%=rs.getString("c_bookId")%>" class="badge text-bg-danger">삭제</a></td> --%>
				<%--<td><%=book.getBookId()%> - <%=book.getName()%></td>
					<td><%=book.getUnitPrice()%></td>
					<td><%=book.getQuantity()%></td>
					<td><%=total%></td>
					<td><a href="./removeCart.jsp?id=<%=book.getBookId()%>" class="badge text-bg-danger">삭제</a></td> --%>
				</tr>
				<%
					}
				%>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%=sum%></th>
					<th></th>
				</tr>
			</table>
			<a href="./books.jsp" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
