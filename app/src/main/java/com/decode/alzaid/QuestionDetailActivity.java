package com.decode.alzaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class QuestionDetailActivity extends AppCompatActivity {

    Spinner spQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);

        spQuestions = (Spinner) findViewById(R.id.sp_questions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.questions_array, android.R.layout.simple_spinner_item);
        spQuestions.setAdapter(adapter);
    }
}
