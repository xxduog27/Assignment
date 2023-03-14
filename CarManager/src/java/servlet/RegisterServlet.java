package servlet;

import dao.CustomerDao;
import entity.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Integer admin = 0;


        if (req.getParameter("admin") != null){
            admin = Integer.parseInt(req.getParameter("admin"));
        }

        if (name.equals("") || email.equals("") || password.equals("")){
            resp.sendRedirect("Register.jsp");
        }else {
            Customer userSave = new Customer(name,email,password,admin);

            CustomerDao dao = new CustomerDao();

            try {
                boolean flag = false;

                for(Customer customer : dao.getAllUser()){
                    if(customer.getEmail().equals(email)){
                        resp.sendRedirect("Register.jsp");
                        flag = true;
                        break;
                    }
                }

                if (!flag){
                    dao.saveUser(userSave);
                    resp.sendRedirect("Login.jsp");
//                resp.sendRedirect("Login.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
