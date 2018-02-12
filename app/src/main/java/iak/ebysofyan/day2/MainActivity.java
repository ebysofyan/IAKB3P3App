package iak.ebysofyan.day2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import iak.ebysofyan.R;
import iak.ebysofyan.day1.sample1.D1Sample1Activity;

/**
 * Created by e on 2/11/18.
 */

public class MainActivity extends AppCompatActivity {

    Button btnCalculator, btnInformation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_main);

        btnCalculator = findViewById(R.id.btn_calculator);
        btnInformation = findViewById(R.id.btn_information);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Kalkulator1Activity.class);
                intent.putExtra("TITLE", "Kalkulator Bro . . .");
                intent.putExtra("NILAI_AWAL", 0);
                startActivity(intent);
            }
        });

        btnInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), D1Sample1Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(getString(R.string.message))
                .setTitle(getString(R.string.confirm))
                .create();
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
