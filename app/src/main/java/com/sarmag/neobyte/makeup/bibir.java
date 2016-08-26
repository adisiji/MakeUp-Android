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
import android.widget.RadioGroup;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class bibir extends AppCompatActivity{
    private RadioButton penuh,tipis,mungil,turun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnprev,btnnext;
        setContentView(R.layout.bibir);
        penuh = (RadioButton) findViewById(R.id.radio50);
        tipis = (RadioButton) findViewById(R.id.radio51);
        mungil = (RadioButton) findViewById(R.id.radio52);
        turun = (RadioButton) findViewById(R.id.radio53);
        btnprev = (Button) findViewById(R.id.buttonPrev5);
        btnnext = (Button) findViewById(R.id.buttonNext5);

        btnprev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil activity_main
                Intent i = new Intent(getApplicationContext(), hidung.class);
                startActivity(i); //memulai intent
            }
        });

        btnnext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil activity_main
                Intent j = new Intent(getApplicationContext(), mata.class);
                RadioGroup rdg = (RadioGroup)findViewById(R.id.radioGroup5);
                String radiovalue = ((RadioButton)findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                soltemp.setciri(3,radiovalue);
                soltemp.setkode(3,carikode());
                startActivity(j); //memulai intent
            }
        });
    }
    private String carikode(){
        String hasil = null;
        if (penuh.isChecked())
            hasil="l1";
        else if (tipis.isChecked())
            hasil="l2";
        else if (mungil.isChecked())
            hasil="l3";
        else if (turun.isChecked())
            hasil = "l4";
        return hasil;
    }
}