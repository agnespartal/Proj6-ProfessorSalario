package com.example.proj6_professorsalario;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proj6_professorsalario.model.Horista;
import com.example.proj6_professorsalario.model.Professor;
import com.example.proj6_professorsalario.model.Titular;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbProfTitular;
    private RadioButton rbProfHorista;
    private TextView txtMostraSalario;
    private EditText txtHoras;
    private EditText txtAnos;


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

        rbProfTitular = findViewById(R.id.rbProfTitular);
        rbProfTitular.setChecked(true);
        rbProfHorista = findViewById(R.id.rbProfHorista);
        rbProfHorista.setChecked(false);
        txtMostraSalario = findViewById(R.id.txtMostraSalario);
        txtAnos = findViewById(R.id.txtAnos);
        txtHoras = findViewById(R.id.txtHoras);
        RadioGroup rg = findViewById(R.id.rgProfessor);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> CalcularSalario());

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbProfHorista) {
                    txtHoras.setVisibility(View.VISIBLE);
                    txtAnos.setVisibility(View.GONE);
                } else if (checkedId == R.id.rbProfTitular) {
                    txtHoras.setVisibility(View.GONE);
                    txtAnos.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void CalcularSalario()
    {
        int horas = Integer.parseInt(txtHoras.getText().toString());
        int anos = Integer.parseInt((txtAnos.getText().toString()));
        double salario = 0;

        Professor prof;
        if (rbProfHorista.isChecked())
        {
            prof = new Horista();
            salario = prof.CalculaSalario(horas);
        }
        if (rbProfTitular.isChecked())
        {
            prof = new Titular();
            salario = prof.CalculaSalario(anos);
        }
        BigDecimal sal = BigDecimal.valueOf(salario).setScale(2, RoundingMode.HALF_UP);

        txtMostraSalario.setText(getString(R.string.salario) + sal);
    }
}