package iak.ebysofyan.day2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import iak.ebysofyan.R;

/**
 * Created by e on 2/11/18.
 */

public class Kalkulator1Activity extends AppCompatActivity {

    EditText txtInput1, txtInput2;
    Button btnHitung;
    TextView tvHasil;

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_latihan1);

        txtInput1 = findViewById(R.id.txt_input1);
        txtInput2 = findViewById(R.id.txt_input2);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = txtInput1.getText().toString();
                String input2 = txtInput2.getText().toString();

                double angka1 = 0;
                double angka2 = 0;

                if (!input1.equals("")) {
                    angka1 = Double.parseDouble(input1);
                }

                if (!input2.equals("")) {
                    angka2 = Double.parseDouble(input2);
                }

                double hasil = angka1 + angka2;
                tvHasil.setText(hasil + "");
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra("TITLE");
        ab.setTitle(title);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                Toast.makeText(this, getString(R.string.information), Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_help:
                Snackbar.make(this.getCurrentFocus(), getString(R.string.help), Snackbar.LENGTH_LONG).show();
                break;
        }

        return true;
    }
}
