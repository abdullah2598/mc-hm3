package com.example.mc_ass2_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizQuestions extends AppCompatActivity {
   static int i=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        TextView qes=findViewById(R.id.questiontext);
        RadioButton rd1=findViewById(R.id.radioButton1);
        RadioButton rd2=findViewById(R.id.radioButton2);
        RadioButton rd3 = findViewById(R.id.radioButton3);
        RadioButton rd4= findViewById(R.id.radioButton4);
        Button next=findViewById(R.id.nextbutton);

        Intent intent=getIntent();
        String quess=intent.getStringExtra("quest");
        String op1=intent.getStringExtra("op1");
        String op2=intent.getStringExtra("op2");
        String op3=intent.getStringExtra("op3");
        String op4=intent.getStringExtra("op4");
        qes.setText(quess);
        rd1.setText(op1);
        rd2.setText(op2);
        rd3.setText(op3);
        rd4.setText(op4);
        String[] answers=new String[getAllQuestion()];


            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    QuestionClass q = getQuestion(i);
                    qes.setText(q.questionvalue);
                    rd1.setText(q.option1);
                    rd2.setText(q.option2);
                    rd3.setText(q.option3);
                    rd4.setText(q.option4);
                    if(q!=null)
                    {

                        if(rd1.isSelected())
                        {
                            answers[i]= (String) rd1.getText();
                        }
                        if(rd2.isSelected())
                        {
                            answers[i]= (String) rd2.getText();
                        }
                        if(rd3.isSelected())
                        {
                            answers[i]= (String) rd3.getText();
                        }
                        if(rd3.isSelected())
                        {
                            answers[i]= (String) rd4.getText();
                        }
                        i++;
                    }
                    else
                    {

                    }

                }
            });




    }
    public QuestionClass getQuestion(int index)
    {
        DBHelper db=new DBHelper(this);
        ArrayList<QuestionClass> list1=db.getAllData();

        String ival=String.valueOf(list1.size());
        Toast.makeText(QuizQuestions.this, ival, Toast.LENGTH_SHORT).show();

        if(index >list1.size())
        {
            return null;
        }
        QuestionClass qt=list1.get(index);
        return qt;

    }
    public int  getAllQuestion()
    {

        DBHelper db=new DBHelper(this);
        ArrayList<QuestionClass> list1=db.getAllData();

        return list1.size();

    }


}