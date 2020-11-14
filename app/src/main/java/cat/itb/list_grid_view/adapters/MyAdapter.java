package cat.itb.list_grid_view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import cat.itb.list_grid_view.R;
import cat.itb.list_grid_view.activities.MainActivity;
import cat.itb.list_grid_view.models.Data;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Data> listItems;

    public MyAdapter(Context context, int layout, ArrayList<Data> listItems) {
        this.context = context;
        this.layout = layout;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Data Item = (Data) getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);

            holder = new ViewHolder();
            holder.nombreJugador = convertView.findViewById(R.id.nombreJugador);
            holder.posicion = convertView.findViewById(R.id.posicion);
            holder.dorsal = convertView.findViewById(R.id.dorsal);
            holder.imagenNacionalidad = convertView.findViewById(R.id.imagenNacionalidad);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nombreJugador.setText(Item.getNombreJugador());
        holder.posicion.setText(Item.getPosicion());
        holder.dorsal.setText(Item.getDorsal());
        holder.imagenNacionalidad.setImageResource(Item.getNacionalidad());


        return convertView;
    }

    static class ViewHolder {
        private TextView nombreJugador, posicion, dorsal;
        private ImageView imagenNacionalidad;
    }
}
