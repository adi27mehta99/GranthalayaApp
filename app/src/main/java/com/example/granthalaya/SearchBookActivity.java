package com.example.granthalaya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


class SearchBookActivity extends FirestoreRecyclerAdapter<SearchBooks, SearchBookActivity.NoteHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SearchBookActivity(@NonNull FirestoreRecyclerOptions<SearchBooks> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull SearchBooks model) {

        holder.textViewTitle.setText(model.getTitle());
        holder.textViewLocation.setText(model.getLocation());
        holder.textViewID.setText(model.getID());


        //holder.textViewPriority.setText(Integer.toString(model.getPriority()));
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_book_card, parent, false);
        //View view = LayoutInflater.from(new SecondActivity().inflate(R.layout.issued_book_card, parent,false));

        return new SearchBookActivity.NoteHolder(v);
    }






    class NoteHolder extends RecyclerView.ViewHolder
    {
        TextView textViewTitle;
        TextView textViewLocation;
        TextView textViewID;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.text_view_all_title);
            textViewLocation = itemView.findViewById(R.id.text_view_location);
            textViewID = itemView.findViewById(R.id.text_view_BookId);

        }
    }
}



