package br.com.catapan.testemaxima.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.catapan.testemaxima.R;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SingleRow> arrayList;

    public CustomAdapter(Context context) {
        this.context = context;
        arrayList = new ArrayList<>();
        Resources res = context.getResources();
        String[] names = res.getStringArray(R.array.legends_details_status_order_erp);
        int[] images = {R.drawable.ic_maxima_em_processamento, R.drawable.ic_maxima_alvara_inativo, R.drawable.ic_legenda_campanha};

        for (int i = 0; i < images.length; i++) {
            arrayList.add(new SingleRow(names[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_listview, parent, false);
        TextView textView = row.findViewById(R.id.textViewCustom);
        ImageView imageView = row.findViewById(R.id.imageViewCustom);

        SingleRow temp_obj = arrayList.get(position);

        textView.setText(temp_obj.name);
        imageView.setImageResource(temp_obj.image);

        return row;
    }

    public static class SingleRow {
        String name;
        int image;

        public SingleRow(String name, int image) {
            this.name = name;
            this.image = image;
        }
    }
}
