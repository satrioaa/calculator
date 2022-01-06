package com.satrioarda.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    RadioGroup rg1;
    RadioButton rb1;
    Button btnHitung;
    TextView tvHasil;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        tvHasil=(TextView) findViewById(R.id.tvHasil);
        btnHitung=(Button) findViewById(R.id.count);
        rg1=(RadioGroup) findViewById(R.id.rg_hitung);
        pref=this.getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                double input1, input2, hasil = 0;
                input1=Double.valueOf(et1.getText().toString().trim());
                input2=Double.valueOf(et2.getText().toString().trim());

                switch (id){
                    case R.id.tambah:
                        hasil=input1+input2;
                        break;
                    case R.id.kurang:
                        hasil=input1-input2;
                        break;
                    case R.id.bagi:
                        hasil=input1/input2;
                        break;
                    case R.id.kali:
                        hasil=input1*input2;
                        break;
                }
                String hasil1=String.valueOf(hasil);
                tvHasil.setText(hasil1);

                pref.edit().putString(getString(R.string.result_key), String.valueOf(hasil)).apply();
            }
            });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double input1, input2, hasil = 0;
                input1=Double.valueOf(et1.getText().toString().trim());
                input2=Double.valueOf(et2.getText().toString().trim());

                rg1=(RadioGroup) findViewById(R.id.rg_hitung);
                int selectedId = rg1.getCheckedRadioButtonId();


                switch (selectedId){
                    case R.id.tambah:
                        hasil=input1+input2;
                        break;
                    case R.id.kurang:
                        hasil=input1-input2;
                        break;
                    case R.id.bagi:
                        hasil=input1/input2;
                        break;
                    case R.id.kali:
                        hasil=input1*input2;
                        break;
                }
                String hasil1=String.valueOf(hasil);
                tvHasil.setText(hasil1);

                pref.edit().putString(getString(R.string.result_key), String.valueOf(hasil)).apply();
            }
        });
    }
}