import java.sql.*;
import java.io.*;

public class TAImageGetter {
	
	public static void main(String args[]) throws Exception{

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: ");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        Connection connect = null;

        try {
            connect = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
        } catch (SQLException e) {
            System.out.println("SQL Exception");
            throw new RuntimeException(e);
        }

        System.out.println("Connection established......");
        
        byte[] filebytes;

        String query;
        try
        {
                query = "select image from pictures";
                Statement state = connect.createStatement();
                ResultSet rs = state.executeQuery(query);
                if (rs.next())
               {
                         filebytes = rs.getBytes(1);
                         OutputStream targetFile=  
                         new FileOutputStream(
                              "C:\\Users\\Karthik.P\\Downloads\\new.jpg");

                         targetFile.write(filebytes);
                         targetFile.close();
               }        
                
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
        
        System.out.println("Record Retrieved.....");

    }
}
