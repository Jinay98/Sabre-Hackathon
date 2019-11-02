package com.example.hackathonproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceAdapter extends FirebaseRecyclerAdapter<Place, PlaceAdapter.PlaceViewHolder> {

    public PlaceAdapter(@NonNull FirebaseRecyclerOptions<Place> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PlaceViewHolder holder, int position, @NonNull Place place) {
        holder.name.setText(place.getName());
        holder.desc.setText(place.getDesc());
        holder.noofdays.setText(place.getNoofdays());
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place1, parent, false);

        return new PlaceViewHolder( view);
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        TextView name,noofdays,desc;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            noofdays=itemView.findViewById(R.id.days);
            desc=itemView.findViewById(R.id.description);
        }
    }
}
