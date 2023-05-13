package com.MuhamadAdityaDwiSeptiawan.uts.model;
import com.MuhamadAdityaDwiSeptiawan.jadwal.data.interfaces.JadwalListener;
import java.util.ArrayList;
import java.util.Arrays;
public class JadwalMengajar extends JadwalMatkul {
    private final ArrayList<Jadwal> listJadwal;
    private JadwalListener jadwalListener;

    public JadwalMengajar() {
        listJadwal = new ArrayList<>(
                Arrays.asList(
            new Jadwal(new Dosen("Muhamad Arief Yulianto S.Kom., M.Kom.", "111", "L", "TI"), "Pemrograman 1", "Sabtu", "07:40 - 09:20", "404", "3"),
            new Jadwal(new Dosen("Maulana Fansyuri S.Kom., M.Kom", "222", "L", "TI"),"Basis Data", "Sabtu", "09:20 - 11:00", "404", "2"),
            new Jadwal(new Dosen("Wasis Haryono M.Kom", "333", "P", "TI"), "Pengantar Aplikasi Komputer","Sabtu", "11:00 - 13:50", "404", "3"),
            new Jadwal(new Dosen("Ahmad Arifin S.Pd., M.Pd.", "444", "L", "TI"), "Bahasa Inggris","Sabtu","13:50 - 15:30", "404", "2")
        ));
    }
    public void setJadwalListener(JadwalListener jadwalListener) {
        this.jadwalListener = jadwalListener;
    }
    @Override
    public void tambahJadwal(Jadwal jadwal) {
        listJadwal.add(jadwal);
        jadwalListener.onAdd("Berhasil Menambahkan Jadwal Baru !");
    }
    @Override
    public void updateJadwal(int position, Jadwal jadwal) {
        try {
            listJadwal.set(position, jadwal);
            jadwalListener.onUpdate("Berhasil Merubah Jadwal Baru !");
        } catch (Exception e){
            jadwalListener.onUpdate("Gagal Merubah Jadwal!");
        }
    }
    @Override
    public void hapusJadwal(int position) {
        try {
            listJadwal.remove(position);
            jadwalListener.onDelete("Jadwal Berhasil Dihapus!");
        } catch (Exception e) {
            jadwalListener.onDelete("Gagal Menghapus Jadwal!");
        }
    }
    @Override
    public Jadwal lihatJadwal(int position) {
        return listJadwal.get(position);
    }
    @Override
    public ArrayList<Jadwal> lihatSemuaJadwal() {
        return listJadwal;
    }
}
