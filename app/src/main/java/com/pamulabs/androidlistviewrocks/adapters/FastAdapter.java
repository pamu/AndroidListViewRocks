package com.pamulabs.androidlistviewrocks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pamulabs.androidlistviewrocks.R;

/**
 * Created by pnagarjuna on 26/04/15.
 */
public class FastAdapter<T> extends ArrayAdapter<T> {
    private Context mContext;
    private T[] objects;
    private LayoutInflater layoutInflater;
    private int resource;

    public FastAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.objects = objects;
        this.resource = resource;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nameTextView = null;
        TextView descTextView = null;
        View rootView = null;

        if (convertView != null) {
            rootView = convertView;
        } else {
            rootView = layoutInflater.inflate(resource, null);
        }

        nameTextView = (TextView) rootView.findViewById(R.id.name);
        descTextView = (TextView) rootView.findViewById(R.id.desc);
        nameTextView.setText(objects[position].toString());
        descTextView.setText(objects[position].toString());

        return rootView;
    }
}
