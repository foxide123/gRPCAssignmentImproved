package com.assignment.server;


import com.assignment.protobuf.Animal;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static String dataUrl = "jdbc:postgresql://mouse.db.elephantsql.com:5432/ejsrwscs";
    private static String dataPassword = "k52Amb9p9_94Zm28aH7k5W076i-Et2Qa";
    private static String dataUser = "ejsrwscs";



    public static Animal getAnimalById(long id)
    {
        Animal.Builder animal = Animal.newBuilder();
        //AnimalModel animalModel = new AnimalModel(0,null,0,null);
        String SQL = "SELECT * FROM animal WHERE reg_nr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal.build();
    }


    public static ArrayList<Animal> getAllAnimals()
    {
        ArrayList<Animal> animals = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            stmt = conn.createStatement();
            String SQL = "Select * FROM animal";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Animal.Builder animal = Animal.newBuilder();
                process(rs, animal);
                animals.add(animal.build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

/*
    public static Animal getAnimalById(long id)
    {
        Animal.Builder tmpAnimal = Animal.newBuilder();
        String SQL = "SELECT * FROM animal WHERE reg_nr=?";
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
*/


    private static void process(ResultSet rs, Animal.Builder animal) throws SQLException {
        animal.setRegNr(rs.getLong("reg_nr"));
        animal.setArriveDate(rs.getString("arrive_date"));
        animal.setWeight(rs.getFloat("weight"));
        animal.setOrigin(rs.getString("origin"));
    }

}
