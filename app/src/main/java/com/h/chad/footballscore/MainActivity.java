package com.h.chad.footballscore;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.digits;
import static com.h.chad.footballscore.R.string.fieldgoal;
import static com.h.chad.footballscore.R.string.home;
import static com.h.chad.footballscore.R.string.touchdown;

public class MainActivity extends AppCompatActivity {
    private int homeScore;          //Home team's score global variable
    private int awayScore;          //Away team's score global variable
    public String doubledigit;      //keeps the scoreboard double digits
    private final int TOUCHDOWN = 6;
    private final int FIELDGOAL = 3;
    private final int SAFETY = 2;
    private final int PAT = 1;

    public MainActivity() {
        homeScore = 0;
        awayScore = 0;
        doubledigit = "%1$02d";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset();
    }
    //Resets the score from the reset button
    public void resetScore(View view){
        reset();
    }
    //resets the score from the resetScore method.
    //added because calling reset score from onCreate caused an error
    public void reset(){
        homeScore = 0;
        awayScore = 0;
        display(homeScore, awayScore);
    }
    //adds six points when the home team scores a touchdown
    public void homeTouchDown(View view){
        homeScore += TOUCHDOWN;
        display(homeScore, awayScore);
    }
    //adds 3 points when the home team scores a fieldgoal
    public void homeFieldGoal(View view){
        homeScore += FIELDGOAL;
        display(homeScore, awayScore);
    }
    //adds 2 points when the home team scores a safety or 2 point conversion
    public void homeSafety(View view){
        homeScore += SAFETY;
        display(homeScore, awayScore);
    }
    //adds 1 point home team converts a PAT
    //should only be available after a touchdown is made
    public void homePAT(View view){
        homeScore += PAT;
        display(homeScore, awayScore);
    }
    //add 6 points when the away team scores a touchdown
    public void awayTouchDown(View view){
        awayScore += TOUCHDOWN;
        display(homeScore, awayScore);
    }
    //add 3 points when the away team scores a fieldgoal
    public void awayFieldGoal(View view){
        awayScore += FIELDGOAL;
        display(homeScore, awayScore);
    }
    //add 2 points when away team scores a safety or 2 point conversion
    public void awaySafety(View view){
        awayScore += SAFETY;
        display(homeScore, awayScore);
    }
    //adds 1 point away team converts a PAT
    //should only be available after a touchdown is made
    public void awayPAT(View view){
        awayScore += PAT;
        display(homeScore, awayScore);
    }
    //Displays the score for both home team and away team
    public void display(int home, int away){
        TextView tvHomeScore = (TextView) findViewById(R.id.tv_homeScore);
        TextView tvAwayScore = (TextView) findViewById(R.id.tv_awayScore);
        tvHomeScore.setText(String.format(doubledigit, home));
        tvAwayScore.setText(String.format(doubledigit, away));
    }
}
