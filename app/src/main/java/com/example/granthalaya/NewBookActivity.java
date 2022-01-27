package com.example.granthalaya;

import android.os.Build;
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

public class NewBookActivity  extends AppCompatActivity {

    private EditText bookName;
    private EditText description;
    private NumberPicker numberPicker;

  //  @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.firestore_activity_layout);

        bookName = (EditText) findViewById(R.id.editText);
        description = (EditText) findViewById(R.id.description);
        numberPicker = (NumberPicker) findViewById(R.id.number_picker_priority);

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
   // @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void savenote()
    {
        String title = bookName.getText().toString();
        String author = description.getText().toString();
        int priority = numberPicker.getValue();

        if(title.trim().isEmpty() || author.trim().isEmpty())
        {
            Toast.makeText(this, "Please Insert Title and Description ", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference Booksref = FirebaseFirestore.getInstance()
                .collection("Books");

        Booksref.add(new Books(title,author,priority));
        Toast.makeText(this, title+"Note Added", Toast.LENGTH_SHORT).show();
        finish();


    }
}
