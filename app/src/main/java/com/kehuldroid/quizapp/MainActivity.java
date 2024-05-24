package com.kehuldroid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView , q_no;
    private RadioGroup answersRadioGroup;
    private Button submitButton;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_text_view);
        answersRadioGroup = findViewById(R.id.answers_radio_group);
        submitButton = findViewById(R.id.submit_button);
        q_no = findViewById(R.id.qno);

        QuestionBank questionBank = new QuestionBank();
        questions = questionBank.getQuestions();

        loadQuestion();

        answersRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = findViewById(checkedId);
                if (checkedRadioButton != null) {
                    checkedRadioButton.setTextColor(Color.WHITE);
                }

                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton != null && radioButton.getId() != checkedId) {
                        radioButton.setTextColor(Color.BLACK);
                    }
                }
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            int temp = currentQuestionIndex +1;
            q_no.setText("Question "+temp+"/"+questions.size());
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionTextView.setText(currentQuestion.getQuestionText());
            ((RadioButton) answersRadioGroup.getChildAt(0)).setText(currentQuestion.getOptions()[0]);
            ((RadioButton) answersRadioGroup.getChildAt(1)).setText(currentQuestion.getOptions()[1]);
            ((RadioButton) answersRadioGroup.getChildAt(2)).setText(currentQuestion.getOptions()[2]);
            ((RadioButton) answersRadioGroup.getChildAt(3)).setText(currentQuestion.getOptions()[3]);
        } else {
            showScore();
        }
    }

    private void checkAnswer() {
        int selectedId = answersRadioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            int answerIndex = answersRadioGroup.indexOfChild(selectedRadioButton);

            if (answerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                score++;
            }

            currentQuestionIndex++;
            answersRadioGroup.clearCheck();
            loadQuestion();
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        new AlertDialog.Builder(this)
                .setTitle("Quiz Finished")
                .setMessage("Your score: " + score +"/"+questions.size())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }
}
