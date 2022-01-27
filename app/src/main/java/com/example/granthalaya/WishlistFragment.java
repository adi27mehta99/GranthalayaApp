package com.example.granthalaya;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WishlistFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wishlist, container, false);
    }

    Button show;

    public  void onViewCreated(View view, Bundle savedInstance)
    {
        super.onViewCreated(view,savedInstance);

        show = view.findViewById(R.id.show_wishlist);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open(this,JustTrialActivity.class);
               // Intent in = new Intent(getActivity(), JustTrialActivity.class);
                //startActivity(in);
            }

        });
    }

    @Override
    public void onClick(View v) {


    }
}
