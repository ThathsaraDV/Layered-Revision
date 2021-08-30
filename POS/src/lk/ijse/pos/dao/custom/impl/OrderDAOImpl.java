package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    public boolean save(Orders orders) throws Exception {
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql,orders.getId(),orders.getDate(),orders.getCustomerId());

    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Orders search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        return null;
    }

}
