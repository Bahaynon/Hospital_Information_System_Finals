package FinalsTP;

import javax.swing.*;

import FinalsTP.Doctor.retri;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class background extends JFrame {
	JFrame hs = new JFrame("Doctor");
	public background(){
		Font font = new Font("Bell MT", Font.BOLD, 18);
		JLabel label = new JLabel("Select buttons to proceed for Doctors information's");
		label.setForeground(Color.WHITE);
		label.setBounds(60,20,600,40);
		label.setFont(font);
		hs.add(label);
        hs.setSize(550, 200);
        hs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hs.setLocationRelativeTo(null);
        hs.setLayout(null);
        
        JButton docs = new JButton("Doctor's Module");
        docs.setBounds(180, 80, 170, 25);
        docs.setBackground(Color.decode("#FBF8BE"));
        docs.setForeground(Color.BLACK);
        docs.addActionListener(new buttonDoctorListener());
        hs.add(docs);
        
        
        JButton view= new JButton("View and Edit Records");
        view.setBounds(180, 120, 170, 25);
        view.setBackground(Color.decode("#FBF8BE"));
        view.setForeground(Color.BLACK);
        view.addActionListener(new buttonPatientListener());
        hs.add(view);
        hs.setVisible(true);
        
        JButton rtrn = new JButton("Return");
        rtrn.setBounds(20, 120, 80, 30);
        hs.add(rtrn);
        rtrn.setForeground(Color.WHITE);
        rtrn.setBackground(Color.decode("#E97777"));
        rtrn.addActionListener(new retri());
        hs.getContentPane().setBackground(Color.decode("#234E70"));

    }
	class retri implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            hs.dispose();
            new FinalBahaynon();
            
        }
    }

    class buttonDoctorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            hs.dispose();
            new Doctor();
        }
    }
    class buttonPatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            hs.dispose();
            new ViewRecords();
    
        }
    }

}