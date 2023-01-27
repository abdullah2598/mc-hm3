package com.example.mc_ass2_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db=new DBHelper(this);

        Boolean val=db.insert("when pakistan won t20 World cup","2008","2009","2010","2012","2009");
        Boolean val1= db.insert("Sailkot is famous for","sports industry","fertilizers","car industry","tyre industry","sports industry");
        Boolean val2= db.insert("independence day of pakistan","1947","1948","1979","1950","1947");
        Boolean val3= db.insert("Age to get eligible for licence","18","19","20","21","18");
        ArrayList<QuestionClass> list1=db.getAllData();
        QuestionClass qest=list1.get(0);
        String question11= qest.questionvalue;
        String option1=qest.option1;
        String option2= qest.option2;
        String option3=qest.option3;
        String option4= qest.option4;
        Button startTest=findViewById(R.id.starttest);
        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent=new Intent(MainActivity.this, QuizQuestions.class);

                intent.putExtra("quest",question11);
                intent.putExtra("op1",option1);
                intent.putExtra("op2",option2);
                intent.putExtra("op3",option3);
                intent.putExtra("op4",option4);

                startActivity(intent);
            }
        });




    }
}