package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.OrderDetailDAO;
import lk.ijse.pos.model.OrderDetails;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public boolean saveOrderDetails(OrderDetails details) throws Exception {
        String sql = "INSERT INTO OrderDetail VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql,details.getOrderId(),details.getItemCode(),details.getQty(),details.getUnitPrice());
    }

}
