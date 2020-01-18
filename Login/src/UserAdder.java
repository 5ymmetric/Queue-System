import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAdder {

    public static boolean addUserToDatabase(String username, String password) throws SQLException {

        boolean trueFalse = true;

        if (username == null || password == null) {
            return false;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            System.out.println("InstantiationException: ");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException: ");
            e.printStackTrace();
            throw new RuntimeException(e);
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

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            try {
                ps.executeUpdate();

            } catch (SQLException e) {

                trueFalse = false;
            }

            if (ps != null && !ps.isClosed()) {
                ps.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trueFalse;

    }

}
