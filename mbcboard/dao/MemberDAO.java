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
	public Connection connection = null;					//1�ܰ�
	//public Statement statement = null;					//3�ܰ�(����)
	public PreparedStatement preparedStatement = null;		//3�ܰ�(����)
	public ResultSet resultSet = null;						//4�ܰ� ��� �޴� ��ü
	public int result = 0;									//4�ܰ� ��� ���� ����
	
	public MemberDAO() {
		
		try {
			//���� �߻��ص� ���α׷� �������� ����
			
			//1�ܰ� ojdbc6.jar ȣ��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2�ܰ�
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.151:1521:xe",
					"boardtest", "boardtest");
			
		}catch(ClassNotFoundException e) {
			
			System.out.println("����̹� �̸��̳�, ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0); //��������
		}catch(SQLException e) {
			
			System.out.println("url, id, pw�� �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0); //��������
		}
	}
	
	//ȸ������
	public void joinMember(MemberDTO memberDTO) throws SQLException {		

		try {
			
			String sql = "insert into member(mno, bwriter, id, pw)" + " values(board_seq.nextVal, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				
				System.out.println(result + " ȸ�� ���� ����");
				connection.commit();
			}else {
				
				System.out.println(result + " ���� ���� ���, ȸ�� ���� ����");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			
			System.out.println("���ܹ߻� joinMemberȮ��");
			e.printStackTrace();
			
		}finally {
			//���� �߻� �� ���� ���� �� ������ ó����
			
			preparedStatement.close();
			//connection.close();		
		}	
		
	}

	//��ü ȸ�� ����
	public void readAllMember() throws SQLException {
		
		try {
			
			String sql = "select mno, bwriter, id, regidate from member";
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery(); //������ ���� �� ��� ǥ�� ����
			
			while(resultSet.next()) {
				//�˻� ����� ������
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMno(resultSet.getInt("Mno"));
				memberDTO.setBwriter(resultSet.getString("bwriter"));
				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setRegidate(resultSet.getDate("regidate"));
		
				//������ ���̽��� �ִ� �� ��ü�� �ֱ� �Ϸ�
				
				System.out.println("==========================");
				System.out.println("��ȣ : " + memberDTO.getMno());
				System.out.println("�г��� : " + memberDTO.getBwriter());
				System.out.println("ID : " + memberDTO.getId());
				System.out.println("������ : " + memberDTO.getRegidate());			
			}
			
		} catch (SQLException e) {
			
			System.out.println("���ܹ߻� readAllMemberȮ��");
			e.printStackTrace();
			
		}finally {
			//���� �߻� �� ���� ���� �� ������ ó����
			
			preparedStatement.close();
			resultSet.close();		
		}	
		
	}

	//�α���
	public MemberDTO logInMember(MemberDTO memberDTO) throws SQLException {
		
		MemberDTO session = null;
		
		try {
			
			String sql = "select * from member where id= ? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPw());

			//System.out.println("����Ȯ�� " + sql);
			
			resultSet = preparedStatement.executeQuery(); //������ ���� �� ��� ǥ�� ����
			
			if(resultSet.next()) {
				
				session = new MemberDTO();
				session.setMno(resultSet.getInt("Mno"));
				session.setBwriter(resultSet.getString("bwriter"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setRegidate(resultSet.getDate("regidate"));
				System.out.println(result + "�α��� ����");
			}else {
				
				System.out.println(result + " ���� ���� ���, �α��� ����");
			
			}
			
		} catch (SQLException e) {
			
			System.out.println("���ܹ߻� logInMemberȮ��");
			e.printStackTrace();
			
		}finally {
			//���� �߻� �� ���� ���� �� ������ ó����
			
			preparedStatement.close();
			resultSet.close();		
		}	

		return session;
	}

	//ȸ�� ���� ����
	public MemberDTO modifyMember(MemberDTO session, MemberDTO memberDTO) throws SQLException {
		
		try {
			String sql = "update member set bwriter=?, pw=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getPw());
			preparedStatement.setString(3, session.getId());
			
			result = preparedStatement.executeUpdate(); //������ ���� ��� ����
			
			if(result > 0) {
				
				session.setBwriter(memberDTO.getBwriter());
				session.setPw(memberDTO.getPw());

				System.out.println(result + " ȸ�� ���� ���� �Ϸ�");
				connection.commit();
			}else {
				
				System.out.println(result + " ȸ�� ���� ���� ����");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("���� �߻� modifyMember �޼��� sql�� Ȯ��");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			
		}
		
		return session;
	}

	//ȸ�� Ż��
	public void deleteMember(MemberDTO session) throws SQLException {
		
		try {
			String sql = "delete from member where id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "������ ���� �Ǿ����ϴ�");
				connection.commit();	
				
			}else {
				
				System.out.println(result + " ���� ���� ����");
				connection.rollback();
			}
			
			System.out.println("==================");
			
			
		} catch (SQLException e) {

			System.out.println("���� �߻� deleteOne sql�� Ȯ��");
			e.printStackTrace();
		} finally {
			
			preparedStatement.close();
		}
		
	}

}
