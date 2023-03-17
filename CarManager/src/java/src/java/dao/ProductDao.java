package dao;

import dal.DBContext;
import entity.Customer;
import entity.Product;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public List<Product> getAllProduct() throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        try {
            connection = bContext.getConnection();
            pstm = connection.prepareStatement ("SELECT * FROM [product]");
            rs = pstm.executeQuery();

            Product product = null;
            while (rs.next()){
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getLong("product_price"));
                product.setProductType(rs.getString("product_type"));
                product.setProductURLImg(rs.getString("product_img"));
                product.setProductDes(rs.getString("product_des"));
                productList.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pstm, connection);
        }
        return productList;
    }

    public String convertToPicture(byte[] photo, Integer productId) {
        //System.out.println("Hello");
        String result = "";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(photo);
            BufferedImage image = ImageIO.read(bis);

            File output = new File("\"D:\\Assignment\\Assignment\\CarManager\\web\\WEB-INF\\image\"" + "img_" + productId + ".jpg");
            

            output.createNewFile();

            if (ImageIO.write(image, "png", output)) {
                String path = "image\\" + "img_" + productId + ".jpg";
                result = path;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getBiggestId() throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Integer biggestID = null;
        try {
            connection = bContext.getConnection();
            pstm = connection.prepareStatement("SELECT MAX(product_id) AS product_id FROM product");
            rs = pstm.executeQuery();
            if (rs.next()) {
                biggestID = rs.getInt("product_id");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pstm, connection);
        }
        return biggestID;
    }

    public boolean saveProduct(Product product ) throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        try {
            connection = bContext.getConnection();
            ProductDao dao = new ProductDao();
            int id = getBiggestId() + 1;
            product.setProductURLImg(dao.convertToPicture(product.getProductImg(),id));

            pstm = connection.prepareStatement("INSERT INTO [product]([product_name],[product_price],[product_type],[product_img],[product_des]) VALUES (?,?,?,?,?)");
            pstm.setString(1,product.getProductName());
            pstm.setLong(2, product.getProductPrice());
            pstm.setString(3, product.getProductType());
            pstm.setString(4, product.getProductURLImg());
            pstm.setString(5, product.getProductDes());
            i = pstm.executeUpdate();



        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pstm, connection);
        }
        if (i != 0){
            return true;
        }else{
            return false;
        }
    }
}
