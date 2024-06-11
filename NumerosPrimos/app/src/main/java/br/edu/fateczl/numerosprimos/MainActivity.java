package br.edu.fateczl.numerosprimos;

import android.os.Bundle;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValorA;
    private EditText etValorB;
    private TextView tvNumerosPrimos;
    private Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etValorA = findViewById(R.id.etValorA);
        etValorB = findViewById(R.id.etValorB);
        tvNumerosPrimos = findViewById(R.id.tvNumerosPrimos);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(v -> calc());

    }
    private void calc(){
        int valorA = Integer.parseInt(etValorA.getText().toString());
        int valorB = Integer.parseInt(etValorB.getText().toString());
        String resultado = "";
        if(valorA >50 || valorB >50 || valorA < 0 || valorB < 0){
            tvNumerosPrimos.setText(R.string.num_invalido);

        }else if (valorA > valorB){
            for(int i = valorB; i <= valorA; i++){
                if(isPrimo(i)){
                    resultado += i + " ";
                }
            }
            tvNumerosPrimos.setText(getString(R.string.num_primos)+resultado);
        }else{
            for(int i = valorA; i <= valorB; i++){
                if(isPrimo(i)){
                    resultado += i + " ";
                }
            }
        }
        etValorA.setText("");
        etValorB.setText("");

    }
    private boolean isPrimo(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}