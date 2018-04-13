package ucenfotec.logic.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import ucenfotec.logic.managers.CharacterManager;

public class TestLogic {

	@Test
	public void addCharacterTest() throws SQLException, Exception {
		CharacterManager characterTest = new CharacterManager();
		String[] pNewCharacter = new String[5];
		pNewCharacter[0] = "Character1";
		pNewCharacter[1] = "100";
		pNewCharacter[2] = "5";
		pNewCharacter[3] = "5";
		
		assertEquals(true,characterTest.addNewCharacter(pNewCharacter));
	}

}
