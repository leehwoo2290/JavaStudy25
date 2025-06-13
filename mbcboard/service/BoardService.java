package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;

public class BoardService {
	//dao dto ����Ͽ� �θ޴��� crudó��
	
	public BoardDAO boardDAO = new BoardDAO(); // 1,2�ܰ����
	
	public void subMenu(Scanner inputStr) throws SQLException {
		
		boolean bSubRun = true;
		
		while(bSubRun) {
			
			System.out.println("�Խ��� ���� ����");
			System.out.println("1. ��κ���");
			System.out.println("2. �Խñ� �ۼ�");
			System.out.println("3. �Խñ� �ڼ��� ����");
			System.out.println("4. �Խñ� ����");
			System.out.println("5. �Խñ� ����");
			System.out.println("6. ������");
			System.out.println(">>>");
			
			String subSelect = inputStr.next();
			
			switch(subSelect) {
			
			case "1":
				System.out.println("��� �Խù� ����");
				selectAll(boardDAO);
				break;
			case "2":
				System.out.println("�Խù� �ۼ�");
				insertBoard(boardDAO, inputStr);
				break;
			case "3":
				System.out.println("�Խù� �ڼ��� ����");
				readOne(inputStr);
				break;
			case "4":
				System.out.println("�Խù� ����");
				modify(inputStr);
				break;
			case "5":
				System.out.println("�Խù� ����");
				deleteOne(inputStr);
				break;
			case "6":
				System.out.println("�Խù� ���� ����");
				boardDAO.connection.close();
				bSubRun = false;
				break;
			default:
				System.out.println("�߸��� �Է� ��");
				break;
			}
		}
		
	}

	private void deleteOne(Scanner inputStr) throws SQLException {
		// �Խù��� ��ȣ�� �޾� �����Ѵ�
		System.out.println("�����Ϸ��� �Խñ��� ��ȣ�� �Է��ϼ���");
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		boardDAO.deleteOne(selectBno);
		
	}

	private void modify(Scanner inputStr) throws SQLException {
		// ������ ã�Ƽ� ������ �����Ѵ�
		
		System.out.println("�����Ϸ��� �Խñ� ���� �Է�");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.modify(title, inputStr);
		System.out.println("=========��========");
	}

	private void readOne(Scanner inputStr) throws SQLException {
		// ������ �Է��ϸ� ������ ���̵��� selectó��
		System.out.println("������� �Խñ��� ������ �Է��ϼ���.");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.readOne(title);
		System.out.println("==========��==========");
	}

	private void insertBoard(BoardDAO boardDAO, Scanner inputStr) throws SQLException {
		//Ű����� �Է��� �����͸� dto ����Ͽ� �����ͺ��̽��� insert����
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("�ۼ��� : ");
		boardDTO.setBwrite(inputStr.next());
		
		System.out.println("���� : ");
		boardDTO.setBtitle(inputStr.next());
		
		System.out.println("���� : ");
		boardDTO.setBcontent(inputStr.next());	//���� nextline
		
		boardDAO.insertBoard(boardDTO);
		System.out.println("=========insertBoard����=========");
	}

	private void selectAll(BoardDAO boardDAO)throws SQLException {
		//��������
		System.out.println("================");
		System.out.println("====�Խ��� ���====");
		boardDAO.selectAll();
		System.out.println("================");
	}
	
}
