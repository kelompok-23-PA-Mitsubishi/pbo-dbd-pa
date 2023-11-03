/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;
import java.sql.*;
import koneksi.Database;

/**
 *
 * @author Dinnu & Aufa
 */
public class Kendaraan {
    String id_Kendaraan;
    String ukuranmesin_Kendaraan;
    String model;
    String warna;
    static Database db = new Database();
    static ArrayList<Kendaraan> ArrayKendaraan = new ArrayList<>();
    
    public Kendaraan(String id_Kendaraan, String ukuranmesin_Kendaraan, String model, String warna) {
        this.id_Kendaraan = id_Kendaraan;
        this.ukuranmesin_Kendaraan = ukuranmesin_Kendaraan;
        this.model = model;
        this.warna = warna;
    }

    public String getId_Kendaraan() {
        return id_Kendaraan;
    }

    public void setId_Kendaraan(String id_Kendaraan) {
        this.id_Kendaraan = id_Kendaraan;
    }

    public String getUkuranmesin_Kendaraan() {
        return ukuranmesin_Kendaraan;
    }

    public void setUkuranmesin_Kendaraan(String ukuranmesin_Kendaraan) {
        this.ukuranmesin_Kendaraan = ukuranmesin_Kendaraan;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public static ArrayList<Kendaraan> readKendaraan() throws SQLException{
        ArrayKendaraan.clear();
        String query = "SELECT * FROM Kendaraan";
        ResultSet rs = db.executeSelectQuery(query);
        while (rs.next()) {            
            String id_kendaraan = rs.getString("ID Kendaraan");
            String ukuran_mesin = rs.getString("Ukuran mesin");
            String model = rs.getString("Model");
            String warna = rs.getString("Warna");
            Kendaraan kendaraanBaru = new Kendaraan(id_kendaraan, ukuran_mesin, model, warna);
            ArrayKendaraan.add(kendaraanBaru);
        }
        return ArrayKendaraan;
    }
    
    public static void createKendaraan(String id_kendaraan, String ukuran_mesin, String model, String warna) throws SQLException{
        Kendaraan kendaraanBaru = new Kendaraan(id_kendaraan, ukuran_mesin, model, warna);
        ArrayKendaraan.add(kendaraanBaru);
        String query = String.format("INSERT INTO Kendaraan VALUES ('%s','%s','%s')",
                kendaraanBaru.getId_Kendaraan(),kendaraanBaru.getUkuranmesin_Kendaraan(),kendaraanBaru.getModel(),kendaraanBaru.getWarna());
        db.executeUpdateQuery(query);
    }
    
    public static void deleteKendaraan(String id_Kendaraan) throws SQLException{
        for (Kendaraan kendaraan : ArrayKendaraan) {
            if (kendaraan.getId_Kendaraan().equals(id_Kendaraan)) {
                ArrayKendaraan.remove(kendaraan);
                String query = String.format("DELETE FROM kendaraan WHERE id_kendaraan = '%s'", kendaraan.getId_Kendaraan());
                db.executeUpdateQuery(query);
                break;
            }
        }
    }
    
    public static void updateKendaraan(String id_kendaraan, String ukuran_mesin, String model, String warna) throws SQLException{
        for (Kendaraan kendaraan : ArrayKendaraan) {
            if (kendaraan.getId_Kendaraan().equals(id_kendaraan)) {
                kendaraan.setUkuranmesin_Kendaraan(ukuran_mesin);
                kendaraan.setModel(model);
                kendaraan.setWarna(warna);
                String query = String.format("UPDATE Kendaraan SET ukuran_mesin = '%s', model = '%s' WHERE id_kendaraan = '%s' ",
                        kendaraan.getUkuranmesin_Kendaraan(),kendaraan.getModel(),kendaraan.getId_Kendaraan());
                db.executeUpdateQuery(query);
            }
        }
    }
    
}
