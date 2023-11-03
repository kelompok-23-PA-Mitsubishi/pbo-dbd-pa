/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;
import koneksi.Database;

/**
 *
 * @author User
 */
public class Truk extends Kendaraan {
    String jenis_bak;
    String kapasitas_maksimum;
    static Database db = new Database();
    static ArrayList<Truk> ArrayTruk = new ArrayList<>();

    public Truk(String jenis_bak, String kapasitas_maksimum, String id_Kendaraan, String ukuranmesin_Kendaraan, String model, String warna) {
        super(id_Kendaraan, ukuranmesin_Kendaraan, model, warna);
        this.jenis_bak = jenis_bak;
        this.kapasitas_maksimum = kapasitas_maksimum;
    }

    public String getJenis_bak() {
        return jenis_bak;
    }

    public void setJenis_bak(String jenis_bak) {
        this.jenis_bak = jenis_bak;
    }

    public String getKapasitas_maksimum() {
        return kapasitas_maksimum;
    }

    public void setKapasitas_maksimum(String kapasitas_maksimum) {
        this.kapasitas_maksimum = kapasitas_maksimum;
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

    
    
}
