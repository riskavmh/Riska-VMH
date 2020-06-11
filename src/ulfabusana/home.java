package ulfabusana;
/**
 * Nama      : Riska Virliana M H
 * NIM / Gol : E31192024 / C
 * Prodi     : Manajemen Informatika
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public final class home extends JFrame implements ActionListener {
    private JPanel jpub = new JPanel();
    private JButton btnbrg = new JButton("DATA BARANG"),
                    btnplnggn = new JButton("DATA PELANGGAN");
    
    String[] strJdl={"Kode","Nama","Jenis","Harga","Tanggal Masuk","Tanggal Kadaluarsa",
        "Jumlah Stok", "Kondisi"};

//Deklarasi untuk Tabel

JTable tabel = new JTable();
JScrollPane skrTabel = new JScrollPane();


    home (){
        super("ULFA BUSANA || E31192024_RiskaVirlianaMH_C");
        setSize(1366,738);
        jpub.setLayout(null);
        
        btnbrg.setBounds(350, 250, 200, 100);
        btnplnggn.setBounds(770, 250, 200, 100);
        
        jpub.add(btnbrg);
        jpub.add(btnplnggn);
        btnbrg.addActionListener(this);
        btnplnggn.addActionListener(this);
        
        getContentPane().add(jpub);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
     public void actionPerformed(ActionEvent a){
        Object obj = a.getSource();
        if (obj ==btnbrg){
            barang();
        }
        if (obj ==btnplnggn){
            plnggn();
        }
    }
    
    void barang(){
        try{
            koneksi kon = new koneksi();
            Connection con = kon.bukakoneksi();
            Statement st = con.createStatement();
            this.setVisible(false);
            new databrg().setVisible(true);
        }
        catch(SQLException e){
        }
    }
    void plnggn(){
        try{
            koneksi kon = new koneksi();
            Connection con = kon.bukakoneksi();
            Statement st = con.createStatement();
            this.setVisible(false);
            new dataplnggn().setVisible(true);
        }
        catch(SQLException e){
        }
    }

}
