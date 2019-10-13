package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btnmostrar);
        tv1 = (TextView) findViewById(R.id.mensaje);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SensorManager sensorAdmin = (SensorManager) getSystemService(SENSOR_SERVICE);
                List<Sensor> listaSensores = sensorAdmin.getSensorList(Sensor.TYPE_ALL);
                for(Sensor sensor:listaSensores){
                    log(sensor.getName());
                }
            }
        });

    }
    private void log(String cadena){
        tv1.append(cadena + "\n");
    }
}
