package com.example.mac.thegameawards;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Mac on 22/11/2016.
 */

public class AdaptadorLista extends CursorAdapter {

    public AdaptadorLista(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.listitem_gameawards, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tvYear = (TextView) view.findViewById(R.id.lblYear);
        String year = cursor.getString(cursor.getColumnIndexOrThrow("year"));
        tvYear.setText(year);
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }
}
