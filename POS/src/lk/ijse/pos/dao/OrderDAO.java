package lk.ijse.pos.dao;

import lk.ijse.pos.model.Orders;

public interface OrderDAO {

    public boolean saveOrder(Orders orders) throws Exception;

}
