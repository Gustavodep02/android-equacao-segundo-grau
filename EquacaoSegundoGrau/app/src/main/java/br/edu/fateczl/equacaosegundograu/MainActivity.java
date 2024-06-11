package br.edu.fateczl.equacaosegundograu;

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

    private EditText etValorA, etValorB, etValorC;
    private TextView tvX1, tvX2, tvDelta, tvRaiz;

    private Button btnCalc;
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

        etValorC = findViewById(R.id.etValorC);


        tvX1 = findViewById(R.id.tvX1);
        tvX2 = findViewById(R.id.tvX2);
        tvDelta = findViewById(R.id.tvDelta);
        tvRaiz = findViewById(R.id.tvRaiz);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());


    }

    private void calc(){
        int a = Integer.parseInt(etValorA.getText().toString());
        int b = Integer.parseInt(etValorB.getText().toString());
        int c = Integer.parseInt(etValorC.getText().toString());

        String delta = String.valueOf(Math.pow(b, 2) - 4 * a * c);
        String deltatotal = (getString(R.string.delta)+": " + delta);
        tvDelta.setText(deltatotal);

        if (delta.equals("0")){
            double x = -b / (2 * a);
            String x1 = (getString(R.string.x1)+": " + x);
            tvX1.setText(x1);
            String x2 = (getString(R.string.x2)+": " + x);
            tvX2.setText(x2);
            String raiz = (getString(R.string.raiz)+": " + x);
            tvRaiz.setText(raiz);
        } else if (delta.compareTo("0") > 0){
            double x1 = (-b + Math.sqrt(Double.parseDouble(delta))) / (2 * a);
            double x2 = (-b - Math.sqrt(Double.parseDouble(delta))) / (2 * a);
            String Sx1 = (getString(R.string.x1)+": " + x1);
            String Sx2 = (getString(R.string.x1)+": " + x2);
            tvX1.setText(Sx1);
            tvX2.setText(Sx2);
            String raiz = (getString(R.string.raiz)+": " + x1+" "+getString(R.string.e)+": "+x2);
            tvRaiz.setText(raiz);
        } else if (delta.compareTo("0") < 0){
            String x1 = ("X1: "+getString(R.string.nao_existe));
            String x2 = ("X2: "+getString(R.string.nao_existe));
            String raiz = (getString(R.string.raiz)+getString(R.string.nao_existe));
            tvX1.setText(x1);
            tvX2.setText(x2);
            tvRaiz.setText(raiz);


        }
        etValorA.setText("");
        etValorB.setText("");
        etValorC.setText("");
    }
}