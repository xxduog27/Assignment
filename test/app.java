package test;

import dal.DBContext;
import dao.CustomerDao;
import dao.ProductDao;
import entity.Customer;
import entity.Product;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class app {
    public static void main(String[] args) throws Exception{
        DBContext bContext = new DBContext();
        Connection c = bContext.getConnection();
        
            ProductDao pd = new ProductDao();
            int carId = 8;

            String name = "22";
            String type = "Gasoiline Car";
            Long price = 11l ;
            String des = "Hello";

            // Create new Product
            Product p = new Product(carId, name,price, type,des);
//        
            pd.updateProduct(p);
//        ProductDao dap = new ProductDao();
//        System.out.println(dap.getProductById(8).toString());
        
//        CustomerDao dao = new CustomerDao();
//        List<Customer> customers = dao.getAllUser();
//        
//        for(Customer cs: customers){
//            System.out.println(cs.toString());
//        }
//        PreparedStatement pstm = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM user");

//        ProductDao dao = new ProductDao();
//        System.out.println(dao.getBiggestId());

//        int count = rs.getInt(Integer.valueOf(String.valueOf(pstm.executeQuery("SELECT TOP(1) product_id FROM product ORDER BY product_id DESC"))));


//        Customer user = new Customer();
//        user.setCustomerName("Dang");
//        user.setEmail("dang@gmail.com");
//        user.setPassword("1");
//        user.setAdmin(0);
//
//        System.out.println(dao.saveUser(user));

//        List<Customer> userList = dao.getAllUser();
//
//        for (Customer user1 : userList){
//            System.out.println(user1.getAdmin());
//        }

//    ProductDao dao2 = new ProductDao();
//        List<Product> productList = dao2.getAllProduct();
//        for (Product p : productList){
//            System.out.println(p.toString());
//        }
//
//
//        System.out.println("Hello" + dao2.convertToPicture(productList.get(0).getProductImg(),productList.get(0).getProductId()));
//
   }
    }
