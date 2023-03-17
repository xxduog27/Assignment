package dao;

import dal.DBContext;
import entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public List<Customer> getAllUser() throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Customer> userList = new ArrayList<>();
        try {
            connection = bContext.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM [customer]");
            rs = pstm.executeQuery();

            Customer user = null;
            while (rs.next()){
                user = new Customer();
                user.setCustomerId(rs.getInt("customer_id"));
                user.setCustomerName(rs.getString("customer_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getInt("admin"));
                userList.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bContext.closeConnection(rs, pstm, connection);
        }
        return userList;
    }

    public boolean saveUser(Customer user ) throws SQLException {
        DBContext bContext = new DBContext();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        List<Customer> userList = new ArrayList<>();
        try {
            connection = bContext.getConnection();

            pstm = connection.prepareStatement("INSERT INTO [customer]([customer_name],[email],[password],[admin]) VALUES (?,?,?,?)");
            pstm.setString(1,user.getCustomerName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.setInt(4,user.getAdmin());
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
