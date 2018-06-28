package np.edu.nast.demoapp.demoapp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import np.edu.nast.demoapp.demoapp.R;

/**
 * Created by Sanjay on 03/04/2017.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {
    private LayoutInflater inflate;
    private int resourceId;
    private ArrayList<String> spinnerList;
    private Context context;
    private int spinnerid;

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<String> spinnerList) {
        super(context, resource, spinnerList);
        this.context = context;
        this.inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resourceId = resource;
        this.spinnerList = spinnerList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflate.inflate(resourceId, null);
            Holder holder = new Holder();
            holder.textView1 = convertView.findViewById(R.id.tv_name);
            holder.textView1.setText(spinnerList.get(position));
            holder.textView1.setTextSize(15);
            holder.textView1.setPadding(15, 15, 15, 15);
            holder.textView1.setHintTextColor(context.getResources().getColor(R.color.colorHint));
            holder.textView1.setTextColor(context.getResources().getColor(R.color.colorHint));
            convertView.setTag(holder);
        }
        Holder holder = (Holder) convertView.getTag();
        holder.textView1.setText(spinnerList.get(position));
        holder.textView1.setTextSize(15);
        holder.textView1.setPadding(15, 15, 15, 15);
        holder.textView1.setHintTextColor(context.getResources().getColor(R.color.colorHint));
        holder.textView1.setTextColor(context.getResources().getColor(R.color.colorHint));

        return convertView;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflate.inflate(resourceId, null);
            Holder holder = new Holder();
            holder.textView1 = convertView.findViewById(R.id.tv_name);
            holder.textView1.setText(spinnerList.get(position));
            holder.textView1.setHintTextColor(context.getResources().getColor(R.color.colorHint));
            holder.textView1.setTextColor(context.getResources().getColor(R.color.colorHint));
            holder.textView1.setTextSize(15);
            convertView.setTag(holder);
        }
        Holder holder = (Holder) convertView.getTag();
        holder.textView1.setText(spinnerList.get(position));

        holder.textView1.setTextSize(15);
        holder.textView1.setHintTextColor(context.getResources().getColor(R.color.colorHint));
        holder.textView1.setTextColor(context.getResources().getColor(R.color.colorHint));

        return convertView;
    }

    private class Holder {
        TextView textView1;
    }
}