package Model;
/*
Added mysql-connector-java jar files as external libraries
Should be able now to use MySQL to store and retrieve scores
that can be scored in the high scores

@references:
https://www.youtube.com/watch?v=BCqW5XwtJxY
https://www.tutorialspoint.com/jdbc/jdbc-insert-records.htm
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBase {

    private String sqlGet = "select * from scores";
    private Statement statement;
    private ResultSet results;
    private Connection con;
    private String name;
    private int score;
    private int id;

    public DataBase() {
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
    public String getScore() {
        //get score from db
        //String[] out;
       // out = new String[10];
        String out = "test";
        try{
            results = statement.executeQuery(sqlGet);
            while (results.next()){

                String name1 = results.getString("name");
                String score2 = results.getString("score");
                // System.out.println("Retrieving highscores...");
                // System.out.println(name +" "+ score);
               // out[0] = name1;
               // out[1] = score2;
               // return out;
                out = name1 + " " + score2;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return out;
    }

    public void setScore(int id, String name, int score) {
        this.name = name;
        this.score = score;
        this.id = id;
        String sqlSet = String.format("insert into scores(id, name, score) values (%d, %s, %d)",id,name, score);
        //insert the score into the mysql database
        try {
            results = statement.executeQuery(sqlSet);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}