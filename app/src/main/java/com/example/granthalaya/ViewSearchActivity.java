package com.example.granthalaya;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ViewSearchActivity<NoteAdapter> extends AppCompatActivity {

    private static final String TAG = "ViewSearchActivity";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference Booksref = db.collection("All Books");

    //private String documentid = d



    public SearchBookActivity adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_card_layout);



        setUpRecycleView();
    }

    private void setUpRecycleView()
    {
        Query query = Booksref.orderBy("ID",Query.Direction.ASCENDING);

        final FirestoreRecyclerOptions<SearchBooks> options = new FirestoreRecyclerOptions.Builder<SearchBooks>()
                .setQuery(query, SearchBooks.class)
                .build();

        //adapter = new FirestoreActivity(options);
        adapter = new SearchBookActivity(options);



        RecyclerView recyclerView  = findViewById(R.id.all_recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //SearchView searchView = (SearchView)findViewById(R.id.search_all_books);
        EditText searchBox = findViewById(R.id.search_all_books);
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "SearchBox is Changed: "+s.toString());

                Query query;

                if(s.toString().isEmpty())
                {

                     query = Booksref.orderBy("ID",Query.Direction.ASCENDING);

                    FirestoreRecyclerOptions<SearchBooks> options = new FirestoreRecyclerOptions.Builder<SearchBooks>()
                            .setQuery(query, SearchBooks.class)
                            .build();

                    adapter.updateOptions(options);
                }
                else
                {
                     query = Booksref.orderBy("ID",Query.Direction.ASCENDING)
                            .whereEqualTo("title",s.toString());

                    FirestoreRecyclerOptions<SearchBooks> options = new FirestoreRecyclerOptions.Builder<SearchBooks>()
                            .setQuery(query, SearchBooks.class)
                            .build();

                    adapter.updateOptions(options);


                }

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchData(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    public void searchData(String s)
    {
        db.collection("All Books").whereEqualTo("search",s)
        .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot doc: task.getResult())
                {
                    //ColorSpace.Model model = new ColorSpace.Model(doc.getString("id"));
                }
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }*/
}
