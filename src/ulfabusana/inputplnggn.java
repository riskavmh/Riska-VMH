package ulfabusana;

/**
 * Nama      : Riska Virliana M H
 * NIM / Gol : E31192024 / C
 * Prodi     : Manajemen Informatika
 */

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class inputplnggn extends JFrame implements ActionListener{
    private JPanel jpub = new JPanel();
    private JLabel lblkode = new JLabel("Kode"),
                    lblnama = new JLabel("Nama"),
                    lblalamat = new JLabel("Alamat"),
                    lblnotelp = new JLabel("Nomor Telpon"),
                    lblemail = new JLabel("Email"),
                    lbljenkel = new JLabel("Jenis Kelamin"),
                    lbltgldftr = new JLabel("Tanggal Mendaftar");
    private JTextField txtkode = new JTextField(),
                        txtnama = new JTextField(),
                        txtnotelp = new JTextField(),
                        txtemail = new JTextField(),
                        txttgldftr = new JTextField();
    private JTextArea taalamat = new JTextArea();
    private JComboBox cbjenkel = new JComboBox();
    private JButton btnsimpan = new JButton("Simpan"),
                    btnbersih = new JButton("Bersih");
    
    inputplnggn (){
        super("INPUT DATA PELANGGAN || ULFA BUSANA");
        setSize (500,400);
        jpub.setLayout(null);
        
        lblkode.setBounds(30, 20, 120, 25);
        lblnama.setBounds(30, 55, 120, 25);
        lblalamat.setBounds(30, 90, 120, 25);
        lblnotelp.setBounds(30, 150, 120, 25);
        lblemail.setBounds(30,  185, 120, 25);
        lbljenkel.setBounds(30, 220, 120, 25);
        lbltgldftr.setBounds(30, 255, 120, 25);

        txtkode.setBounds(160, 20, 80, 25);
        txtnama.setBounds(160, 55, 270, 25);
        taalamat.setBounds(160, 90, 270, 50);
        txtnotelp.setBounds(160, 150, 100, 25);
        txtemail.setBounds(160, 185, 100, 25);
        cbjenkel.setBounds(160, 220, 40, 25);
        txttgldftr.setBounds(160, 255, 100, 25);
        
        CheckboxGroup cbg = new CheckboxGroup();
        jpub.add(new Checkbox("P", cbg, true)); 
        jpub.add(new Checkbox("L", cbg, true)); 

        btnsimpan.setBounds(350, 310, 85, 25);
        btnbersih.setBounds(25, 310, 85, 25);
        
        jpub.add(lblkode);
        jpub.add(lblnama);
        jpub.add(lblalamat);
        jpub.add(lblnotelp);
        jpub.add(lblemail);
        jpub.add(lbljenkel);
        jpub.add(lbltgldftr);
        
        jpub.add(txtkode);
        jpub.add(txtnama);
        jpub.add(taalamat);
        jpub.add(txtnotelp);
        jpub.add(txtemail);
        jpub.add(cbjenkel);
        jpub.add(txttgldftr);
        
        cbjenkel.addItem("P");
        cbjenkel.addItem("L");

        jpub.add(btnsimpan);
        jpub.add(btnbersih);
        btnsimpan.addActionListener(this);
        btnbersih.addActionListener(this);
        
        getContentPane().add(jpub);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent a){
        Object obj = a.getSource();
        if (obj ==btnsimpan){
            simpan();
        }
        bersih();
    }
    
    void simpan(){
        try{
            koneksi kon = new koneksi();
            Connection con = kon.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "INSERT INTO datapelanggan(kode,nama,alamat,notelp,email,"
                    + "jeniskelamin,tgldaftar) values ('"+txtkode.getText()
                    + "','"+txtnama.getText()+"','"+taalamat.getText()+"','"
                    + txtnotelp.getText()+"','"+txtemail.getText()+"','"+
                    "','"+cbjenkel.getSelectedIndex()+"','"+ "','"+txttgldftr.getText()+"')";
                int row = st.executeUpdate(sql);

                if (row ==1){
                    JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan.",
                            "ULFA BUSANA",JOptionPane.INFORMATION_MESSAGE);

                   con.close();
                    }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data belum lengkap. Periksa kembali.",
                    "ULFA BUSANA",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void bersih(){
        jpub.add(txtnotelp);
        jpub.add(txtemail);
        jpub.add(txttgldftr);
        txtkode.setText("");
        txtnama.setText("");
        taalamat.setText("");
        txtnotelp.setText("");
        txtemail.setText("");
        cbjenkel.setSelectedIndex(0);
        txttgldftr.setText("");
    }
}