package com.decode.alzaid;

import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.soundcloud.android.crop.Crop;

import java.io.File;

import static java.lang.Math.abs;

public class ImageQuestionActivity extends AppCompatActivity {

    private static final String TAG = "ImageQuestionActivity";

    Button addImage, addQuestioni;
    ImageView ivImage;
    EditText etAnsi, etOp1i, etOp2i, etOp3i;
    String ansi, op1i, op2i, op3i;
    public static final int PICK_IMAGE_REQUEST = 51;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_question);

        addImage = (Button) findViewById(R.id.btn_add_image);
        addQuestioni = (Button) findViewById(R.id.btn_add_questioni);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        etAnsi = (EditText) findViewById(R.id.et_answeri);
        etOp1i = (EditText) findViewById(R.id.et_option1i);
        etOp2i = (EditText) findViewById(R.id.et_option2i);
        etOp3i = (EditText) findViewById(R.id.et_option3i);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

            }
        });

        addQuestioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ansi = etAnsi.getText().toString();
                op1i = etOp1i.getText().toString();
                op2i = etOp2i.getText().toString();
                op3i = etOp3i.getText().toString();

                Log.d(TAG, "onClick: "+ansi+" "+op1i+" "+op2i+" "+op3i  );
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();

            Log.d(TAG, "onActivityResult: " + uri.hashCode());
            Uri destination = Uri.fromFile(new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "cropped" + uri.hashCode()));
            Log.d(TAG, "onActivityResult: "+destination);
            Crop.of(uri, destination).asSquare().start(this);
           ivImage.setVisibility(View.VISIBLE);

            Glide.with(this).load(destination).fitCenter().into(ivImage);

        }


    }
}
