package com.example.budgetsnap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SavingsAdapter extends RecyclerView.Adapter<SavingsAdapter.ViewHolder> {

    ArrayList<SavingsClass> savingsList;
    Context context;

    public SavingsAdapter(ArrayList<SavingsClass> savingsList, SavingsActivity activity) {
        this.savingsList = savingsList;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.template_savings,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SavingsClass savings = savingsList.get(position);
        holder.textName.setText(savings.getName());
        holder.textCurrentAmount.setText(String.format("Php %.2f", savings.getCurrentAmount()));
        holder.textGoalAmount.setText(String.format("/ %.2f", savings.getGoalAmount()));
        holder.textIsActivated.setText(savings.getIsActivated() ? "(Activated)" : "");

        holder.savingsView.setOnClickListener(v -> {

            Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return savingsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textGoalAmount, textCurrentAmount, textIsActivated;
        TextView savingsView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textCurrentAmount = itemView.findViewById(R.id.textCurrentAmount);
            textGoalAmount = itemView.findViewById(R.id.textGoalAmount);
            textIsActivated = itemView.findViewById(R.id.textIsActivated);
            savingsView = itemView.findViewById(R.id.savingsView);
        }
    }
}
