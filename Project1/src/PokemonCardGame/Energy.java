package PokemonCardGame;
public class Energy extends Card{
	private String type;
	
	public void setType(String energyType ) {
		type = energyType;
	}
	public String getName() {
		return type;
	}
}
