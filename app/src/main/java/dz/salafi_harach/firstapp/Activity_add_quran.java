package dz.salafi_harach.firstapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_add_quran extends AppCompatActivity implements My_Dialog.My_DialogListener{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public Activity_add_quran() {}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quran2);

        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //TextView numberPicker = (TextView) findViewById(R.id.numberPicker);
        //numberPicker.setText("33");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //-------------------------
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        // Add 2 tabs, specifying the tab's text and TabListener
        for (int i = 0; i < 2; i++)
        {
            if(i==0)
                actionBar.addTab(actionBar.newTab().setText("إضافــة بالسور").setTabListener(tabListener));
            else
                actionBar.addTab(actionBar.newTab().setText("إضافــة بالأجزاء").setTabListener(tabListener));
        }

        //--------------------------

        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        actionBar.setSelectedNavigationItem(position);
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.menu_activity_add_quran, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemId = item.getItemId();
        switch (itemId)
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private int nbrOfAyat;
        private String nbrOfAthman;
        private String nbrOfPages;
        private String nbrOfArbaa;

        public PlaceholderFragment() {}

        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();

            int r;
            if(sectionNumber == 0)
            {
                r = R.layout.add_by_sura;
            }
            else
            {
                r = R.layout.add_by_juz;
            }

            args.putInt("suraOrJuz", r);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            Bundle args = getArguments();
            int r = args.getInt("suraOrJuz");

            final View rootView = inflater.inflate(r, container, false);

            if(r == R.layout.add_by_sura)
            {
                String[] list_surahs = getResources().getStringArray(R.array.list_of_surahs);

                Spinner spinner = (Spinner) rootView.findViewById(R.id.quran_list_spinner);

                ArrayAdapter<CharSequence> adapter =
                        new ArrayAdapter<CharSequence>(rootView.getContext(), android.R.layout.simple_spinner_item, list_surahs);

                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                    {
                        DataBaseHelper myDb = new DataBaseHelper(rootView.getContext());
                        nbrOfAyat = myDb.getNumberOfAya(position + 1);

                        nbrOfArbaa = myDb.getElement(position +1, DataBaseHelper.NBRARBAA);
                        if(Float.parseFloat(nbrOfArbaa) != 0)
                        {
                            rootView.findViewById(R.id.by_nbrOfArbaa).setEnabled(true);
                            rootView.findViewById(R.id.by_nbrOfArbaa).setClickable(true);
                        }
                        else
                        {
                            rootView.findViewById(R.id.by_nbrOfArbaa).setEnabled(false);
                            rootView.findViewById(R.id.by_nbrOfArbaa).setClickable(false);
                        }

                        nbrOfAthman = myDb.getElement(position +1, DataBaseHelper.NBRATHMAN);
                        if(Float.parseFloat(nbrOfAthman) != 0)
                        {
                            rootView.findViewById(R.id.by_nbrOfAthman).setEnabled(true);
                            rootView.findViewById(R.id.by_nbrOfAthman).setClickable(true);
                        }
                        else
                        {
                            rootView.findViewById(R.id.by_nbrOfAthman).setEnabled(false);
                            rootView.findViewById(R.id.by_nbrOfAthman).setClickable(false);
                        }

                        nbrOfPages = myDb.getElement(position +1, DataBaseHelper.NBROFPAGES);
                        if(Float.parseFloat(nbrOfPages) != 0)
                        {
                            rootView.findViewById(R.id.by_nbrOfPages).setEnabled(true);
                            rootView.findViewById(R.id.by_nbrOfPages).setClickable(true);
                        }
                        else
                        {
                            rootView.findViewById(R.id.by_nbrOfPages).setEnabled(false);
                            rootView.findViewById(R.id.by_nbrOfPages).setClickable(false);
                        }

                        Bundle bundle = new Bundle();
                        bundle.putString(DataBaseHelper.NBRARBAA, nbrOfArbaa);
                        bundle.putString(DataBaseHelper.NBRATHMAN, nbrOfAthman);
                        bundle.putString(DataBaseHelper.NBROFPAGES, nbrOfPages);
                        bundle.putString(DataBaseHelper.NBROFAYAT, String.valueOf(nbrOfAyat));

                        Intent i = new Intent();
                        i.putExtras(bundle);
                        getActivity().setIntent(i);

                        myDb.close();
                        SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.seek_bar);
                        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                        {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
                            {
                                TextView poucentage = (TextView) rootView.findViewById(R.id.pourcentage_of_actvt_add);
                                poucentage.setText(String.valueOf(i)+"%");
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar)
                            {

                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar)
                            {

                            }
                        });
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView){}
                });
            }
            else
            {
                final GridView juz_gridView = (GridView) rootView.findViewById(R.id.juz_gridView);
                Adapter_for_grid_view adapter_for_grid_view = new Adapter_for_grid_view(rootView.getContext());
                juz_gridView.setAdapter(adapter_for_grid_view);
                juz_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
                    {
                        String item = (String) juz_gridView.getItemAtPosition(position);
                        TextView v = (TextView) view;
                        if(v.getTag().toString().equals("select") && item.equals(v.getText()))
                        {
                            view.setBackground(rootView.getResources().getDrawable(R.drawable.shape2));
                            view.setTag("none");
                            //Toast.makeText(rootView.getContext(), "if", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            view.setBackground(rootView.getResources().getDrawable(R.drawable.shape));
                            view.setTag("select");
                            //Toast.makeText(rootView.getContext(), "else", Toast.LENGTH_SHORT).show();
                        }
/*
                        view.setBackground(rootView.getResources().getDrawable(R.drawable.shape));
                        Toast.makeText(rootView.getContext(), "pos: " + position + " id: " + l, Toast.LENGTH_SHORT).show();
*/
                    }
                });
            }
            //--------------------
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount()
        {
            return 2;
        }
    }

    //the function of dialog listner

    @Override
    public void onDialogPositiveClick(DialogFragment dialog)
    {
        switch (dialog.getTag()) {
            case "all_sura":
                if (add_quran("", 0, 0)) {
                    RadioButton all_btn = (RadioButton) findViewById(R.id.all_btn);
                    all_btn.setChecked(false);
                }
                break;
            case "add_by_aya_enabled": {
                NumberPicker numberPicker1 = (NumberPicker) dialog.getDialog().findViewById(R.id.numberPicker1);
                int i = numberPicker1.getValue();
                NumberPicker numberPicker2 = (NumberPicker) dialog.getDialog().findViewById(R.id.numberPicker2);
                int j = numberPicker2.getValue();

                if (add_quran(DataBaseHelper.AYADEB, i, j)) {
                    RadioButton ayat = (RadioButton) findViewById(R.id.by_ayat);
                    ayat.setChecked(false);
                }
                break;
            }
            case "add_by_page_enabled": {
                NumberPicker numberPicker = (NumberPicker) dialog.getDialog().findViewById(R.id.numberPicker);
                int i = numberPicker.getValue();

                if (add_quran(DataBaseHelper.NBRPAGE_M, i, 0)) {
                    RadioButton nbrOfPages = (RadioButton) findViewById(R.id.by_nbrOfPages);
                    nbrOfPages.setChecked(false);

                }
                break;
            }
            case "add_by_athman_enabled": {
                NumberPicker numberPicker = (NumberPicker) dialog.getDialog().findViewById(R.id.numberPicker);
                int i = numberPicker.getValue();

                if (add_quran(DataBaseHelper.NBRATHMAN_M, i, 0)) {
                    RadioButton nbrOfAthman = (RadioButton) findViewById(R.id.by_nbrOfAthman);
                    nbrOfAthman.setChecked(false);
                }
                break;
            }
            case "add_by_arbaa_enabled": {
                NumberPicker numberPicker = (NumberPicker) dialog.getDialog().findViewById(R.id.numberPicker);
                int i = numberPicker.getValue();

                if (add_quran(DataBaseHelper.NBRARBAA_M, i, 0)) {
                    RadioButton arbaa = (RadioButton) findViewById(R.id.by_nbrOfArbaa);
                    arbaa.setChecked(false);
                }
                break;
            }
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog)
    {
        RadioButton all_btn = (RadioButton) findViewById(R.id.all_btn);
        all_btn.setChecked(false);
        RadioButton ayat = (RadioButton) findViewById(R.id.by_ayat);
        ayat.setChecked(false);
        RadioButton arbaa = (RadioButton) findViewById(R.id.by_nbrOfArbaa);
        arbaa.setChecked(false);
        RadioButton nbrOfPages = (RadioButton) findViewById(R.id.by_nbrOfPages);
        nbrOfPages.setChecked(false);
        RadioButton nbrOfAthman = (RadioButton) findViewById(R.id.by_nbrOfAthman);
        nbrOfAthman.setChecked(false);
    }

    //-----------------------------------------------------------------
    // the functions of our activity
    public void all_sura(View v)
    {
        My_Dialog m = new My_Dialog();
        m.setParameter("إضافة كامل السورة", 0, 0, 0);
        m.show(getSupportFragmentManager(), "all_sura");
    }

    public void add_by_ayas_enabled(View view)
    {
        My_Dialog m = new My_Dialog();

        Bundle bundle = getIntent().getExtras();
        int nbrOfAyat = Integer.parseInt((String) bundle.get(DataBaseHelper.NBROFAYAT));

        m.setParameter(" إضافة بالأيات", R.layout.dialog_for_add_by_ayat, 1, nbrOfAyat);
        m.show(getSupportFragmentManager(), "add_by_aya_enabled");
    }

    public void add_by_arbaa_enabled(View view)
    {
        My_Dialog m = new My_Dialog();

        Bundle bundle = getIntent().getExtras();
        float arbaa = Float.parseFloat((String) bundle.get(DataBaseHelper.NBRARBAA));

        m.setParameter(" إضافة بالأرباع", R.layout.dialog,(int) arbaa, 0);
        m.show(getSupportFragmentManager(), "add_by_arbaa_enabled");
    }

    public void add_by_athman_enabled(View view)
    {
        My_Dialog m = new My_Dialog();

        Bundle bundle = getIntent().getExtras();
        float athman = Float.parseFloat((String) bundle.get(DataBaseHelper.NBRATHMAN));

        m.setParameter(" إضافة بالأثمان", R.layout.dialog, (int) athman, 0);
        m.show(getSupportFragmentManager(), "add_by_athman_enabled");
    }

    public void add_by_page_enabled(View view)
    {
        My_Dialog m = new My_Dialog();

        Bundle bundle = getIntent().getExtras();
        float pages = Float.parseFloat((String) bundle.get(DataBaseHelper.NBROFPAGES));

        m.setParameter(" إضافة بعدد الصفحات", R.layout.dialog, (int) pages, 0);
        m.show(getSupportFragmentManager(), "add_by_page_enabled");
    }

    //---
    public boolean add_quran(String type, int val, int val2)
    {
        Spinner spinner = (Spinner) findViewById(R.id.quran_list_spinner);
        long sura_selected = spinner.getSelectedItemId() + 1;

        DataBaseHelper myDb = new DataBaseHelper(this);

        int aya_deb = 0;
        int aya_fin = 0;
        int numOfArbaa = 0;
        int numOfAthman = 0;
        int numOfPages = 0;

        if(type == DataBaseHelper.NBRARBAA_M)
            numOfArbaa = val;
        else if(type == DataBaseHelper.NBRATHMAN_M)
            numOfAthman = val;
        else if(type == DataBaseHelper.NBRPAGE_M)
            numOfPages = val;
        else if(type == DataBaseHelper.AYADEB)
        {
            aya_deb = val;
            aya_fin = val2;
        }

        int rowUpdate = myDb.addQuran((int) sura_selected, numOfPages, aya_deb, aya_fin, numOfArbaa, numOfAthman);

        Toast.makeText(this, "تمت الإضافة بنجاح", Toast.LENGTH_LONG).show();
        return true;
    }

    public void add_by_juz(View view)
    {
        GridView gridView = (GridView) findViewById(R.id.juz_gridView);
        int size = gridView.getChildCount();

        int pos;
        DataBaseHelper myDb = new DataBaseHelper(this);

        for(pos = 0; pos < size; pos++)
        {
            TextView textView = (TextView) gridView.getChildAt(pos);
            if(textView.getTag().equals("select"))
            {
                myDb.add_juz(pos+1);

            }
        }
        Toast.makeText(this, "تمت الأضافة " , Toast.LENGTH_SHORT).show();
        myDb.close();
        finish();
    }

    public void annuler_btn(View view)
    {
        finish();
    }
}
















