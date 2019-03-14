package com.zr.webmall.dao;

import com.zr.webmall.framework.DataUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author: LiGX
 * @Date: 2019/3/15
 */
public class ItemDao {
    private QueryRunner qr=new QueryRunner(DataUtil.getDataSource());
    public List<Map<String, Object>> findAll(){
        String sql="select * from items";
        try {
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Map<String, Object> queryOne(int id) {
        String sql = "select * from items where id=?";
        try {
            Map<String, Object> query = qr.query(sql, new MapHandler(), id);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int add(Map<String, Object> item) {
        String sql = "INSERT INTO db_mall.items (id, name, city, price, number, picture) VALUES (null,?,?,?,?,?)";
        try {
            int i = qr.update(sql, item.get("name"), item.get("city"), item.get("price"), item.get("number"), item.get("picture"));
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Map<String, Object> item) {
        String sql = "UPDATE db_mall.items SET name = ?, city = ?, price = ?, number = ?, picture = ? WHERE id = ?";
        try {
            int i = qr.update(sql, item.get("name"), item.get("city"), item.get("price"), item.get("number"), item.get("picture"),item.get("id"));
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "delete from items  WHERE id = ?";
        try {
            int i = qr.update(sql, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
