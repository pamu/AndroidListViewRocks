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
public class SuperFastAdapter<T> extends ArrayAdapter<T> {
    private Context mContext;
    private int resource;
    private T[] objects;

    public SuperFastAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rootView = inflater.inflate(resource, null);

            ViewHolder holder = new ViewHolder();

            holder.nameTextView = (TextView) rootView.findViewById(R.id.name);
            holder.descTextView = (TextView) rootView.findViewById(R.id.desc);

            convertView = rootView;
            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.nameTextView.setText(objects[position].toString());
        holder.descTextView.setText(objects[position].toString());

        return convertView;
    }

    public static class ViewHolder {
        TextView nameTextView;
        TextView descTextView;
    }
}
