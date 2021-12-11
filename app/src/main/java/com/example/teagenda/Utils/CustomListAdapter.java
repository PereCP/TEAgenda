package com.example.teagenda.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.teagenda.CapaDomini.Evento;
import com.example.teagenda.R;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Evento> {
    public CustomListAdapter(@NonNull Context context, int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Evento evento = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }
        // Lookup view for data population
        //TextView tvTitle = (TextView) convertView.findViewById(R.id.);
        // Populate the data into the template view using the data object
        //tvTitle.setText(evento.getTitle());
        // Return the completed view to render on screen
        return convertView;
    }
}
