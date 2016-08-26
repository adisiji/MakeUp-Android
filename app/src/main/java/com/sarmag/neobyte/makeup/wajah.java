package com.sarmag.neobyte.makeup;
/**
 * Created by neobyte on 2/12/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class wajah  extends AppCompatActivity{
    private RadioGroupPlus rdg;
    private RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wajah);
        Button btnprev,btnnext;
        final RadioGroupPlus rdg = (RadioGroupPlus)findViewById(R.id.radioGroup3);
        btnprev = (Button) findViewById(R.id.buttonPrev3);
        btnnext = (Button) findViewById(R.id.buttonNext3);
        rb1 = (RadioButton) findViewById(R.id.radio0);
        rb2 = (RadioButton) findViewById(R.id.radio1);
        rb3 = (RadioButton) findViewById(R.id.radio2);

        btnprev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), k_warna.class);
                startActivity(i); //memulai intent
            }
        });
        btnnext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Silahkan pilih bentuk wajah", Toast.LENGTH_SHORT).show();
                }
                else {
                Intent i = new Intent(getApplicationContext(), hidung.class);
                String radiovalue = ((RadioButton)findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                soltemp.setciri(1,radiovalue);
                soltemp.setkode(1,carikode());
                startActivity(i); }//memulai intent
            }
        });
    }
    private String carikode(){
        String hasil = null;
        if (rb1.isChecked())
            hasil="j1";
        else if (rb2.isChecked())
            hasil="j2";
        else if (rb3.isChecked())
            hasil="j3";
        return hasil;
    }

}
