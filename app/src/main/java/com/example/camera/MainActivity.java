package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    @Override // fonction déclaré apres remplace une autre qui porte le meme nom
    protected void onCreate(Bundle savedInstanceState) { //methode déclaré
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.capturedImage);
        button = findViewById(R.id.openCamera);

        button.setOnClickListener(new View.OnClickListener() {
            @Override // fonction déclaré apres remplace une autre qui porte le meme nom
            public void onClick(View view) { //methode déclaré
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 100);

            }
            });
    }

    @Override // fonction déclaré apres remplace une autre qui porte le meme nom
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //methode
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(photo);
    }
}

