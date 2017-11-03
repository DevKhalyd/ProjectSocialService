package com.khalyd.projectsocialservice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khalyd.projectsocialservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNews extends Fragment {


    public FragmentNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_news, container, false);

        return view;
    }

}
