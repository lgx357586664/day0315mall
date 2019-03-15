package com.zr.webmall.item.dao;

import com.zr.webmall.framework.DataUtil;
import com.zr.webmall.item.entity.Items;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author: LiGX
 * @Date: 2019-03-15 上午 9:35
 */
public class ItemsDao {
    QueryRunner qr =new QueryRunner(DataUtil.getDataSource());
    public List<Items>  findAll(){
        String sql="select * from items";
        try {
            List<Items> list = qr.query(sql, new BeanListHandler<>(Items.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Items queryOne(int id){
        String sql="select *from items where id=?";
        try {
            Items items = qr.query(sql, new BeanHandler<>(Items.class),id);
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int delete(int id){
        String sql="delete from items where id=?";
        try {
            int i = qr.update(sql, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int update(Items items){
        String sql="update items set name = ?, city = ?, price = ?, number = ?, picture = ? WHERE id = ?";
        try {
            int i = qr.update(sql, items.getName(), items.getCity(), items.getPrice(), items.getNumber(), items.getPicture(), items.getId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  int add(Items items){
        String sql="insert into items (id,name,city,price,number,picture)values(null,?,?,?,?,?)";
        try {
            int i = qr.update(sql, items.getName(), items.getCity(), items.getPrice(), items.getNumber(), items.getPicture());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
