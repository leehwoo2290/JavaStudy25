package MarioCart.dto;

public class CartDTO {

	private String cartType = null;
	
	private int boosterAcceleration = 0;
	private int boosterDuration = 0;
	private int boosterChargeAmount = 0;
	
	private int driftAcceleration = 0;
	
	private double cartMaxSpeed = 0.0;
	
	public CartDTO(String cartType, double cartMaxSpeed, int boosterAcceleration, int boosterDuration, int driftAcceleration) {
		
		this.cartType = cartType;
		this.cartMaxSpeed = cartMaxSpeed;
		this.boosterAcceleration = boosterAcceleration;
		this.boosterDuration = boosterDuration;
		this.driftAcceleration = driftAcceleration;
	}
	
	public final String getCartType() {
		
		return cartType;
	}
	
	public final int getBoosterAcceleration() {
		
		return boosterAcceleration;
	}

	public final int getBoosterChargeAmount() {
		
		return boosterChargeAmount;
	}

	public final int getBoosterDuration() {
	
		return boosterDuration;
	}
	
	public final int getDriftAcceleration() {
		
		return driftAcceleration;
	}

	public final double getCartMaxSpeed() {
		
		return cartMaxSpeed;
	}

}
