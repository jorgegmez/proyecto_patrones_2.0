package ucenfotec.logic.multis;

import java.sql.*;
import ucenfotec.logic.dbaccess.Connector;

import ucenfotec.logic.objects.Character;

public class CharacterMulti {
	public boolean createCharacter(Character pCharacter) throws Exception
    {
        boolean validate = false;
        String procedure = "[dbo].[sp_add_new_charater] ?,?,?,?";
        Character newCharatcer = pCharacter;

        try (CallableStatement callstmnt = Connector.getConector().getCallableStatement(procedure)) {
            callstmnt.setString(1, newCharatcer.getName());
                callstmnt.setInt(2, newCharatcer.getHealth());
                callstmnt.setInt(3, newCharatcer.getExperience());
                callstmnt.setInt(4, newCharatcer.getPower());
                callstmnt.execute();
                validate = true; 
                return validate;
        }catch(SQLException err){
            System.out.println("Ha ocurrido el siguiente error de SQLException (Registro): " + err.getErrorCode());
            System.out.println("Ha ocurrido el siguiente error: (Registro)" + err.getMessage());
            System.out.println("Ha ocurrido el siguiente error de estatus: (Registro)" + err.getSQLState());
            return validate;
        }

    }
}
