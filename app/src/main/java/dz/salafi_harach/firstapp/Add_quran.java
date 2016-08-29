package dz.salafi_harach.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_quran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quran);

        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] list_surahs = getResources().getStringArray(R.array.list_of_surahs);

        Spinner spinner = (Spinner) findViewById(R.id.quran_list_spinner);

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, list_surahs);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                //Spinner spinner = (Spinner) findViewById(R.id.quran_list_spinner);
                //long suraSelected = spinner.getSelectedItemId();

                DataBaseHelper myDb = new DataBaseHelper(getBaseContext());
                int nbrOfAyat = myDb.getNumberOfAya(position + 1);

                EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
                EditText aya_fin = (EditText) findViewById(R.id.fin_aya);

                aya_deb.setFilters(new InputFilter[]{ new InputFilterMinMax("1", String.valueOf(nbrOfAyat))});
                aya_fin.setFilters(new InputFilter[]{ new InputFilterMinMax("1", String.valueOf(nbrOfAyat))});
                //Toast.makeText(getBaseContext(), String.valueOf(nbrOfAyat), Toast.LENGTH_LONG).show();
                myDb.close();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void all_sura(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(false);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(false);

        EditText arbaa_num = (EditText) findViewById(R.id.arbaa_num);
        arbaa_num.setEnabled(false);

        EditText athman_num = (EditText) findViewById(R.id.athman_num);
        athman_num.setEnabled(false);

        EditText page_num = (EditText) findViewById(R.id.page_num);
        page_num.setEnabled(false);

        Button hifd = (Button) findViewById(R.id.hifd_btn);
        hifd.setClickable(true);
        hifd.setEnabled(true);
    }

    public void add_by_ayas_enabled(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(true);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(true);

        EditText arbaa_num = (EditText) findViewById(R.id.arbaa_num);
        arbaa_num.setEnabled(false);

        EditText athman_num = (EditText) findViewById(R.id.athman_num);
        athman_num.setEnabled(false);

        EditText page_num = (EditText) findViewById(R.id.page_num);
        page_num.setEnabled(false);

        Button hifd = (Button) findViewById(R.id.hifd_btn);
        hifd.setClickable(true);
        hifd.setEnabled(true);
    }

    public void add_by_arbaa_enabled(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(false);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(false);

        EditText arbaa_num = (EditText) findViewById(R.id.arbaa_num);
        arbaa_num.setEnabled(true);

        EditText athman_num = (EditText) findViewById(R.id.athman_num);
        athman_num.setEnabled(false);

        EditText page_num = (EditText) findViewById(R.id.page_num);
        page_num.setEnabled(false);

        Button hifd = (Button) findViewById(R.id.hifd_btn);
        hifd.setClickable(true);
        hifd.setEnabled(true);
    }

    public void add_by_athman_enabled(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(false);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(false);

        EditText arbaa_num = (EditText) findViewById(R.id.arbaa_num);
        arbaa_num.setEnabled(false);

        EditText athman_num = (EditText) findViewById(R.id.athman_num);
        athman_num.setEnabled(true);

        EditText page_num = (EditText) findViewById(R.id.page_num);
        page_num.setEnabled(false);

        Button hifd = (Button) findViewById(R.id.hifd_btn);
        hifd.setClickable(true);
        hifd.setEnabled(true);
    }

    public void add_by_page_enabled(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(false);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(false);

        EditText arbaa_num = (EditText) findViewById(R.id.arbaa_num);
        arbaa_num.setEnabled(false);

        EditText athman_num = (EditText) findViewById(R.id.athman_num);
        athman_num.setEnabled(false);

        EditText page_num = (EditText) findViewById(R.id.page_num);
        page_num.setEnabled(true);

        Button hifd = (Button) findViewById(R.id.hifd_btn);
        hifd.setClickable(true);
        hifd.setEnabled(true);
    }

    public void add_quran(View view)
    {
        Spinner spinner = (Spinner) findViewById(R.id.quran_list_spinner);
        long sura_selected = spinner.getSelectedItemId() + 1;

        DataBaseHelper myDb = new DataBaseHelper(this);

        RadioButton arbaa = (RadioButton) findViewById(R.id.by_nbrOfArbaa);
        RadioButton ayat = (RadioButton) findViewById(R.id.by_ayat);
        RadioButton nbrOfPages = (RadioButton) findViewById(R.id.by_nbrOfPages);
        RadioButton nbrOfAthman = (RadioButton) findViewById(R.id.by_nbrOfAthman);

        int aya_deb = 0;
        int aya_fin = 0;
        int numOfArbaa = 0;
        int numOfAthman = 0;
        int numOfPages = 0;

        boolean all_sura = false;
        boolean by_pages = false;
        boolean by_arbaa = false;
        boolean by_athmane = false;

        if(ayat.isChecked())
        {
            EditText aya_deb_editText = (EditText) findViewById(R.id.deb_aya);
            EditText aya_fin_editText = (EditText) findViewById(R.id.fin_aya);

            if(!aya_deb_editText.getText().toString().equals("") && !aya_fin_editText.getText().toString().equals(""))
            {
                aya_deb = Integer.parseInt(aya_deb_editText.getText().toString());
                aya_fin = Integer.parseInt(aya_fin_editText.getText().toString());
            }
            else
            {
                aya_deb = 0;
                aya_fin = 0;
            }

            if((aya_deb == 0 ) || (aya_fin) == 0)
            {
                Toast.makeText(this, "Invalid number ", Toast.LENGTH_LONG).show();
                return;
            }

            if(aya_deb == 1)
            {
                int n = Integer.parseInt(myDb.getElement(sura_selected, DataBaseHelper.NBROFAYAT));

                if(n == aya_fin)
                {
                    Toast.makeText(this, "تمت إضافة السورة كاملة ", Toast.LENGTH_LONG).show();
                }
            }

            myDb.addQuran((int) sura_selected, 0, aya_deb, aya_fin, 0, 0);
        }
        else if(arbaa.isChecked())
        {
            EditText arbaa_editText = (EditText) findViewById(R.id.arbaa_num);

            if(!arbaa_editText.getText().toString().equals(""))
                numOfArbaa = Integer.parseInt(arbaa_editText.getText().toString());
            else
                numOfArbaa = 0;

            if(numOfArbaa == 0)
            {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_LONG).show();
                return;
            }

            /*
            int n = Integer.parseInt(myDb.getElement(sura_selected, DataBaseHelper.NBRARBAA));

            if(n == numOfArbaa)
            {
                Toast.makeText(this, "تمت إضافة السورة كاملة ", Toast.LENGTH_LONG).show();
            }
             */

            myDb.addQuran((int) sura_selected, 0, 0, 0, numOfArbaa, 0);
        }
        else if(nbrOfPages.isChecked())
        {
            EditText page_editText = (EditText) findViewById(R.id.page_num);

            if(!page_editText.getText().toString().equals(""))
                numOfPages = Integer.parseInt(page_editText.getText().toString());
            else
                numOfPages = 0;

            if(numOfPages == 0)
            {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_LONG).show();
                return;
            }

            /*
            int n = Integer.parseInt(myDb.getElement(sura_selected, DataBaseHelper.NBRARBAA));

            if(n == numOfArbaa)
            {
                Toast.makeText(this, "تمت إضافة السورة كاملة ", Toast.LENGTH_LONG).show();
            }
             */

            myDb.addQuran((int) sura_selected, numOfPages, 0, 0, 0, 0);
        }
        else if(nbrOfAthman.isChecked())
        {
            EditText athman_editText = (EditText) findViewById(R.id.athman_num);

            if(!athman_editText.getText().toString().equals(""))
                numOfAthman = Integer.parseInt(athman_editText.getText().toString());
            else
                numOfAthman = 0;

            if(numOfAthman == 0)
            {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_LONG).show();
                return;
            }

            /*
            int n = Integer.parseInt(myDb.getElement(sura_selected, DataBaseHelper.NBRARBAA));

            if(n == numOfArbaa)
            {
                Toast.makeText(this, "تمت إضافة السورة كاملة ", Toast.LENGTH_LONG).show();
            }
             */

            myDb.addQuran((int) sura_selected, 0, 0, 0, 0, numOfAthman);
        }
        else
            all_sura = true;

        if(all_sura)
        {
            int rowUpdate = myDb.addQuran((int) sura_selected, 0, 0, 0, 0, 0);
        }

        Toast.makeText(this, "تمت الإضافة بنجاح", Toast.LENGTH_LONG).show();
    }

    public void annuler_btn(View view)
    {
        finish();
    }
}












