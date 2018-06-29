package np.edu.nast.demoapp.demoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final LayoutInflater inflate;
    private final int resourceId;
    private final ArrayList<String> spinnerList;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> spinnerList) {
        super(context, resource, spinnerList);
        this.context = context;
        this.inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resourceId = resource;
        this.spinnerList = spinnerList;
    }

}
