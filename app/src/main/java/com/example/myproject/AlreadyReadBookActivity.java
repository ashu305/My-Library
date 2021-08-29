package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class AlreadyReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_already_read_book);

        RecyclerView booksRecyclerView = findViewById(R.id.booksRecyclerView);
        BookRecyclerViewAdapter Adapter = new BookRecyclerViewAdapter(this, "AlreadyReadBooks");
        booksRecyclerView.setAdapter(Adapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Adapter.setBooks(Utils.getInstance(this).getAlreadyRead());


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}