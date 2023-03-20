package dao;

import dal.DBContext;
import entity.Customer;
import entity.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
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
            pstm = connection.prepareStatement("SELECT * FROM [product]");
            rs = pstm.executeQuery();

            Product product = null;
            while (rs.next()) {
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

    public String convertToPicture(byte[] imageData, Integer productId) {
        String directoryPath = "D:\\Assignment\\Assignment\\CarManager\\web\\image\\";
        
        String fileName = "img_" + productId + ".png";
        //System.out.println("Hello");
        String result = "";
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            File file = new File(directoryPath + fileName);
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            // write image data to file
            bos.write(imageData);

            // flush and close streams
            bos.flush();
            bos.close();
            fos.close();

            System.out.println("Image saved to " + directoryPath + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "image\\" +  fileName;
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

    public boolean saveProduct(Product product) throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        try {
            connection = bContext.getConnection();
            ProductDao dao = new ProductDao();
            int id = getBiggestId() + 1;
            product.setProductURLImg(dao.convertToPicture(product.getProductImg(), id));

            pstm = connection.prepareStatement("INSERT INTO [product]([product_name],[product_price],[product_type],[product_img],[product_des]) VALUES (?,?,?,?,?)");
            pstm.setString(1, product.getProductName());
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
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProduct(int id) throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        try {
            connection = bContext.getConnection();
            ProductDao dao = new ProductDao();

            pstm = connection.prepareStatement("DELETE FROM [product] WHERE [product_id] = ?");
            pstm.setInt(1, id);
            i = pstm.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pstm, connection);
        }
        if(i != 0){
            return true;
        }
        return false;
    }

    public Product getProductById(int carId) throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Product product = new Product();
        try {
            connection = bContext.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM [product] WHERE [product_id] = ?");
            pstm.setInt(1, carId);
            rs = pstm.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getLong("product_price"));
                product.setProductType(rs.getString("product_type"));
                product.setProductURLImg(rs.getString("product_img"));
                product.setProductDes(rs.getString("product_des"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pstm, connection);
        }
        return product;
    }

    public boolean updateProduct(Product p) throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int i = 0;
        try {
            connection = bContext.getConnection();
            pst = connection.prepareStatement("UPDATE [product] SET [product_type] = ?, [product_name] = ?, [product_price] = ?, [product_des] = ? WHERE [product_id] =  ?");

            pst.setString(1, p.getProductType());
            pst.setString(2, p.getProductName());
            pst.setLong(3, p.getProductPrice());
            pst.setString(4, p.getProductDes());
            pst.setInt(5, p.getProductId());

            i = pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pst, connection);
        }
        if(i != 0){
            return true;
        }
        return false;
    }
}
