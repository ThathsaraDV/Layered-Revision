package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.OrderDetailDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public boolean saveOrderDetails(OrderDetails details) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO OrderDetail VALUES (?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, details.getOrderId());
        pstm.setObject(2, details.getItemCode());
        pstm.setObject(3, details.getQty());
        pstm.setObject(4, details.getUnitPrice());

        return pstm.executeUpdate()>0;
    }

}
