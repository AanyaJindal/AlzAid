package com.decode.alzaid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionDisplay extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_display);

        Toast welcomeMsg = Toast.makeText(getApplicationContext(), "Let's get started!", Toast.LENGTH_LONG);
        welcomeMsg.setGravity(Gravity.CENTER, 0, 0);
        welcomeMsg.show();

        TextView questText = (TextView) findViewById(R.id.questionText);

        ImageView questImage = (ImageView) findViewById(R.id.questionImage);

        Button op1 = (Button) findViewById(R.id.button1);
        Button op2 = (Button) findViewById(R.id.button2);
        Button op3 = (Button) findViewById(R.id.button3);
        Button op4 = (Button) findViewById(R.id.button4);

        Button submitBtn = (Button) findViewById(R.id.submitButton);

    }
}
