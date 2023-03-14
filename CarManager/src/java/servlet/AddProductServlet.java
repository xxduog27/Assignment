package servlet;

import dao.ProductDao;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.*;
import java.sql.SQLException;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part partProductName = request.getPart("product_name");
        InputStream fileProductName = partProductName.getInputStream();

        BufferedReader readerName = new BufferedReader(new InputStreamReader(fileProductName));
        StringBuilder stringBuilderName = new StringBuilder();
        String lineName = null;
        while ((lineName = readerName.readLine()) != null) {
            stringBuilderName.append(lineName);
        }
        String productName = stringBuilderName.toString();

        Part partProductPrice= request.getPart("product_price");
        InputStream fileProductPrice = partProductPrice.getInputStream();

        BufferedReader readerPrice = new BufferedReader(new InputStreamReader(fileProductPrice));
        StringBuilder stringBuilderPrice = new StringBuilder();
        String linePrice = null;
        while ((linePrice = readerPrice.readLine()) != null) {
            stringBuilderPrice.append(linePrice);
        }
        Long productPrice = Long.valueOf(stringBuilderPrice.toString());

        Part partProductType= request.getPart("product_type");
        InputStream fileProductType = partProductType.getInputStream();

        BufferedReader readerType = new BufferedReader(new InputStreamReader(fileProductType));
        StringBuilder stringBuilderType = new StringBuilder();
        String lineType = null;
        while ((lineType = readerType.readLine()) != null) {
            stringBuilderType.append(lineType);
        }
        String productType = stringBuilderType.toString();

        Part partProductDes= request.getPart("product_des");
        InputStream fileProductDes = partProductDes.getInputStream();

        BufferedReader readerDes = new BufferedReader(new InputStreamReader(fileProductDes));
        StringBuilder stringBuilderDes = new StringBuilder();
        String lineDes = null;
        while ((lineDes = readerDes.readLine()) != null) {
            stringBuilderDes.append(lineDes);
        }
        String productDes = stringBuilderDes.toString();

        InputStream img = request.getPart("img-input").getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = img.read(buffer)) > -1) {
            baos.write(buffer, 0, len);
        }
        baos.flush();
        byte[] productImage = baos.toByteArray();

        Product productSave = new Product(productName,productPrice,productType,productImage,productDes);
        ProductDao dao = new ProductDao();

        try {
            dao.saveProduct(productSave);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("AddProduct.jsp");
    }
}
