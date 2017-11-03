package com.khalyd.projectsocialservice.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.khalyd.projectsocialservice.R;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDirectory extends Fragment implements AdapterView.OnItemClickListener {


    public FragmentDirectory() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_directory, container, false);
        // Inflate the layout for this fragment

        myListSimple(view);

        return view;

    }


    private void myListSimple(View v){

        String [] names = {"Arturo","Jorge","Jaime","Julio"};

        ArrayAdapter <String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,names);

        ListView lv = v.findViewById(R.id.myList);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        if (position == 0){

            Toasty.warning(getActivity(),"El diseño quedaria mejor Con CardViews" , Toast.LENGTH_SHORT).show();
        }else{

        TextView tv = (TextView) view;
                Toasty.warning(getActivity(),"Tu nombre " + tv.getText(), Toast.LENGTH_SHORT).show();

        }

    }
}
