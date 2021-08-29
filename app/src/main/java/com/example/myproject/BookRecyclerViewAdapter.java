package com.example.myproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "BookRecyclerViewAdapter";

    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;

    private String parrentActivity;

    public BookRecyclerViewAdapter(Context mContext, String parrentActivity) {
        this.mContext = mContext;
        this.parrentActivity = parrentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called!");
        holder.txtName.setText(books.get(position).getName());

        Glide.with(mContext).asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imgBook);


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookSelectedActivity.class);
                intent.putExtra("Details", (Serializable)books.get(position));
                mContext.startActivity(intent);
            }
        });

        holder.AuthorName.setText(books.get(position).getAuthor());
        holder.txtShortDesc.setText(books.get(position).getShortDesc());

//        holder.downArrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TransitionManager.beginDelayedTransition(holder.parent);
//                books.get(position).setExpanded(true);
//                holder.ExpandedRelativeLayout.setVisibility(View.VISIBLE);
//                holder.downArrow.setVisibility(View.GONE);
//            }
//        });
//
//        holder.upArrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TransitionManager.beginDelayedTransition(holder.parent);
//                books.get(position).setExpanded(false);
//                holder.ExpandedRelativeLayout.setVisibility(View.GONE);
//                holder.downArrow.setVisibility(View.VISIBLE);
//            }
//        });

        if(books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.ExpandedRelativeLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);

            if(parrentActivity.equals("AllBooks")){
                holder.btnDelete.setVisibility(View.GONE);
            }
            else if(parrentActivity.equals("AlreadyReadBooks")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                String temp = books.get(position).getName();

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Sure, You want to delete ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if( Utils.getInstance(mContext).deleteFromAlreadyRead(books.get(position))) {
                                    Toast.makeText(mContext, temp +" Deleted!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();

                                }else Toast.makeText(mContext, "Try Again!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();
                    }
                });

            }
            else if(parrentActivity.equals("CurrentlyReading")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                String temp = books.get(position).getName();
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Sure, You want to delete ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if( Utils.getInstance(mContext).deleteFromCurrentlyReading(books.get(position))) {
                                    Toast.makeText(mContext, temp +" Deleted!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();

                                }else Toast.makeText(mContext, "Try Again!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();


                    }
                });

            }
            else if(parrentActivity.equals("FavouriteBooks")){

                holder.btnDelete.setVisibility(View.VISIBLE);
                String temp = books.get(position).getName();

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Sure, You want to delete ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if( Utils.getInstance(mContext).deleteFromFavourites(books.get(position))) {
                                    Toast.makeText(mContext, temp +" Deleted!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();

                                }else Toast.makeText(mContext, "Try Again!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();
                    }
                });



            }
            else if(parrentActivity.equals("WishList")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                String temp = books.get(position).getName();

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Sure, You want to delete ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if( Utils.getInstance(mContext).deleteFromWishList(books.get(position))) {
                                    Toast.makeText(mContext, temp +" Deleted!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();

                                }else Toast.makeText(mContext, "Try Again!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.create().show();
                    }
                });
            }
        }
        else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.ExpandedRelativeLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView parent;
        private ImageView imgBook, btnDelete;
        private TextView txtName;

        private ImageView downArrow, upArrow;
        private RelativeLayout ColapsedRelativeLayout, ExpandedRelativeLayout;
        private TextView txtShortDesc, AuthorName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtBookName);

            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            ColapsedRelativeLayout = itemView.findViewById(R.id.ColapsedRelativeLayout);
            ExpandedRelativeLayout = itemView.findViewById(R.id.ExpandedRelativeLayout);

            AuthorName = itemView.findViewById(R.id.AuthorName);
            txtShortDesc = itemView.findViewById(R.id.TxtShortDesc);
            btnDelete = itemView.findViewById(R.id.btnDeleteBook);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());

                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());

                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
