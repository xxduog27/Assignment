package servlet;


import dao.CustomerDao;
import dao.ProductDao;
import entity.Customer;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println(session.getAttribute("adminSession"));

        CustomerDao dao = new CustomerDao();


        try {
            boolean flag = false;
            for(Customer user : dao.getAllUser()){

                if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                    //Nếu có tk trong db
                    if (user.getAdmin() == 1){
                        session.setAttribute("adminSession",1);
                    }
                    session.setAttribute("emailSession",email);
//                    resp.sendRedirect(req.getContextPath() + "/GetProductServlet");

                    resp.sendRedirect("indexServlet");
                    flag = true;

                    break;
                }
            }
            if (!flag){
                //Nếu tk không tồn tại thì cho đăng nhập lại
                resp.sendRedirect("Login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
