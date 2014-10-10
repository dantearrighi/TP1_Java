package datos;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


public class ConexionBD {

    Connection Cone = null;
	static String Url = "jdbc:mysql://localhost:3306/";
	static String dbName = "Electro_db";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root"; 
	static String password = "";
	
	public void OpenConection()
	{
							try{
								  Class.forName(driver).newInstance();
								  Cone = DriverManager.getConnection(Url+dbName,userName,password);
							}
							catch( Exception e)
							{
								e.printStackTrace();
							}
	}
		
public void CloseConnection()
	{
							try{
								Cone.close();
							}
							catch( Exception e)
							{
								e.printStackTrace();
							}
	}

}
	
			

