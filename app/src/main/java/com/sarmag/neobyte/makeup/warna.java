package com.sarmag.neobyte.makeup;

/**
 * Created by neobyte on 2/18/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class warna extends AppCompatActivity {
    private Database db;
    private RadioGroupPlus rdg;
    private Button lanjut;
    public static String radiovalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warna);

        rdg = (RadioGroupPlus) findViewById(R.id.radioGroup1);
        lanjut = (Button) findViewById(R.id.buttonNext1);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil halaman kesan warna
                Intent i = new Intent(getApplicationContext(), k_warna.class);
                if (rdg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Silahkan pilih warna wajah", Toast.LENGTH_SHORT).show();
                }
                else {
                    pilihanuser();
                    startActivity(i);
                }
            }
        });
    }

    private String pilihanuser() {
        radiovalue = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
        return  radiovalue;
    }


}