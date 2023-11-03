/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import static Entity.Kendaraan.ArrayKendaraan;
import static Entity.Kendaraan.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Database;

/**
 *
 * @author User
 */
public class Mobil {
    String id_mobil;
    int jumlah_penumpang;
    int jumlah_pintu;
    static Database db = new Database();
    static ArrayList<Mobil> ArrayMobil = new ArrayList<>();

    public Mobil(String id_mobil, int jumlah_penumpang, int jumlah_pintu) {
        this.id_mobil = id_mobil;
        this.jumlah_penumpang = jumlah_penumpang;
        this.jumlah_pintu = jumlah_pintu;
    }

    private Mobil(int penumpang, int pintu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(String id_mobil) {
        this.id_mobil = id_mobil;
    }

    public int getJumlah_penumpang() {
        return jumlah_penumpang;
    }

    public void setJumlah_penumpang(int jumlah_penumpang) {
        this.jumlah_penumpang = jumlah_penumpang;
    }

    public int getJumlah_pintu() {
        return jumlah_pintu;
    }

    public void setJumlah_pintu(int jumlah_pintu) {
        this.jumlah_pintu = jumlah_pintu;
    }

    public static Database getDb() {
        return db;
    }

    public static void setDb(Database db) {
        Mobil.db = db;
    }

    public static ArrayList<Mobil> getArrayMobil() {
        return ArrayMobil;
    }

    public static void setArrayMobil(ArrayList<Mobil> ArrayMobil) {
        Mobil.ArrayMobil = ArrayMobil;
    }

public static ArrayList<Mobil> readMobil() throws SQLException {
    ArrayList<Mobil> ArrayMobil = new ArrayList<Mobil>(); // Create a new ArrayList
    String query = "SELECT * FROM Mobil";
    ResultSet rs = db.executeSelectQuery(query);
    while (rs.next()) {
        int jumlah_penumpang = rs.getInt("Jumlah Penumpang");
        int jumlah_pintu = rs.getInt("Jumlah Pintu");
        Mobil mobilBaru = new Mobil(jumlah_penumpang, jumlah_pintu);
        ArrayMobil.add(mobilBaru);
    }
    return ArrayMobil;
}
    
public static void createMobil(int pintu, int penumpang) throws SQLException {
    Mobil mobilBaru = new Mobil(penumpang, pintu);
    ArrayMobil.add(mobilBaru); // Use the correct object name
    String query = String.format("INSERT INTO mobil VALUES ('%s','%s')",
            mobilBaru.getJumlah_penumpang(), mobilBaru.getJumlah_pintu());
    db.executeUpdateQuery(query);
}
    
public static void deleteMobil(String id_Kendaraan) throws SQLException {
    for (Mobil mobil : ArrayMobil) {
        if (mobil.getId_mobil().equals(id_Kendaraan)) {
            ArrayMobil.remove(mobil); // Use the correct object name
            String query = String.format("DELETE FROM Mobil WHERE id_kendaraan = '%s'", mobil.getId_mobil());
            db.executeUpdateQuery(query);
            break;
        }
    }
}

    
    public static void updateKendaraan(String id_kendaraan, String ukuran_mesin, String model, String warna) throws SQLException{
        for (Mobil kendaraan : ArrayMobil) {
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
