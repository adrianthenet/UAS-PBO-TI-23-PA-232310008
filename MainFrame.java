package com.projectuas;
//File: MainFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
 private JTextField txtStudentID, txtNama, txtUsia, txtJenisKelamin, txtEtnis;
 private JTextArea txtOutput;

 public MainFrame() {
     // Set up frame
     setTitle("Data Siswa");
     setSize(400, 500);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new FlowLayout());

     // Input fields
     add(new JLabel("Student ID:"));
     txtStudentID = new JTextField(20);
     add(txtStudentID);

     add(new JLabel("Nama:"));
     txtNama = new JTextField(20);
     add(txtNama);

     add(new JLabel("Usia:"));
     txtUsia = new JTextField(20);
     add(txtUsia);

     add(new JLabel("Jenis Kelamin:"));
     txtJenisKelamin = new JTextField(20);
     add(txtJenisKelamin);

     add(new JLabel("Etnis:"));
     txtEtnis = new JTextField(20);
     add(txtEtnis);

     // Button to submit data
     JButton btnSubmit = new JButton("Submit");
     add(btnSubmit);

     // Output area
     txtOutput = new JTextArea(10, 30);
     txtOutput.setEditable(false);
     add(new JScrollPane(txtOutput));

     // Action Listener for Submit Button
     btnSubmit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 String studentID = txtStudentID.getText();
                 String nama = txtNama.getText();
                 int usia = Integer.parseInt(txtUsia.getText());
                 String jenisKelamin = txtJenisKelamin.getText();
                 String etnis = txtEtnis.getText();

                 // Create Siswa object
                 Siswa siswa = new Siswa(studentID, nama, usia, jenisKelamin, etnis);

                 // Display data in text area
                 txtOutput.setText("Informasi Siswa:\n");
                 txtOutput.append("Student ID: " + siswa.getStudentID() + "\n");
                 txtOutput.append("Nama: " + siswa.getNama() + "\n");
                 txtOutput.append("Usia: " + siswa.getUsia() + "\n");
                 txtOutput.append("Jenis Kelamin: " + siswa.getJenisKelamin() + "\n");
                 txtOutput.append("Etnis: " + siswa.getEtnis() + "\n");

                 // Clear input fields
                 txtStudentID.setText("");
                 txtNama.setText("");
                 txtUsia.setText("");
                 txtJenisKelamin.setText("");
                 txtEtnis.setText("");

             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(null, "Usia harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     });
 }

 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> {
         MainFrame frame = new MainFrame();
         frame.setVisible(true);
     });
 }
}