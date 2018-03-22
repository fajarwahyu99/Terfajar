
/*
 * Copyright (c) by Fajar Nugraha Wahyu 3/22/18 10:32 AM 2018.
 * Very Original All rights reserved
 */

package com.example.infolabsolution.myfavoritemovie;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import static com.example.infolabsolution.myfavoritemovie.DataContract.FavoColumn.OVERVIEW;
import static com.example.infolabsolution.myfavoritemovie.DataContract.FavoColumn.POSTER;
import static com.example.infolabsolution.myfavoritemovie.DataContract.FavoColumn.MOVIE_TITLE;
import static com.example.infolabsolution.myfavoritemovie.DataContract.getColumnString;
import com.squareup.picasso.Picasso;




public class AdapterFavorite extends CursorAdapter {

    private Context textContex;

    public AdapterFavorite(Context context, Cursor cursor, boolean autoRequery) {
        super(context, cursor, autoRequery);
        this.textContex = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_content, parent, false);
        return view;
    }
    @Override
    public Cursor getCursor() {
        return super.getCursor();
    }

    @Override
    public void bindView(View itemView, Context context, Cursor cursor) {
        if (cursor != null){
            TextView teksTitle = (TextView)itemView.findViewById(R.id.nowplaying_title);
            TextView textDesk = (TextView)itemView.findViewById(R.id.nowplaying_desk);
            ImageView imgMovie = (ImageView)itemView.findViewById(R.id.nowplaying_image);
            Button shareButton = (Button)itemView.findViewById(R.id.btn_detail);
            teksTitle.setText(getColumnString(cursor,MOVIE_TITLE));
            textDesk.setText(getColumnString(cursor,OVERVIEW));
           Picasso.with(context).load(getColumnString(cursor,POSTER)).into(imgMovie);
        }
    }
}
