package com.example.demo;

import com.example.demo.dataManagers.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DataBaseAssistant {
    private final JdbcTemplate jdbcTemplate;

    DataBaseAssistant(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:/home/aleksey/home/public/h2");
        dataSource.setPassword("");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean add(Desktop data){
        try {
            jdbcTemplate.update("INSERT INTO descktop(series_number, maker, price, counter, form_factor)" +
                            " VALUES(?, ?, ?, ?, ?)", data.getSeriesNumber(), data.getMaker(), data.getPrice(),
                    data.getCounter(), data.getFormFactor());
            return true;
        } catch (Exception ignored){
            return false;
        }
    }

    public boolean add(HardDisk data){
        try {
            jdbcTemplate.update("INSERT INTO hard(series_number, maker, price, counter, volume)" +
                            " VALUES(?, ?, ?, ?, ?)", data.getSeriesNumber(), data.getMaker(), data.getPrice(),
                    data.getCounter(), data.getVolume());
            return true;
        } catch (Exception ignored){
            return false;
        }
    }

    public boolean add(Monitor data){
        try {
            jdbcTemplate.update("INSERT INTO monitor(series_number, maker, price, counter, diagonal)" +
                            " VALUES(?, ?, ?, ?, ?)", data.getSeriesNumber(), data.getMaker(), data.getPrice(),
                    data.getCounter(), data.getDiagonal());
            return true;
        } catch (Exception ignored){
            return false;
        }
    }

    public boolean add(Notebook data){
        try {
            jdbcTemplate.update("INSERT INTO monitor(series_number, maker, price, counter, size)" +
                            " VALUES(?, ?, ?, ?, ?)", data.getSeriesNumber(), data.getMaker(), data.getPrice(),
                    data.getCounter(), data.getSize());
            return true;
        } catch (Exception ignored){
            return false;
        }
    }

    public Data searchId(Class clazz, int id){
        if (Desktop.class.equals(clazz)) {
            return jdbcTemplate.query(
                    "select * from decktop where id = ?", new Integer[]{id},
                    (rs, rowNum) -> new Desktop(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getInt(4), rs.getInt(5),
                            rs.getString(6))).get(0);
        } else if(HardDisk.class.equals(clazz)){
            return jdbcTemplate.query(
                    "select * from hard where id = ?", new Integer[]{id},
                    (rs, rowNum) -> new HardDisk(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getInt(4), rs.getInt(5),
                            rs.getInt(6))).get(0);
        } else if(Monitor.class.equals(clazz)){
            return jdbcTemplate.query(
                    "select * from monitor where id = ?", new Integer[]{id},
                    (rs, rowNum) -> new Monitor(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getInt(4), rs.getInt(5),
                            rs.getInt(6))).get(0);
        } else if(Notebook.class.equals(clazz)){
            return jdbcTemplate.query(
                    "select * from notebook where id = ?", new Integer[]{id},
                    (rs, rowNum) -> new Notebook(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getInt(4), rs.getInt(5),
                            rs.getInt(6))).get(0);
        } else return null;
    }
}
