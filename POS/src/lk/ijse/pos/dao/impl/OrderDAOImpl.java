package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.OrderDAO;
import lk.ijse.pos.model.Orders;

public class OrderDAOImpl implements OrderDAO {

    public boolean saveOrder(Orders orders) throws Exception {
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql,orders.getId(),orders.getDate(),orders.getCustomerId());

    }

}
