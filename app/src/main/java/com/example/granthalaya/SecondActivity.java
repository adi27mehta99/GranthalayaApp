

package com.example.granthalaya;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.lang.annotation.Annotation;


public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private final Button issue_add = (Button)findViewById(R.id.issue_button_add);
    private DrawerLayout drawer;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseUser currentUser = firebaseAuth.getCurrentUser();

    //CollectionReference Booksref = db.collection("Books");
    CollectionReference Booksref = db.collection("IBooks");


    public IssuedBookActivity adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);


        setUpRecycleView();
        updateHeader();


        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(SecondActivity.this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setUpRecycleView() {
        Query query = Booksref.orderBy("return_date", Query.Direction.ASCENDING);


        FirestoreRecyclerOptions<IssuedBooks> options = new FirestoreRecyclerOptions.Builder<IssuedBooks>()
                .setQuery(query, IssuedBooks.class)
                .build();

        adapter = new IssuedBookActivity(options);


        RecyclerView recyclerView = findViewById(R.id.issued_book_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

//For deleting item through swipe by using deleteItem() method from FireStoreActivity


    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {


            case R.id.nav_notification:
                Intent noti = new Intent(SecondActivity.this, NotificationActivity.class);
                startActivity(noti);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).commit();
                Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_SHORT).show();
                break;
            /*case R.id.nav_category:
                break;*/
            case R.id.nav_wishlist:
                Intent in = new Intent(this, ViewWishListActiity.class);
                startActivity(in);


                Toast.makeText(getApplicationContext(), "Wishlist", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_search:
                Intent inn = new Intent(this, ViewSearchActivity.class);
                startActivity(inn);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                break;

            case R.id.favourite_books:
                Intent fav = new Intent(SecondActivity.this, ViewFavouriteActivity.class);
                startActivity(fav);
                break;
            case R.id.Logout_btn:
                firebaseAuth.signOut();
                Intent logout = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(logout);
                Toast.makeText(this, "LogOut Successful", Toast.LENGTH_SHORT).show();

                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateHeader() {
        NavigationView navigationview = findViewById(R.id.nav_view);
        View Headerview = navigationview.getHeaderView(0);

        /*
        Use this for getting anything from current User to Header
        TextView navName = Headerview.findViewById(R.id.nav_name);
         */
        //TextView navName = findViewById(R.id.nav_name);
        TextView navEmail = Headerview.findViewById(R.id.textView2);
        TextView navName = findViewById(R.id.nav_name);


        navEmail.setText(currentUser.getEmail());

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
}




