package com.app.zadaniezinformatora;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public int currentPhoto = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView zdjecie = findViewById(R.id.imageView);
        Button prev = findViewById(R.id.prev);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            currentPhoto++;
            if(currentPhoto > 4){
                currentPhoto = 1;
            }
            zdjecie.setImageResource(changePhoto(currentPhoto));
        });
        prev.setOnClickListener(v -> {
            currentPhoto--;
            if(currentPhoto < 1){
                currentPhoto = 4;
            }
            zdjecie.setImageResource(changePhoto(currentPhoto));
        });
    }

    protected int changePhoto(int photoNumber){
        switch (photoNumber){
            case 1: return R.drawable.alpy;
            case 2: return R.drawable.dynarskie;
            case 3: return R.drawable.karpaty;
            case 4: return R.drawable.pireneje;
        }
        return 0;
    }
}