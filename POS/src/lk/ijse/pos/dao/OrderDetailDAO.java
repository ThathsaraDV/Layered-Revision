package lk.ijse.pos.dao;

import lk.ijse.pos.model.OrderDetails;

public interface OrderDetailDAO {

    public boolean saveOrderDetails(OrderDetails details) throws Exception;

}
