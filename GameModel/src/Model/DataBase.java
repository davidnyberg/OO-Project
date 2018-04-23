package Model;
/*
Added mysql-connector-java jar files as external libraries
Should be able now to use MySQL to store and retrieve scores
that can be scored in the high scores

@author david nyberg
@references:
https://www.youtube.com/watch?v=BCqW5XwtJxY
https://www.tutorialspoint.com/jdbc/jdbc-insert-records.htm
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


class DataBase {

    private String sqlGet = "select * from scores";
    private Statement statement;
    private ResultSet results;
    private Connection con;
    private String name;
    private int score;
    private int id;

    DataBase() {
        final String URL = "jdbc:mysql://localhost:3306/highscores?useSSL=false";
        final String USER = "root";
        final String PASS = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to highscores database...");
            con = DriverManager.getConnection(URL, USER, PASS);
            statement = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success!");

    }
    void getScore() {
        //gets the score from the Controller after a game is finished, can use SQL to put into the DB
        try{
            results = statement.executeQuery(sqlGet);
            while (results.next()){

                String name = results.getString("name");
                String score = results.getString("score");
                System.out.println("Retrieving highscores...");
                System.out.println(name +" "+ score);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setScore(int id, String name, int score) {
        this.name = name;
        this.score = score;
        this.id = id;
        String sqlSet = "insert into scores(id, name, score) values (%d, %s, %d)"+ id + score + name;
        //insert the score into the mysql database
        // st.executeQuery(sqlSet);
    }

    public int returnScore() {
        //will return the score from the database with SQL to the View leaderboard screen
        return 0;
    }
}