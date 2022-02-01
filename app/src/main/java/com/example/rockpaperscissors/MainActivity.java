package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private int pWeapon, cWeapon;
    private int pScore = 0, cScore = 0;
    private String cW = " ", results = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView score = findViewById(R.id.score), playerWeapon = findViewById(R.id.playerWeapon), computerWeapon = findViewById(R.id.computerWeapon),
        outcome = findViewById(R.id.results);
        score.setText("Player's Score: " + pScore + " , Computer's Score: " + cScore);
        playerWeapon.setText("Player Weapon: ");
        computerWeapon.setText("Computer Weapon: ");
        outcome.setText("No games played.");


        findViewById(R.id.scissorsId).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cWeapon = new Random().nextInt(Weapon.values().length);
                pWeapon = Weapon.SCISSORS.ordinal();
                fight(pWeapon, cWeapon);
                score.setText("Player's Score: " + pScore + " , Computer's Score: " + cScore);
                playerWeapon.setText("Player Weapon: " + Weapon.SCISSORS.toString());
                computerWeapon.setText("Computer Weapon: " + cW);
                outcome.setText(results);
            }
        });
        findViewById(R.id.rockId).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cWeapon = new Random().nextInt(Weapon.values().length);
                pWeapon = Weapon.ROCK.ordinal();
                fight(pWeapon, cWeapon);
                score.setText("Player's Score: " + pScore + " , Computer's Score: " + cScore);
                playerWeapon.setText("Player Weapon: " + Weapon.ROCK.toString());
                computerWeapon.setText("Computer Weapon: " + cW);
                outcome.setText(results);
            }
        });
        findViewById(R.id.paperId).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cWeapon = new Random().nextInt(Weapon.values().length);
                pWeapon = Weapon.PAPER.ordinal();
                fight(pWeapon, cWeapon);
                score.setText("Player's Score: " + pScore + " , Computer's Score: " + cScore);
                playerWeapon.setText("Player Weapon: " + Weapon.PAPER.toString());
                computerWeapon.setText("Computer Weapon: " + cW);
                outcome.setText(results);
            }
        });
    }

    public void fight(int pWeapon, int cWeapon){
        if (pWeapon == Weapon.ROCK.ordinal()){ // player is rock
            if(cWeapon == Weapon.ROCK.ordinal()){  // tie
                cW = Weapon.ROCK.toString();
                results = "Tie ... Rock vs Rock.";

            }
            else if(cWeapon == Weapon.PAPER.ordinal()){ // computer win
                cW = Weapon.PAPER.toString();
                cScore++;
                results = "Computer Wins ... Paper beats Rock.";
            }
            else if (cWeapon == Weapon.SCISSORS.ordinal()){  // player win
                cW = Weapon.SCISSORS.toString();
                pScore++;
                results = "Player Wins ... Rock beats Scissors.";
            }
        }
        else if(pWeapon == Weapon.SCISSORS.ordinal()){ // player is scissors
            if(cWeapon == Weapon.SCISSORS.ordinal()){ // tie
                cW = Weapon.SCISSORS.toString();
                results = "Tie ... Scissors vs Scissors.";
            }
            else if(cWeapon == Weapon.ROCK.ordinal()){ // computer win
                cW = Weapon.ROCK.toString();
                cScore++;
                results = "Computer Wins ... Rock beats Scissors.";
            }
            else if (cWeapon == Weapon.PAPER.ordinal()){ // player win
                cW = Weapon.PAPER.toString();
                pScore++;
                results = "Player Wins ... Scissors beats Paper.";
            }
        }
        else if (pWeapon == Weapon.PAPER.ordinal()){ // player is paper
            if(cWeapon == Weapon.PAPER.ordinal()){ // tie
                cW = Weapon.PAPER.toString();
                results = "Tie ... Paper vs Paper.";
            }
            else if(cWeapon == Weapon.SCISSORS.ordinal()){ // computer win
                cW = Weapon.SCISSORS.toString();
                cScore++;
                results = "Computer Wins ... Scissors beats Paper.";
            }
            else if (cWeapon == Weapon.ROCK.ordinal()){ // player win
                cW = Weapon.ROCK.toString();
                pScore++;
                results = "Player Wins ... Paper beats Rock.";
            }
        }
    }
}