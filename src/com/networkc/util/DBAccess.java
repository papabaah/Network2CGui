package com.networkc.util;

import com.networkc.model.Formula;
import com.networkc.model.Rectangle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
*This is a Database Access Class used to connect the application
* data to the underlining database.
* */
public class DBAccess {
  // MySQL driver string.
  private final String DRIVER = "com.mysql.cj.jdbc.Driver";
  //The name of the Database
  private final String DBNAME = "db_nwk2C";

  // The username of the Database Server Account
  private final String USERNAME = "networkc";

  // The password of the Database Server Account
  private final String PASSWORD = "12345";

  // The IP of the host computer
  private final String HOST = "localhost";

  private Connection connect = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  public DBAccess() {
    try {
      Class.forName(DRIVER);
      connect = DriverManager.getConnection(getUrl());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int save(Rectangle rec) throws SQLException {
    String query = "INSERT INTO rectangle(length, height, result, formula, dateCreated) values(?, ?, ?, ?, ?)";
    ps = connect.prepareStatement(query);
    ps.setDouble(1, rec.getLength() );
    ps.setDouble(2, rec.getHeight());
    ps.setDouble(3, rec.getResult());
    ps.setString(4, rec.getFormula().toString());
    ps.setTimestamp(5, rec.getDateCreated());
    return ps.executeUpdate();
  }

  public List<Rectangle> findAll() throws SQLException {
    String query = "SELECT * FROM rectangle";
    ps = connect.prepareStatement(query);
    rs = ps.executeQuery();

    List<Rectangle> listRec = new ArrayList<>();
    while(rs.next()) {
      Rectangle rec = new Rectangle();
      rec.setId(rs.getInt("id"));
      rec.setLength(rs.getDouble("length"));
      rec.setHeight(rs.getDouble("height"));
      rec.setResult(rs.getDouble("result"));
      rec.setFormula(Formula.valueOf(rs.getString("formula")));
      rec.setDateCreated(rs.getTimestamp("dateCreated"));
      listRec.add(rec);
    }
    return listRec;
  }

  public int delete(int id) throws SQLException {
    String query = "DELETE FROM rectangle WHERE id = ?";
    ps = connect.prepareStatement(query);
    ps.setInt(1, id);
    return ps.executeUpdate();
  }

  private String getUrl() {
    return "jdbc:mysql://" + USERNAME + ":" + PASSWORD +"@"+HOST+"/"+DBNAME;
  }
}
