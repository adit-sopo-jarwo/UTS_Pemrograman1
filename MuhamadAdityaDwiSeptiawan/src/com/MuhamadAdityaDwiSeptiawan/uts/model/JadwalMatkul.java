/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MuhamadAdityaDwiSeptiawan.uts.model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
abstract class JadwalMatkul {
    public void tambahJadwal(Jadwal jadwal){}
    public void updateJadwal(int position, Jadwal jadwal){}
    public void hapusJadwal(int position){}
    public Jadwal lihatJadwal(int position){
        return null;
    }
    public ArrayList<Jadwal> lihatSemuaJadwal(){
        return null;
    }
    
}
