package com.packt.madev.portfolio.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.packt.madev.R;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<StockPortfolioItem> list;

    public void setItems(List<StockPortfolioItem> items) {
        this.list.clear();
        this.list.addAll(items);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView symbol;

        public ViewHolder(View v) {
            super(v);
            symbol = v.findViewById(R.id.portfolio_item_symbol);
        }
    }

    public ListAdapter(List<StockPortfolioItem> myDataset) {
        list = myDataset;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.portfolio_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.symbol.setText(list.get(position).getSymbol());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}