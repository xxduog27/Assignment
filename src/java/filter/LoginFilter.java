package filter;

import dao.ProductDao;
import entity.Product;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebFilter(filterName = "LoginFilter",urlPatterns = {"/index.jsp","/indexServlet"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession();

        String email = (String)session.getAttribute("emailSession");



        if (email == null){
            resp.sendRedirect("Login.jsp");
        }
        chain.doFilter(request, response);
    }
}
