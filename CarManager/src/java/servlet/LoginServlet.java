package servlet;


import dao.CustomerDao;
import entity.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        CustomerDao dao = new CustomerDao();

        try {
            boolean flag = false;
            for(Customer user : dao.getAllUser()){
                if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                    resp.sendRedirect("index.jsp");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                resp.sendRedirect("Login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
