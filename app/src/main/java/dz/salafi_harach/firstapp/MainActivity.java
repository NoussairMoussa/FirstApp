package dz.salafi_harach.firstapp;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

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

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    @Override
    protected void onStart() {
        super.onStart();
        //create the dataBase
        DataBaseHelper myDb = new DataBaseHelper(getBaseContext());

        TextView db_content = (TextView) findViewById(R.id.db_content);

        Cursor cursor = myDb.getAllQuran();
        String QuranFromDb = "";

        cursor.moveToFirst();

        if (cursor.getCount() > 0)
        {
            do {
                QuranFromDb += cursor.getString(0) + ": " + cursor.getString(1) + "\n";
            } while (cursor.moveToNext());
        }

        if(QuranFromDb == "")
            db_content.setText("You haven't enything" + "\n");
        else
            db_content.setText(QuranFromDb + "\n");

        cursor.close();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
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
        if(position == 0)
        {
            return_to_accueil();
            return;
        }

        TextView title = (TextView) findViewById(R.id.titre);
        title.setText(getString(R.string.titre) + " " + mPlanetTitles[position]);

        //ImageView i = (ImageView) findViewById(R.id.image_of_array_adapter);
        //i.setImageResource(android.R.drawable.star_on);

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        //mDrawerLayout.closeDrawer(mDrawerList);
    }

    private void return_to_accueil()
    {
        TextView title = (TextView) findViewById(R.id.titre);
        title.setText(" ");
        setTitle(R.string.app_name);
    }

    @Override
    public void setTitle(CharSequence title)
    {
        getSupportActionBar().setTitle(title);
    }
}


