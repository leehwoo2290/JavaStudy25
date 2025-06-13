package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;
import mbcboard.dto.MemberDTO;

public class MemberDAO {

	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null;					//1단계
	//public Statement statement = null;					//3단계(구형)
	public PreparedStatement preparedStatement = null;		//3단계(신형)
	public ResultSet resultSet = null;						//4단계 결과 받는 객체
	public int result = 0;									//4단계 결과 저장 정수
	
	public MemberDAO() {
		
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
	
	//회원가입
	public void joinMember(MemberDTO memberDTO) throws SQLException {		

		try {
			
			String sql = "insert into member(mno, bwriter, id, pw)" + " values(board_seq.nextVal, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				
				System.out.println(result + " 회원 가입 성공");
				connection.commit();
			}else {
				
				System.out.println(result + " 쿼리 실행 결과, 회원 가입 실패");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			
			System.out.println("예외발생 joinMember확인");
			e.printStackTrace();
			
		}finally {
			//예외 발생 및 정상 실행 후 무조건 처리됨
			
			preparedStatement.close();
			//connection.close();		
		}	
		
	}

	//전체 회원 열람
	public void readAllMember() throws SQLException {
		
		try {
			
			String sql = "select mno, bwriter, id, regidate from member";
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery(); //쿼리문 실행 후 결과 표로 받음
			
			while(resultSet.next()) {
				//검색 결과가 있으면
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMno(resultSet.getInt("Mno"));
				memberDTO.setBwriter(resultSet.getString("bwriter"));
				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setRegidate(resultSet.getDate("regidate"));
		
				//데이터 베이스에 있는 행 객체에 넣기 완료
				
				System.out.println("==========================");
				System.out.println("번호 : " + memberDTO.getMno());
				System.out.println("닉네임 : " + memberDTO.getBwriter());
				System.out.println("ID : " + memberDTO.getId());
				System.out.println("가입일 : " + memberDTO.getRegidate());			
			}
			
		} catch (SQLException e) {
			
			System.out.println("예외발생 readAllMember확인");
			e.printStackTrace();
			
		}finally {
			//예외 발생 및 정상 실행 후 무조건 처리됨
			
			preparedStatement.close();
			resultSet.close();		
		}	
		
	}

	//로그인
	public MemberDTO logInMember(MemberDTO memberDTO) throws SQLException {
		
		MemberDTO session = null;
		
		try {
			
			String sql = "select * from member where id= ? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPw());

			//System.out.println("쿼리확인 " + sql);
			
			resultSet = preparedStatement.executeQuery(); //쿼리문 실행 후 결과 표로 받음
			
			if(resultSet.next()) {
				
				session = new MemberDTO();
				session.setMno(resultSet.getInt("Mno"));
				session.setBwriter(resultSet.getString("bwriter"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setRegidate(resultSet.getDate("regidate"));
				System.out.println(result + "로그인 성공");
			}else {
				
				System.out.println(result + " 쿼리 실행 결과, 로그인 실패");
			
			}
			
		} catch (SQLException e) {
			
			System.out.println("예외발생 logInMember확인");
			e.printStackTrace();
			
		}finally {
			//예외 발생 및 정상 실행 후 무조건 처리됨
			
			preparedStatement.close();
			resultSet.close();		
		}	

		return session;
	}

	//회원 정보 수정
	public MemberDTO modifyMember(MemberDTO session, MemberDTO memberDTO) throws SQLException {
		
		try {
			String sql = "update member set bwriter=?, pw=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getPw());
			preparedStatement.setString(3, session.getId());
			
			result = preparedStatement.executeUpdate(); //쿼리문 실행 결과 저장
			
			if(result > 0) {
				
				session.setBwriter(memberDTO.getBwriter());
				session.setPw(memberDTO.getPw());

				System.out.println(result + " 회원 정보 수정 완료");
				connection.commit();
			}else {
				
				System.out.println(result + " 회원 정보 수정 실패");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("예외 발생 modifyMember 메서드 sql문 확인");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			
		}
		
		return session;
	}

	//회원 탈퇴
	public void deleteMember(MemberDTO session) throws SQLException {
		
		try {
			String sql = "delete from member where id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "계정이 삭제 되었습니다");
				connection.commit();	
				
			}else {
				
				System.out.println(result + " 계정 삭제 실패");
				connection.rollback();
			}
			
			System.out.println("==================");
			
			
		} catch (SQLException e) {

			System.out.println("예외 발생 deleteOne sql문 확인");
			e.printStackTrace();
		} finally {
			
			preparedStatement.close();
		}
		
	}

}
