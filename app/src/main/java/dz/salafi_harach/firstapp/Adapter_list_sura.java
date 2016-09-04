package dz.salafi_harach.firstapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;
import java.util.Date;

public class Adapter_list_sura extends ArrayAdapter<String> {

    private ArrayList<Sura_mahfouda> listQuran;

    public Adapter_list_sura(Context context, int r, ArrayList<String> s, ArrayList<Sura_mahfouda> listOfSuraMahfouda)
    {
        super(context, r, s);
        listQuran = listOfSuraMahfouda;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater l = LayoutInflater.from(getContext());
        View v;
        v = l.inflate(R.layout.row_of_quran_list, parent, false);

        TwoLineListItem linearLayout = (TwoLineListItem) v.findViewById(R.id.layout_of_list_sura);

        TextView textView = (TextView) v.findViewById(R.id.item_of_sura_list);
        textView.setText(listQuran.get(position).toString());
        TextView soustextView = (TextView) v.findViewById(R.id.sous_item_of_sura_list);
        soustextView.setText(listQuran.get(position).createRowOfSura());
        soustextView.setTextColor(v.getResources().getColor(R.color.colorPrimary));

        if(listQuran.get(position).getIsMahfoud() == 0)
        {
            textView.setEnabled(false);
        }
        else
        {
            Date today = new Date();
            long defrence = today.getTime() - listQuran.get(position).getDateOfInsert();

            long dayInTimeUnix = 60*60*24;

            if(defrence < dayInTimeUnix * 2)
            {
                linearLayout.setBackgroundColor(v.getResources().getColor(R.color.safe));

                textView.setTextColor(v.getResources().getColor(R.color.colorPrimary));

                soustextView.setText(listQuran.get(position).createRowOfSura());
                soustextView.setTextColor(v.getResources().getColor(R.color.colorPrimary));
            }
            else if(defrence < 10*dayInTimeUnix)
            {
                linearLayout.setBackgroundColor(v.getResources().getColor(R.color.warning));

                textView.setTextColor(v.getResources().getColor(R.color.colorPrimaryDark));

                soustextView.setText(listQuran.get(position).createRowOfSura());
                soustextView.setTextColor(v.getResources().getColor(R.color.colorPrimary));
            }
            else
            {
                linearLayout.setBackgroundColor(v.getResources().getColor(R.color.danger));

                textView.setTextColor(v.getResources().getColor(R.color.colorPrimaryDark));

                soustextView.setText(listQuran.get(position).createRowOfSura());
                soustextView.setTextColor(v.getResources().getColor(R.color.colorPrimary));
            }
            linearLayout.setClickable(true);
        }
        if(listQuran.get(position).getIsMahfoud() == 1)
        {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent edit_quran_intent = new Intent(getContext(), Edit_quran_activity.class);
                    edit_quran_intent.putExtra("sura_num", listQuran.get(position).getSura().getSuraNum());
                    getContext().startActivity(edit_quran_intent);
                }
            });
        }
        return v;
    }
}










