package com.zian.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText nama, nohp, email, harga, diskon;
    RadioButton rbJkel;
    RadioGroup rgJkel;
    CheckBox cbBind, cbBing, cbMand, cbPranc, cbArab, cbRusia;
    Spinner spnCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.etNama);
        nohp = findViewById(R.id.etNohp);
        email = findViewById(R.id.etEmail);
        rgJkel = findViewById(R.id.rgJkel);
        cbBind = findViewById(R.id.cbBind);
        cbBing = findViewById(R.id.cbBing);
        cbMand = findViewById(R.id.cbMandarin);
        cbPranc = findViewById(R.id.cbPranc);
        cbArab = findViewById(R.id.cbArab);
        cbRusia = findViewById(R.id.cbRusia);
        harga = findViewById(R.id.etHarga);
        diskon = findViewById(R.id.etDisk);
        spnCourse = findViewById(R.id.spinner);

        Button kirim = findViewById(R.id.kirim);
        kirim.setOnClickListener(v -> {
            if (nama.getText().toString().length()==0){
                nama.setError("Inputan Tidak Boleh Kosong");
            } else if (nohp.getText().toString().length() == 0) {
                nohp.setError("Inputan Tidak Boleh Kosong");
            } else if (email.getText().toString().length() == 0) {
                email.setError("Inputan Tidak Boleh Kosong");
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putString("NAMA", Objects.requireNonNull (nama.getText()).toString());
                bundle.putString("NOHP", Objects.requireNonNull(nohp.getText()).toString());
                bundle.putString("EMAIL", Objects.requireNonNull(email.getText()).toString());

                int radioId = rgJkel.getCheckedRadioButtonId();
                rbJkel = (RadioButton) findViewById(radioId);

                ArrayList<String> hasilCb = new ArrayList<>();
                if (cbBind.isChecked()){
                    hasilCb.add("Bahasa Indonesia");
                }
                if (cbBing.isChecked()){
                    hasilCb.add("Bahasa Inggris");
                }
                if (cbMand.isChecked()){
                    hasilCb.add("Bahasa Mandarin");
                }
                if (cbPranc.isChecked()){
                    hasilCb.add("Bahasa Prancis");
                }
                if (cbArab.isChecked()){
                    hasilCb.add("Bahasa Arab");
                }
                if (cbRusia.isChecked()){
                    hasilCb.add("Bahasa Rusia");
                }

                bundle.putString("rbJkel", Objects.requireNonNull(rbJkel.getText()).toString());
                bundle.putStringArrayList("hasilCb", hasilCb);
                String firstItem = String.valueOf(spnCourse.getSelectedItem());
                bundle.putString("spnCourse", firstItem);
                bundle.putString("HARGA", Objects.requireNonNull(harga.getText()).toString());
                bundle.putString("DISKON", Objects.requireNonNull(diskon.getText()).toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtras(bundle);

                Toast.makeText(getApplicationContext(), "Data Berhasil di Simpan", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }
}