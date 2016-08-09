package dz.salafi_harach.firstapp;

import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Cursor Quran;
    private GridView gridview;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlanetTitles = getResources().getStringArray(R.array.array_adapter);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new My_addapter(this,
                R.layout.row, mPlanetTitles));

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close){

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle("title");
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle("title");
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

//-------------------------
    @Override
    protected void onStart()
    {
        super.onStart();
        //create the dataBase
        DataBaseHelper myDb = new DataBaseHelper(getBaseContext());

        //myDb.addMatn("الأربعين النووية");
        //myDb.addQuran("ال عمران", 1,  22);

        Quran = myDb.getAllQuran();
        String QuranFromDb = "";
        String MoutounFromDb = "";
/*
        cursor.moveToFirst();

        if (cursor.getCount() > 0)
        {
            do {
                QuranFromDb += cursor.getString(0) + ": " + cursor.getString(1) + " "
                        + cursor.getString(2) + "الى" + cursor.getString(3) + "\n";
            } while (cursor.moveToNext());
        }

        cursor2.moveToFirst();

        if (cursor2.getCount() > 0)
        {
            do {
                MoutounFromDb += cursor2.getString(0) + ": " + cursor2.getString(1) + "\n";
            } while (cursor2.moveToNext());
        }

        if(QuranFromDb == "")
            db_content.setText(getString(R.string.empty_db) + "\n");
        else
            db_content.setText(QuranFromDb + "\n");

        if(MoutounFromDb == "")
            db_content2.setText(R.string.empty_db + "\n");

        else
            db_content2.setText(MoutounFromDb + "\n");

        cursor.close();
        cursor2.close();
        */
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id)
        {
            selectItem(position);
        }
    }

    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position)
    {
        TextView title = (TextView) findViewById(R.id.titre);
        title.setText(getString(R.string.titre) + " " + mPlanetTitles[position]);
        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
        ArrayList<String> listQuran = new ArrayList<String>();

        if(position == 0)
        {
            return_to_accueil();
            return;
        }
        else if(position == 1)
        {
            Quran.moveToFirst();

            if (Quran.getCount() > 0)
            {
                do {
                    String QuranFromDb = Quran.getString(0) + ": " + Quran.getString(1) + " "
                            + Quran.getString(2) + " الى " + Quran.getString(3) + "\n";
                    listQuran.add(QuranFromDb);
                } while (Quran.moveToNext());
            }
            listView = (ListView) findViewById(R.id.contentBD);
            listView.setAdapter(
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listQuran)
            );
            gridview.setAdapter(null);
        }
        else if(position == 2)
        {
            listQuran.add("حفظ المتون خاصية ستضاف لاحقا");
            listView.setAdapter(
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listQuran)
            );
            gridview.setAdapter(null);
        }
    }

    private void return_to_accueil()
    {
        TextView title = (TextView) findViewById(R.id.titre);
        title.setText(" ");
        gridview.setAdapter(new ImageAdapter(this));
        listView.setAdapter(null);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public void setTitle(CharSequence title)
    {
        getSupportActionBar().setTitle(title);
    }
}


