package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.model.OrderDetails;

import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public boolean save(OrderDetails details) throws Exception {
        String sql = "INSERT INTO OrderDetail VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql,details.getOrderId(),details.getItemCode(),details.getQty(),details.getUnitPrice());
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public OrderDetails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws Exception {
        return null;
    }

}
