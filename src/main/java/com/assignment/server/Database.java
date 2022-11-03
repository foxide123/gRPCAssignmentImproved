package com.assignment.server;


import com.assignment.protobuf.Animal;
import com.assignment.protobuf.AnimalPart;
import com.assignment.protobuf.PartPack;
import com.assignment.protobuf.Tray;

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

    public static PartPack getPartPackById(long id)
    {
        PartPack.Builder partPack = PartPack.newBuilder();
        //AnimalModel animalModel = new AnimalModel(0,null,0,null);
        String SQL = "SELECT * FROM product WHERE reg_nr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            int i=0;
            while (rs.next()) {
                process(rs, partPack, i);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partPack.build();
    }

    public static Tray getTrayById(long id)
    {
        Tray.Builder tray = Tray.newBuilder();
        //AnimalModel animalModel = new AnimalModel(0,null,0,null);
        String SQL = "SELECT * FROM tray WHERE reg_nr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            int i=0;
            while (rs.next()) {
                process(rs, tray);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tray.build();
    }


    public static AnimalPart getPartById(long id)
    {
        AnimalPart.Builder animalPart = AnimalPart.newBuilder();
        //AnimalModel animalModel = new AnimalModel(0,null,0,null);
        String SQL = "SELECT * FROM part WHERE reg_nr=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            int i=0;
            while (rs.next()) {
                process(rs, animalPart);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animalPart.build();
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

    public static ArrayList<PartPack> getAllProducts()
    {
        ArrayList<PartPack> products = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            stmt = conn.createStatement();
            String SQL = "Select * FROM product";
            rs = stmt.executeQuery(SQL);

            int i = 0;
            while (rs.next()) {
                PartPack.Builder product = PartPack.newBuilder();
                process(rs, product,i);
                products.add(product.build());
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static Animal updateAnimal(Animal animal)
    {
        Connection conn = null;
        /*
         * cvr,password,firstname,lastname,email,phone,
         * description,address,hourlyRate, rating*/
        String SQL = "UPDATE animal SET "
                + "reg_nr=?"
                + "arrive_date=?"
                + "weight=?"
                + "origin=?"
                + " WHERE reg_nr=?";
        PreparedStatement posted = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setLong(1, animal.getRegNr());
            posted.setString(2, animal.getArriveDate());
            posted.setFloat(3, animal.getWeight());
            posted.setString(4, animal.getOrigin());
            posted.setLong(5, animal.getRegNr());

            posted.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getAnimalById(animal.getRegNr());
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



    private static void process(ResultSet rs, PartPack.Builder partPack, int i) throws SQLException {
        partPack.setPackRegNr(rs.getLong("reg_nr"));
        partPack.setTrayRef(i, rs.getLong("tray_ref"));

    }

    private static void process(ResultSet rs, Tray.Builder tray) throws SQLException {
        tray.setTrayRegNr(rs.getLong("reg_nr"));
        tray.setWeight(rs.getFloat("weight"));
        tray.setPartType(rs.getString("type"));
        tray.setPartRef(rs.getLong("part_ref"));

    }

    private static void process(ResultSet rs, AnimalPart.Builder animalPart) throws SQLException {
        animalPart.setAnimalRef(rs.getLong("regNr"));
        animalPart.setType(rs.getString("type"));
        animalPart.setAnimalRef(rs.getLong("animalRef"));
        animalPart.setWeight(rs.getLong("weight"));

    }


}
