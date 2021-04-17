package com.example.singbike.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singbike.Adapters.OptionsRecyclerViewAdapter;
import com.example.singbike.Fragments.AccountTab.ProfileFragment;
import com.example.singbike.R;

public class AccountFragment extends Fragment {

    private static final String D_EDIT = "EDIT_PROFILE";

    public AccountFragment () {
        super (R.layout.fragment_account);
    }

    @Override
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* edit profile button tap */
        final Button editBtn = view.findViewById (R.id.editButton_account);
        editBtn.setOnClickListener (
                new View.OnClickListener () {
                    @Override
                    public void onClick (View v) {
                        Log.d (D_EDIT, "button tapped!");

                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace (R.id.fragmentContainerView, ProfileFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack ("profile")
                                .commit();

                    }
                }
        );

        /* Container for other options, payment, setting etc ... */
        final RecyclerView optionsRV = view.findViewById (R.id.accountRecyclerView);
        final String[] options = getResources().getStringArray(R.array.account_options);

        // instantiate layoutmanager to attach a view to recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager (getActivity());
        optionsRV.setLayoutManager (layoutManager);

        OptionsRecyclerViewAdapter adapter = new OptionsRecyclerViewAdapter (options);
        optionsRV.setAdapter(adapter);

    }

}
