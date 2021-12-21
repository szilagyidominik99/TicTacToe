package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectTableSize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_table_size);
    }

    public void backButton(View view) {
        finish();
    }

    public void size3Button(View view) {
        Intent intent = new Intent(this, Game3x3.class);
        startActivity(intent);
    }

    public void size4Button(View view) {
        Intent intent = new Intent(this, Game4x4.class);
        startActivity(intent);
    }

    public void size5Button(View view) {
        Intent intent = new Intent(this, Game5x5.class);
        startActivity(intent);
    }
}