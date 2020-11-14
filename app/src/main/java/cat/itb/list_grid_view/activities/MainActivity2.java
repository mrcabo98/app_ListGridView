package cat.itb.list_grid_view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import cat.itb.list_grid_view.R;
import cat.itb.list_grid_view.adapters.MyAdapter;
import cat.itb.list_grid_view.models.Data;

public class MainActivity2 extends AppCompatActivity {
    private Spinner spinnerPosiciones, spinnerNacionalidades;
    private EditText editTextNombre, editTextDorsal;
    private Button button;
    private int position;
    private boolean isCreated = false;
    int posicionNacionalidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinnerPosiciones = (Spinner) findViewById(R.id.spinnerPosiciones);
        spinnerNacionalidades = (Spinner) findViewById(R.id.spinnerNacionalidades);
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextDorsal = (EditText) findViewById(R.id.editTextDorsal);
        button = (Button) findViewById(R.id.button);

        // SPINNER POSICIONES
        ArrayAdapter<CharSequence> adapterPosiciones = ArrayAdapter.createFromResource(this, R.array.posiciones, android.R.layout.simple_spinner_item);
        spinnerPosiciones.setAdapter(adapterPosiciones);

        // SPINNER NACIONALIDADES
        ArrayAdapter<CharSequence> adapterNacionalidades = ArrayAdapter.createFromResource(this, R.array.nacionalidades, android.R.layout.simple_spinner_item);
        spinnerNacionalidades.setAdapter(adapterNacionalidades);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // EDITAR REGISTROS
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    isCreated = false;
                    position = bundle.getInt("position");

                    Data elemento = MainActivity.listItems.get(position);
                    editTextNombre.setText(elemento.getNombreJugador());
                    editTextDorsal.setText(elemento.getDorsal());

                    if (elemento.getPosicion().equalsIgnoreCase("ENT")) {
                        spinnerPosiciones.setSelection(1);
                    } else if (elemento.getPosicion().equalsIgnoreCase("POR")) {
                        spinnerPosiciones.setSelection(2);
                    } else if (elemento.getPosicion().equalsIgnoreCase("CAD")) {
                        spinnerPosiciones.setSelection(3);
                    } else if (elemento.getPosicion().equalsIgnoreCase("LD")) {
                        spinnerPosiciones.setSelection(4);
                    } else if (elemento.getPosicion().equalsIgnoreCase("DFC")) {
                        spinnerPosiciones.setSelection(5);
                    } else if (elemento.getPosicion().equalsIgnoreCase("LI")) {
                        spinnerPosiciones.setSelection(6);
                    } else if (elemento.getPosicion().equalsIgnoreCase("CAI")) {
                        spinnerPosiciones.setSelection(7);
                    } else if (elemento.getPosicion().equalsIgnoreCase("MCD")) {
                        spinnerPosiciones.setSelection(8);
                    } else if (elemento.getPosicion().equalsIgnoreCase("MD")) {
                        spinnerPosiciones.setSelection(9);
                    } else if (elemento.getPosicion().equalsIgnoreCase("MC")) {
                        spinnerPosiciones.setSelection(10);
                    } else if (elemento.getPosicion().equalsIgnoreCase("MI")) {
                        spinnerPosiciones.setSelection(11);
                    } else if (elemento.getPosicion().equalsIgnoreCase("MCO")) {
                        spinnerPosiciones.setSelection(12);
                    } else if (elemento.getPosicion().equalsIgnoreCase("SDD")) {
                        spinnerPosiciones.setSelection(13);
                    } else if (elemento.getPosicion().equalsIgnoreCase("MP")) {
                        spinnerPosiciones.setSelection(14);
                    } else if (elemento.getPosicion().equalsIgnoreCase("SDI")) {
                        spinnerPosiciones.setSelection(15);
                    } else if (elemento.getPosicion().equalsIgnoreCase("ED")) {
                        spinnerPosiciones.setSelection(16);
                    } else if (elemento.getPosicion().equalsIgnoreCase("DC")) {
                        spinnerPosiciones.setSelection(17);
                    } else if (elemento.getPosicion().equalsIgnoreCase("EI")) {
                        spinnerPosiciones.setSelection(18);
                    }

                    int currentImage = elemento.getNacionalidad();
                    if (currentImage == R.drawable.ge) {
                        spinnerNacionalidades.setSelection(1);
                    } else if (currentImage == R.drawable.br) {
                        spinnerNacionalidades.setSelection(2);
                    } else if (currentImage == R.drawable.sp) {
                        spinnerNacionalidades.setSelection(3);
                    } else if (currentImage == R.drawable.eu) {
                        spinnerNacionalidades.setSelection(4);
                    } else if (currentImage == R.drawable.ur) {
                        spinnerNacionalidades.setSelection(5);
                    } else if (currentImage == R.drawable.fr) {
                        spinnerNacionalidades.setSelection(6);
                    } else if (currentImage == R.drawable.rd) {
                        spinnerNacionalidades.setSelection(7);
                    } else if (currentImage == R.drawable.ho) {
                        spinnerNacionalidades.setSelection(8);
                    } else if (currentImage == R.drawable.bo) {
                        spinnerNacionalidades.setSelection(9);
                    } else if (currentImage == R.drawable.di) {
                        spinnerNacionalidades.setSelection(10);
                    } else if (currentImage == R.drawable.po) {
                        spinnerNacionalidades.setSelection(11);
                    } else if (currentImage == R.drawable.ar) {
                        spinnerNacionalidades.setSelection(12);
                    }
                } else {
                    isCreated = true;
                }

                // AÑADIR REGISTROS
                String nombreJugador = editTextNombre.getText().toString();
                String dorsal = editTextDorsal.getText().toString();
                String posicion = spinnerPosiciones.getSelectedItem().toString();
                int imagen = 0;

                if (!nombreJugador.isEmpty()) {
                    switch (posicionNacionalidad) {
                        case 0:
                            imagen = R.drawable.unknow;
                            break;
                        case 1:
                            imagen = R.drawable.ge;
                            break;
                        case 2:
                            imagen = R.drawable.br;
                            break;
                        case 3:
                            imagen = R.drawable.sp;
                            break;
                        case 4:
                            imagen = R.drawable.eu;
                            break;
                        case 5:
                            imagen = R.drawable.ur;
                            break;
                        case 6:
                            imagen = R.drawable.fr;
                            break;
                        case 7:
                            imagen = R.drawable.rd;
                            break;
                        case 8:
                            imagen = R.drawable.ho;
                            break;
                        case 9:
                            imagen = R.drawable.bo;
                            break;
                        case 10:
                            imagen = R.drawable.di;
                            break;
                        case 11:
                            imagen = R.drawable.po;
                            break;
                        case 12:
                            imagen = R.drawable.ar;
                            break;
                    }
                } else {
                    Toast.makeText(MainActivity2.this, "Debes introducir un nombre", Toast.LENGTH_SHORT).show();
                }

                if (isCreated) {
                    MainActivity.listItems.add(new Data(nombreJugador, posicion, dorsal, imagen));
                } else {
                    MainActivity.listItems.get(position).setNombreJugador(nombreJugador);
                    MainActivity.listItems.get(position).setPosicion(posicion);
                    MainActivity.listItems.get(position).setDorsal(dorsal);
                    MainActivity.listItems.get(position).setNacionalidad(imagen);
                }
                MainActivity.myAdapterList.notifyDataSetChanged();
                MainActivity.myAdapterGrid.notifyDataSetChanged();
                finish();


            }
        });

        spinnerPosiciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerNacionalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posicionNacionalidad = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

}