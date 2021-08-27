package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.ItemDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    public boolean addItem(Item item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");

        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());

        return pstm.executeUpdate()>0;

    }

    public boolean updateItem(Item item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitprice=?, qtyonhand=? WHERE id=?");
        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, item.getUnitPrice());
        pstm.setObject(3, item.getQtyOnHand());
        pstm.setObject(4, item.getCode());

        return pstm.executeUpdate()>0;
    }

    public boolean updateQtyOnHand(String code, int qtyOnHand) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET qtyOnHand=? WHERE id=?");
        pstm.setObject(1, qtyOnHand);
        pstm.setObject(2, code);

        return pstm.executeUpdate()>0;
    }

    public boolean deleteItem(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE id=?");
        pstm.setObject(1, id);

        return pstm.executeUpdate()>0;
    }

    public Item searchItem(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item where id=?");
        pstm.setObject(1, id);

        ResultSet rst = pstm.executeQuery();

        if (rst.next()){
            return new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));
        }
        return null;
    }

    public ArrayList<Item> getAllItems() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<Item> items = new ArrayList<>();
        while (rst.next()){
            Item item = new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));
            items.add(item);
        }

        return items;
    }





}
