package com.example.teagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.teagenda.CapaDomini.DomainController;
import com.example.teagenda.CapaDomini.Evento;

import java.sql.Time;
import java.util.Date;

public class TascaView extends AppCompatActivity {

    private Evento event;
    private TextView NameText;
    private TextView date;
    private TextView desc;
    private View barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DomainController.restoreDomainController(getApplicationContext());

        event = DomainController.getInstance().getSelectedEvento();
        setContentView(R.layout.activity_tasca_view);
        barra = (View)findViewById(R.id.barra);
        NameText = (TextView)findViewById(R.id.EventName);
        date = (TextView)findViewById(R.id.Date);
        desc = (TextView)findViewById(R.id.EventDesc);
        NameText.setText(event.getTitle());
        date.setText(event.getDate().toString());
        desc.setText(event.getDescription());

        int color = event.getColor();
        barra.setBackgroundColor(color);

        //if(event.getColor());

    }

    @Override
    protected void onPause() {
        super.onPause();
        DomainController.saveDomainController();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DomainController.restoreDomainController(getApplicationContext());
    }

}