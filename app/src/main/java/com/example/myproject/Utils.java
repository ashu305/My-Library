package com.example.myproject;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static final String All_Books_key = "allBooks";
    private static final String Already_Read_Books_key = "alreadyRead";
    private static final String WishList_key = "WishlistBooks";
    private static final String Favourite_books_key = "FavouriteBooks";
    private static final String Continue_Reading_key = "ContinueReadingBooks";

    private SharedPreferences sharedPreferences;
    private static Utils Instance;
//    private static ArrayList<Book> AllBooks;
//    private static ArrayList<Book> AlreadyRead;
//    private static ArrayList<Book> CurrentlyReading;
//    private static ArrayList<Book> WishListBooks;
//    private static ArrayList<Book> FavouriteBooks;


    private Utils(Context context){

        sharedPreferences = context.getSharedPreferences("AlternateDB", Context.MODE_PRIVATE);
        if(getAllBooks() == null){
//            AllBooks = new ArrayList<>();
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();


        if(getAlreadyRead() == null){
//            AlreadyRead = new ArrayList<>();
            editor.putString(Already_Read_Books_key, gson.toJson(new ArrayList<Book>()));                   //Entering empty thing to sharedPrefereences
            editor.commit();
        }

        if(getCurrentlyReading() == null){
//            CurrentlyReading = new ArrayList<>();
            editor.putString(Continue_Reading_key, gson.toJson(new ArrayList<Book>()));                   //Entering empty thing to sharedPrefereences
            editor.commit();
        }
        if(getWishListBooks() == null){
//            WishListBooks = new ArrayList<>();

            editor.putString(WishList_key, gson.toJson(new ArrayList<Book>()));                   //Entering empty thing to sharedPrefereences
            editor.commit();
        }

        if(getFavouriteBooks() == null){
//            FavouriteBooks = new ArrayList<>();
            editor.putString(Favourite_books_key, gson.toJson(new ArrayList<Book>()));                   //Entering empty thing to sharedPrefereences
            editor.commit();
        }
    }

    private void initData() {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "Ikigai", "Francesc Miralles", "https://images-na.ssl-images-amazon.com/images/I/71tbalAHYCL.jpg", 150,
                "Ikigai (生き甲斐, \"a reason for being\") is" +
                        " a Japanese " +
                        "concept referring to having a direction or purpose in life, " +
                        "providing a sense of fulfillment and towards which they the " +
                        "person may take actions, giving them satisfaction and a sense of meaning.",
                "Ikigai (生き甲斐, \"a reason for being\") is" +
                        " a Japanese " +
                        "concept referring to having a direction or purpose in life, " +
                        "providing a sense of fulfillment and towards which they the " +
                        "person may take actions, giving them satisfaction and a sense of meaning."+
                        "Ikigai (生き甲斐, \"a reason for being\") is" +
                        " a Japanese " +
                        "concept referring to having a direction or purpose in life, " +
                        "providing a sense of fulfillment and towards which they the " +
                        "person may take actions, giving them satisfaction and a sense of meaning."+
                        "Ikigai (生き甲斐, \"a reason for being\") is" +
                        " a Japanese " +
                        "concept referring to having a direction or purpose in life, " +
                        "providing a sense of fulfillment and towards which they the " +
                        "person may take actions, giving them satisfaction and a sense of meaning."));


        books.add(new Book(2, "The Subtle Art Of Not Giving A Fuck", "Mark Manson",
                "https://n2.sdlcdn.com/imgs/g/4/3/The-Subtle-Art-of-Not-SDL788651516-1-e11e0.jpeg",
                224, "The Subtle Art of Not Giving a Fuck: " +
                "A Counterintuitive Approach to Living a Good Life (first published in 2016) is the second book by blogger and author Mark Manson." +
                " In it Manson argues that life's struggles give it meaning, " +
                "and that the mindless positivity of typical self-help books is neither practical nor helpful",
                "A Counterintuitive Approach to Living a Good Life (first published in 2016) is the second book by blogger and author Mark Manson." +
                        " In it Manson argues that life's struggles give it meaning, " +
                        "and that the mindless positivity of typical self-help books is neither practical nor helpful"+
                        "A Counterintuitive Approach to Living a Good Life (first published in 2016) is the second book by blogger and author Mark Manson." +
                        " In it Manson argues that life's struggles give it meaning, " +
                        "and that the mindless positivity of typical self-help books is neither practical nor helpful"+
                        "A Counterintuitive Approach to Living a Good Life (first published in 2016) is the second book by blogger and author Mark Manson." +
                        " In it Manson argues that life's struggles give it meaning, " +
                        "and that the mindless positivity of typical self-help books is neither practical nor helpful"+
                        "A Counterintuitive Approach to Living a Good Life (first published in 2016) is the second book by blogger and author Mark Manson." +
                        " In it Manson argues that life's struggles give it meaning, " +
                        "and that the mindless positivity of typical self-help books is neither practical nor helpful"));

        books.add(new Book(3, "Autobiography of a Yogi", "Paramahansa Yogananda",
                "https://images-na.ssl-images-amazon.com/images/I/41sEB1SxefL._SX307_BO1,204,203,200_.jpg", 403,
                "Autobiography of a Yogi introduces the reader to the life of Paramahansa Yogananda and his encounters with spiritual" +
                        " figures of both the Eastern and the Western world." +
                        " The book begins with his childhood family life, to " +
                        "finding his guru, to becoming a monk and establishing his teachings of Kriya Yoga meditation.",
                "Autobiography of a Yogi introduces the reader to the life of Paramahansa Yogananda and his encounters with spiritual" +
                        " figures of both the Eastern and the Western world." +
                        " The book begins with his childhood family life, to " +
                        "finding his guru, to becoming a monk and establishing his teachings of Kriya Yoga meditation."+
                        "Autobiography of a Yogi introduces the reader to the life of Paramahansa Yogananda and his encounters with spiritual" +
                        " figures of both the Eastern and the Western world." +
                        " The book begins with his childhood family life, to " +
                        "finding his guru, to becoming a monk and establishing his teachings of Kriya Yoga meditation."+"Autobiography of a Yogi introduces the reader to the life of Paramahansa Yogananda and his encounters with spiritual" +
                        " figures of both the Eastern and the Western world." +
                        " The book begins with his childhood family life, to " +
                        "finding his guru, to becoming a monk and establishing his teachings of Kriya Yoga meditation."));

        books.add(new Book(4, "Many Lives, Many Masters", "Brian Weiss",
                "https://images-na.ssl-images-amazon.com/images/I/51bLoCPouFL._SX308_BO1,204,203,200_.jpg",
                150, "Many Lives, Many Masters is the true story of a prominent psychiatrist, his young patient, " +
                "and the past-life therapy that changed both their lives. Dr. Brian L. " +
                "Weiss was a scientist and psychotherapist, molded by years of disciplined study into a conservative professional.",
                "Many Lives, Many Masters is the true story of a prominent psychiatrist, his young patient, " +
                        "and the past-life therapy that changed both their lives. Dr. Brian L. " +
                        "Weiss was a scientist and psychotherapist, molded by years of disciplined study into a conservative professional."+
                        "Many Lives, Many Masters is the true story of a prominent psychiatrist, his young patient, " +
                        "and the past-life therapy that changed both their lives. Dr. Brian L. " +
                        "Weiss was a scientist and psychotherapist, molded by years of disciplined study into a conservative professional."));

        books.add(new Book(5, "Let Us C", "Yashvant Kanetkar",
                "https://images-na.ssl-images-amazon.com/images/I/61X3fZAD6OL.jpg",
                109, "Let us c by Yashwant Kanetkar is nice book. If you think about learning c then this book is best option for you. Because this book basically written for beginners. Language of this book is very simple and everybody can understand easily.",
                "Let us c by Yashwant Kanetkar is nice book. If you think about learning c then this book is best option for you. Because this book basically written for beginners. Language of this book is very simple and everybody can understand easily."+
                "Let us c by Yashwant Kanetkar is nice book. If you think about learning c then this book is best option for you. Because this book basically written for beginners. Language of this book is very simple and everybody can understand easily."+
                "Let us c by Yashwant Kanetkar is nice book. If you think about learning c then this book is best option for you. Because this book basically written for beginners. Language of this book is very simple and everybody " +
                        "can understand easily."));

        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        editor.putString(All_Books_key, gson.toJson(books));
        editor.commit();
    }


    public static synchronized Utils getInstance(Context context) {
        if (Instance == null) {
            Instance = new Utils(context);
        }
        return  Instance;
    }


    public  ArrayList<Book> getAlreadyRead() {
        Gson gson= new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(Already_Read_Books_key, null), type);
        return books;
    }

    public  ArrayList<Book> getCurrentlyReading() {
        Gson gson= new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(Continue_Reading_key, null), type);
        return books;
    }

    public  ArrayList<Book> getWishListBooks() {
        Gson gson= new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WishList_key, null), type);
        return books;
    }

    public  ArrayList<Book> getFavouriteBooks() {
        Gson gson= new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(Favourite_books_key, null), type);
        return books;
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();

        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(All_Books_key, null), type);

        return books;
    }

    public boolean AddToAlreadyRead(Book book){
//        return AlreadyRead.add(book);
        ArrayList<Book> books = getAlreadyRead();
        if(books != null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.remove(Already_Read_Books_key);
                editor.putString(Already_Read_Books_key, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean AddToWishList(Book book){
//        return WishListBooks.add(book);
        ArrayList<Book> books = getWishListBooks();
        if(books != null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.remove(WishList_key);
                editor.putString(WishList_key, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToFavourites(Book book){
//        return FavouriteBooks.add(book);
        ArrayList<Book> books = getFavouriteBooks();
        if(books != null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.remove(Favourite_books_key);
                editor.putString(Favourite_books_key, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;

    }

    public boolean addToCurrentlyReading(Book book){
//        return CurrentlyReading.add(book);
        ArrayList<Book> books = getCurrentlyReading();
        if(books != null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.remove(Continue_Reading_key);
                editor.putString(Continue_Reading_key, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;

    }

    public boolean deleteFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyRead();
        if(books != null){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(Already_Read_Books_key);
                        editor.putString(Already_Read_Books_key, gson.toJson(books));

                        editor.commit();
                        return true;
                    }
                }
            }
        }

       return false;
    }
    public boolean deleteFromWishList(Book book){
//        return WishListBooks.remove(book);
        ArrayList<Book> books = getWishListBooks();
        if(books != null){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WishList_key);
                        editor.putString(WishList_key, gson.toJson(books));

                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean deleteFromFavourites(Book book){
//        return FavouriteBooks.remove(book);
        ArrayList<Book> books = getFavouriteBooks();
        if(books != null){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(Favourite_books_key);
                        editor.putString(Favourite_books_key, gson.toJson(books));

                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean deleteFromCurrentlyReading(Book book){
//        return CurrentlyReading.remove(book);
        ArrayList<Book> books = getCurrentlyReading();
        if(books != null){
            for (Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(Continue_Reading_key);
                        editor.putString(Continue_Reading_key, gson.toJson(books));

                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;

    }
}
