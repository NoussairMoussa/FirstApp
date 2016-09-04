package dz.salafi_harach.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter_for_grid_view extends BaseAdapter {
    private Context mContext;
    private String[] juzList;

    public Adapter_for_grid_view(Context c)
    {
        mContext = c;
        juzList = mContext.getResources().getStringArray(R.array.juz_list);
    }

    public int getCount()
    {
        return juzList.length;
    }

    public Object getItem(int position)
    {
        return juzList[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        DataBaseHelper myDb = new DataBaseHelper(mContext);
        TextView textView;
        View v;

        if (convertView == null)
        {
            LayoutInflater l = LayoutInflater.from(mContext);
            v = l.inflate(R.layout.item_for_grid_juz, parent, false);
            textView = (TextView) v.findViewById(R.id.textViewOfGridView);
            textView.setText(juzList[position]);
            textView.setTag("none");
            textView.setId(position);

        }
        else
        {
            textView = (TextView) convertView;
            textView.setText(juzList[position]);
            textView.setTag("none");
            textView.setId(position);
        }

        if(myDb.isJuzMahfoud(position+1))
        {
            textView.setBackground(parent.getResources().getDrawable(R.drawable.shape));
            textView.setTag("select");
        }

        return textView;
    }
}













