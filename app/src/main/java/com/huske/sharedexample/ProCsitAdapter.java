package com.huske.sharedexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProCsitAdapter extends RecyclerView.Adapter<ProCsitAdapter.ProductViewHolder> {
Context mCtx;
List<ProductCsit> productList;

    public ProCsitAdapter(Context mCtx, List<ProductCsit> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.csit_notice,viewGroup,false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        ProductCsit productCsit  = productList.get(i);
        productViewHolder.title.setText(productCsit.getTitle());
        productViewHolder.date.setText(productCsit.getDate());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView date;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.textViewDate);
        title=itemView.findViewById(R.id.textViewTitle);

        }



    }
    public interface onNoteClick{
        void onNoteClick(int position);
    }
}
