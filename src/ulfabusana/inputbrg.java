package ulfabusana;

/**
 * Nama      : Riska Virliana M H
 * NIM / Gol : E31192024 / C
 * Prodi     : Manajemen Informatika
 */

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
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class inputbrg extends JFrame implements ActionListener{
    private JPanel jpub = new JPanel();
    private JLabel lblkode = new JLabel("Kode"),
                    lblnama = new JLabel("Nama"),
                    lbljns = new JLabel("Jenis"),
                    lblhrg = new JLabel("Harga"),
                    lbltglmsk = new JLabel("Tanggal Masuk"),
                    lblkdlrs = new JLabel("Tanggal Kadaluarsa"),
                    lbljml = new JLabel("Jumlah Stok"),
                    lblknds = new JLabel("Kondisi");
    private JTextField txtnama = new JTextField(),
                        txttglmsk = new JTextField(),
                        txtkdlrs = new JTextField(),
                        txtjml = new JTextField(),
                        txtkode = new JTextField(),
                        txthrg = new JTextField();
    private JComboBox cbjns = new JComboBox(),
                        cbknds = new JComboBox();
    private JButton btnsimpan = new JButton("Simpan"),
                    btnbersih = new JButton("Bersih");
    
    inputbrg (){
        super("INPUT DATA BARANG || ULFA BUSANA");
        setSize (500,400);
        jpub.setLayout(null);
        
        lblkode.setBounds(25, 20, 120, 25);
        lblnama.setBounds(25, 55, 120, 25);
        lbljns.setBounds(25, 90, 120, 25);
        lblhrg.setBounds(25, 125, 120, 25);
        lbltglmsk.setBounds(25,  160, 120, 25);
        lblkdlrs.setBounds(25, 195, 120, 25);
        lbljml.setBounds(25,  230, 120, 25);
        lblknds.setBounds(25, 265, 120, 25);

        txtkode.setBounds(160, 20, 80, 25);
        txtnama.setBounds(160, 55, 290, 25);
        cbjns.setBounds(160, 90, 80, 25);
        txthrg.setBounds(160, 125, 100, 25);
        txttglmsk.setBounds(160, 160, 100, 25);
        txtkdlrs.setBounds(160, 195, 100, 25);
        txtjml.setBounds(160, 230, 30, 25);
        cbknds.setBounds(160, 265, 80, 25);

        btnsimpan.setBounds(350, 310, 85, 25);
        btnbersih.setBounds(25, 310, 85, 25);
        
        jpub.add(lblkode);
        jpub.add(lblnama);
        jpub.add(lbljns);
        jpub.add(lblhrg);
        jpub.add(lbltglmsk);
        jpub.add(lblkdlrs);
        jpub.add(lbljml);
        jpub.add(lblknds);
        
        jpub.add(txtkode);
        jpub.add(txtnama);
        jpub.add(cbjns);
        jpub.add(txttglmsk);
        jpub.add(txtkdlrs);
        jpub.add(txtjml);
        jpub.add(txthrg);
        jpub.add(cbknds);
        
        cbjns.addItem("Jubah");
        cbjns.addItem("Kaos");
        cbjns.addItem("Hem");
        cbjns.addItem("Tunik");
        cbjns.addItem("Dress");
        cbjns.addItem("ATK");
        cbjns.addItem("Makanan");
        
        cbknds.addItem("Baik");
        cbknds.addItem("Tidak Baik");
        
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
            String sql = "INSERT INTO databarang(kode,nama,jenis,harga,tglmsk,"
                    + "tglkadaluarsa,jumlah,kondisi) values ('"+txtkode.getText()
                    + "','"+txtnama.getText()+"','"+cbjns.getSelectedItem()+"','"
                    + txthrg.getText()+"','"+txttglmsk.getText()+"','"+txtkdlrs.getText()
                    + "','"+txtjml.getText()+"','"+cbknds.getSelectedItem()+"')";
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
        txtkode.setText("");
        txtnama.setText("");
        cbjns.setSelectedIndex(0);
        txthrg.setText("");
        txttglmsk.setText("");
        txtkdlrs.setText("");
        txtjml.setText("");
        cbknds.setSelectedIndex(0);
    }
}