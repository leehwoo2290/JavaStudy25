package MarioCart.service;

import java.util.ArrayList;
import java.util.Scanner;

import MarioCart.dto.MemberDTO;

public class MemberService {

	public void menu(Scanner input, ArrayList<MemberDTO> memberDTOs, MemberDTO loginState) {
		
			System.out.println("---------회원관리 메뉴에 진입 하였습니다.------");
			boolean run = true;
			while (run) {
				System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 삭제 | 5. 종료");
				System.out.print(">>>");
		
				String select = input.next();
		
				switch (select) {
					case "1": 
						createAccout(input, memberDTOs);
						break;
					case "2":
						loginState = loginAccount(input, memberDTOs, loginState);
						break;
					case "3":
						modifyAccount(input, memberDTOs, loginState);
						break;
					case "4":
						deleteAccount(memberDTOs, loginState);
						break;					
					case "5":
						run = false;
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + select);
				}	
		}
	}

	public boolean checkCreateAccout_Validation(ArrayList<MemberDTO> memberDTOs, String inputID, String inputNickName) {
		
		boolean returnVal = true;
		
		for(var memberDTO : memberDTOs) {
			
			if(memberDTO.getID().equals(inputID)) {
				
				System.out.println("중복 아이디 입니다. \n 가입 실패");
				returnVal = false;
				break;
			}
			else if (memberDTO.getNickName().equals(inputNickName)) {
				
				System.out.println("중복 닉네임 입니다. \n 가입 실패");
				returnVal = false;
				break;
			}
		}
		return returnVal;
	}
	
	public MemberDTO inputAccoutInfo(Scanner input, ArrayList<MemberDTO> memberDTOs) {
		
		System.out.print("ID입력: ");
		String id = input.next();
		
		System.out.print("PW입력: ");
		String pw = input.next();
		
		System.out.print("NickName입력: ");
		String nickName = input.next();
		
		if(!checkCreateAccout_Validation(memberDTOs, id, nickName)) {
			
			return null;
		}
		
		System.out.println(nickName + "님 가입을 환영 합니다.");
		
		return new MemberDTO(id, pw, nickName);	
	}
	public void createAccout(Scanner input, ArrayList<MemberDTO> memberDTOs) {
		
		MemberDTO newMemberDTO = inputAccoutInfo(input, memberDTOs);
		
		//call by ref
		memberDTOs.add(newMemberDTO);	
		
	}
	
	public MemberDTO loginAccount(Scanner input, ArrayList<MemberDTO> memberDTOs, MemberDTO loginState) {
		
		System.out.print("ID입력: ");
		String id = input.next();
		
		System.out.print("PW입력: ");
		String pw = input.next();
		
		boolean bLoginSuccess = false;
		
		for(var memberDTO : memberDTOs) {
			
			if(memberDTO.getID().equals(id) && memberDTO.getPW().equals(pw)) {
				
				bLoginSuccess = true;
				//call by ref
				loginState = memberDTO;
				break;
			}
		}
		
		String printStr = bLoginSuccess ? "로그인 성공":"로그인 실패";
		
		System.out.println(printStr);
		
		return loginState;
	}
	
	public void modifyAccount(Scanner input, ArrayList<MemberDTO> memberDTOs, MemberDTO loginState) {
		
		if(loginState == null) {
			
			System.out.println("비로그인 상태입니다.");
			return;
		}
		MemberDTO modifyMemberDTO = inputAccoutInfo(input, memberDTOs);	
		
		memberDTOs.set(memberDTOs.indexOf(loginState), modifyMemberDTO);	
	}
	
	public void deleteAccount(ArrayList<MemberDTO> memberDTOs, MemberDTO loginState) {
		
		if(loginState == null) {
			
			System.out.println("비로그인 상태입니다.");
			return;
		}
		memberDTOs.remove(loginState);
		
		//call by ref
		loginState = null;
	}

}
