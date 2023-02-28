package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
@BindView(R.id.wt)
    EditText wt;

    @BindView(R.id.ht)
    EditText ht;

    @BindView(R.id.ag)
    EditText ag;

    @BindView(R.id.result)
    TextView result;

    @BindView(R.id.rst)
    Button rst;

    @BindView(R.id.info)
    ImageView info;

    @BindView(R.id.cal)
    Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) throws NumberFormatException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    final int w = Integer.parseInt(String.valueOf(wt.getText()));
                    final double h = Double.parseDouble(String.valueOf(ht.getText()));
                    final int a = Integer.parseInt(String.valueOf(ag.getText()));

                    double heightInMeters = h* 0.3048;
                    double BMI = w/(heightInMeters*heightInMeters);

                    BMI = (double) Math.round(BMI * 100.0) / 100.0;
                    String bmi= String.valueOf(BMI);


                    result.setText(bmi);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }





        });

info.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("BMI Information");
        builder.setMessage("BMI (Body Mass Index) is a commonly used metric to assess whether a person's weight is healthy or not."
                + "\n\nThe formula for calculating BMI is weight (in kg) divided by height (in meters) squared."
                );
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


});

        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                wt.setText("");
                ht.setText("");
                ag.setText("");
result.setText("");
            }
        });


    }
}