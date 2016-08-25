package dz.salafi_harach.firstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper myDb;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         String[] mPlanetTitles = getResources().getStringArray(R.array.array_adapter);
         DrawerLayout mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawer_layout);
         ListView mDrawerList= (ListView) findViewById(R.id.left_drawer);


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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        // Handle your other action bar items...
        if(item.getItemId() == R.id.addQuran)
        {
            Intent intent = new Intent(this, Add_quran.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//-------------------------
    @Override
    protected void onStart()
    {
        super.onStart();
        myDb = new DataBaseHelper(this);
        return_to_accueil();
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
        myDb = new DataBaseHelper(getBaseContext());

        ArrayList<Sura_mahfouda> listQuran;

        TextView title  = (TextView) findViewById(R.id.titre);
        TextView intro = (TextView) findViewById(R.id.intro);
        ListView contentDB= (ListView) findViewById(R.id.contentBD);

        String[] mPlanetTitles  = getResources().getStringArray(R.array.array_adapter);
        DrawerLayout mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView mDrawerList= (ListView) findViewById(R.id.left_drawer);
        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);

        ArrayList<String> listQuranForAdapter = new ArrayList<>();

        if(position == 0)
        {
            return_to_accueil();
            return;
        }
        else if(position == 1)
        {
            listQuran = myDb.getAllQuran();


            for(Sura_mahfouda temp : listQuran)
            {
                listQuranForAdapter.add(temp.toString());
            }

            /*contentDB.setAdapter(
                    new ArrayAdapter<>(this, R.layout.row_of_quran_list, listQuranForAdapter)
            );*/
            contentDB.setAdapter(
                    new Adapter_list_sura(this, R.layout.row_of_quran_list, listQuranForAdapter, listQuran)
            );

            intro.setText("");
            title.setText(mPlanetTitles[position]);
        }
        else if(position == 2)
        {
            listQuran = myDb.getAllSuraMahfouda();
            for(Sura_mahfouda temp : listQuran)
            {
                String suraRow = temp.toString();
                listQuranForAdapter.add(suraRow);
            }

            contentDB.setAdapter(
                    new ArrayAdapter<>(this, R.layout.row_of_quran_list, listQuranForAdapter)
            );

            intro.setText("");
            title.setText(mPlanetTitles[position]);

            contentDB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                {
                    Toast.makeText(getBaseContext(), "Rani", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView)
                {
                    Toast.makeText(getBaseContext(), "Rani", Toast.LENGTH_LONG).show();
                }
            });
        }
        else if(position == 3)
        {
            return_to_accueil();
            return;
        }
        //Quran.close();
        myDb.close();
    }

    private void return_to_accueil()
    {
        TextView title  = (TextView) findViewById(R.id.titre);
        TextView intro = (TextView) findViewById(R.id.intro);
        ListView contentDB= (ListView) findViewById(R.id.contentBD);

        setTitle(R.string.app_name);
        title.setText(R.string.app_name);
        intro.setText(R.string.intro_txt);
        contentDB.setAdapter(null);
    }

    @Override
    public void setTitle(CharSequence title)
    {
        getSupportActionBar().setTitle(title);
    }

}
