package mx.edu.ittepic.lab212;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button guardar,cargar;
    CheckBox basica,lujo;
    SeekBar barra;
    int valormeseros=0;
    EditText nombre,celular,evento,fecha,horaini,horafinal,numeroplatillos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getPreferences(MODE_PRIVATE);

        nombre=findViewById(R.id.nombre);
        celular=findViewById(R.id.ceular);
        evento=findViewById(R.id.evento);
        fecha=findViewById(R.id.fecha);
        horaini=findViewById(R.id.horaini);
        horafinal=findViewById(R.id.horafin);
        numeroplatillos=findViewById(R.id.platillos);
        barra=findViewById(R.id.seekBar);

        basica=findViewById(R.id.chkbasica);
        lujo=findViewById(R.id.checklujo);

        cargar=findViewById(R.id.btncargar);
        guardar=findViewById(R.id.btnsave);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText(sharedPreferences.getString("nombre",null));
                celular.setText(sharedPreferences.getString("celular",null));
                evento.setText(sharedPreferences.getString("evento",null));
                fecha.setText(sharedPreferences.getString("fecha",null));
                horaini.setText(sharedPreferences.getString("horaini",null));
                horafinal.setText(sharedPreferences.getString("horafinal",null));
                numeroplatillos.setText(""+sharedPreferences.getInt("numeroplatillos",0));
                barra.setProgress(sharedPreferences.getInt("meseros",0));
                basica.setChecked(sharedPreferences.getBoolean("basica",false));
                lujo.setChecked(sharedPreferences.getBoolean("lujo",false));

            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = getPreferences(MODE_PRIVATE).edit();
                editor.putString("nombre", nombre.getText().toString());
                editor.putString("celular", celular.getText().toString());
                editor.putString("evento", evento.getText().toString());
                editor.putString("fecha", fecha.getText().toString());
                editor.putString("horaini", horaini.getText().toString());
                editor.putString("horafinal", horafinal.getText().toString());
                editor.putInt("numeroplatillos",  Integer.parseInt(numeroplatillos.getText().toString()));
                editor.putInt("meseros", valormeseros);
                editor.putBoolean("basica",basica.isChecked() );
                editor.putBoolean("lujo",lujo.isChecked() );
                editor.commit();

                nombre.setText("");
                celular.setText("");
                evento.setText("");
                fecha.setText("");
                horaini.setText("");
                horafinal.setText("");
                numeroplatillos.setText("");
                barra.setProgress(0);
                basica.setChecked(false);
                lujo.setChecked(false);

            }
        });

        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valormeseros=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}