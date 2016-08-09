package dz.salafi_harach.firstapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView = null;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            textView = new TextView(mContext);
            textView.setText("My text");
            /*imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);*/
        } else {
            textView = new TextView(mContext);
            textView.setText("My text");

            //imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        //return imageView;
        return textView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ic_add_box_black_48dp, R.color.colorAccent,
            R.string.app_name, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
            R.color.colorAccent, R.color.colorAccent,
    };
}
