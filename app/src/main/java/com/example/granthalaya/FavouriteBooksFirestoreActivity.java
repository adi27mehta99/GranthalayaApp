package com.example.granthalaya;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
class FavouriteBookFireStoreActivity extends FirestoreRecyclerAdapter<FavouriteBooks, FavouriteBookFireStoreActivity.NoteHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FavouriteBookFireStoreActivity(@NonNull FirestoreRecyclerOptions<FavouriteBooks> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull FavouriteBooks model) {

        holder.textviewTitle.setText(model.getTitle());
        holder.textviewDetails.setText(model.getDescription());
        holder.textViewPriority.setText(Integer.toString(model.getRating()));

    }

    @SuppressLint("SetTextI18n")
   // @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Books model) {
        holder.textviewTitle.setText(model.getTitle());
        holder.textviewDetails.setText(model.getDescription());
        holder.textViewPriority.setText(Integer.toString(model.getPriority()));
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_book_card_layout, parent, false);
        //View view = LayoutInflater.from(new SecondActivity().inflate(R.layout.issued_book_card, parent,false));

        return new NoteHolder(v);
    }

    public void deleteItem(int position)
    {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder
    {
        TextView textviewTitle;
        TextView textviewDetails;
        TextView textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textviewTitle = itemView.findViewById(R.id.fav_title);
            textviewDetails = itemView.findViewById(R.id.fav_book_card_desc);
            textViewPriority = itemView.findViewById(R.id.fire_fav_rating);

        }
    }

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options1

    public FavouriteBookFireStoreActivity(@NonNull FirestoreRecyclerOptions<FavouriteBooks> options1) {
        super(options1);
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_book_card_layout,
                parent, false);
        return new NoteHolder(v);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull FavouriteBooks model) {
        holder.favtitle.setText(model.getTitle());
        holder.favDescription.setText(model.getDescription());
//        holder.favrating.setText(model.getRating());
       // holder.favrating.setText(model.getRating());
    }

    public void deleteItem(int adapterPosition) {
        getSnapshots().getSnapshot(adapterPosition).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView favtitle;
        TextView favDescription;
        TextView favrating;
        public NoteHolder(View itemView) {
            super(itemView);
            favtitle = itemView.findViewById(R.id.fav_title);
            favDescription = itemView.findViewById(R.id.fav_book_card_desc);
            favrating = itemView.findViewById(R.id.fire_fav_rating);
        }
    }*/
}