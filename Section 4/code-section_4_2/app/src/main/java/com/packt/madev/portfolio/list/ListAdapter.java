package com.packt.madev.portfolio.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.packt.madev.R;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<StockPortfolioItem> list;

    public void setItems(List<StockPortfolioItem> items) {
        this.list.clear();
        this.list.addAll(items);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.portfolio_item_symbol)
        public TextView symbol;

        @BindView(R.id.portfolio_item_date)
        public TextView date;

        @BindView(R.id.portfolio_item_share_count)
        public TextView shareCount;

        @BindView(R.id.portfolio_item_last_price)
        public TextView lastPrice;

        @BindView(R.id.portfolio_item_value)
        public TextView value;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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
        StockPortfolioItem item = list.get(position);
        holder.symbol.setText(item.getSymbol());
        holder.date.setText(toText(item.getDateAdded()));
        holder.lastPrice.setText(toText(item.getLastPrice()));
        holder.shareCount.setText(toText(item.getShareCount()));
        holder.value.setText(toText(item.getValue()));
    }

    String toText(Date date) {
        if (date == null) {
            return "";
        }

        return date.toGMTString();
    }

    String toText(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "N/A";
        }

        return bigDecimal.toPlainString();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}