package com.projectuas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FaceRecognitionApp {
    private JFrame frame;
    private JLabel imageLabel;
    private JButton uploadButton;
    private JLabel resultLabel;

    private FaceAnalyzer analyzer = new FaceAnalyzer();
    private ExpressionDAO expressionDAO = new ExpressionDAO();

    public FaceRecognitionApp() {
        frame = new JFrame("Face Recognition App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        uploadButton = new JButton("Upload Photo");
        frame.add(uploadButton, BorderLayout.SOUTH);

        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(resultLabel, BorderLayout.NORTH);

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String expression = analyzer.analyzeFace(selectedFile.getAbsolutePath());
                    imageLabel.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
                    resultLabel.setText("Result: " + expression);
                    expressionDAO.saveExpression(new Expression(selectedFile.getAbsolutePath(), expression));
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FaceRecognitionApp();
    }
}
