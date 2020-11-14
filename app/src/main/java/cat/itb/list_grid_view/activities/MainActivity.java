package cat.itb.list_grid_view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;

import cat.itb.list_grid_view.R;
import cat.itb.list_grid_view.adapters.MyAdapter;
import cat.itb.list_grid_view.models.Data;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private GridView gridView;
    public static ArrayList<Data> listItems;
    public static MyAdapter myAdapterList;
    public static MyAdapter myAdapterGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewItems);
        gridView = (GridView) findViewById(R.id.gridViewItems);

        listItems = new ArrayList<>();
        listItems.add(new Data("Ter Stegen", "POR", "01", R.drawable.ge));
        listItems.add(new Data("Leo Messi", "ED", "10", R.drawable.ar));

        myAdapterList = new MyAdapter(this, R.layout.list_view, listItems);
        myAdapterGrid = new MyAdapter(this, R.layout.grid_view, listItems);

        // LIST VIEW ADAPTER
        listView.setAdapter(myAdapterList);
        registerForContextMenu(listView);

        // GRID VIEW ADAPTER
        gridView.setAdapter(myAdapterGrid);
        registerForContextMenu(gridView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        String name = ((TextView) info.targetView.findViewById(R.id.nombreJugador)).getText().toString();
        menu.setHeaderTitle(name);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.modify_item:
                Toast.makeText(MainActivity.this, "RELLENA TODOS LOS CAMPOS PARA EDITAR EL REGISTRO!",Toast.LENGTH_SHORT).show();
                Intent intentUpdate = new Intent(MainActivity.this, MainActivity2.class);
                intentUpdate.putExtra("position", info.position);
                startActivity(intentUpdate);
                return true;
            case R.id.delete_item:
                listItems.remove(info.position);
                myAdapterList.notifyDataSetChanged();
                myAdapterGrid.notifyDataSetChanged();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                return true;
            case R.id.listIcon:
                if (item.getTitle().equals("Grid")) {
                    listView.setVisibility(View.INVISIBLE);
                    gridView.setVisibility(View.VISIBLE);
                    item.setIcon(R.drawable.ic_list_view);
                    item.setTitle("List");
                } else {
                    gridView.setVisibility(View.INVISIBLE);
                    listView.setVisibility(View.VISIBLE);
                    item.setIcon(R.drawable.ic_grid_view);
                    item.setTitle("Grid");
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}