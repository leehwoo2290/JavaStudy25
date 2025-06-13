package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;

public class BoardDAO {
	//게시판의 db와 연동을 담당한다.
	//jdbc 5단계를 사용
	//1단계 : connect 객체를 사용해 ojdbc6.jar 생성
	//2단계: url, id , pw, sql 쿼리문 작성
	//3단계: 쿼리문 실행
	//4단계: 쿼리문 실행 결과
	//5단계: 연결 종료
	
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null;					//1단계
	public Statement statement = null;						//3단계(구형)
	public PreparedStatement preparedStatement = null;		//3단계(신형)
	public ResultSet resultSet = null;						//4단계 결과 받는 객체
	public int result = 0;									//4단계 결과 저장 정수
	
	public BoardDAO() {
		
		try {
			//예외 발생해도 프로그램 강제종료 안함
			
			//1단계 ojdbc6.jar 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2단계
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.151:1521:xe",
					"boardtest", "boardtest");
			
		}catch(ClassNotFoundException e) {
			
			System.out.println("드라이버 이름이나, ojdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0); //강제종료
		}catch(SQLException e) {
			
			System.out.println("url, id, pw가 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0); //강제종료
		}
	}

	public void selectAll() throws SQLException{ //쿼리문 오류 예외처리
		// sql 사용하여 전체 목록 보기 출력
		try {
			
			String sql = "select nbo, btitle, bwriter, bdate from board order by bdate desc";
			statement = connection.createStatement(); //쿼리문 실행 할 객체 생성
			resultSet = statement.executeQuery(sql); //쿼리문 실행해서 결과 받아옴
			
			System.out.println("번호\t 제목\t 작성자\t 작성일\t");
			//resultSet-> 결과표 (테이블 값들)
			while(resultSet.next()) {
				//결과표 위부터 아래로 순차출력
				System.out.print(resultSet.getInt("nbo") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			}
			
			System.out.println("========끝=======");
		}catch(SQLException e) {
			//오류발생 시 예외처리
			System.out.println("selectAll()메서드에 쿼리문이 잘못 되었습니다.");
			e.printStackTrace();
		}finally {
			//항상 실행
			resultSet.close();
			statement.close();
			//connection.close();
		}
	}

	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// jdbc사용 insert쿼리 처리
		// preparedStatement 문 사용
		// 동적쿼리문 ?자리에 세터로 값 삽입
		
		try {
			String sql = "insert into board(nbo, btitle, bcontent, bwriter, bdate)" +
					" values(board_seq.nextVal, ?, ?, ?, sysdate)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, boardDTO.getBwrite());
			
			System.out.println("쿼리확인 " + sql);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				
				System.out.println(result + "개의 게시물이 등록 되어 있습니다.");
				connection.commit();
			}else {
				
				System.out.println(result + " 쿼리 실행 결과, 입력 실패");
				connection.rollback();
			}
			
		}catch(SQLException e) {
			
			System.out.println("insertBoard 쿼리문 오류");
			e.printStackTrace();
		}finally {
			//예외 발생 및 정상 실행 후 무조건 처리됨
			
			preparedStatement.close();
			//connection.close();
			
		}
		
	}

	public void readOne(String title) throws SQLException {
		//제목 문자열 받아서 select 출력
		
		try {
			
			String sql = "select nbo, btitle, bcontent, bwriter, bdate from board where btitle= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title); //service에서 넘어온 찾고 싶은 제목이 ?로 넘어간다.
			resultSet = preparedStatement.executeQuery(); //쿼리문 실행 후 결과 표로 받음
			
			if(resultSet.next()) {
				//검색 결과가 있으면
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNbo(resultSet.getInt("nbo"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwrite(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				//데이터 베이스에 있는 행 객체에 넣기 완료
				
				System.out.println("==========================");
				System.out.println("번호 : " + boardDTO.getNbo());
				System.out.println("제목 : " + boardDTO.getBtitle());
				System.out.println("내용 : " + boardDTO.getBcontent());
				System.out.println("작성자 : " + boardDTO.getBwrite());
				System.out.println("작성일 : " + boardDTO.getBdate());
				
			}else {
				
				System.out.println("해당 게시물이 존재하지 않습니다");
			}
			
		} catch (SQLException e) {

			System.out.println("예외발생 readone확인");
			e.printStackTrace();
		} finally {
			
			resultSet.close();
			preparedStatement.close();
		}
		
	}

	public void modify(String title, Scanner inputStr) throws SQLException {
		// 제목을 찾아서 내용 수정
		BoardDTO boardDTO = new BoardDTO();
		
		System.out.println("수정할 내용 입력");
		System.out.println("제목: ");
		boardDTO.setBtitle(inputStr.next());
		
		System.out.println("내용: ");
		boardDTO.setBcontent(inputStr.next());
		
		try {
			String sql = "update board set btitle=?, bcontent=?, bdate= sysdate where btitle=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, title);
			
			result = preparedStatement.executeUpdate(); //쿼리문 실행 결과 저장
			
			if(result > 0) {
				
				System.out.println(result + "개의 데이터가 수정 되었습니다");
				connection.commit();
			}else {
				
				System.out.println(result + " 수정되지 않았습니다.");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("예외 발생 modify 메서드 sql문 확인");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	}

	public void deleteOne(int selectBno) throws SQLException {
		// 서비스에서 받은 게시물의 번호를 이용하여 데이터를 삭제한다.
		
		try {
			String sql = "delete from board where nbo =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectBno);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "게시물이 삭제 되었습니다");
				connection.commit();	
				
			}else {
				
				System.out.println(result + " 게시물 삭제 실패");
				connection.rollback();
			}
			
			System.out.println("==================");
			selectAll(); //삭제 후 전체 리스트 보기
			
			
		} catch (SQLException e) {

			System.out.println("예외 발생 deleteOne sql문 확인");
			e.printStackTrace();
		} finally {
			
			preparedStatement.close();
		}
		
	}
}
