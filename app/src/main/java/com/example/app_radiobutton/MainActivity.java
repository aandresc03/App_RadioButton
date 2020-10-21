package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;

    RadioButton rb1;
    RadioButton rb2;

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Para coger los elementos, los IDs que le hemos dados en la parte gráfica.

        et1 = (EditText) findViewById(R.id.txt_num1);
        et2 = (EditText) findViewById(R.id.txt_num2);

        rb1 = (RadioButton) findViewById(R.id.rb_sumar);
        rb2 = (RadioButton) findViewById(R.id.rb_restar);

        tv = (TextView) findViewById(R.id.tv_resultado);

    }

    // Método asociado al botón de calcular

    public void calcular(View view) {

        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();


        // Comprobamos si algún valor está vacío para que muestre un aviso.

        if ((valor1.isEmpty() && valor2.isEmpty()) || valor1.isEmpty() || valor2.isEmpty()){

            Toast.makeText(this, "Escribe los dos valores", Toast.LENGTH_LONG).show();

        } else {

            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);


            if (rb1.isChecked()) {

                int suma = sumar(num1, num2);

                tv.setText(String.valueOf(suma));

            } else if (rb2.isChecked()) {

                int resta = restar(num1, num2);
                tv.setText(String.valueOf(resta));

            } else {

                Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_LONG).show();

            }

        }

    }

    public int sumar(int valor1, int valor2) {

        return valor1 + valor2;

    }

    public int restar(int valor1, int valor2) {

        return valor1 - valor2;

    }

}