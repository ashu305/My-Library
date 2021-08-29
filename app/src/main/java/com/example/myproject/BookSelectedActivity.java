package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class BookSelectedActivity extends AppCompatActivity {

    private TextView BookName, Author, pages, LongDesc;
    private Button AddToCurrentlyReading, AddToAlreadyRead, AddToWishlist , AddToFavourites, GotoBook;
    private ImageView BookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_book_selected);

        InitViews();


        Book book =(Book) getIntent().getSerializableExtra("Details");

        if(book != null){
            setData(book);
            HandelAlreadyRead(book);
            HandelCurrentlyReadingBook(book);
            HandelWishlistBooks(book);
            HandelFavoutiteBooks(book);
            HandelVisitingBook(book);
        }


    }

    private void HandelVisitingBook(Book book) {

        GotoBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookSelectedActivity.this, WebActivity.class);
                switch (book.getId()){
                    case 1:
                        intent.putExtra("url", "https://www.youtube.com/watch?v=uSDHIWHjxws&ab_channel=SundaySuspect");
                        break;
                    case 2:
                        intent.putExtra("url", "https://www.youtube.com/watch?v=lzjiri4zluI&ab_channel=Cltbooks%26mediation");
                        break;
                    case 3:
                        intent.putExtra("url", "https://www.youtube.com/playlist?list=PLGr7rzeO4rCWoJKVCU5GcKuP8EZFxkBZl");
                        break;
                    case 4:
                        intent.putExtra("url", "https://www.youtube.com/watch?v=MpnYSBeZG0E");
                        break;
                    default:
                        intent.putExtra("url", "https://books.google.co.in/books/about/Let_us_C_16th_Edition.html?id=QIV8DwAAQBAJ&printsec=frontcover&source=kp_read_button&redir_esc=y#v=onepage&q&f=false");
                        break;

                }

                startActivity(intent);
            }
        });



    }

    private void HandelCurrentlyReadingBook(Book book) {
        ArrayList<Book> CurrentlyReadingBook = Utils.getInstance(this).getCurrentlyReading();
        boolean doesExist = false;
        for(Book b: CurrentlyReadingBook){
            if(b.getId() == book.getId()) doesExist = true;
        }

        if(doesExist){
            AddToCurrentlyReading.setEnabled(false);
        }else{
            AddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookSelectedActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(BookSelectedActivity.this, "Book Added!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookSelectedActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookSelectedActivity.this, "Try Again!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void HandelWishlistBooks(Book book) {
        ArrayList<Book> WantToReadBooks = Utils.getInstance(this).getWishListBooks();
        boolean doesExist = false;
        for(Book b: WantToReadBooks){
            if(b.getId() == book.getId()) doesExist = true;
        }

        if(doesExist){
            AddToWishlist.setEnabled(false);
        }else{
            AddToWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookSelectedActivity.this).AddToWishList(book)){
                        Toast.makeText(BookSelectedActivity.this, "Book Added!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookSelectedActivity.this, WishlistActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookSelectedActivity.this, "Try Again!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void HandelFavoutiteBooks(Book book) {
        ArrayList<Book> FavouriteBooks = Utils.getInstance(this).getFavouriteBooks();
        boolean doesExist = false;
        for(Book b: FavouriteBooks){
            if(b.getId() == book.getId()) doesExist = true;
        }

        if(doesExist){
            AddToFavourites.setEnabled(false);
        }else{
            AddToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookSelectedActivity.this).addToFavourites(book)){
                        Toast.makeText(BookSelectedActivity.this, "Book Added!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookSelectedActivity.this, FavouriteBooksActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookSelectedActivity.this, "Try Again!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void HandelAlreadyRead(Book book) {

        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyRead();
        boolean doesExist = false;
        for(Book b: alreadyReadBooks){
            if(b.getId() == book.getId()) doesExist = true;
        }

        if(doesExist){
            AddToAlreadyRead.setEnabled(false);
        }else{
            AddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookSelectedActivity.this).AddToAlreadyRead(book)){
                        Toast.makeText(BookSelectedActivity.this, "Book Added!", Toast.LENGTH_SHORT).show();
                        //TODO: Navigate the User!
                        Intent intent = new Intent(BookSelectedActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookSelectedActivity.this, "Try Again!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {
        BookName.setText(book.getName());
        Author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));
        LongDesc.setText(book.getLongDesc());

        Glide.with(this).asBitmap().
                load(book.getImageUrl()).into(BookImage);
    }

    private void InitViews() {
        BookName = findViewById(R.id.txtBookNameBookSelected);
        Author = findViewById(R.id.txtAuthorBookSelected);
        pages = findViewById(R.id.txtpagesBookSelected);
        LongDesc = findViewById(R.id.txtLongDescBookSelected);
        AddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        AddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        AddToWishlist = findViewById(R.id.btnAddToWishlist);
        AddToFavourites = findViewById(R.id.btnAddToFavourites);
        BookImage = findViewById(R.id.ImgBookBookSelect);
        GotoBook = findViewById(R.id.btnGoto);
    }
}