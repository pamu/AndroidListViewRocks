package com.pamulabs.androidlistviewrocks;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SimpleListViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private final String LOG_TAG = PlaceholderFragment.class.getSimpleName();

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_simple_list_view, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.simple_list_view);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("Scala");
            arrayList.add("Java");
            arrayList.add("Android");
            arrayList.add("C");
            arrayList.add("CPP");
            arrayList.add("C#");
            arrayList.add("Swift");
            arrayList.add("Objective C");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.listview_item, R.id.text_view, arrayList);
            listView.setAdapter(adapter);

            Intent intent = getActivity().getIntent();
            if (intent != null && intent.hasExtra(MainActivity.PlaceholderFragment.ITEM_NUMBER)) {
                int itemNumber = (int) intent.getExtras().get(MainActivity.PlaceholderFragment.ITEM_NUMBER);
                Log.d(LOG_TAG, "Item Number: " + itemNumber);
            }
            return rootView;
        }
    }
}
