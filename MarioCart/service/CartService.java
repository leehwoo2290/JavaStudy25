package MarioCart.service;

import java.util.ArrayList;
import java.util.Scanner;

import MarioCart.dto.CartDTO;
import MarioCart.dto.MemberDTO;

public class CartService {

	public void menu(Scanner input, MemberDTO loginState, ArrayList<MemberDTO> memberDTOs, ArrayList<CartDTO> cartDTOs) {
		
		if(loginState == null) {
			
			System.out.println("비로그인 상태입니다.");
			return;
		}
		
		printCartType(cartDTOs);
		selectCartType(input, loginState, memberDTOs, cartDTOs);
		
	}
	
	public void printCartType(ArrayList<CartDTO> cartDTOs) {
		
		for(var cartDTO: cartDTOs) {
			
			System.out.println("카트 타입: " + cartDTO.getCartType() + "|| 최고 속도: " + 
			cartDTO.getCartMaxSpeed() + "|| 부스터 가속도: " + cartDTO.getBoosterAcceleration()
			+ "|| 부스터 지속시간: " + cartDTO.getBoosterDuration() + "|| 드리프트 가속도: " + cartDTO.getDriftAcceleration() + "\n\n");
		}
	}
	
	public void selectCartType(Scanner input, MemberDTO loginState, ArrayList<MemberDTO> memberDTOs, ArrayList<CartDTO> cartDTOs) {
		
		System.out.println("카트 타입 선택: ");
		
		String cartType = input.next();
		
		for(var cartDTO: cartDTOs) {
			
			if(cartDTO.getCartType().equals(cartType)) {
				
				loginState.setCartDTO(cartDTO);
				break;
			}			
		}
	}
}
