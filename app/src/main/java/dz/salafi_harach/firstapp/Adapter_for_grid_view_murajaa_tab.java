package dz.salafi_harach.firstapp;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Adapter_for_grid_view_murajaa_tab extends BaseAdapter {
    private Context mContext;
    private ArrayList datesOMurajaa;
    private String sura_name;

    public Adapter_for_grid_view_murajaa_tab(Context c, ArrayList datesOMurajaa, String sura_name)
    {
        this.mContext = c;
        this.datesOMurajaa = datesOMurajaa;
        this.sura_name = sura_name;
    }

    public int getCount()
    {
        return datesOMurajaa.size() * 2;
    }

    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //DataBaseHelper myDb = new DataBaseHelper(mContext);
        TextView textView;
        View v;
        Date date;
        Locale locale = new Locale("ara", "DZ");

        SimpleDateFormat ft = new SimpleDateFormat("E  dd/MMM/y  HH:mm", locale);
        //SimpleDateFormat ft = new SimpleDateFormat("E  dd/MMM/y  HH:mm", Locale.getDefault());
        //ft.applyPattern(ft.toLocalizedPattern());

        if (convertView == null)
        {
            LayoutInflater l = LayoutInflater.from(mContext);
            v = l.inflate(R.layout.item_for_grid_murajaa, parent, false);
            textView = (TextView) v.findViewById(R.id.textViewOfMurajaa_tab);
            if(position % 2 != 0)
            {
                date = new Date((Long.parseLong((String) datesOMurajaa.get(position/2))));
                textView.setText(String.valueOf(ft.format(date)));
                textView.setTextColor(Color.BLACK);
            }
            else
            {
                textView.setText(sura_name);
                textView.setTextColor(Color.parseColor("#b74a90"));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            }
            textView.setId(position);

        }
        else
        {
            textView = (TextView) convertView;
            textView.setId(position);
        }
        return textView;
    }
}













