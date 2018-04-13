package ucenfotec.logic.dbaccess;

import java.io.BufferedReader;
import java.io.FileReader;
import ucenfotec.logic.dbaccess.AccessDB;

public class Connector {
	private static AccessDB connectorDB = null;
    private static final String FILENAME = "data_base.txt";

	public static AccessDB getConector() throws java.sql.SQLException,Exception{
	    BufferedReader br = new BufferedReader(new FileReader(FILENAME));
	    try {
	        String driver = null;
	        String conexion = null;
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        String[] arr = everything.split(",");
	        String driverTxt = arr[0];
	        String connectionUrl = arr[1];
	
	        driver = driverTxt;
	        conexion = connectionUrl;
	        if(connectorDB == null){
	        	connectorDB = new AccessDB(driver,conexion);
	        }
	        
	        
	    } finally {
	        br.close();
	    }
	
	
	    return connectorDB;
	}
}
