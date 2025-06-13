package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;

public class BoardService {
	//dao dto 사용하여 부메뉴와 crud처리
	
	public BoardDAO boardDAO = new BoardDAO(); // 1,2단계실행
	
	public void subMenu(Scanner inputStr) throws SQLException {
		
		boolean bSubRun = true;
		
		while(bSubRun) {
			
			System.out.println("게시판 서비스 시작");
			System.out.println("1. 모두보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 자세히 보기");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("6. 나가기");
			System.out.println(">>>");
			
			String subSelect = inputStr.next();
			
			switch(subSelect) {
			
			case "1":
				System.out.println("모든 게시물 보기");
				selectAll(boardDAO);
				break;
			case "2":
				System.out.println("게시물 작성");
				insertBoard(boardDAO, inputStr);
				break;
			case "3":
				System.out.println("게시물 자세히 보기");
				readOne(inputStr);
				break;
			case "4":
				System.out.println("게시물 수정");
				modify(inputStr);
				break;
			case "5":
				System.out.println("게시물 삭제");
				deleteOne(inputStr);
				break;
			case "6":
				System.out.println("게시물 보기 종료");
				boardDAO.connection.close();
				bSubRun = false;
				break;
			default:
				System.out.println("잘못된 입력 값");
				break;
			}
		}
		
	}

	private void deleteOne(Scanner inputStr) throws SQLException {
		// 게시물의 번호를 받아 삭제한다
		System.out.println("삭제하려는 게시글의 번호를 입력하세요");
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		boardDAO.deleteOne(selectBno);
		
	}

	private void modify(Scanner inputStr) throws SQLException {
		// 제목을 찾아서 내용을 수정한다
		
		System.out.println("수정하려는 게시글 제목 입력");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.modify(title, inputStr);
		System.out.println("=========끝========");
	}

	private void readOne(Scanner inputStr) throws SQLException {
		// 제목을 입력하면 내용이 보이도록 select처리
		System.out.println("보고싶은 게시글의 제목을 입력하세요.");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.readOne(title);
		System.out.println("==========끝==========");
	}

	private void insertBoard(BoardDAO boardDAO, Scanner inputStr) throws SQLException {
		//키보드로 입력한 데이터를 dto 사용하여 데이터베이스에 insert하자
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("작성자 : ");
		boardDTO.setBwrite(inputStr.next());
		
		System.out.println("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		System.out.println("내용 : ");
		boardDTO.setBcontent(inputStr.next());	//띄어쓰기 nextline
		
		boardDAO.insertBoard(boardDTO);
		System.out.println("=========insertBoard종료=========");
	}

	private void selectAll(BoardDAO boardDAO)throws SQLException {
		//전제보기
		System.out.println("================");
		System.out.println("====게시판 목록====");
		boardDAO.selectAll();
		System.out.println("================");
	}
	
}
