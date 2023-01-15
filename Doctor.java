package FinalsTP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import FinalsTP.Patient.clear;



public class Doctor{
	JComboBox comboGender;
    JFrame dc = new JFrame("Doctor's Module");
    JTextField name = new JTextField();
    JTextField id = new JTextField();
    JTextField special = new JTextField();
    
    public Doctor() {
        dc.setSize(700, 500);
        dc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dc.setLocationRelativeTo(null);
        dc.setLayout(null);
      
        Font font = new Font("Arial", Font.BOLD, 30);
        JLabel addAccount = new JLabel("Insert Doctor's Information");
        addAccount.setBounds(150, 20, 400, 40);
        dc.add(addAccount);
        addAccount.setFont(font);
       
        JLabel username = new JLabel("Doctor's Name");
        username.setBounds(100, 100, 100, 40);
        dc.add(username);

        JLabel password = new JLabel("Doctor's ID");
        password.setBounds(100, 160, 100, 40);
        dc.add(password);
      
        JLabel email = new JLabel("Specialization");
        email.setBounds(100, 220, 100, 40);
        dc.add(email);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(102, 280, 80, 25);
        dc.add(labelGender);
        
        String gender[] = {"Male","Female"};
        comboGender = new JComboBox(gender);
        comboGender.setBounds(200, 280, 165, 25);
        dc.add(comboGender);

        name.setBounds(200, 100, 300, 40);
        dc.add(name);
        id.setBounds(200, 160, 150, 40);
        dc.add(id);
        special.setBounds(200, 220, 200, 40);
        dc.add(special);
        
        JButton add = new JButton("Submit");
        add.setBounds(270, 350, 100, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.decode("#234E70"));
        dc.add(add);
        add.addActionListener(new submit());
        
        JButton rtrn = new JButton("Return");
        rtrn.setBounds(10, 10, 80, 25);
        dc.add(rtrn);
        rtrn.setForeground(Color.WHITE);
        rtrn.setBackground(Color.decode("#E97777"));
        rtrn.addActionListener(new retri());
        dc.getContentPane().setBackground(Color.decode("#E5E5CB"));
        
        JButton clr= new JButton("Clear");
        clr.setBounds(490, 360, 80, 25);
        dc.add(clr);
       clr.setForeground(Color.WHITE);
        clr.setBackground(Color.decode("#234E70"));
        clr.addActionListener(new clear());
        dc.setVisible(true);
    }
   
   
    class submit implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           
            String idsa = name.getText();
            String dsd = id.getText();
            String dol = special.getText();
            String sex = comboGender.getSelectedItem().toString();
            
        if(!idsa.isEmpty() && !dsd.isEmpty() && !dol.isEmpty()){
            
                        try{
                        File file = new File("D:/games/angel/src/FinalsTP/records.txt");
                        FileWriter fileWriter = new FileWriter(file,true);
                        fileWriter.write(idsa + " , " + dsd + " , " + dol + " , " + sex +"\n");
                        JOptionPane.showMessageDialog(null, "Listed");
                        fileWriter.close();
                        dc.dispose();
                        new Doctor();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    name.setText("");
                    id.setText("");
                    special.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Please fill the blank");
        }

        }
    }
    class retri implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        
            dc.dispose();
            new background();
        }
    }
    public class clear implements ActionListener{
        public void actionPerformed(ActionEvent e){
            name.setText("");
            id.setText("");
            special.setText("");
    
        }
    }
  
    
}
