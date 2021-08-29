package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView bookRecyclerView;
    private BookRecyclerViewAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_all_books);


        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        bookRecyclerView = findViewById(R.id.BooksRecyclerView);

        Adapter = new BookRecyclerViewAdapter(this, "AllBooks");

        bookRecyclerView.setAdapter(Adapter);
        bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        Adapter.setBooks(Utils.getInstance(this).getAllBooks());

    }

    @Override
    public void finish() {
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        super.finish();
    }
}