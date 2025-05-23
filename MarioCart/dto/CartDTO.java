package MarioCart.dto;

public class CartDTO {

	private String cartType = null;
	private double cartMaxSpeed = 0.0;
	private double handling = 0.0;
	
	public CartDTO(String cartType, double cartMaxSpeed, double handling) {
		
		this.cartType = cartType;
		this.cartMaxSpeed = cartMaxSpeed;
		this.handling = handling;
	}
}
