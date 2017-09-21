package com.example.android.braintrainer;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout gameLayout;
    Button startButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
    TextView sumTextView;
    ArrayList<Integer> answers;
    int locationOfCorrectAnswer;
    TextView answerToast;
    TextView points;
    TextView timerTextView;
    int score = 0;
    int numberOfQuestions =0;

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        points.setText("0/0");
        answerToast.setText("");
        playAgain.setVisibility(View.INVISIBLE);

        new CountDownTimer(30200, 1000) {
            @Override
            public void onTick(long millisecondsUntilFinished) {
                timerTextView.setText(String.valueOf(millisecondsUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                sumTextView.setText("Done!");
                timerTextView.setText("0s");
                answerToast.setText("Your score: " + score);
                answerToast.setTextColor(Color.BLUE);
                playAgain.setVisibility(View.VISIBLE);

            }
        }.start();

        answers.clear();

        generateQuestion();
    }

    public void generateQuestion(){
        Random rand = new Random();

        int num1 = rand.nextInt(21);
        int num2 = rand.nextInt(21);

        sumTextView.setText(Integer.toString(num1) + " + " + Integer.toString(num2));

        locationOfCorrectAnswer = rand.nextInt(4);

        int incorrectAnswer;

        for (int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add(num1 + num2);
            }else{
                incorrectAnswer = rand.nextInt(41);

                while (incorrectAnswer == num1 + num2){
                    incorrectAnswer = rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(RelativeLayout.VISIBLE);

    }

    public void chooseAnswer(View view){

        numberOfQuestions++;

        answers.clear();

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            Log.i("Correct", "Correct");
            answerToast.setText("Correct!");
            answerToast.setTextColor(Color.GREEN);
            score++;
        }else{
            answerToast.setText("Wrong!");
            answerToast.setTextColor(Color.RED);
        }
        points.setText(Integer.toString(score) +"/" + Integer.toString(numberOfQuestions));
        generateQuestion();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerToast = (TextView)findViewById(R.id.answerView);
        points = (TextView)findViewById(R.id.pointsTextView);
        answers = new ArrayList<>();
        startButton = (Button)findViewById(R.id.startButton);
        sumTextView = (TextView)findViewById(R.id.sumTextView);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        playAgain = (Button)findViewById(R.id.playAgain);
        gameLayout = (RelativeLayout)findViewById(R.id.gameLayout);

        playAgain(findViewById(R.id.playAgain));


    }
}
