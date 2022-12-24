package com.zian.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvNama, tvNim, tvMtk, tvBind,tvBing, tvFis, tvBio, tvRatarata, tvMutu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNama = findViewById(R.id.tvNama);
        tvNim = findViewById(R.id.tvNim);
        tvMtk = findViewById(R.id.tvMtk);
        tvBind = findViewById(R.id.tvBind);
        tvBing = findViewById(R.id.tvBing);
        tvFis = findViewById(R.id.tvFis);
        tvBio = findViewById(R.id.tvBio);
        tvRatarata = findViewById(R.id.tvRata);
        tvMutu = findViewById(R.id.tvMutu);

        Bundle extras = getIntent().getExtras();
        tvNama.setText(extras.getString("NAMA"));
        tvNim.setText(extras.getString("NIM"));
        tvMtk.setText(extras.getString("MTK"));
        tvBind.setText(extras.getString("BIND"));
        tvBing.setText(extras.getString("BING"));
        tvFis.setText(extras.getString("FIS"));
        tvBio.setText(extras.getString("BIO"));

        int nilai1 = Integer.parseInt(extras.getString("MTK"));
        int nilai2 = Integer.parseInt(extras.getString("BIND"));
        int nilai3 = Integer.parseInt(extras.getString("BING"));
        int nilai4 = Integer.parseInt(extras.getString("FIS"));
        int nilai5 = Integer.parseInt(extras.getString("BIO"));
        int total  = (nilai1 + nilai2 + nilai3 + nilai4 + nilai5)/5;

        tvRatarata.setText(String.valueOf(total));

        if(total >= 85 && total <= 100) {
            tvMutu.setText("A");
        } else if(total >= 70 && total <= 84) {
            tvMutu.setText("B");
        } else if(total >= 60 && total <= 69) {
            tvMutu.setText("C");
        } else if(total >= 50 && total <= 69) {
            tvMutu.setText("E");
        } else if(total >= 0 && total <= 49) {
            tvMutu.setText("E");
        } else if(total < 0 ) {
            tvMutu.setText("Tidak Terdefinisi");
        }

        Button kembali = findViewById(R.id.buttonBack);
        kembali.setOnClickListener(v-> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}