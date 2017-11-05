package com.khalyd.projectsocialservice.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.khalyd.projectsocialservice.Class.CircleForm;
import com.khalyd.projectsocialservice.Model.Directory;
import com.khalyd.projectsocialservice.R;

//Sometimes the class R is missing so should be import for work

import java.util.List;



public class AdapterDirectory extends RecyclerView.Adapter<AdapterDirectory.ViewHolder>{

    //The class ViewHolder need be public

    private List<Directory> directoryList;
    private int layout;
    private MyItemClickListener Aclick;//interface (list Directory, int position)
    private Context context; //This is not a Fragment or Activity Context will be use

    public AdapterDirectory(List<Directory> directoryList, int layout, MyItemClickListener aclick) {
        this.directoryList = directoryList;
        this.layout = layout;
        this.Aclick = aclick;


    }

    //Main methods onCreateViewHolder,onBindViewHolder,getItemCount


    @Override
    public AdapterDirectory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);

        context = parent.getContext();
        //May Error


        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }



    @Override
    public void onBindViewHolder(AdapterDirectory.ViewHolder holder, int position) {

        holder.bind(directoryList.get(position),Aclick);

        //May A ERROR TODO

    }

    //Print
    @Override
    public int getItemCount() {

        //Ready to use

        return directoryList.size();
        //Get lenght
        //To print

    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        //View to use

        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgProfile;


        public ViewHolder(View itemView) {
            super(itemView);
            //super should be called firts
            txtName = itemView.findViewById(R.id.name_Person);
            txtDescription = itemView.findViewById(R.id.description_Person);
            imgProfile = itemView.findViewById(R.id.img_profile);
            //Initialize
            //find by id Views

        }

        private void bind (final Directory dr, final MyItemClickListener aclick){

            txtName.setText(dr.getName());
            txtDescription.setText(dr.getDescription());


            //Need a string = URL sooo...
            //load.put The string = URL
          Glide.with(context).load(dr.getImgProfile())
                    .crossFade()
                    .thumbnail(0.5f)
                    .bitmapTransform(new CircleForm(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfile);


            //Ready to use

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    aclick.Aclick(dr,getAdapterPosition());

                }
            });

        }

    }

    //Interface Dont need parameters
    public interface MyItemClickListener{
        void Aclick(Directory directory, int position);



    }



}
