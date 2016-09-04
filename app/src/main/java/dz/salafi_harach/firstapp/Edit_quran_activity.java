package dz.salafi_harach.firstapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Edit_quran_activity extends AppCompatActivity {

    private int sura_num;
    private String elm = "all";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_quran_activity);

        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("تعديــــل");

        sura_num = (int) getIntent().getExtras().get("sura_num");

        DataBaseHelper myDb = new DataBaseHelper(this);
        Sura_mahfouda suraMahfouda = myDb.getSura(sura_num);

        TextView title = (TextView) findViewById(R.id.sura_name);
        TextView label = (TextView) findViewById(R.id.label);
        title.setText(" ســورة " + String.valueOf(suraMahfouda.getSura().getName()));

        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.nbrOf);
        if(suraMahfouda.getAyaFin() != 0)
        {
            elm = DataBaseHelper.AYAFIN;
            label.setText("عدد الأيات");
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue(suraMahfouda.getSura().getNbrOfAyat());
            numberPicker.setValue(suraMahfouda.getAyaFin() - suraMahfouda.getAyaDeb() + 1);
        }
        else if(suraMahfouda.getNbrArbaa_m() != 0)
        {
            elm = DataBaseHelper.NBRARBAA_M;
            label.setText("عدد الأرباع");
            numberPicker.setMaxValue((int) suraMahfouda.getSura().getNbrOfArbaa());
            numberPicker.setMinValue(1);
            numberPicker.setValue((int) suraMahfouda.getNbrArbaa_m());
        }
        else if(suraMahfouda.getNbrAthman_m() != 0)
        {
            elm = DataBaseHelper.NBRATHMAN_M;
            label.setText("عدد الأثمان");
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue((int) suraMahfouda.getSura().getNbrOfAthman());
            numberPicker.setValue((int) suraMahfouda.getNbrAthman_m());
        }
        else if(suraMahfouda.getNbrPage_m() != 0)
        {
            elm = DataBaseHelper.NBRPAGE_M;
            label.setText("عدد الصفحات");
            numberPicker.setMaxValue((int) suraMahfouda.getSura().getNbrOfPages());
            numberPicker.setMinValue(1);
            numberPicker.setValue(suraMahfouda.getNbrPage_m());

        }
        else
        {
            numberPicker.setVisibility(View.GONE);
            label.setVisibility(View.GONE);
            TextView smallText = (TextView) findViewById(R.id.small_text_for_title);
            smallText.setText("كاملة");
        }
        SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar_of_edit);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                TextView poucentage = (TextView) findViewById(R.id.pourcentage);
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

    public void edit_sura(View view)
    {
        DataBaseHelper myDb = new DataBaseHelper(this);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.nbrOf);
        int val = numberPicker.getValue();

        Toast.makeText(this, elm + " " + String.valueOf(val), Toast.LENGTH_SHORT).show();

        if(!elm.equals("all"))
            myDb.edit_sura(sura_num, elm, val);

        myDb.close();
        finish();
    }
}



