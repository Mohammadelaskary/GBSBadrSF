package com.example.gbsbadrsf.Quality.manfacturing.productionscraprequest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbsbadrsf.Util.OnClick;
import com.example.gbsbadrsf.databinding.ProductionscrapLstBinding;
import com.example.gbsbadrsf.databinding.QualityscrapLstBinding;
import com.example.gbsbadrsf.qualityscrap.qualityscraplistadapter;

public class productionscraplistAdapter extends RecyclerView.Adapter<productionscraplistAdapter.productionscraplistViewHolder> {
    ProductionscrapLstBinding productionscrapLstBinding;
    final OnClick onClick;

    public productionscraplistAdapter(OnClick onClick) {
        this.onClick = onClick;
    }
    @NonNull
    @Override
    public productionscraplistAdapter.productionscraplistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productionscrapLstBinding = ProductionscrapLstBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new productionscraplistAdapter.productionscraplistViewHolder(productionscrapLstBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull productionscraplistAdapter.productionscraplistViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.OnItemClickedListener(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }
    class productionscraplistViewHolder extends RecyclerView.ViewHolder{
        TextView jobordernametxt,jobordername,Deptxt,Dep,operationtxt,operation,scrapquantitytxt,scrapquantity;

        public productionscraplistViewHolder(@NonNull  ProductionscrapLstBinding itemView) {
            super(itemView.getRoot());
            jobordernametxt=itemView.jobordernumTxt;
            jobordername=itemView.jobordername;
            Deptxt=itemView.depTxt;
            Dep=itemView.department;
            operationtxt=itemView.operationTxt;
            operation=itemView.operation;
            scrapquantitytxt=itemView.scrapqtnTxt;
            scrapquantity=itemView.scrapqtn;







        }
    }

}
