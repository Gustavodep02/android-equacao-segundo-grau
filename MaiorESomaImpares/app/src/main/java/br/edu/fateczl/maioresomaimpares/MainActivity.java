package br.edu.fateczl.maioresomaimpares;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValorA;
    private EditText etValorB;
    private Button btnMaior;
    private Button btnSoma;
    private TextView tvSoma;
    private TextView tvMaior;


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
        btnMaior = findViewById(R.id.btnMaior);
        btnSoma = findViewById(R.id.btnSoma);
        tvSoma = findViewById(R.id.tvSoma);
        tvMaior = findViewById(R.id.tvMaior);

        btnMaior.setOnClickListener(v -> calcularMaior());
        btnSoma.setOnClickListener(v -> calcular());
    }
    private void calcular() {
        int valorA = Integer.parseInt(etValorA.getText().toString());
        int valorB = Integer.parseInt(etValorB.getText().toString());
        int soma =0;
        if(valorA>valorB){

        for(int i =valorB;i<valorA;i++){
            if(i%2!=0){
                soma+=i;
            }
        }}else {
            for (int i = valorA; i < valorB; i++) {
                if (i % 2 != 0) {
                    soma += i;
                }
            }
        }
        String resultado = getString(R.string.soma)+soma;
        tvSoma.setText(resultado);
    }
    private void calcularMaior() {
        int valorA = Integer.parseInt(etValorA.getText().toString());
        int valorB = Integer.parseInt(etValorB.getText().toString());
        if(valorA > valorB){
            String resultado = getString(R.string.maiorValor)+valorA;
            tvMaior.setText(resultado);
        }else if(valorB>valorA) {
            String resultado = getString(R.string.maiorValor) + valorB;
            tvMaior.setText(resultado);
        }else{
            String resultado = getString(R.string.iguais);
            tvMaior.setText(resultado);
    }
    }
}