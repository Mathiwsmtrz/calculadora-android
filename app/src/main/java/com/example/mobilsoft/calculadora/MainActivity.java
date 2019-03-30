package com.example.mobilsoft.calculadora;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1=(EditText)findViewById(R.id.editTextN1);
        numero2=(EditText)findViewById(R.id.editTextN2);
        resultado=(TextView)findViewById(R.id.resultadoText);
    }

    public void sumar(View view){
        boolean digitsOnly =datosValidos(view);
        if(digitsOnly){
            Double n1 = Double.valueOf(numero1.getText().toString());
            Double n2 = Double.valueOf(numero2.getText().toString());
            Double res = n1+n2;
            resultado.setText(String.valueOf(res));
        }else{
            resultado.setText("0");
        }
    }
    public void restar(View view){
        boolean digitsOnly =datosValidos(view);
        if(digitsOnly){
            Double n1 = Double.valueOf(numero1.getText().toString());
            Double n2 = Double.valueOf(numero2.getText().toString());
            Double res = n1-n2;
            resultado.setText(String.valueOf(res));
        }else{
            resultado.setText("0");
        }
    }
    public void multiplicar(View view){
        boolean digitsOnly =datosValidos(view);
        if(digitsOnly){
            Double n1 = Double.valueOf(numero1.getText().toString());
            Double n2 = Double.valueOf(numero2.getText().toString());
            Double res = n1*n2;
            resultado.setText(String.valueOf(res));
        }else{
            resultado.setText("0");
        }
    }
    public void dividir(View view){
        boolean digitsOnly =datosValidos(view);
        if(digitsOnly){
            Double n1 = Double.valueOf(numero1.getText().toString());
            Double n2 = Double.valueOf(numero2.getText().toString());
            Double res = 0.0;
            if(n2!=0) {
                res = n1 / n2;
            }else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "No puede dividir entre 0", Toast.LENGTH_SHORT);
                toast.show();
                res = 0.0;
            }
            resultado.setText(String.valueOf(res));
        }else{
            resultado.setText("0");
        }
    }
    public void petenciar(View view){
        boolean digitsOnly =datosValidos(view);
        if(digitsOnly){
            Double n1 = Double.valueOf(numero1.getText().toString());
            Double n2 = Double.valueOf(numero2.getText().toString());
            Double res = Math.pow(n1,n2);
            resultado.setText(String.valueOf(res));
        }else{
            resultado.setText("0");
        }
    }
/*
    public void setData(View view,String valor1, String valor2, Integer Operacion  ){
        boolean digitsOnly =datosValidos(view);
        if(digitsOnly){
            resultado.setText(String.valueOf(valor));
        }else{
            Toast toast = Toast.makeText(context, "digitsOnly", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
*/
    public boolean datosValidos(View view){
        if(!TextUtils.isEmpty(numero1.getText()) && !TextUtils.isEmpty(numero2.getText()))
            return true ;
        else {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Debe digitar los dos campos", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }

}
