package com.pamulabs.androidlistviewrocks.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by pnagarjuna on 25/04/15.
 */
public class SlowAdapter<T> extends ArrayAdapter<T> {
    private Context mContext;

    public SlowAdapter(Context context, int resource) {
        super(context, resource);

    }
}
