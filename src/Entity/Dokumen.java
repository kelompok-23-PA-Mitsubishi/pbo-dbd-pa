/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author User
 */
public class Dokumen {
    String id_Dokumen;
    String jenis_Dokumen;
    String tanggalterbit_Dokumen;
    int id_Kendaraan;

    public Dokumen(String id_Dokumen, String jenis_Dokumen, String tanggalterbit_Dokumen, int id_Kendaraan) {
        this.id_Dokumen = id_Dokumen;
        this.jenis_Dokumen = jenis_Dokumen;
        this.tanggalterbit_Dokumen = tanggalterbit_Dokumen;
        this.id_Kendaraan = id_Kendaraan;
    }

    public String getId_Dokumen() {
        return id_Dokumen;
    }

    public void setId_Dokumen(String id_Dokumen) {
        this.id_Dokumen = id_Dokumen;
    }

    public String getJenis_Dokumen() {
        return jenis_Dokumen;
    }

    public void setJenis_Dokumen(String jenis_Dokumen) {
        this.jenis_Dokumen = jenis_Dokumen;
    }

    public String getTanggalterbit_Dokumen() {
        return tanggalterbit_Dokumen;
    }

    public void setTanggalterbit_Dokumen(String tanggalterbit_Dokumen) {
        this.tanggalterbit_Dokumen = tanggalterbit_Dokumen;
    }

    public int getId_Kendaraan() {
        return id_Kendaraan;
    }

    public void setId_Kendaraan(int id_Kendaraan) {
        this.id_Kendaraan = id_Kendaraan;
    }    
    
}
