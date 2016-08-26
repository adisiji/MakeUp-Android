package com.sarmag.neobyte.makeup;

/**
 * Created by neobyte on 2/13/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class mata extends AppCompatActivity{
    private RadioButton bulat,sipit,turun,kecil,jauh,dalam,dekat;
    private String mata,kesan,wajah,hidung,bibir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnprev,btnfinish;
        setContentView(R.layout.mata);
        final RadioGroupPlus rdg = (RadioGroupPlus)findViewById(R.id.radioGroup6);
        bulat = (RadioButton)findViewById(R.id.radio60);
        sipit = (RadioButton)findViewById(R.id.radio61);
        turun = (RadioButton)findViewById(R.id.radio62);
        kecil = (RadioButton)findViewById(R.id.radio63);
        jauh = (RadioButton)findViewById(R.id.radio64);
        dalam = (RadioButton)findViewById(R.id.radio65);
        dekat = (RadioButton)findViewById(R.id.radio66);
        btnprev = (Button) findViewById(R.id.buttonPrev6);
        btnfinish = (Button) findViewById(R.id.buttonSelesai);
        kesan = soltemp.getciri(0);
        wajah =  soltemp.getciri(1);
        hidung = soltemp.getciri(2);
        bibir = soltemp.getciri(3);

        btnprev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil activity_main
                Intent in = new Intent(getApplicationContext(), bibir.class);
                startActivity(in); //memulai intent
            }
        });

                btnfinish.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil activity_main
                if (rdg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Silahkan pilih bentuk mata", Toast.LENGTH_SHORT).show();
                }
                else {
                    soltemp.setkode(4, carikode());
                    String radiovalue = ((RadioButton)findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                    soltemp.setciri(4, radiovalue);
                    mata = soltemp.getciri(4);
                    showdialog(mata);
                 }//memulai intent
            }
        });
    }
    private String carikode() {
        String hasil = null;
        if (bulat.isChecked())
            hasil = "n1";
        else if (sipit.isChecked())
            hasil = "n2";
        else if (turun.isChecked())
            hasil = "n3";
        else if (kecil.isChecked())
            hasil = "n4";
        else if (jauh.isChecked())
            hasil = "n5";
        else if (dalam.isChecked())
            hasil = "n6";
        else if (dekat.isChecked())
            hasil = "n7";
        return hasil;
    }

    protected void showdialog(String mata){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Konfirmasi");
        builder.setMessage("Apa Anda sudah yakin dengan data berikut ini?\n1) Warna "+kesan+"\n2) Bentuk Wajah: "+wajah+"\n3) Bentuk Hidung: "+hidung+
                            "\n4) Bentuk Bibir: "+bibir+"\n5) Bentuk Mata: "+mata);

        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                Intent in = new Intent(getApplicationContext(), hasil.class);
                dialog.dismiss();
                startActivity(in);
            }

        });

        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                dialog.dismiss();
            }
        });

        builder.show();
    }
}