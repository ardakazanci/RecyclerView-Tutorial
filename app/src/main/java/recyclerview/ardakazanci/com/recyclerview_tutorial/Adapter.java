package recyclerview.ardakazanci.com.recyclerview_tutorial;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ardakazanci on 16.11.2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<String> values;


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;


        public ViewHolder(View v) {

            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);


        }

    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public Adapter(List<String> myDataset) {
        values = myDataset;
    }


    // Yeni görünümler oluşturan metot
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View v = layoutInflater.inflate(R.layout.row_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;


    }


    // Görünümün içeriğini yerleştirme


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = values.get(position);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });

        holder.txtFooter.setText("Footer: " + name);
    }


    @Override
    public int getItemCount() {
        return values.size();
    }

}
