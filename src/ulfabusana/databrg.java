package ulfabusana;

/**
 * Nama      : Riska Virliana M H
 * NIM / Gol : E31192024 / C
 * Prodi     : Manajemen Informatika
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public final class databrg extends JFrame implements ActionListener {
    private JPanel jpub = new JPanel();
     private JLabel lbljudul = new JLabel("DATA BARANG");
    private JButton btnsimpan = new JButton("Input Data");
    
    String[] strJdl={"Kode","Nama","Jenis","Harga","Tanggal Masuk","Tanggal Kadaluarsa",
        "Jumlah Stok", "Kondisi"};

//Deklarasi untuk Tabel

JTable tabel = new JTable();
JScrollPane skrTabel = new JScrollPane();


    databrg (){
        super("ULFA BUSANA || E31192024_RiskaVirlianaMH_C");
        setSize(1366,738);
        jpub.setLayout(null);

        lbljudul.setBounds(50, 30, 300, 25);

        btnsimpan.setBounds(50, 70, 100, 25);
        
        jpub.add(lbljudul);
        jpub.add(btnsimpan);
        
        btnsimpan.addActionListener(this);
        
        getContentPane().add(jpub);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //pengaturan Tabel
        skrTabel.getViewport().add(tabel);
        tabel.setEnabled(true);
        skrTabel.setBounds(15, 250, 1300, 400);

        //menambahkan tabel pada panel
        jpub.add(skrTabel);

        //menambahkan objek JPanel pada container frame
        getContentPane().add(jpub);
        //menampilkan tabel siswa ke komponen tabel
        TampilTabel();

    }
    
     public void actionPerformed(ActionEvent a){
        Object obj = a.getSource();
        if (obj ==btnsimpan){
            simpan();
        }
    }
    
    void simpan(){
        try{
            koneksi kon = new koneksi();
            Connection con = kon.bukakoneksi();
            Statement st = con.createStatement();
            new inputbrg().setVisible(true);
        }
        catch(SQLException e){
        }
    }
    void TampilTabel(){
        try {
            koneksi ObjKoneksi = new koneksi();
            Connection con = ObjKoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM databarang";
            ResultSet set = st.executeQuery(sql);
            //menampilkan data ke Tabel
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel.setModel(model);
        }
        catch(SQLException e) {
        }
}
}
