package com.khalyd.projectsocialservice.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.khalyd.projectsocialservice.Activities.Resumed;
import com.khalyd.projectsocialservice.Adapters.AdapterListViewNotifications;
import com.khalyd.projectsocialservice.Model.NotificationsModel;
import com.khalyd.projectsocialservice.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFBTW extends Fragment {


    private ListView listView;
    private ArrayList<NotificationsModel> listModel;


    private static final  String fb = "https://stockmarketdaily.co/wp-content/uploads/2016/12/logo-facebook.png";
    private static final  String tw = "http://icons.iconarchive.com/icons/sicons/basic-round-social/512/twitter-icon.png";


    public FragmentFBTW() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__fb_tw, container, false);

        setListView(view);
        return view;
    }

    private void setListView(View v){

        listView = v.findViewById(R.id.list_custom);

        listModel = new ArrayList<>();

        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(fb,"Hay una nueva noticia","Gana las elecciones"));
        listModel.add(new NotificationsModel(tw,"Hay una nueva noticia","Gana las elecciones"));


        AdapterListViewNotifications ad = new AdapterListViewNotifications(getActivity(),listModel);


        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent i = new Intent(getActivity(), Resumed.class);
                startActivity(i);


            }
        });





    }

}
