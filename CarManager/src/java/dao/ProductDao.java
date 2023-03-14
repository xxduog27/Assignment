package dao;

import dal.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductDao extends DBContext{
    public List<Product> getAllProduct() throws SQLException {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        try {
            connection = new DBContext().connection;
            pstm = connection.prepareStatement("SELECT * FROM [product]");
            rs = pstm.executeQuery();

            Product product = null;
            while (rs.next()){
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getLong("product_price"));
                product.setProductType(rs.getString("product_type"));
                product.setProductImg(rs.getBlob("product_img").getBytes(1,(int)rs.getBlob("product_img").length()));
                product.setProductDes(rs.getString("product_des"));
                productList.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBContext.(rs, pstm, connection);
        }
        return productList;
    }

    public String convertToPicture(byte[] photo, Integer productId) {
        //System.out.println("Hello");
        String result = "";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(photo);
            BufferedImage image = ImageIO.read(bis);

            File output = new File("D:\\PRJ_Assignment_Backup\\src\\main\\webapp\\image\\" + "img_" + productId + ".png");

            output.createNewFile();

            if (ImageIO.write(image, "png", output)) {
                String path = "image\\" + "img_" + productId + ".png";
                result = path;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean saveProduct(Product product ) throws SQLException {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        try {
            connection = DBContext.getConnection();

            pstm = connection.prepareStatement("INSERT INTO [product]([product_name],[product_price],[product_type],[product_img],[product_des]) VALUES (?,?,?,?,?)");
            pstm.setString(1,product.getProductName());
            pstm.setLong(2, product.getProductPrice());
            pstm.setString(3, product.getProductType());
            pstm.setBytes(4, product.getProductImg());
            pstm.setString(5, product.getProductDes());
            i = pstm.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBContext.closeConnection(rs, pstm, connection);
        }
        if (i != 0){
            return true;
        }else{
            return false;
        }
    }
}
