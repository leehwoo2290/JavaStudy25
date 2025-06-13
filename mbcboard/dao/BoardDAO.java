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
	//�Խ����� db�� ������ ����Ѵ�.
	//jdbc 5�ܰ踦 ���
	//1�ܰ� : connect ��ü�� ����� ojdbc6.jar ����
	//2�ܰ�: url, id , pw, sql ������ �ۼ�
	//3�ܰ�: ������ ����
	//4�ܰ�: ������ ���� ���
	//5�ܰ�: ���� ����
	
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null;					//1�ܰ�
	public Statement statement = null;						//3�ܰ�(����)
	public PreparedStatement preparedStatement = null;		//3�ܰ�(����)
	public ResultSet resultSet = null;						//4�ܰ� ��� �޴� ��ü
	public int result = 0;									//4�ܰ� ��� ���� ����
	
	public BoardDAO() {
		
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

	public void selectAll() throws SQLException{ //������ ���� ����ó��
		// sql ����Ͽ� ��ü ��� ���� ���
		try {
			
			String sql = "select nbo, btitle, bwriter, bdate from board order by bdate desc";
			statement = connection.createStatement(); //������ ���� �� ��ü ����
			resultSet = statement.executeQuery(sql); //������ �����ؼ� ��� �޾ƿ�
			
			System.out.println("��ȣ\t ����\t �ۼ���\t �ۼ���\t");
			//resultSet-> ���ǥ (���̺� ����)
			while(resultSet.next()) {
				//���ǥ ������ �Ʒ��� �������
				System.out.print(resultSet.getInt("nbo") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			}
			
			System.out.println("========��=======");
		}catch(SQLException e) {
			//�����߻� �� ����ó��
			System.out.println("selectAll()�޼��忡 �������� �߸� �Ǿ����ϴ�.");
			e.printStackTrace();
		}finally {
			//�׻� ����
			resultSet.close();
			statement.close();
			//connection.close();
		}
	}

	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// jdbc��� insert���� ó��
		// preparedStatement �� ���
		// ���������� ?�ڸ��� ���ͷ� �� ����
		
		try {
			String sql = "insert into board(nbo, btitle, bcontent, bwriter, bdate)" +
					" values(board_seq.nextVal, ?, ?, ?, sysdate)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, boardDTO.getBwrite());
			
			System.out.println("����Ȯ�� " + sql);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				
				System.out.println(result + "���� �Խù��� ��� �Ǿ� �ֽ��ϴ�.");
				connection.commit();
			}else {
				
				System.out.println(result + " ���� ���� ���, �Է� ����");
				connection.rollback();
			}
			
		}catch(SQLException e) {
			
			System.out.println("insertBoard ������ ����");
			e.printStackTrace();
		}finally {
			//���� �߻� �� ���� ���� �� ������ ó����
			
			preparedStatement.close();
			//connection.close();
			
		}
		
	}

	public void readOne(String title) throws SQLException {
		//���� ���ڿ� �޾Ƽ� select ���
		
		try {
			
			String sql = "select nbo, btitle, bcontent, bwriter, bdate from board where btitle= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title); //service���� �Ѿ�� ã�� ���� ������ ?�� �Ѿ��.
			resultSet = preparedStatement.executeQuery(); //������ ���� �� ��� ǥ�� ����
			
			if(resultSet.next()) {
				//�˻� ����� ������
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNbo(resultSet.getInt("nbo"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwrite(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				//������ ���̽��� �ִ� �� ��ü�� �ֱ� �Ϸ�
				
				System.out.println("==========================");
				System.out.println("��ȣ : " + boardDTO.getNbo());
				System.out.println("���� : " + boardDTO.getBtitle());
				System.out.println("���� : " + boardDTO.getBcontent());
				System.out.println("�ۼ��� : " + boardDTO.getBwrite());
				System.out.println("�ۼ��� : " + boardDTO.getBdate());
				
			}else {
				
				System.out.println("�ش� �Խù��� �������� �ʽ��ϴ�");
			}
			
		} catch (SQLException e) {

			System.out.println("���ܹ߻� readoneȮ��");
			e.printStackTrace();
		} finally {
			
			resultSet.close();
			preparedStatement.close();
		}
		
	}

	public void modify(String title, Scanner inputStr) throws SQLException {
		// ������ ã�Ƽ� ���� ����
		BoardDTO boardDTO = new BoardDTO();
		
		System.out.println("������ ���� �Է�");
		System.out.println("����: ");
		boardDTO.setBtitle(inputStr.next());
		
		System.out.println("����: ");
		boardDTO.setBcontent(inputStr.next());
		
		try {
			String sql = "update board set btitle=?, bcontent=?, bdate= sysdate where btitle=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, title);
			
			result = preparedStatement.executeUpdate(); //������ ���� ��� ����
			
			if(result > 0) {
				
				System.out.println(result + "���� �����Ͱ� ���� �Ǿ����ϴ�");
				connection.commit();
			}else {
				
				System.out.println(result + " �������� �ʾҽ��ϴ�.");
				connection.rollback();
			}
			
		} catch (SQLException e) {
			System.out.println("���� �߻� modify �޼��� sql�� Ȯ��");
			e.printStackTrace();
		}finally {
			preparedStatement.close();
		}
	}

	public void deleteOne(int selectBno) throws SQLException {
		// ���񽺿��� ���� �Խù��� ��ȣ�� �̿��Ͽ� �����͸� �����Ѵ�.
		
		try {
			String sql = "delete from board where nbo =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectBno);
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "�Խù��� ���� �Ǿ����ϴ�");
				connection.commit();	
				
			}else {
				
				System.out.println(result + " �Խù� ���� ����");
				connection.rollback();
			}
			
			System.out.println("==================");
			selectAll(); //���� �� ��ü ����Ʈ ����
			
			
		} catch (SQLException e) {

			System.out.println("���� �߻� deleteOne sql�� Ȯ��");
			e.printStackTrace();
		} finally {
			
			preparedStatement.close();
		}
		
	}
}
