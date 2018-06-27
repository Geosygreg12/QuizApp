package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    /**
     * score, keeps track of the candidate's score
     * correctAnswerOne, correctAnswerTwo, correctAnswerthree, correctAnswerfour, used to implement the total
     * score and serves as conditions for the submitButton method
     * spinners, used to activate and implement the spinners in sml containing the question options */

    int score = 0;
    boolean correctAnswerOne;
    boolean correctAnswerTwo;
    boolean correctAnswerThree;
    boolean correctAnswerFour;
    Spinner numberOne, numberTwo, numberThree, numberFour;

/**
 * here the spinners are activated and implemented
 * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = findViewById(R.id.questionOneSpinner);
        ArrayAdapter<CharSequence> numberOneAdapter = ArrayAdapter.createFromResource(this, R.array.questionOneOptions, android.R.layout.simple_list_item_1);
        numberOneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOne.setAdapter(numberOneAdapter);
        numberOne.setOnItemSelectedListener(this);

        numberTwo = findViewById(R.id.questionTwoSpinner);
        ArrayAdapter<CharSequence> numberTwoAdapter = ArrayAdapter.createFromResource(this, R.array.questionTwoOptions, android.R.layout.simple_list_item_1);
        numberTwoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberTwo.setAdapter(numberTwoAdapter);
        numberTwo.setOnItemSelectedListener(this);

        numberThree = findViewById(R.id.questionThreeSpinner);
        ArrayAdapter<CharSequence> numberThreeAdapter = ArrayAdapter.createFromResource(this, R.array.questionThreeOptions, android.R.layout.simple_list_item_1);
        numberTwoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberThree.setAdapter(numberThreeAdapter);
        numberThree.setOnItemSelectedListener(this);

        numberFour = findViewById(R.id.questionFourSpinner);
        ArrayAdapter<CharSequence> numberFourAdapter = ArrayAdapter.createFromResource(this, R.array.questionFourOptions, android.R.layout.simple_list_item_1);
        numberFourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberFour.setAdapter(numberFourAdapter);
        numberFour.setOnItemSelectedListener(this);

    }
/**
 * this method is called whenever the submit button is pressed
 **/
    public void submitButton(View v){

        if (correctAnswerOne){
            score = score + 25;
        }
        if (correctAnswerTwo){
            score = score + 25;
        }
        if (correctAnswerThree){
            score = score + 25;
        }
        if (correctAnswerFour){
            score = score + 25;
        }
        TextView userName = findViewById(R.id.newUserName);
        String addressMessage = userName.getText().toString();
        addressMessage = addressMessage + "," + " your score is " + score + " percent";
        displayMessage(addressMessage);
        score = 0;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.questionOneSpinner:

                if (position == 1){
                    correctAnswerOne = true;
                }
                else {
                    correctAnswerOne = false;
                }
                break;
            case R.id.questionTwoSpinner:
                if (position == 2){
                    correctAnswerTwo = true;
                }
                else {
                    correctAnswerTwo = false;
                }
                break;
            case R.id.questionThreeSpinner:
                if (position == 1){
                    correctAnswerThree = true;
                }
                else {
                    correctAnswerThree = false;
                }
                break;
            case R.id.questionFourSpinner:
                if (position == 1 ){
                    correctAnswerFour = true;
                }
                else {
                    correctAnswerFour = false;
                }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
/**
 * this method is called whenever the startover button is pressed
 * */
    public void startOver (View v){
        score = 0;
        displayMessage("");
    }
/**
 * this method is used to display the selected text to the screen
 * */
    private void displayMessage (String message){
        TextView answerView = findViewById(R.id.answerStatement);
        answerView.setText(message);
    }
}
