package ulfabusana;

/**
 * Nama      : Riska Virliana M H
 * NIM / Gol : E31192024 / C
 * Prodi     : Manajemen Informatika
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    private JPanel jpub = new JPanel();
    private JLabel lbluname = new JLabel("Username :"),
                    lblpass = new JLabel("Password :");
    private JTextField txtuname = new JTextField();
    private JPasswordField passfield = new JPasswordField();
    private JButton btnmasuk = new JButton("Masuk");
    
    login (){
        super("ULFA BUSANA || E31192024_RiskaVirlianaMH_C");
        setSize (500,400);
        jpub.setLayout(null);
        
        lbluname.setBounds(100, 100, 100, 25);
        lblpass.setBounds(100, 140, 100, 25);
        
        txtuname.setBounds(180, 100, 125, 25);
        passfield.setBounds(180, 140, 125, 25);
        
        btnmasuk.setBounds(300, 200, 85, 25);
        
        jpub.add(lbluname);
        jpub.add(lblpass);
        jpub.add(txtuname);
        jpub.add(passfield);
        jpub.add(btnmasuk);
        btnmasuk.addActionListener(this);
        
        getContentPane().add(jpub);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent a){
        Object obj = a.getSource();
        if (obj ==btnmasuk){
            masuk();
        }
    }
    
    void masuk(){
            String username = "admin";
            String password = "1234";
                if(username.equalsIgnoreCase(txtuname.getText()) &&
                        password.equalsIgnoreCase(passfield.getText())){
               this.setVisible(false);
               new home().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username atau "
                            + "Password Anda salah" + "\n harap cek kembali.",
                            "",JOptionPane.INFORMATION_MESSAGE);
                }
    }
}


