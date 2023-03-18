package servlet;




import dao.ProductDao;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyProducts", value = "/my-product")
public class MyProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao pd = new ProductDao();
            if(request.getParameter("action") == null){
                List<Product> products = pd.getAllProduct();
                request.setAttribute("products", products);
                request.getRequestDispatcher("Edit.jsp").forward(request, response);
            } else if(request.getParameter("action").equals("add-car")){
                response.sendRedirect(request.getContextPath()+"/add-product");
            } else if(request.getParameter("action").equals("edit-product")){
                response.sendRedirect(request.getContextPath()+"/edit");
            } else if(request.getParameter("action").equals("delete")){
                pd.deleteProduct(Integer.parseInt(request.getParameter("car-id")));
                response.sendRedirect(request.getContextPath()+"/EditProductServlet");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/my-product");
        }

    }

}