package com.pamulabs.androidlistviewrocks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pamulabs.androidlistviewrocks.R;

/**
 * Created by pnagarjuna on 25/04/15.
 */
public class SlowAdapter<T> extends ArrayAdapter<T> {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private T[] objects;
    private int resource;

    public SlowAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.objects = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = layoutInflater.inflate(resource, null);
        TextView nameTextView = (TextView) rootView.findViewById(R.id.name);
        TextView descTextView = (TextView) rootView.findViewById(R.id.desc);
        nameTextView.setText(objects[position].toString());
        descTextView.setText(objects[position].toString());
        return rootView;
    }
}
