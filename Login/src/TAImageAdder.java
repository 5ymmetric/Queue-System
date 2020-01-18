import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TAImageAdder {
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

        PreparedStatement ps = connect.prepareStatement("INSERT INTO pictures(image) VALUES(?)");
       
        
        //Inserting Blob type
        InputStream in = new FileInputStream("C:\\Users\\Karthik.P\\Downloads\\cat(10).jpeg");
        ps.setBlob(1, in);
        //Executing the statement
        ps.execute();
        System.out.println("Record inserted......");
    }
}