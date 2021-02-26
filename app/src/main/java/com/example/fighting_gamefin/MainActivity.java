package com.example.fighting_gamefin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int player1H = 500;
    int player2H = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView player1Health = findViewById(R.id.player1Health);
        TextView player2Health = findViewById(R.id.player2Health);
        TextView player1DMG = findViewById(R.id.player1DMG);
        TextView player2DMG = findViewById(R.id.player2DMG);
        TextView PlayerText = findViewById(R.id.PlayerText);
        TextView WinText = findViewById(R.id.WinText);


        Button btnFight, RstBtn;
        btnFight = findViewById(R.id.btnFight);
        RstBtn = findViewById(R.id.RstBtn);

        btnFight.setOnClickListener(this);
        RstBtn.setOnClickListener(this);

        PlayerText.setText("");
        WinText.setText("");
    }

    @Override
    public void onClick(View v) {

        TextView player1Health, player2Health, PlayerText, WinText;

        player1Health = findViewById(R.id.player1Health);
        player2Health = findViewById(R.id.player2Health);
        PlayerText = findViewById(R.id.PlayerText);
        WinText = findViewById(R.id.WinText);


        int player1D = (int) Math.floor(Math.random() * 10 + 2);
        int player2D = (int) Math.floor(Math.random() * 15 + 6);

        if (player1H > 0 && player2H > 0) {
            switch (v.getId()) {
                case R.id.btnFight:
                    player1H -= player2D;
                    player2H -= player1D;
                    break;
            }
        }

        else {
            if (player1H <= 0 && player2H <= 0){
                if (player1H > player2H) {
                    PlayerText.setText("Player 1");
                    WinText.setText("Wins!");
                }
                else if (player2H > player1H) {
                    PlayerText.setText("Player 2");
                    WinText.setText("Wins!");
                }
                else if (player1H == player2H) {
                    PlayerText.setText("Draw!");
                    WinText.setText("");
                }
            }
            else if (player1H <= 0){
                player1H = 0;
                PlayerText.setText("Player 2");
                WinText.setText("Wins!");
            }
            else if (player2H <= 0){
                player2H = 0;
                PlayerText.setText("Player 1");
                WinText.setText("Wins!");
            }
        }

        if (v.getId() == R.id.RstBtn){
            player1H = 500;
            player2H = 250;
            player1Health.setText(("Health: ")+(Integer.toString(player1H)));
            player2Health.setText(("Health: ")+(Integer.toString(player2H)));
            PlayerText.setText("");
            WinText.setText("");
        }

        player1Health.setText(("Health: ")+(Integer.toString(player1H)));
        player2Health.setText(("Health: ")+(Integer.toString(player2H)));




        }
    }







