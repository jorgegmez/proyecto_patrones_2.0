package ucenfotec.logic.managers;

import java.sql.SQLException;

import ucenfotec.logic.multis.CharacterMulti;
import ucenfotec.logic.objects.Character;;

public class CharacterManager {
	public boolean addNewCharacter(String[] pCharacterData) throws SQLException, Exception
    {
        boolean valid = false;
        int health = Integer.parseInt(pCharacterData[1]);
        int experience = Integer.parseInt(pCharacterData[2]);
        int power = Integer.parseInt(pCharacterData[3]);

        Character newCharacter = new Character(pCharacterData[0], health, experience, power);
        try{
            
            new CharacterMulti().createCharacter(newCharacter);
            valid = true;
            return valid;

        }catch(SQLException error){
            System.out.println("Codigo error: " + error.getErrorCode());
            System.out.println("Mensaje error: SQLEX" + error.getMessage());
            return valid;
        }
        catch(Exception error){
            System.out.println("Mensaje error: Exception" + error.getMessage());
            System.out.println("Mensaje error: Exception" + error.getCause());
            return valid;
        }
    }
}
