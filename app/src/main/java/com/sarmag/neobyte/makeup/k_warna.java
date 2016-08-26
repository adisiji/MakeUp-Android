package com.sarmag.neobyte.makeup;

/**
 * Created by neobyte on 2/13/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class k_warna extends AppCompatActivity {
    private Button btnprev,btnnext;
    private RadioButton fun,kasual,elegan;
    private final String dataNama = warna.radiovalue;
    private RadioGroup rdg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kesan_warna);
        rdg = (RadioGroup) findViewById(R.id.radioGroup2);
        btnprev = (Button) findViewById(R.id.buttonPrev2);
        btnnext = (Button) findViewById(R.id.buttonNext2);
        fun = (RadioButton) findViewById(R.id.radio10);
        kasual = (RadioButton) findViewById(R.id.radio11);
        elegan = (RadioButton) findViewById(R.id.radio12);
        fun.setText("Kulit "+ dataNama+ " dengan kesan "+fun.getText());
        kasual.setText("Kulit "+ dataNama+ " dengan kesan "+kasual.getText());
        elegan.setText("Kulit "+ dataNama+ " dengan kesan "+elegan.getText());
        //
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(k_warna.this, wajah.class);
                soltemp.setkode(0,carikode());
                String radiovalue = ((RadioButton)findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                soltemp.setciri(0,radiovalue);
                startActivity(j);
            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil halaman wajah
                Intent i = new Intent(k_warna.this, warna.class);
                startActivity(i);
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public String carikode(){
        String hasil=null;
        if (fun.isChecked()&&dataNama.equals("Putih"))
            hasil = "f1";
        else if (kasual.isChecked()&&dataNama.equals("Putih"))
            hasil = "f2";
        else if(elegan.isChecked()&&dataNama.equals("Putih"))
            hasil = "f3";
        else if (fun.isChecked()&&dataNama.equals("Kuning"))
            hasil = "g1";
        else if (kasual.isChecked()&&dataNama.equals("Kuning"))
            hasil = "g2";
        else if(elegan.isChecked()&&dataNama.equals("Kuning"))
            hasil = "g3";
        else if (fun.isChecked()&&dataNama.equals("Sawo Matang"))
            hasil = "i1";
        else if (kasual.isChecked()&&dataNama.equals("Sawo Matang"))
            hasil = "i2";
        else if(elegan.isChecked()&&dataNama.equals("Sawo Matang"))
            hasil = "i3";
        return hasil;
    }


}
