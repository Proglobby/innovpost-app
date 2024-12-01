package com.proglobby.innovpost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TicketHolder>{
    List<Ticket> tickets = new ArrayList<>();

    public RecyclerAdapter(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    @NonNull
    @Override
    public TicketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_item, parent, false);
        TicketHolder ticketHolder = new TicketHolder(view);
        return ticketHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketHolder holder, int position) {
        Ticket ticket = tickets.get(position);
        final int[] totalist = {0};
        final int[] index = {0};
        FirebaseCallback callback = new FirebaseCallback() {
            @Override
            public void onIndexCallback(int total) {
                index[0] = total;
                int remaining = ticket.getRemaining(index[0]);
                if (remaining < 0) {
                    holder.description.setText("Ticket Expired");

                }else{
                    holder.description.setText(ticket.getRemaining(index[0])+ " to go");
                }
            }

            @Override
            public void onCallback(List<Ticket> tickets) {
            }
        };
        FireBaseHelper.readTicketIndex(21004, callback);
        holder.title.setText(ticket.getZip()+"");


    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public class TicketHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView date;
        public TicketHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ticketId);
            description = (TextView) itemView.findViewById(R.id.ticketDescription);
            date = (TextView) itemView.findViewById(R.id.ticketDate);
        }
    }
}
