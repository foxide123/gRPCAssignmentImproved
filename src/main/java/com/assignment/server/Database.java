package com.assignment.server;


import com.assignment.protobuf.Animal;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static String dataUrl = "jdbc:postgresql://abul.db.elephantsql.com:5432/kxbpghuf";
    private static String dataPassword = "yn6B1EMc4s4pB9QgbbpCzH-tNxFxTSTF";
    private static String dataUser = "kxbpghuf";



    public static Animal getAnimalById(long id)
    {
        Animal.Builder tmpAnimal = Animal.newBuilder();
        String SQL = "SELECT * FROM tmpAnimal WHERE addressID=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpAnimal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpAnimal.build();
    }



    private static void process(ResultSet rs, Animal.Builder animal) throws SQLException {
        animal.setRegNr((rs.getLong("reg_nr")));
        animal.setArriveDate(rs.getString("arrive_date"));
        animal.setWeight(rs.getFloat("weight"));
        animal.setOrigin(rs.getString("origin"));
    }

}
