package Model;
/*
Added mysql-connector-java jar files as external libraries
Should be able now to use MySQL to store and retrieve scores
that can be scored in the high scores
 */
import java.sql.DriverManager;


class DataBase {

    private String sqlInsert = "";
    private String sqlReturn = "";

    DataBase(){
        final String URL = "jdbc:mysql://localhost:3306/highscores?useSSL=false";
        final String USER = "root";
        final String PASS = "root";
        //Connection con;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to highscores database...");
            DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        System.out.println("Success!");

    }

    public void getScore() {
        //gets the score from the controller after a game is finished, can use SQL to put into the DB
    }
    public void insertScore(){
        //insert the score into the mysql database
    }

    public int returnScore() {
        //will return the score from the database with SQL to the View leaderboard screen
        return 0;
    }
}
