package com.example.gbsbadrsf.productionsequence;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbsbadrsf.R;
import com.example.gbsbadrsf.databinding.DefectinproductionrepstatusLstBinding;
import com.example.gbsbadrsf.databinding.ProductionsequenceRvBinding;
import com.example.gbsbadrsf.productionrepairstaus.ProductionrepstatusAdapter;

public class productionsequenceadapter  extends RecyclerView.Adapter<productionsequenceadapter.productionsequenceViewHolder> {
    ProductionsequenceRvBinding productionsequenceRvBinding;
    @NonNull
    @Override
    public productionsequenceadapter.productionsequenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productionsequenceRvBinding = ProductionsequenceRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new productionsequenceadapter.productionsequenceViewHolder(productionsequenceRvBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull productionsequenceadapter.productionsequenceViewHolder holder, int position) {
    if (position==0){
       productionsequenceRvBinding.productionrepair.setTextColor(Color.parseColor("#FF0000"));
       productionsequenceRvBinding.defectnameCheckBox.setTextColor(Color.parseColor("#FF0000"));
       productionsequenceRvBinding.productionnotes.setTextColor(Color.parseColor("#FF0000"));
        productionsequenceRvBinding.qcnotes.setTextColor(Color.parseColor("#FF0000"));

productionsequenceRvBinding.productionrepair.setText("Not ok");

    }
    else if (position==1){
        productionsequenceRvBinding.defectnameCheckBox.setText("2");

    }
    else {
        productionsequenceRvBinding.defectnameCheckBox.setText("3");


    }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
    class productionsequenceViewHolder extends RecyclerView.ViewHolder{

        TextView defectname,Qcnotes,Productionnotes;
        CheckBox sequence;

        public productionsequenceViewHolder(@NonNull ProductionsequenceRvBinding itemView) {
            super(itemView.getRoot());
            //defectname=itemView.productionrepair;
            //Qcnotes=itemView.qcnotes;
            //Productionnotes=itemView.productionnotes;
            //sequence=itemView.defectnameCheckBox;
        }
    }

}
