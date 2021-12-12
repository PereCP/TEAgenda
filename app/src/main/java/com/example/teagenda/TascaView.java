package com.example.teagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    Button buttonExit;
    public Evento event;
    private TextView NameText;
    private TextView date;
    private TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("hola");
        DomainController dc = DomainController.getInstance();
       // System.out.println("hola2");
       // int pos = dc.getPos();
        // System.out.println("Este es pos:" +pos);
        /*if(pos > 0) {
            event = dc.getEvento(pos);
        }*/
         event = new Evento(1, "title", "String description", 6747, new Date(2001, 12, 1), true);
        //event = dc.getEvento(13);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasca_view);
        buttonExit = (Button)findViewById(R.id.buttonExit);
        NameText = (TextView)findViewById(R.id.EventName);
        date = (TextView)findViewById(R.id.Date);
        desc = (TextView)findViewById(R.id.EventDesc);
        NameText.setText(event.getTitle());
        date.setText(event.getDate().toString());
        desc.setText(event.getDate().toString());
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tornar = new Intent(TascaView.this, MainActivity.class);
                startActivity(tornar);
            }
        });
    }

}