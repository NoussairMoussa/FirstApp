package dz.salafi_harach.firstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Dimension;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper myDb;
    private ActionBarDrawerToggle mDrawerToggle;
    private LinearLayout accueil;
    private String sort;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         String[] mPlanetTitles = getResources().getStringArray(R.array.array_adapter);
         DrawerLayout mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawer_layout);
         ListView mDrawerList= (ListView) findViewById(R.id.left_drawer);
        sort = "DESC";
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

    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ListView contentDB= (ListView) findViewById(R.id.contentBD);
        registerForContextMenu(contentDB);
        returnToAccueil(sort);

        ListView mDrawerList= (ListView) findViewById(R.id.left_drawer);
        String[] mPlanetTitles = getResources().getStringArray(R.array.array_adapter);
        mDrawerList.setAdapter(new My_addapter(this,
                R.layout.row, mPlanetTitles, 0));
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
        else if(item.getItemId() == R.id.sort)
        {
            returnToAccueil(sort);
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
            returnToAccueil(sort);
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

            accueil.removeAllViews();
            intro.setText("");
            registerForContextMenu(contentDB);
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
            accueil.removeAllViews();

            registerForContextMenu(contentDB);
        }
        else if(position == 3)
        {
            about();
            accueil.removeAllViews();
            //accueil.setAdapter(null);
            return;
        }

        myDb.close();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()==R.id.contentBD)
        {
            ListView ls = (ListView) v;
            Toast.makeText(this, String.valueOf(1), Toast.LENGTH_SHORT).show();
            menu.setHeaderTitle("ماذا تفعــل");
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.delete_sura:
                deleteSura();
                //item.getActionView();
                return true;
            case R.id.info_sura:
                info_sura();
                return true;
        }
        return false;
    }

    private void info_sura()
    {


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

    private void about()
    {
        TextView intro = (TextView) findViewById(R.id.intro);
        ListView contentDB= (ListView) findViewById(R.id.contentBD);

        contentDB.setAdapter(null);
        setTitle(R.string.app_name);
        intro.setText(R.string.intro_txt);

    }
    private void returnToAccueil(String sort)
    {
        if(sort.compareTo("ASC")==0)
            this.sort = "DESC";
        else
            this.sort = "ASC";
        accueil = (LinearLayout) findViewById(R.id.actualite_layout);
        accueil.removeAllViews();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int hight = (int) (size.y / displayMetrics.density);
        //Toast.makeText(this, String.valueOf(hight/100+1), Toast.LENGTH_LONG).show();

        myDb = new DataBaseHelper(this);
        ArrayList<Sura_mahfouda> lastMurajaa = myDb.getLastMurajaa(sort);
        Sura_mahfouda sura_mahfouda;

        for(int i = 0; i<lastMurajaa.size(); i++)
        {
            sura_mahfouda = lastMurajaa.get(i);

            LinearLayout row_of_accueil = new LinearLayout(this);
            row_of_accueil.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            row_of_accueil.setOrientation(LinearLayout.VERTICAL);
            row_of_accueil.setPadding(10, 40, 10, 20);
            row_of_accueil.setGravity(Gravity.CENTER);

            LinearLayout sub_row_of_accueil = new LinearLayout(this);
            sub_row_of_accueil.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            sub_row_of_accueil.setOrientation(LinearLayout.HORIZONTAL);
            sub_row_of_accueil.setGravity(Gravity.RIGHT);

            TextView date = new TextView(this);
            date.setTextAppearance(this, R.style.date_style);
            Locale locale = new Locale("ara", "DZ");
            SimpleDateFormat ft = new SimpleDateFormat("E  dd/MMM/y ", locale);
            date.setText(ft.format(sura_mahfouda.getDateOfInsert()));
            sub_row_of_accueil.addView(date);

            TextView sura_name_textView = new TextView(this);
            sura_name_textView.setTextAppearance(this, R.style.MyTextViewStyle);
            sura_name_textView.setText("ســــورة " + sura_mahfouda.getSura().getName());
            sura_name_textView.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
            sura_name_textView.setGravity(Gravity.CENTER);

            row_of_accueil.addView(sub_row_of_accueil);
            row_of_accueil.addView(sura_name_textView);

            TextView line = new TextView(this);
            line.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            line.setHeight(5);
            line.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            row_of_accueil.addView(line);

            accueil.addView(row_of_accueil);
        }

        TextView intro = (TextView) findViewById(R.id.intro);
        ListView contentDB= (ListView) findViewById(R.id.contentBD);

        contentDB.setAdapter(null);
        setTitle(R.string.app_name);
        intro.setText("المراجعــات");
        myDb.close();
    }
}




