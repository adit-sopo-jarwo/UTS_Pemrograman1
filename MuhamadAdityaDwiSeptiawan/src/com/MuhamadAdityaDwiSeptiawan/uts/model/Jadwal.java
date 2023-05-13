/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MuhamadAdityaDwiSeptiawan.uts.model;
/**
 *
 * @author User
 */
 public class Jadwal extends JadwalMatkul {
    private final Dosen dosen;
    private final String matkul;
  private final  String hari;
    private final String jam;
    private final String ruangan;
    private final String sks;
   
    public Jadwal(Dosen dosen, String hari, String matkul, String jam, String ruangan, String sks){
        this.dosen = dosen;
        this.matkul = matkul;
        this.hari = hari;
        this.jam = jam;
        this.ruangan = ruangan;
        this.sks = sks;
    }
    public Dosen getDosen(){
        return dosen;
    }
    public String getMatkul(){
        return matkul;
    }
    public String getHari(){
        return hari;
    }
    public String getJam(){
        return jam;
    }
    public String getRuangan(){
        return ruangan;
    }
    public String getSks(){
        return sks;
    }
}
