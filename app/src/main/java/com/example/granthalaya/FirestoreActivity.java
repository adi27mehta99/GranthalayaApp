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


class FirestoreActivity extends FirestoreRecyclerAdapter <Books, FirestoreActivity.NoteHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirestoreActivity(@NonNull FirestoreRecyclerOptions<Books> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Books model) {
        holder.textviewTitle.setText(model.getTitle());
        holder.textviewDetails.setText(model.getDescription());
        holder.textViewPriority.setText(Integer.toString(model.getPriority()));
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_card, parent, false);
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

            textviewTitle = itemView.findViewById(R.id.text_view_title);
            textviewDetails = itemView.findViewById(R.id.text_view_details);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);

        }
    }
}

