package MarioCart;

import java.util.ArrayList;
import java.util.Scanner;

import MarioCart.dto.MemberDTO;

import MarioCart.service.MemberService;

public class MarioCartExam {

	public static Scanner input = new Scanner(System.in);
	
	public static ArrayList<MemberDTO> memberDTOs = new ArrayList<MemberDTO>();
	
	public static MemberDTO loginState; 
	
	static {
		
	}
	
	public static void main(String[] args) {
	
		boolean bRun = true;
	
		while(bRun) {
		
			System.out.println("1. 회원관리 | 2. 카트관리 | 3. 게임실행 | 4. 종료");

			System.out.print(">>>");
			String select = input.next(); 
			
			switch (select) {
			case "1": 
				MemberService memberService = new MemberService();
				memberService.menu(input, memberDTOs, loginState);			
				break;
				
			case "4":
				bRun = false;
				break;
			
			default:
				break;
			}
		}
		
		for(var x : memberDTOs) {
			
			System.out.println(x.getNickName());
		}

	}

}
