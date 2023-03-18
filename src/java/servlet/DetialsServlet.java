/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.ProductDao;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author trand
 */
@WebServlet(name = "editDetails", value = "/editDetails")
public class DetialsServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao pd = new ProductDao();
            String carId = request.getParameter("car-id");

            Product p = pd.getProductById(Integer.parseInt(carId)); 

            request.setAttribute("product", p);
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);

            
        } catch (Exception e) {
            response.sendRedirect("404.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao pd = new ProductDao();
            Integer carId = Integer.valueOf(request.getParameter("car_id")) ;

            String name = request.getParameter("product_name");
            String type = request.getParameter("product_type");
            Long price = Long.valueOf(request.getParameter("product_price")) ;
            String des = request.getParameter("product_des");

            // Create new Product
            Product p = new Product(carId, name,price, type,des);
            // Add it to database
            if(pd.updateProduct(p)){
                response.sendRedirect(request.getContextPath()+"/EditProductServlet");
            }else {
                response.getWriter().println("fail!");
            }
        } catch (Exception e){
            
            response.getWriter().println(e.getStackTrace());
        }
    }
}
