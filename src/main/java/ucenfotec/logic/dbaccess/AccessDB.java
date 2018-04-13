package ucenfotec.logic.dbaccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessDB {
	private Connection conn = null;
	private Statement st;
	

	public AccesoDB(String driver,String conexion) throws SQLException{
		conn = DriverManager.getConnection(conexion);
		st = conn.createStatement();
	}
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		return conn.prepareStatement(sql);
    }
        
    public CallableStatement getCallableStatement(String sql) throws SQLException{
        return conn.prepareCall(sql);
    }
	
	public void ejecutarSQL(String sentencia) 
	throws SQLException{	
		st.execute(sentencia);		
	}
	
	public ResultSet ejecutarSQL(String sentencia,
								boolean retorno) throws SQLException{
		ResultSet rs;
		rs = st.executeQuery(sentencia);
		return rs;
	}
	
	public void iniciarTransaccion()
	throws java.sql.SQLException{
		conn.setAutoCommit(false);	
	}
	
	public void terminarTransaccion() throws java.sql.SQLException{
		conn.setAutoCommit(true);
	}
		
	public void aceptarTransaccion() throws java.sql.SQLException{
		conn.commit();
	}

	public void deshacerTransaccion() throws java.sql.SQLException{
		conn.rollback();	
	}

	protected void finalize(){
		try {
			conn.close();
                       
		}
		catch(SQLException e){
			e.getErrorCode();
			e.getSQLState();
			e.getCause();
		}
               
	}
}
