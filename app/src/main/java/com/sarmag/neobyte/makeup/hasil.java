package com.sarmag.neobyte.makeup;

/**
 * Created by neobyte on 2/16/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class hasil extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Database db = new Database(this);
        Button btnprev,btnexit;
        TextView t0,t1,t2,t3,t4;
        String a,b,c,d,e;
        setContentView(R.layout.hasil);

        btnprev = (Button) findViewById(R.id.buttonPrev7);
        btnexit = (Button) findViewById(R.id.buttonKeluar);

        t0 = (TextView) findViewById(R.id.sWarna);
        t1 = (TextView) findViewById(R.id.sWajah);
        t2 = (TextView) findViewById(R.id.sHidung);
        t3 = (TextView) findViewById(R.id.sBibir);
        t4 = (TextView) findViewById(R.id.sMata);
        try {
        a = db.carisol(soltemp.getkode(0), "tbl_warna", "kd_kesan", "s_kesan");
        b = db.carisol(soltemp.getkode(1), "tbl_wajah", "kd_bentuk", "s_bentuk");
        c = db.carisol(soltemp.getkode(2), "tbl_hidung", "kd_hidung", "s_hidung");
        d = db.carisol(soltemp.getkode(3), "tbl_bibir", "kd_bibir", "s_bibir");
        e = db.carisol(soltemp.getkode(4), "tbl_mata", "kd_mata", "s_mata");
            if (soltemp.getkode(0) != null)
                t0.setText(a.toCharArray(), 0, a.length());
            if (soltemp.getkode(1) != null)
                t1.setText(b.toCharArray(), 0, b.length());
            if (soltemp.getkode(2) != null)
                t2.setText(c.toCharArray(), 0, c.length());
            if (soltemp.getkode(3) != null)
                t3.setText(d.toCharArray(), 0, d.length());
            if (soltemp.getkode(4) != null)
                t4.setText(e.toCharArray(), 0, e.length());


            btnprev.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //memanggil activity_main
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i); //memulai intent
                }
            });

            btnexit.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                    finish();
                }
            });

            db.close();
        } catch (Exception n){
            n.printStackTrace();
        }
    }
}