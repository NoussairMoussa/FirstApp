package dz.salafi_harach.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by noussair on 07/08/16.
 */

public class My_addapter extends ArrayAdapter<String> {

    int p;
    public My_addapter(Context context, int r, String[] v, int p)
    {
        super(context, r, v);
        this.p = p;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater l = LayoutInflater.from(getContext());

        View v = l.inflate(R.layout.row, parent, false);

        String item = getItem(position);

        TextView textView = (TextView) v.findViewById(R.id.text_array_addapter);
        textView.setText(item);

        if (position == p)
        {
            ImageView i = (ImageView) v.findViewById(R.id.image_of_array_adapter);
            i.setImageResource(android.R.drawable.star_on);
        }
        return v;
    }

}







