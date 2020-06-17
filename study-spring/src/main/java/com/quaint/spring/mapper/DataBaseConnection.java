package com.quaint.spring.mapper;

import com.quaint.spring.config.DynamicDataSource;
import com.quaint.spring.po.SpringUserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>
 * desc: 数据库 connection test
 * </p>
 *
 * @author quaint
 * @since 17 June 2020
 */
@Component
public class DataBaseConnection {

    @Autowired
    private DynamicDataSource dataSource;

    public SpringUserPo selectById(Integer id){

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conn = dataSource.getConnection();
            statement = conn.prepareStatement("select * from spring_user where id = ?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            SpringUserPo user = new SpringUserPo();
            if (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public DynamicDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DynamicDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
