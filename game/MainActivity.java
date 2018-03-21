package oop.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.playButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pressed Play!", Toast.LENGTH_SHORT).show();
                openGameScreen();
            }
        });

        Button button1 = (Button) findViewById(R.id.leaderboard);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Display Leaderboard", Toast.LENGTH_SHORT).show();
                openLeaderBoard();
            }
        });
    }

    public void openLeaderBoard(){
        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }
    public void openGameScreen(){
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }
}
