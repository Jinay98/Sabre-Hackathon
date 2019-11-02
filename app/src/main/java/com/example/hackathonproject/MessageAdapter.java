package com.example.hackathonproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessageAdapter extends FirebaseRecyclerAdapter<Message, MessageAdapter.MessageViewHolder> {


    public MessageAdapter(@NonNull FirebaseRecyclerOptions<Message> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MessageViewHolder holder, int position, @NonNull Message message) {
        holder.name.setText("Name of Sender : "+message.getName());
        holder.desc.setText("Nationality of Sender : "+message.getNationality());
        holder.date.setText(message.getDate());
        holder.con.setText(message.getContent());

    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message, parent, false);

        return new MessageAdapter.MessageViewHolder( view);
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView name,date,desc,con;


        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            date=itemView.findViewById(R.id.date);
            desc=itemView.findViewById(R.id.nationality);
            con=itemView.findViewById(R.id.msg);

        }
    }
}
