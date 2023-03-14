package test;

import dao.CustomerDao;

import dal.DBContext;

import java.sql.Connection;
import java.sql.Statement;

public class app {
    public static void main(String[] args) throws Exception{
        Connection connection = DBContext.getConnection();
        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM user");

        CustomerDao dao = new CustomerDao();


        CustomerDao user = new CustomerDao();
        user.setUserName("Duong");
        user.setEmail("duong@gmail.com");
        user.setPassword("1");

       System.out.println(dao.saveUser(user));

//        List<User> userList = dao.getAllUser();
//
//        for (Customer user1 : userList){
//            System.out.println(user1.toString());
//        }
    }
}
