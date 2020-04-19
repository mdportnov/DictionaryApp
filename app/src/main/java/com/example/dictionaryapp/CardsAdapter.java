package com.example.dictionaryapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {

    private ArrayList<String> arrayList;

    static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        public CardViewHolder(@NonNull CardView cv) {
            super(cv);
            cardView = cv;
        }
    }

    public CardsAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override // создаем новое представление
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewHolder(cv);
    }

    @Override // заполняем представление данными
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView definitionTxt = cardView.findViewById(R.id.txtDefinition);
        definitionTxt.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
