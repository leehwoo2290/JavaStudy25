package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Book;
import mvc.database.DBConnection;

public class CartDAO {

	// 프론트에서 넘어오는 더미데이터 리스트
	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	} // 자신 객체를 생성하는 메소드
	
	public ArrayList<Book> getCartList(String accountId){
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			String sql = "select * from cart where c_accountId = ? ";
			
			conn = DBConnection.getConnection();
			
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);		
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				System.out.println(" bookId!!!: " + rs.getString("c_bookId"));
				Book book = new Book();
				book.setBookId(rs.getString("c_bookId"));
				book.setUnitPrice(rs.getInt("c_unitPrice"));
				book.setName(rs.getString("c_bookName"));	
				book.setQuantity(rs.getInt("c_amount"));
				bookList.add(book);
			}
			
		} catch (Exception ex) {
			System.out.println("getCartList : " + ex);
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
		
		return bookList;
	}

	public void addToCart(String accoutId, String bookId) {

		BookRepository dao = BookRepository.getInstance();

		ArrayList<Book> goodsList = dao.getAllBooks();
		Book goods = new Book();
		for (int i = 0; i < goodsList.size(); i++) {
			goods = goodsList.get(i);
			if (goods.getBookId().equals(bookId)) { 			
				break;
			}
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from cart where c_bookId = ? ";
			
			conn = DBConnection.getConnection();		
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			
			//c_bookId동일한게 이미 있으면
			if (rs.next()){
				
				sql = "update cart set c_amount=?, c_unitTotalPrice=? where c_bookId=?";
				pstmt = conn.prepareStatement(sql);	
				
				pstmt.setInt(1, rs.getInt("c_amount") + 1);
				pstmt.setInt(2, (rs.getInt("c_amount") + 1) * goods.getUnitPrice());
				pstmt.setString(3, bookId);
				pstmt.executeUpdate();
			}
			else{
				sql = "insert into cart values(?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, accoutId);
				pstmt.setString(2, bookId);	
				pstmt.setInt(3, goods.getUnitPrice());
				pstmt.setString(4, goods.getName());	
				pstmt.setInt(5, goods.getUnitPrice());
				pstmt.setInt(6, 1);
				pstmt.executeUpdate();
			}
							
		} catch (Exception ex) {
			System.out.println("addToCart : " + ex);
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

		/* response.sendRedirect("book.jsp?id=" + id); */
	}

	public void deleteCart(String accoutId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "delete from cart where c_accountId=?";
			
			conn = DBConnection.getConnection();		
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accoutId);
			pstmt.executeUpdate();
							
		} catch (Exception ex) {
			System.out.println("deleteCart : " + ex);
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
	}

	public void removeCart(String accoutId, String bookId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			
			String sql = "delete from cart where c_accountId=? and c_bookId=?";	
			
			conn = DBConnection.getConnection();		
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1, accoutId);
			pstmt.setString(2, bookId);
			pstmt.executeUpdate();
	

		} catch (Exception ex) {
			System.out.println("removeCart()  : " + ex);
		} finally {
			try {										
				if (pstmt != null) 
					pstmt.close();				
				if (conn != null) 
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}		
		}
	}
}
