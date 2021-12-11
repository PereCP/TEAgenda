package com.example.teagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.teagenda.CapaDomini.DomainController;
import com.example.teagenda.CapaDomini.Evento;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import yuku.ambilwarna.AmbilWarnaDialog;

public class CreateEvento extends AppCompatActivity {

    private LinearLayoutCompat eLayout;
    private int mDefaultColor;
    private Button mButton;
    private Button eButton;
    private EditText actTitle;
    private EditText actDescr;
    private TextView mDisplayDate;
    private ImageView colorPanel;
    private Date auxDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Evento newActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_evento);

        DomainController.buildDomainController(getApplicationContext());

        auxDate = new Date();
        eLayout = (LinearLayoutCompat) findViewById(R.id.eventLayout);
        mDefaultColor = ContextCompat.getColor(CreateEvento.this, R.color.white);
        actTitle = findViewById(R.id.activityTitle);
        actDescr = findViewById(R.id.activityDescription);
        colorPanel = findViewById(R.id.imageView);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CreateEvento.this, android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                gc.set(year, month, day, 0, 0, 0);
                auxDate = gc.getTime();
                String date = year + "/" + month + "/" + day;
                mDisplayDate.setText(date);
            }
        };
        mButton = (Button) findViewById(R.id.colorPicker);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
        eButton = (Button) findViewById(R.id.addEvent);
        eButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setActivityData();
            }
        });

    }

    public void openColorPicker() {
        AmbilWarnaDialog colPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                colorPanel.setBackgroundColor(mDefaultColor);
            }
        });
        colPicker.show();
    }

    public void setActivityData() {
        String title = actTitle.getText().toString().trim();
        String desc = actDescr.getText().toString().trim();

        newActivity = new Evento();
        newActivity.setTitle(title);
        newActivity.setDescription(desc);
        newActivity.setColor(mDefaultColor);
        newActivity.setColor(0);
        newActivity.setDate(auxDate);

        if (true) {
            DomainController.getInstance().addEvento(newActivity);
            DomainController.closeDomainController();
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        DomainController.closeDomainController();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DomainController.buildDomainController(getApplicationContext());
    }
}