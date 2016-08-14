package dz.salafi_harach.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Add_quran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quran);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);

        String[] list_surahs = getResources().getStringArray(R.array.list_of_surahs);

        Spinner spinner = (Spinner) findViewById(R.id.quran_list_spinner);

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, list_surahs);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:

                finish();

                break;
        }
        return true;
    }

    public void add_by_ayas_disabled(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(false);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(false);
    }

    public void add_by_ayas_enabled(View view)
    {
        EditText aya_deb = (EditText) findViewById(R.id.deb_aya);
        aya_deb.setEnabled(true);

        EditText aya_fin = (EditText) findViewById(R.id.fin_aya);
        aya_fin.setEnabled(true);


        aya_deb.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});
        aya_fin.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});
    }
}
