package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.model.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {



    public boolean save(Customer customer) throws Exception {
        String sql = "INSERT INTO Customer VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql,customer.getcID(),customer.getName(),customer.getAddress());

    }

    public boolean update(Customer customer) throws Exception {
        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        return CrudUtil.executeUpdate(sql,customer.getName(),customer.getAddress(),customer.getcID());
    }

    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM Customer WHERE id=?";
        return CrudUtil.executeUpdate(sql,id);
    }

    public Customer search(String id) throws Exception {
        String sql = "SELECT * FROM Customer where id=?";
        ResultSet rst = CrudUtil.executeQuery(sql,id);
        if (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
        }

        return null;
    }

    public ArrayList<Customer> getAll() throws Exception {
        String sql = "SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer> customers = new ArrayList<>();
        while (rst.next()){
            Customer customer = new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
            customers.add(customer);
        }

        return customers;
    }



}
