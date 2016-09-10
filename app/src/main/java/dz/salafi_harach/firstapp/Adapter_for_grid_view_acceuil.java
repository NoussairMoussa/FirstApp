package dz.salafi_harach.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter_for_grid_view_acceuil extends BaseAdapter {
    private Context mContext;

    public Adapter_for_grid_view_acceuil(Context c)
    {
        mContext = c;
    }

    public int getCount()
    {
        return 0;
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
        TextView textView;
        View v;

        if (convertView == null)
        {
            LayoutInflater l = LayoutInflater.from(mContext);
            v = l.inflate(R.layout.item_for_grid_murajaa, parent, false);
            textView = (TextView) v.findViewById(R.id.textViewOfMurajaa_tab);
        }
        else
        {
            textView = (TextView) convertView;
        }
        textView.setId(position);

        return textView;
    }
}




















