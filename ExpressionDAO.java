package com.projectuas;

import java.sql.*;

import javax.swing.JOptionPane;

public class ExpressionDAO {
    private Connection connection;

    public ExpressionDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/FaceRecognitionDB";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "error"+ e);
        }
    }

    public void saveExpression(Expression expression) {
        String query = "INSERT INTO expressions (image_path, expression) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, expression.getImagePath());
            stmt.setString(2, expression.getExpression());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
