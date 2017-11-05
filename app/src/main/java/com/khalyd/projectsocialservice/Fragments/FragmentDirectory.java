package com.khalyd.projectsocialservice.Fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.khalyd.projectsocialservice.Adapters.AdapterDirectory;
import com.khalyd.projectsocialservice.Class.CircleForm;
import com.khalyd.projectsocialservice.Model.Directory;
import com.khalyd.projectsocialservice.R;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDirectory extends Fragment {

    private List<Directory> drmine;
    private RecyclerView myRecyclerV;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLM;
    private static final  String firtsUrl = "http://oaxacadiaadia.com/wp-content/uploads/2016/04/Un-debate-propositivo-y-por-Oaxaca-Alejandro-Murat.jpg";
    private static final  String ramdonsUrl = "http://profile.actionsprout.com/default.jpeg";
    private static final  String ramdonsUrl2 = "https://resizing.flixster.com/1BjhtXLH47Ogqz36vS2Dk6zvSO4=/300x300/v1.bjsxMTc5MjU7ajsxNzUwNjsxMjAwOzY0ODs5Njg";

    private ImageView imgview;




    public FragmentDirectory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_directory, container, false);
        // Inflate the layout for this fragment


        customRecyclerView(view);

        return view;

    }

    private void customRecyclerView(View v){



        final String moreInfo = "Una breve descripcion o informacion sobre la persona";
        //May a ERROR
        drmine = this.myitems();
        myRecyclerV = v.findViewById(R.id.recycler_view);
        myLM  = new LinearLayoutManager(getActivity());
        imgview = v.findViewById(R.id.img_profile);

        myAdapter = new AdapterDirectory(drmine, R.layout.cardview_model, new AdapterDirectory.MyItemClickListener() {
            @Override
            public void Aclick(Directory directory, int position) {

                switch (position){

                    case  0:
                        setAlertDialog(directory,moreInfo);
                        break;
                    case  1:
                        setAlertDialog(directory,moreInfo);
                        break;
                    case  2:
                        setAlertDialog(directory,moreInfo);
                        break;
                    case  3:
                        setAlertDialog(directory,moreInfo);
                        break;

                    case  4:
                        setAlertDialog(directory,moreInfo);
                        break;


                }



            }
        });

        myRecyclerV.setHasFixedSize(true);
        myRecyclerV.setItemAnimator(new DefaultItemAnimator());
        myRecyclerV.setLayoutManager(myLM);
        myRecyclerV.setAdapter(myAdapter);





    }


    private void setAlertDialog(Directory dr, String moreinfo){

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle(dr.getName());//Model very important
        b.setMessage(moreinfo);
        b.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

            }
        });

        Dialog d = b.create();
        d.show();



    }

    private void setMyAdapterInto(View v){
        //Data, MOdel card view, my mehod

        //myAdapter = new Directory(drmine,R.layout.cardview_model,)


    }

    private List<Directory> myitems() {

        return new ArrayList<Directory>(){{

            add(new Directory("Alejandro Murat" ,"Presidente de Oaxaca" , firtsUrl));
            add(new Directory("Jorge" ,"Proximo presidente de Oaxaca" , ramdonsUrl));
            add(new Directory("Juan" ,"Proximo presidente de Oaxaca" , ramdonsUrl2));
            add(new Directory("Toño" ,"Proximo presidente de Oaxaca" , ramdonsUrl));
            add(new Directory("Arturo" ,"Proximo presidente de Oaxaca" , ramdonsUrl));

        }};

    }










   private void myListSimple(View v){

        String [] names = {"Arturo","Jorge","Jaime","Julio"};
        ArrayAdapter <String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,names);
       // ListView lv = v.findViewById(R.id.myList);
      //  lv.setAdapter(adapter);
      //  lv.setOnItemClickListener(this);

        //A simple list never used
    }

   /*

   implements AdapterView.OnItemClickListener //

   @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0){
            Toasty.warning(getActivity(),"El diseño quedaria mejor Con CardViews" , Toast.LENGTH_SHORT).show();
        }else{
        TextView tv = (TextView) view;
                Toasty.warning(getActivity(),"Tu nombre " + tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }*/

}
