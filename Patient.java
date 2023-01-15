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


public class Patient{
	JComboBox Gender;
	JComboBox Type;
	JComboBox Row;
    JFrame pts = new JFrame("Appointment");
    JTextField name = new JTextField();
    JTextField age = new JTextField();
    JTextField special = new JTextField();
    JTextField bek = new JTextField();
    
    public Patient() {
        pts.setSize(700, 700);
        pts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pts.setLocationRelativeTo(null);
        pts.setLayout(null);
      
        Font font = new Font("Arial", Font.BOLD, 30);
        JLabel addAccount = new JLabel("Insert Patient's Information");
        addAccount.setBounds(150, 20, 400, 40);
        pts.add(addAccount);
        addAccount.setFont(font);
       
        JLabel username = new JLabel("Patient Name: ");
        username.setBounds(100, 100, 100, 40);
        pts.add(username);

        JLabel ages = new JLabel("Age: ");
        ages.setBounds(100, 160, 100, 40);
        pts.add(ages);
      
        JLabel email = new JLabel("Address:");
        email.setBounds(100, 220, 100, 40);
        pts.add(email);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(102, 280, 80, 25);
        pts.add(labelGender);
        
        JLabel type = new JLabel("Rooms: ");
        type.setBounds(102, 340, 80, 25);
        pts.add(type);
        
        JLabel sob = new JLabel("Blood Type: ");
        sob.setBounds(102, 400, 80, 25);
        pts.add(sob);
        
        JLabel ph = new JLabel("Phone Number: ");
        ph.setBounds(102, 460, 100, 40);
        pts.add(ph);
        
        String gender[] = {"Male","Female"};
        Gender = new JComboBox(gender);
        Gender.setBounds(200, 280, 70, 25);
        pts.add(Gender);
        
        String blood[] = {"Operating Room","Emergency Room","ICU","Post-anesthesia Care Unit"};
        Type = new JComboBox(blood);
        Type.setBounds(200, 340, 165, 25);
        pts.add(Type);
        
        String bloods[] = {"A+","B+","AB+","O+"};
        Row = new JComboBox(bloods);
        Row.setBounds(200, 400, 165, 25);
        pts.add(Row);
        
        name.setBounds(200, 100, 300, 40);
        pts.add(name);
        age.setBounds(200, 160, 50, 40);
        pts.add(age);
        special.setBounds(200, 220, 200, 40);
        pts.add(special);
        bek.setBounds(200, 460, 150, 40);
        pts.add(bek);
        
        JButton add = new JButton("Submit");
        add.setBounds(270, 550, 100, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.decode("#234E70"));
        pts.add(add);
        add.addActionListener(new submit());
        
        JButton rtrn = new JButton("Return");
        rtrn.setBounds(10, 20, 80, 25);
        pts.add(rtrn);
        rtrn.setForeground(Color.WHITE);
        rtrn.setBackground(Color.decode("#E97777"));
        rtrn.addActionListener(new retri());
        pts.getContentPane().setBackground(Color.decode("#E5E5CB"));
        
        JButton clr= new JButton("Clear");
        clr.setBounds(490, 560, 80, 25);
        pts.add(clr);
        clr.setForeground(Color.WHITE);
        clr.setBackground(Color.decode("#234E70"));
        clr.addActionListener(new clear());
        pts.setVisible(true);
    }
   
   
    class submit implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String idsa = name.getText();
            String dsd = age.getText();
            String dol = special.getText();
            String sex = Gender.getSelectedItem().toString();
            String blood= Type.getSelectedItem().toString();
            String bloods= Row.getSelectedItem().toString();
            String call =  bek.getText();
        if(!idsa.isEmpty() && !dsd.isEmpty() && !dol.isEmpty()){
                 try{
                        File file = new File("D:/games/angel/src/FinalsTP/second_records.txt");
                        FileWriter fileWriter = new FileWriter(file,true);
                        fileWriter.write(idsa + " , " + dsd + " , " + dol + " , " + sex + " , "+ blood + " , "+ bloods + " , "+ call+"\n");
                        JOptionPane.showMessageDialog(null, "Listed");
                        fileWriter.close();
                        pts.dispose();
                        new Patient();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    name.setText("");
                    age.setText("");
                    special.setText("");
                    bek.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Please fill the blank");
        }

        }
    }
    class retri implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        
            pts.dispose();
            new secondBackground();
        }
    }
    public class clear implements ActionListener{
        public void actionPerformed(ActionEvent e){
            name.setText("");
            age.setText("");
            special.setText("");
           bek.setText("");
        }
    }
  
    
}
