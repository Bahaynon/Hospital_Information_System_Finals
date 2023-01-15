package FinalsTP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

import FinalsTP.Doctor.clear;


public class secondRecords{
	JComboBox Row;
    DefaultTableModel model;
    JTable table;
    String[][] info;
    String[] columnNames = {"Patient's Name", "Age", "Adress", "Gender","Rooms","Blood Type","Phone Number"};
    JFrame dm = new JFrame("View and Edit Records");
    JComboBox Gender;
    JComboBox Type;
    JTextField docname = new JTextField();
    JTextField age = new JTextField();
    JTextField docspecial = new JTextField();
    JTextField bek = new JTextField();
    
    public secondRecords() {
        dm.setSize(900, 725);
        dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dm.setLocationRelativeTo(null);
        dm.setLayout(null); 
        Font font = new Font("Arial", Font.BOLD, 25);
    
        JLabel addAccount = new JLabel("Edit the Patient's Informations");
        addAccount.setBounds(270, 5, 400, 40);
        dm.add(addAccount);
        addAccount.setFont(font);
       
        JLabel username = new JLabel("Patient Name: ");
        username.setBounds(50, 60, 100, 40);
        dm.add(username);

        JLabel ages= new JLabel("Age: ");
        ages.setBounds(50, 120, 100, 40);
        dm.add(ages);
      
        JLabel email = new JLabel("Address:");
        email.setBounds(50, 180, 100, 40);
        dm.add(email);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(500, 60, 80, 25);
        dm.add(labelGender);
        
        JLabel type = new JLabel("Room: ");
        type.setBounds(500, 120, 80, 25);
        dm.add(type);
        JLabel ph = new JLabel("Phone Number: ");
        ph.setBounds(50, 240, 100, 40);
        dm.add(ph);
        
        
        String gender[] = {"Male","Female"};
        Gender = new JComboBox(gender);
        Gender.setBounds(600, 60, 70, 25);
        dm.add(Gender);
        
        String bloods[] = {"A+","B+","AB+","O+"};
        Row = new JComboBox(bloods);
        Row.setBounds(600, 185, 165, 25);
        dm.add(Row);
        
        JLabel sob = new JLabel("Blood Type: ");
        sob.setBounds(500, 185, 80, 25);
        dm.add(sob);
        
        String blood[] = {"Operating Room","Emergency Room","ICU","Post-anesthesia Care Unit"};
        Type = new JComboBox(blood);
        Type.setBounds(600, 120, 165, 25);
        dm.add(Type);

       docname.setBounds(190, 60, 230, 40);
        dm.add(docname);
        age.setBounds(190, 120, 50, 40);
        dm.add(age);
        docspecial.setBounds(190, 180, 200, 40);
        dm.add(docspecial);
        bek.setBounds(190, 240, 150, 40);
        dm.add(bek);
        
        JButton rtrn = new JButton("Return");
        rtrn.setBounds(20, 10, 80, 25);
        dm.add(rtrn);
        rtrn.setForeground(Color.WHITE);
        rtrn.setBackground(Color.decode("#E97777"));
        rtrn.addActionListener(new back());

        dm.getContentPane().setBackground(Color.decode("#E5E5CB"));
        
        JButton update = new JButton("Update");
        update.setBounds(600, 240, 85, 40);
        dm.add(update);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.decode("#234E70"));
        update.addActionListener(new update());
  
        JButton del = new JButton("Delete");
        del.setBounds(760, 240, 70, 40);
        dm.add(del);
        del.setForeground(Color.WHITE);
        del.setBackground(Color.decode("#234E70"));
        del.addActionListener(new delete());
        
        JButton clr = new JButton("Clear");
        clr.setBounds(450, 240, 70, 40);
        dm.add(clr);
        clr.setForeground(Color.WHITE);
        clr.setBackground(Color.decode("#234E70"));
        clr.addActionListener(new clear());
        dm.setVisible(true);
    

        dm.setVisible(true);

        int gh = 0;
        try {
            Scanner scs = new Scanner(new File("D:/games/angel/src/FinalsTP/second_records.txt"));
            while(scs.hasNextLine()) {
                gh++;
                scs.nextLine();
            }
            scs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        info = new String[gh][7];
        
        int i = 0;
        try {
            Scanner scs = new Scanner(new File("D:/games/angel/src/FinalsTP/second_records.txt"));
            while(scs.hasNextLine()) {
                String line = scs.nextLine();
                String[] parts = line.split(" , ");
                
                info[i][0] = parts[0];
                info[i][1] = parts[1];
                info[i][2] = parts[2];
                info[i][3] = parts[3];
                info[i][4] = parts[4];
                info[i][5] = parts[5];
                info[i][6] = parts[6];
                i++;
            }	
            scs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

      
         model = new DefaultTableModel(info, columnNames);
        table = new JTable(model);
        table.setBounds(500, 0, 685, 462);
        dm.add(table);
       
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 328,875, 350);
        dm.add(scrollPane);
       
        table.setRowSelectionAllowed(true);
    }
    class back implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            dm.dispose();
            new secondBackground();
        }
    }
    public class clear implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	
            docname.setText("");
            age.setText("");
            docspecial.setText("");
            bek.setText("");
    
        }
    }
  

    class update implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int i = table.getSelectedRow();
            String name = docname.getText();
            String id = age.getText();
            String special = docspecial.getText();
            String sex = Gender.getSelectedItem().toString();
            String rooms = Type.getSelectedItem().toString();
            String bloods= Row.getSelectedItem().toString();
            String low = bek.getText();
            if(i == -1 ){
                JOptionPane.showMessageDialog(null, "Please select a row to update");
            }
            else{
                if(!name.isEmpty() && !id.isEmpty() && !special.isEmpty()){
                                if(i >= 0) {
                 model.setValueAt(name, i, 0);
                 model.setValueAt(id, i, 1);
                 model.setValueAt(special, i, 2);
                 model.setValueAt(sex, i, 3);
                 model.setValueAt(rooms, i, 4);
                 model.setValueAt(bloods, i, 5);
                 model.setValueAt(low, i, 6);
                 try {
                     FileWriter fileWriter = new FileWriter("D:/games/angel/src/FinalsTP/second_records.txt");
             for(int p = 0; p < table.getRowCount(); p++) {
            	 fileWriter.write(model.getValueAt(p, 0).toString() + " , " + 
             model.getValueAt(p, 1).toString() + " , " + model.getValueAt(p, 2).toString() + " , " + model.getValueAt(p, 3).toString() +
             " , " + model.getValueAt(p, 4).toString()+ " , " + model.getValueAt(p, 5).toString() 
             + " , " + model.getValueAt(p, 6).toString() + "\n");
			}
              fileWriter.close();
			  JOptionPane.showMessageDialog(null, "Update Successfully");
            }catch (IOException e1) {
                e1.printStackTrace();
            }
                }else{
                    JOptionPane.showMessageDialog(null, "Please fill the blank");
                }
            }
            

            

        }
    }

    }
  
    class delete implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete");
                }else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Permanently delete?", "Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION) {
                     model.removeRow(row);
                     try {
                      BufferedWriter bw = new BufferedWriter(new FileWriter("D:/games/angel/src/FinalsTP/second_records.txt"));
                      for(int i = 0; i < table.getRowCount(); i++) {
                      for(int j = 0; j < table.getColumnCount(); j++) {
                      bw.write(table.getValueAt(i, j).toString() + " , ");
                 }
                 bw.newLine();
                  }
                 bw.close();
                 } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
        }
    }



    
    
    }
