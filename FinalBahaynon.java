package FinalsTP;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class FinalBahaynon extends JFrame {
	JFrame hs = new JFrame("Hospital Information System");
	
	public FinalBahaynon(){
		Font font = new Font("Bell MT", Font.BOLD, 40);
		JLabel label = new JLabel("Welcome to Angel's Lotus Hospital");
		label.setForeground(Color.WHITE);
		label.setBounds(50,20,800,50);
		label.setFont(font);
		hs.add(label);
        hs.setSize(750, 350);
        hs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hs.setLocationRelativeTo(null);
        hs.setLayout(null);
        
        JButton doc = new JButton("Doctor");
        doc.setBounds(180, 180, 150, 65);
        doc.setBackground(Color.decode("#FBF8BE"));
        doc.setForeground(Color.BLACK);
        doc.addActionListener(new DoctorListener());
        hs.add(doc);
        JButton patient = new JButton("Patient");
        patient.setForeground(Color.BLACK);
        patient.setBackground(Color.decode("#FBF8BE"));
        patient.setBounds(380, 180, 150, 65);
        patient.addActionListener(new PatientListener());
        hs.add(patient);

        JButton log = new JButton("Close");
        log.setForeground(Color.WHITE);
        log.setBounds(637, 270, 80, 30);
       log.setBackground(Color.decode("#E97777"));
        hs.add(log);
        log.addActionListener(new log());
        hs.setVisible(true);
        hs.getContentPane().setBackground(Color.decode("#234E70"));
    }

    class DoctorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            hs.dispose();
            new background();
        }
    }
	class log implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            hs.dispose();   
        }
    }
    class PatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            hs.dispose();
            new secondBackground();
    
        }
    }
 
	public static void main(String[] args) {
	    new FinalBahaynon();
	}

}