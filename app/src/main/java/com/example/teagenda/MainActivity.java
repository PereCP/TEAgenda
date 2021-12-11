package com.example.teagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.teagenda.CapaDomini.DomainController;
import com.example.teagenda.CapaDomini.Evento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button botonAñadir;
    private ListView myListView;
    private EditText myEditText;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAñadir = findViewById(R.id.addButton);
        botonAñadir.setOnClickListener(this);
        myListView = findViewById(R.id.listView);
        myListView.setOnItemClickListener(this);
        myEditText = findViewById(R.id.myList);

        DomainController.buildDomainController(getApplicationContext());
        List<String> titulos = DomainController.getInstance().getTitulosEventos();
        mAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, titulos);
        myListView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addButton:
                /*
                String text = myEditText.getText().toString().trim();
                Evento e = new Evento();
                e.setTitle(text);
                DomainController.getInstance().addEvento(e);
                List<String> titulos = DomainController.getInstance().getTitulosEventos();
                mAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, titulos);
                myListView.setAdapter(mAdapter);
                */

                Intent intent = new Intent(MainActivity.this, CreateEvento.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DomainController.getInstance().setSelectedEvento(i);
        Intent intent = new Intent(MainActivity.this, TascaView.class);
        startActivity(intent);
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
        List<String> titulos = DomainController.getInstance().getTitulosEventos();
        mAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, titulos);
        myListView.setAdapter(mAdapter);
    }
}