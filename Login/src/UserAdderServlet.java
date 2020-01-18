import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAdderServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    	
    	String username = null;
    	String password = null;

        if(request.getParameter("submit").equals("submitted")) {
            username = request.getParameter("username");
            password = request.getParameter("password");
        }

        boolean result = false;
		try {
			result = UserAdder.addUserToDatabase(username, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        try {
            if(result) {
                response.sendRedirect("index.html");
            } else {
                response.sendRedirect("error.html");
            }
        } catch (Exception e) {

        }
    }


}
