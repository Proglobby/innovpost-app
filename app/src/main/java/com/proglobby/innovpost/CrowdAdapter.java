package com.proglobby.innovpost;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CrowdAdapter extends RecyclerView.Adapter<CrowdAdapter.CrowdHolder>{
    List<Agency> agencies = new ArrayList<>();

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
        notifyDataSetChanged();
    }

    public CrowdAdapter(List<Agency> agencies) {
        this.agencies = agencies;
    }

    @NonNull
    @Override
    public CrowdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.crowd_item, null);
        return new CrowdHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrowdHolder holder, int position) {
        Agency agency = agencies.get(position);
        holder.name.setText(agency.getName());
        holder.zip.setText(String.valueOf(agency.getZip()));
        holder.crowd.setText(String.valueOf(agency.getCrowd()));
        if (agency.getCrowd() <20){
            //set the text color to green if the crowd is less than 20
            holder.crowd.setTextColor(Color.GREEN);
        }else {
            if (agency.getCrowd() < 28){
                //set the text color to yellow if the crowd is less than 30
                holder.crowd.setTextColor(Color.YELLOW);
            }else{
                holder.crowd.setTextColor(Color.RED);
            }

        }
    }

    @Override
    public int getItemCount() {
        return agencies.size();
    }


    public class CrowdHolder extends RecyclerView.ViewHolder {
        TextView name, zip, crowd;

        public CrowdHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.crowdName);
            zip = itemView.findViewById(R.id.crowdZip);
            crowd = itemView.findViewById(R.id.crowdRate);
        }
    }

}
