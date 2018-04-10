package Model;
/*
Added mysql-connector-java jar files as external libraries
Should be able now to use MySQL to store and retrieve scores
that can be scored in the high scores
 */
import java.sql.DriverManager;


class DataBase {

    DataBase(){
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String user = "root";
        String pass = "root";
        //Connection con;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("Caught error: " + e);
        }
    }

    public void getScore() {
        //gets the score from the controller after a game is finished, can use SQL to put into the DB
    }

    public int returnScore() {
        //will return the score from the database with SQL to the View leaderboard screen
        return 0;
    }
}
