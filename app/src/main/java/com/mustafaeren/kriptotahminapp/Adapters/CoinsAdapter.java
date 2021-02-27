package com.mustafaeren.kriptotahminapp.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafaeren.kriptotahminapp.R;
import com.mustafaeren.kriptotahminapp.views.CoinTahminActivity;

import java.util.ArrayList;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinHolder> {
    ArrayList<String> currenyList;

    public CoinsAdapter(ArrayList<String> currenyList) {
        this.currenyList = currenyList;
    }

    @NonNull
    @Override
    public CoinsAdapter.CoinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row_coins,parent,false);

        return new CoinsAdapter.CoinHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsAdapter.CoinHolder holder, int position) {

        holder.curreny.setText(currenyList.get(position));

    }

    @Override
    public int getItemCount() {
        return currenyList.size();
    }

    public class CoinHolder extends RecyclerView.ViewHolder {
        TextView curreny;
        Button tahminAlmaButonu;

        public CoinHolder(@NonNull View itemView) {
            super(itemView);

            curreny = itemView.findViewById(R.id.coinIsmiTextView);
            tahminAlmaButonu = itemView.findViewById(R.id.tahminAlmaButonu);

            tahminAlmaButonu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), CoinTahminActivity.class);
                    intent.putExtra("coinAdi",curreny.getText().toString());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}
