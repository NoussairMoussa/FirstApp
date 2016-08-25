package dz.salafi_harach.firstapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by noussair on 25/08/16.
 */
public class Adapter_list_sura extends ArrayAdapter<String> {

    private ArrayList<Sura_mahfouda> listQuran;

    public Adapter_list_sura(Context context, int r, ArrayList<String> s, ArrayList<Sura_mahfouda> listOfSuraMahfouda)
    {
        super(context, r, s);
        listQuran = listOfSuraMahfouda;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater l = LayoutInflater.from(getContext());

        View v = l.inflate(R.layout.row_of_quran_list, parent, false);

        TextView textView = (TextView) v.findViewById(R.id.item_of_sura_list);

        textView.setText(listQuran.get(position).toString());

        if(listQuran.get(position).getIsMahfoud() == 0)
        {
            textView.setEnabled(false);
        }

        if(listQuran.get(position).getIsMahfoud() == 1)
        {
            textView.setBackgroundColor(v.getResources().getColor(R.color.danger));
            textView.setBackground(v.getResources().getDrawable(R.drawable.shape));
        }
        else
            textView.setBackgroundColor(v.getResources().getColor(R.color.safe));


        return v;
    }

}



