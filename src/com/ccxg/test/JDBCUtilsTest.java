package com.ccxg.test;

import com.ccxg.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author ccxg
 * @create 2024-08-21 11:25
 */
public class JDBCUtilsTest {
    @Test
    public void testJdbcUtils() {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from t_game";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("author")+" "
                        +rs.getString("name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
