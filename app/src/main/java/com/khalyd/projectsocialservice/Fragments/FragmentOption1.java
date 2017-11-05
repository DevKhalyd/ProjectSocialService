package com.khalyd.projectsocialservice.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.khalyd.projectsocialservice.Activities.LoginFBTW;
import com.khalyd.projectsocialservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOption1 extends Fragment {


    private LoginButton btnFb;

    public FragmentOption1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_option1, container, false);
        // Inflate the layout for this fragment
        AccessToken.getCurrentAccessToken(); //check

        btnFb = view.findViewById(R.id.logout);

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                LoginManager.getInstance().logOut();
                Intent i = new Intent(getActivity(), LoginFBTW.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);


            }
        });

        return view;



    }

}
