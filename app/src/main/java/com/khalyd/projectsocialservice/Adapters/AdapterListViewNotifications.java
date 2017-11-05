package com.khalyd.projectsocialservice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.khalyd.projectsocialservice.Class.CircleForm;
import com.khalyd.projectsocialservice.Model.NotificationsModel;
import com.khalyd.projectsocialservice.R;

import java.util.List;


public class AdapterListViewNotifications extends BaseAdapter {

    private Context context;
    private List<NotificationsModel> notications;


    public AdapterListViewNotifications(Context context, List<NotificationsModel> notications) {
        this.context = context;
        this.notications = notications;

    }

    @Override
    public int getCount() {
        return notications.size();
    }

    @Override
    public Object getItem(int i) {
        //This is not need
        return null;
    }

    @Override
    public long getItemId(int i) {
        //This is not need
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //May an Error

        LayoutInflater i = LayoutInflater.from(context);
        //This should use ViewHolder pattern
        view = i.inflate(R.layout.model_item_listview,null);

        TextView txtTitle = view.findViewById(R.id.Title);
        TextView txtDescription = view.findViewById(R.id.description_list_view);
        ImageView img = view.findViewById(R.id.fb_tw);

        txtTitle.setText(notications.get(position).getTitle1().toString());
        txtDescription.setText(notications.get(position).getSubdescription());

        Glide.with(context).load(notications.get(position).getUrlImg())
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleForm(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);



        return view;
    }


    /*@Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }*/

}
