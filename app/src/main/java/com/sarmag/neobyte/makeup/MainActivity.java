package com.sarmag.neobyte.makeup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Typeface;
import android.widget.TextView;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class MainActivity extends AppCompatActivity {
    private Database db;
    private RadioGroupPlus rdg;
    private Button lanjut;
    public static String radiovalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView) findViewById(R.id.teksawaltop);
        TextView tv2 = (TextView) findViewById(R.id.teksawalbwh);
        Typeface face = Typeface.createFromAsset(getAssets(), "font/font.ttf");
        tv1.setTypeface(face);
        tv2.setTypeface(face);
        Button mulai = (Button) findViewById(R.id.mulai);
        Button help = (Button) findViewById(R.id.help);
        Button exit = (Button) findViewById(R.id.exit);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil halaman kesan warna
                Intent i = new Intent(getApplicationContext(), warna.class);
                startActivity(i);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil halaman kesan warna
                tampilhelp();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            }
        });
    }

    public void tampilhelp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bantuan");
        builder.setMessage("\n1) Pilih Mulai\n2) Pilih ciri-ciri yang sesuai dengan wajah Anda\n" +
                "3) Anda dapat menerapkan riasan yang sesuai di halaman Hasil\n")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do nothing
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}