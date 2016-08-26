package com.sarmag.neobyte.makeup;
/**
 * Created by neobyte on 2/13/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class hidung extends AppCompatActivity{
    private RadioButton pendek,panjang,lebar,bengkok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnprev,btnnext;
        setContentView(R.layout.hidung);
        final RadioGroupPlus rdg = (RadioGroupPlus)findViewById(R.id.radioGroup4);
        pendek = (RadioButton)findViewById(R.id.radio40);
        panjang = (RadioButton)findViewById(R.id.radio41);
        lebar = (RadioButton)findViewById(R.id.radio42);
        bengkok = (RadioButton)findViewById(R.id.radio43);
        btnprev = (Button) findViewById(R.id.buttonPrev4);
        btnnext = (Button) findViewById(R.id.buttonNext4);

        btnprev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil activity_main
                Intent i = new Intent(getApplicationContext(), wajah.class);
                startActivity(i); //memulai intent
            }
        });

        btnnext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Silahkan pilih bentuk hidung", Toast.LENGTH_SHORT).show();
                }
                else {
                Intent j = new Intent(getApplicationContext(), bibir.class);
                String radiovalue = ((RadioButton)findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                soltemp.setciri(2,radiovalue);
                soltemp.setkode(2,carikode());
                startActivity(j); }//memulai intent
            }
        });
    }

    private String carikode(){
        String hasil = null;
        if (pendek.isChecked())
            hasil="k1";
        else if (panjang.isChecked())
            hasil="k2";
        else if (lebar.isChecked())
            hasil="k3";
        else if(bengkok.isChecked())
            hasil="k4";
        return hasil;
    }
}