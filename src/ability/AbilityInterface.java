package ability;

import pokemons.AllPokemons;

public interface AbilityInterface {

	
	String getName();
	String getType();
	void setName(String name);
	void setType(String type);
	void setPosition(int position);
	
	void changeVinoslivosti();
	void changeZhizni(int count);
	void setAtackDefPoint(int atackPoint, int defencePoint);
	
	int getHealth();
	int getVinoslivost();
}
