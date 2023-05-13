/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MuhamadAdityaDwiSeptiawan.uts.jadwal;

import com.MuhamadAdityaDwiSeptiawan.jadwal.data.interfaces.JadwalListener;
import com.MuhamadAdityaDwiSeptiawan.uts.model.Dosen;
import com.MuhamadAdityaDwiSeptiawan.uts.model.Jadwal;
import com.MuhamadAdityaDwiSeptiawan.uts.model.JadwalMengajar;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main implements JadwalListener {
    JadwalMengajar jadwalMengajar = new JadwalMengajar();
    Scanner scannerMenu;
    Scanner scannerRestart;
    String restart = "y";
    public static void main(String args[]){
        Main main = new Main();
        main.initProgram();
    }
    private String hari;
    public void initProgram(){
        scannerMenu = new Scanner(System.in);
        int menu;
        jadwalMengajar.setJadwalListener(this);
        do {
            System.out.println("-----------------------------------------");
            System.out.println("      Program Jadwal Dosen Mengajar       ");
            System.out.println("-----------------------------------------");
            System.out.println("1. Lihat Jadwal Yang Sudah Ada");
            System.out.println("2. Menambahkan Jadwal Baru");
            System.out.println("3. Mengubah Jadwal");
            System.out.println("4. Menghapus Jadwal Yang Ada");
            System.out.println("5. Keluar Dari Program");
            System.out.println("-----------------------------------------");
            System.out.print("Masukkan Pilihan : ");
            menu = scannerMenu.nextInt();
            System.out.println("------------------------------------------");
            switch(menu){
                case 1:
                    printListJadwal();
                    break;
                case 2:
                    tambahJadwal();
                    break;
                case 3:
                    updateJadwal();
                    break;
                case 4:
                    hapusJadwal();
                    break;
                case 5:
                    return;
                default:
                    printOutput("Pilihan Tidak Valid !");
            }
            System.out.println();
        } while (!restart.equalsIgnoreCase("n"));
    }
    public void printListJadwal(){
        System.out.println("       List Jadwal Mengajar Dosen          ");
                    if(jadwalMengajar.lihatSemuaJadwal() != null && jadwalMengajar.lihatSemuaJadwal().size() > 0){
                        int number = 0;
                        for(Jadwal jadwal : jadwalMengajar.lihatSemuaJadwal()){
                            number++;
                            System.out.println(number+"");
                            System.out.println("Nama Dosen          :   "+ jadwal.getDosen().getName());
                            System.out.println("Mata Kuliah         :   "+ jadwal.getMatkul());
                            System.out.println("Hari Mengajar       :   "+ jadwal.getHari());
                            System.out.println("Jam Mengajar        :   "+ jadwal.getJam());
                            System.out.println("Jumlah SKS          :   "+ jadwal.getSks());
                            System.out.println("Ruangan Mengajar    :   "+ jadwal.getRuangan());
                            System.out.println("------------------------------------------------");
                        }
                        restart();
                    } else {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Tidak Ada List Jadwal Yang Tersedia!");
                        restart();
                    } 
    }
    public void tambahJadwal(){
        System.out.print("Nama Dosen            :   ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("NIDN                  :   ");
        String nidn = new Scanner(System.in).nextLine();
        System.out.print("Jenis Kelamin L/P     :   ");
        String jenisKelamin = new Scanner(System.in).nextLine();
        System.out.print("Prodi                 :   ");
        String prodi = new Scanner(System.in).nextLine();
        Dosen dosen = new Dosen(name, nidn, jenisKelamin, prodi);
        System.out.print("Mata Kuliah           :   ");
        String matkul = new Scanner(System.in).nextLine();
        System.out.print("Hari Mengajar         :   ");
        String hari = new Scanner (System.in).next();
        System.out.print("Jam Mengajar          :   ");
        String jam = new Scanner(System.in).nextLine();
        System.out.print("Ruangan Mengajar      :   ");
        String ruangan = new Scanner(System.in).nextLine();
        System.out.print("Jumalah SKS           :   ");
        String sks = new Scanner(System.in).nextLine();
        jadwalMengajar.tambahJadwal(new Jadwal(dosen, matkul, hari, jam, ruangan, sks));
    }
    public void updateJadwal(){
        int total = jadwalMengajar.lihatSemuaJadwal().size();
        System.out.print("Masukkan Urutan Jadwal Yang Mau Diubah (1-"+total+") : ");
        int position = new Scanner(System.in).nextInt();
        System.out.print("Nama Dosen        :   ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("NIDN              :   ");
        String nidn = new Scanner(System.in).nextLine();
        System.out.print("Jenis Kelamin L/P :   ");
        String jenisKelamin = new Scanner(System.in).nextLine();
        System.out.print("Prodi             :   ");
        String prodi = new Scanner(System.in).nextLine();
        Dosen dosen = new Dosen(name, nidn, jenisKelamin, prodi);
        System.out.print("Mata Kuliah       :   ");
        String matkul = new Scanner(System.in).nextLine();
        System.out.print("Hari Mengajar     :   ");
        String hari = new Scanner (System.in).nextLine()
        System.out.print("Jam Mengajar      :   ");
        String jam = new Scanner(System.in).nextLine();
        System.out.print("Ruangan Mengajar  :   ");
        String ruangan = new Scanner(System.in).nextLine();
        System.out.print("Jumlah SKS        :   ");
        String sks = new Scanner(System.in).nextLine();
        jadwalMengajar.updateJadwal(position-1, new Jadwal(dosen, hari, matkul, jam, ruangan, sks));
    }
    public void hapusJadwal(){
        int total = jadwalMengajar.lihatSemuaJadwal().size();
        System.out.print("Masukkan Urutan Jadwal Yang Akan Dihapus  (1-"+total+") : ");
        int position = new Scanner(System.in).nextInt();
        jadwalMengajar.hapusJadwal(position-1);
    }
    public void restart(){
        scannerRestart = new Scanner(System.in);
        System.out.print("Apakah Ingin Mengulangi Program Tersebuut (y / n) ? : ");
                        restart = scannerRestart.nextLine();
    }
    @Override
    public void onAdd(String message) {
        printOutput(message);
        restart();
    }
    @Override
    public void onUpdate(String message) {
        printOutput(message);
        restart();
    }
    @Override
    public void onDelete(String message) {
        printOutput(message);
        restart();
    }
    static void printOutput(String message){
        System.out.println(message);
    }
    
}
