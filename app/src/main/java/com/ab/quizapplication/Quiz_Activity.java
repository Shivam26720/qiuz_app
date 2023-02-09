package com.ab.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ab.quizapplication.databinding.ActivityQuizBinding;

public class Quiz_Activity extends AppCompatActivity implements View.OnClickListener {
   ActivityQuizBinding binding;
    int score=0;
    int totalquestion=question.questions.length;
    int currindex=0;
    String selected="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.rgb(241,81,31));
        super.onCreate(savedInstanceState);
        binding=ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.optionA.setOnClickListener(this);
        binding.optionB.setOnClickListener(this);
        binding.optionC.setOnClickListener(this);
        binding.optionD.setOnClickListener(this);
        binding.submitbutton.setOnClickListener(this);
        loadnewquestion();
        binding.Totalquestion.setText("Total questions : "+currindex+" / "+totalquestion);
    }
    void  loadnewquestion(){
        if(currindex==totalquestion){
            questionover();
            return;
        }
        binding.question.setText(question.questions[currindex]);
        binding.optionA.setText(question.choic[currindex][0]);
        binding.optionB.setText(question.choic[currindex][1]);
        binding.optionC.setText(question.choic[currindex][2]);
        binding.optionD.setText(question.choic[currindex][3]);
    }

    void questionover(){
        new AlertDialog.Builder(this).setTitle("Result")
                        .setMessage("Score is  " + score + " out of " + totalquestion)
                .setCancelable(true).show();
    }

    @Override
    public void onClick(View view) {
        binding.optionA.setBackgroundColor(Color.rgb(241,81,31));
        binding.optionB.setBackgroundColor(Color.rgb(241,81,31));
        binding.optionC.setBackgroundColor(Color.rgb(241,81,31));
        binding.optionD.setBackgroundColor(Color.rgb(241,81,31));
        Button clickedButton=(Button) view;
 if(clickedButton.getId()==R.id.submitbutton){
     if(selected.equals(question.rightanswer[currindex])){
         score++;
     }
     currindex++;
     binding.Totalquestion.setText("Total questions : "+currindex+" / "+totalquestion);
     loadnewquestion();

 }
 else{
     selected=clickedButton.getText().toString();
     clickedButton.setBackgroundColor(Color.GREEN);

 }
    }
}