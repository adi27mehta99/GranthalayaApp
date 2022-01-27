package com.example.granthalaya;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewFavouriteBookActivity  extends AppCompatActivity {

    private EditText bookName;
    private EditText description;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.new_favourite_book_layout);

        bookName =  findViewById(R.id.fav_et);
        description =  findViewById(R.id.fav_de);
         numberPicker =  findViewById(R.id.np_rating);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_book_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.save_note:
                savenote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void savenote()
    {
        String title = bookName.getText().toString();
        String author = description.getText().toString();
        int rating = numberPicker.getValue();

        if(title.trim().isEmpty() || author.trim().isEmpty())
        {
            Toast.makeText(this, "Please Insert Title and Description ", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference Booksref = FirebaseFirestore.getInstance()
                .collection("Favourite Books");

        Booksref.add(new FavouriteBooks(title,author,rating));
        Toast.makeText(this, title+"Note Added", Toast.LENGTH_SHORT).show();
        finish();


    }

   /* private EditText bookName;
    private EditText description;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.new_favourite_book_layout);

        bookName = findViewById(R.id.fav_et);
        description = findViewById(R.id.fav_de);
        numberPicker = findViewById(R.id.np_rating);

      numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_book_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.save_note:
                savenote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void savenote()
    {
        String title = bookName.getText().toString();
        String desc = description.getText().toString();
//        int rating = numberPicker.getValue();

        if(title.trim().isEmpty() || desc.trim().isEmpty())
        {
            Toast.makeText(this, "Please Insert Title and Description ", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference Booksref = FirebaseFirestore.getInstance()
                .collection("Favourite Books");

        Booksref.add(new FavouriteBooks(title,desc));
        Toast.makeText(this, title+"Note Added", Toast.LENGTH_SHORT).show();
        finish();


    }*/
}
