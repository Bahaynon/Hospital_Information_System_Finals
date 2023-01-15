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

import FinalsTP.Doctor.clear;


public class ViewRecords{
    DefaultTableModel model;
    JTable table;
    String[][] info;
    String[] columnNames = {"Doctor's Name", "Doctor's ID", "Specialization", "Gender"};
    JFrame dm = new JFrame("View and Edit Records");
    JComboBox comboGender;
    JTextField docname = new JTextField();
    JTextField docid = new JTextField();
    JTextField docspecial = new JTextField();
    
    public ViewRecords() {
        dm.setSize(800, 800);
        dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dm.setLocationRelativeTo(null);
        dm.setLayout(null); 
        Font font = new Font("Arial", Font.BOLD, 25);
    
        JLabel addAccount = new JLabel("Edit the Doctor's Informations");
        addAccount.setBounds(220, 5, 400, 40);
        dm.add(addAccount);
        addAccount.setFont(font);
       
        JLabel da = new JLabel("Doctor's Name:");
        da.setBounds(50, 70, 100, 40);
        dm.add(da);

        JLabel dsa = new JLabel("Doctor's ID:");
        dsa.setBounds(50, 130, 100, 40);
        dm.add(dsa);
      
        JLabel pes = new JLabel("Specialization:");
        pes.setBounds(390, 70, 100, 40);
        dm.add(pes);
        
        JLabel labelGender = new JLabel("Gender: ");
        labelGender.setBounds(390, 135, 80, 25);
        dm.add(labelGender);
        

        docname.setBounds(150,70, 200, 40);
        dm.add(docname);
        docid.setBounds(150, 130, 200, 40);
        dm.add(docid);
        docspecial.setBounds(480, 70, 200, 40);
        dm.add(docspecial);
        
        String gender[] = {"Male","Female"};
        comboGender = new JComboBox(gender);
        comboGender.setBounds(480, 135, 165, 25);
        dm.add(comboGender);
        
        JButton rtrn = new JButton("Return");
        rtrn.setBounds(20, 10, 80, 25);
        rtrn.setForeground(Color.WHITE);
        rtrn.setBackground(Color.decode("#E97777"));
        dm.add(rtrn);
        rtrn.addActionListener(new back());

       
        JButton update = new JButton("Update");
        update.setBounds(335, 210, 85, 40);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.decode("#234E70"));
        dm.add(update);
        update.addActionListener(new update());
  
        
        JButton del = new JButton("Delete");
        del.setBounds(520, 210, 70, 40);
        dm.add(del);
        del.setForeground(Color.WHITE);
        del.setBackground(Color.decode("#234E70"));
        del.addActionListener(new delete());
        
        JButton clr= new JButton("Clear");
        clr.setBounds(165, 210, 70, 40);
        dm.add(clr);
        clr.setForeground(Color.WHITE);
        clr.setBackground(Color.decode("#234E70"));
        clr.addActionListener(new clear());
        dm.setVisible(true);
    
        dm.getContentPane().setBackground(Color.decode("#E5E5CB"));
        dm.setVisible(true);

        int gh = 0;
        try {
            Scanner scs = new Scanner(new File("D:/games/angel/src/FinalsTP/records.txt"));
            while(scs.hasNextLine()) {
                gh++;
                scs.nextLine();
            }
            scs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        info = new String[gh][4];
        
        int i = 0;
        try {
            Scanner scs = new Scanner(new File("D:/games/angel/src/FinalsTP/records.txt"));
            while(scs.hasNextLine()) {
                String line = scs.nextLine();
                String[] parts = line.split(" , ");
                
                info[i][0] = parts[0];
                info[i][1] = parts[1];
                info[i][2] = parts[2];
                info[i][3] = parts[3];
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
        scrollPane.setBounds(10, 290, 760, 462);
        dm.add(scrollPane);
       
        table.setRowSelectionAllowed(true);
    }
    class back implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            dm.dispose();
            new background();
        }
    }
    public class clear implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	
            docname.setText("");
            docid.setText("");
            docspecial.setText("");
    
        }
    }
  

    class update implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int i = table.getSelectedRow();
            String name = docname.getText();
            String id = docid.getText();
            String special = docspecial.getText();
            String sex = comboGender.getSelectedItem().toString();
            
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
                 try {
                     FileWriter fileWriter = new FileWriter("D:/games/angel/src/FinalsTP/records.txt");
             for(int p = 0; p < table.getRowCount(); p++) {
            	 fileWriter.write(model.getValueAt(p, 0).toString() + " , " + 
             model.getValueAt(p, 1).toString() + " , " + model.getValueAt(p, 2).toString() + " , " + model.getValueAt(p, 3).toString() + "\n");
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
                      BufferedWriter bw = new BufferedWriter(new FileWriter("D:/games/angel/src/FinalsTP/records.txt"));
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
