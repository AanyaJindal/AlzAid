package com.decode.alzaid;

import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;
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

public class ImageQuestionActivity extends AppCompatActivity {

    private static final String TAG = "ImageQuestionActivity";

    Button addImage, addQuestioni;
    ImageView ivImage;
    public static final int PICK_IMAGE_REQUEST = 51;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_question);

        addImage = (Button) findViewById(R.id.btn_add_image);
        addQuestioni = (Button) findViewById(R.id.btn_add_questioni);
        ivImage = (ImageView) findViewById(R.id.iv_image);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();

            Log.d(TAG, "onActivityResult: " + uri.hashCode());
            Uri destination = Uri.fromFile(new File(getExternalCacheDir(), "/AlxAid/" + uri.hashCode()));
            Crop.of(uri, destination).asSquare().start(this);
            Glide.with(this).load(destination).fitCenter().into(ivImage);

        }


    }
}
