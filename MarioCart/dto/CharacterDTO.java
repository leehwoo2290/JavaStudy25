package MarioCart.dto;

public class CharacterDTO {

	private String characterType = null;
	private double weight = 0.0;
	
	public CharacterDTO(String characterType, double weight) {
		
		this.characterType = characterType;
		this.weight = weight;
	}
}
