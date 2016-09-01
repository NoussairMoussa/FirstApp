package dz.salafi_harach.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class Edit_quran_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_quran_activity);

        int i = (int) getIntent().getExtras().get("p");

        TextView p = (TextView) findViewById(R.id.sura_name);
        p.setText(String.valueOf(i));
    }

}
