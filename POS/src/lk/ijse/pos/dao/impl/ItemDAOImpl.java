package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.ItemDAO;
import lk.ijse.pos.model.Item;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    public boolean addItem(Item item) throws Exception {
        String sql = "INSERT INTO Item VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql,item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());

    }

    public boolean updateItem(Item item) throws Exception {
        String sql = "UPDATE Item SET description=?, unitprice=?, qtyonhand=? WHERE id=?";
        return CrudUtil.executeUpdate(sql,item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
    }

    public boolean updateQtyOnHand(String code, int qtyOnHand) throws Exception {
        String sql = "UPDATE Item SET qtyOnHand=? WHERE id=?";
        return CrudUtil.executeUpdate(sql,qtyOnHand,code);
    }

    public boolean deleteItem(String id) throws Exception {
        String sql = "DELETE FROM Item WHERE id=?";
        return CrudUtil.executeUpdate(sql,id);
    }

    public Item searchItem(String id) throws Exception {
        String sql = "SELECT * FROM Item where id=?";
        ResultSet rst = CrudUtil.executeQuery(sql,id);

        if (rst.next()){
            return new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));
        }
        return null;
    }

    public ArrayList<Item> getAllItems() throws Exception {
        String sql = "SELECT * FROM Item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Item> items = new ArrayList<>();
        while (rst.next()){
            Item item = new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));
            items.add(item);
        }

        return items;
    }





}
