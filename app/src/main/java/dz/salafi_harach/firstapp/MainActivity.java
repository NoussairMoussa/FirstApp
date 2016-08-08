package dz.salafi_harach.firstapp;

import android.database.Cursor;
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

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    @Override
    protected void onStart() {
        super.onStart();
        //create the dataBase
        DataBaseHelper myDb = new DataBaseHelper(getBaseContext());

        //myDb.addMatn("الأربعين النووية");
        //myDb.addQuran("ال عمران", 1,  22);

        TextView db_content = (TextView) findViewById(R.id.db_content);
        TextView db_content2 = (TextView) findViewById(R.id.db_content2);

        Cursor cursor = myDb.getAllQuran();
        Cursor cursor2 = myDb.getAllMatn();
        String QuranFromDb = "";
        String MoutounFromDb = "";

        if(cursor == null || cursor2 == null)
            return;

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


