package db;


import java.sql.*;

public class DB {

    private final static String DB_URL = "jbdc:postgressql://localhost:5432/habrdb";
    private final static String USER = "habrpguser";
    private final static String PASS = "pgwd4habr";


    static Statement statement = null;
    public static void main(String[] args) throws SQLException {
        System.out.println("Test connection to Driver");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error connect to driver");
            throw new RuntimeException(e);
        }

        System.out.println("We successfully connected to driver");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Fail to get connection");
            throw new RuntimeException(e);
        }

        if (connection != null) {
            System.out.println("We successfully connected");
        } else {
            System.out.println("Fail to get connection");
        }

        statement = connection.createStatement();
        //SQL SELECT
        try {


            ResultSet rs = statement.executeQuery("SELECT * FROM  WHERE username like 'Alice'");

            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");

                System.out.println(username);
                System.out.println(age);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //SQL INSERT

        try {
            statement.executeUpdate("INSERT INTO USERS (username, age) VALUES ('Alice', 27)");
            System.out.println("The person Alice added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //SQL UPDATE

        try {
            statement.execute("UPDATE USERS SET username = 'Den' WHERE username = 'Nick'");
            System.out.println("The person successfully updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //SQL DELETE

        try {
            statement.execute("delete from USERS WHERE username = 'Alice'");
            System.out.println("The user Alice successfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
