package com.example.teagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.teagenda.CapaDomini.Evento;

import java.util.Date;

public class TascaView extends AppCompatActivity {
    Button buttonExit;
    private Evento event;
    private TextView NameText;
    private EditText date;
    private TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        event = new Evento(1, "title", "String description", 6747, new Date(2001, 12, 1), true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasca_view);

        buttonExit = (Button)findViewById(R.id.buttonExit);
        NameText = (TextView) findViewById(R.id.EventName);
        date = (EditText)findViewById(R.id.Date);
        desc = (TextView)findViewById(R.id.EventDesc);
        NameText.setText(event.getTitle());
        date.setText(event.getDate().toString());
        desc.setText(event.getDescription());
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tornar = new Intent(TascaView.this, MainActivity.class);
                startActivity(tornar);
            }
        });
    }

}