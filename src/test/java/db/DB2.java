package db;
import java.sql.*;
public class DB2 {
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

        // Сценарий 1: Добавление пользователя в таблицу, изменение его имени и получение обновленного имени
        try {
            statement.executeUpdate("INSERT INTO USERS (username, age) VALUES ('Alice', 27)");
            System.out.println("The person Alice added successfully");

            statement.executeUpdate("UPDATE USERS SET username = 'Den' WHERE username = 'Alice'");
            System.out.println("The person successfully updated");

            ResultSet rs = statement.executeQuery("SELECT username FROM USERS WHERE username = 'Den'");
            while (rs.next()) {
                String updatedName = rs.getString("username");
                System.out.println("Updated name: " + updatedName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Сценарий 2: Добавление пользователя в таблицу, удаление его и проверка, что пользователь не найден
        try {
            statement.executeUpdate("INSERT INTO USERS (username, age) VALUES ('Bob', 35)");
            System.out.println("The person Bob added successfully");

            statement.executeUpdate("DELETE FROM USERS WHERE username = 'Bob'");
            System.out.println("The user Bob successfully deleted");

            ResultSet rs = statement.executeQuery("SELECT * FROM USERS WHERE username = 'Bob'");
            if (!rs.next()) {
                System.out.println("User Bob not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connection.close();
    }
}
