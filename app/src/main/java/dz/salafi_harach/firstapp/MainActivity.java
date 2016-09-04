package dz.salafi_harach.firstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
                R.layout.row, mPlanetTitles, 0));

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

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ListView contentDB= (ListView) findViewById(R.id.contentBD);
        registerForContextMenu(contentDB);
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
            Intent add_quran_activity = new Intent(this, Activity_add_quran.class);
            startActivity(add_quran_activity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//-------------------------
    @Override
    protected void onStart()
    {
        super.onStart();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id)
        {
            selectItem(position);
            ListView mDrawerList= (ListView) findViewById(R.id.left_drawer);
            String[] mPlanetTitles = getResources().getStringArray(R.array.array_adapter);
            // Set the adapter for the list view
            mDrawerList.setAdapter(new My_addapter(getBaseContext(),
                    R.layout.row, mPlanetTitles, position));
        }
    }

    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position)
    {
        myDb = new DataBaseHelper(getBaseContext());

        ArrayList<Sura_mahfouda> listQuran;

        TextView intro = (TextView) findViewById(R.id.intro);
        final ListView contentDB= (ListView) findViewById(R.id.contentBD);

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
            //الرئيسية
            return;
        }
        else if(position == 1)
        {
            listQuran = myDb.getAllQuran();

            for(Sura_mahfouda temp : listQuran)
            {
                listQuranForAdapter.add(temp.toString());
            }

            contentDB.setAdapter(
                    new Adapter_list_sura(this, R.layout.row_of_quran_list, listQuranForAdapter, listQuran)
            );

            intro.setText("");
        }
        else if(position == 2)
        {
            listQuran = myDb.getAllSuraMahfouda();

            if(listQuran.isEmpty())
                Toast.makeText(this, "لم يتــم إضـــافة أي ســـورة", Toast.LENGTH_LONG).show();

            for(Sura_mahfouda temp : listQuran)
            {
                String suraRow = temp.toString();
                listQuranForAdapter.add(suraRow);
            }

            contentDB.setAdapter(
                    new Adapter_list_sura(this, R.layout.row_of_quran_list, listQuranForAdapter, listQuran)
            );

            intro.setText("");
        }
        else if(position == 3)
        {
            about();
            return;
        }

        contentDB.setOnScrollListener(new AbsListView.OnScrollListener()
        {
            int mLastFirstVisibleItem = 0;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i)
            {
                //Toast.makeText(getBaseContext(),"ana houna", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onScroll(AbsListView view, int i, int i1, int i2)
            {
                if (view.getId() == contentDB.getId()) {
                    final int currentFirstVisibleItem = contentDB.getFirstVisiblePosition();

                    if (currentFirstVisibleItem > mLastFirstVisibleItem) {
                        // getSherlockActivity().getSupportActionBar().hide();
                        getSupportActionBar().hide();
                    } else if (currentFirstVisibleItem < mLastFirstVisibleItem) {
                        // getSherlockActivity().getSupportActionBar().show();
                        getSupportActionBar().show();
                    }

                    mLastFirstVisibleItem = currentFirstVisibleItem;
                }
            }
        });
        myDb.close();
    }

    private void about()
    {
        TextView intro = (TextView) findViewById(R.id.intro);
        ListView contentDB= (ListView) findViewById(R.id.contentBD);

        contentDB.setAdapter(null);
        setTitle(R.string.app_name);
        intro.setText(R.string.intro_txt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.delete_sura:
                deleteSura();
                return true;
        }
        return true;
    }

    private void deleteSura()
    {
        Toast.makeText(this, "delete!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTitle(CharSequence title)
    {
        getSupportActionBar().setTitle(title);
    }

}
