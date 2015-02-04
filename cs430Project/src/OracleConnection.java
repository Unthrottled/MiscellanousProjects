import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;


public class OracleConnection {

	private Connection con;
    private OraclePreparedStatement stmt;
    private OracleResultSet rs;
    
    public OracleConnection(){
    try {
        Properties ociProps = new Properties();
        String url = "jdbc:oracle:thin:@dbserv.cs.siu.edu:1521:cs";
        ociProps.put ("user","asimons");
        ociProps.put ("password", "alexisgreat");
        con = DriverManager.getConnection (url, ociProps);
	    } catch (SQLException ex) {
	        System.out.println("error code : " + ex.getErrorCode());
	        System.out.println("error message : " + ex.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
      
    }
    public OracleResultSet queryDataBase(String query){
        try{
    	stmt = (OraclePreparedStatement) con.prepareStatement(query);
        rs = (OracleResultSet) stmt.executeQuery();
          }catch (SQLException ex) {
	        System.out.println("error code : " + ex.getErrorCode());
	        System.out.println("error message : " + ex.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        
    	return rs;
    }
    public void closeRS(){
    	try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
