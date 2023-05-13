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
public class Dosen {
      
    private String namaLengkap;
    private String nidn;
    private String jenisKelamin;
    private String prodi;
    
    public Dosen(String namaLengkap, String nidn, String jenisKelamin, String prodi){
        this.namaLengkap = namaLengkap;
        this.nidn = nidn;
        this.jenisKelamin = jenisKelamin;
        this.prodi = prodi;
    }
    
    public String getName(){
        return namaLengkap;
    }
    
    public String getNidn(){
        return nidn;
    }
    
    public String getJenisKelamin(){
        return jenisKelamin;
    }
    
    public String getProdi(){
        return prodi;
    }
}
