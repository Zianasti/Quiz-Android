package com.zian.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView nama, nohp, email, hasilRb, hasilCb, hasilSpinner, harga, diskon, totalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<String> hasilCbList = new ArrayList<>();
        nama = findViewById(R.id.tvNama);
        nohp = findViewById(R.id.tvNohp);
        email = findViewById(R.id.tvEmail);
        hasilRb = findViewById(R.id.tvJkel);
        hasilCb = findViewById(R.id.tvBahasa);
        hasilSpinner = findViewById(R.id.tvCourse);
        harga = findViewById(R.id.tvHarga);
        diskon = findViewById(R.id.tvDiskon);
        totalHarga = findViewById(R.id.tvTotal);

        Bundle extras = getIntent().getExtras();
        nama.setText(extras.getString("NAMA"));
        nohp.setText(extras.getString("NOHP"));
        email.setText(extras.getString("EMAIL"));
        hasilRb.setText(extras.getString("rbJkel"));
        hasilCbList = getIntent().getStringArrayListExtra("hasilCb");
        hasilCb.setText("");
        for (int i = 0;i<hasilCbList.size();i++){
            hasilCb.append(hasilCbList.get(i)+", ");
        }
        hasilSpinner.setText(extras.getString("spnCourse"));
        harga.setText(extras.getString("HARGA"));
        diskon.setText(extras.getString("DISKON"));

        int nilai1 = Integer.parseInt(extras.getString("HARGA"));
        int nilai2 = Integer.parseInt(extras.getString("DISKON"));
        int total = nilai1 - (nilai1*nilai2/100);

        totalHarga.setText(String.valueOf(total));

        Button kembali = findViewById(R.id.buttonBack);
        kembali.setOnClickListener(v-> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}