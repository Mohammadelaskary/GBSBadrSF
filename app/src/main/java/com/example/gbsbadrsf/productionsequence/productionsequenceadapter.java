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
import com.example.gbsbadrsf.data.response.Ppr;
import com.example.gbsbadrsf.databinding.DefectinproductionrepstatusLstBinding;
import com.example.gbsbadrsf.databinding.ProductionsequenceRvBinding;
import com.example.gbsbadrsf.productionrepairstaus.ProductionrepstatusAdapter;

import java.util.ArrayList;
import java.util.List;

public class productionsequenceadapter  extends RecyclerView.Adapter<productionsequenceadapter.productionsequenceViewHolder> {
    //ProductionsequenceRvBinding productionsequenceRvBinding;
    private List<Ppr> Productionsequenceresponse;
    public productionsequenceadapter(List<Ppr> productionsequenceresponse) {
        this.Productionsequenceresponse = productionsequenceresponse;
    }
    public void getproductionsequencelist(List<Ppr> productionsequencelst){
        Productionsequenceresponse.clear();
        Productionsequenceresponse.addAll(productionsequencelst);
        notifyDataSetChanged();
    }
  

    @NonNull
    @Override
    public productionsequenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductionsequenceRvBinding productionsequenceRvBinding = ProductionsequenceRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new productionsequenceadapter.productionsequenceViewHolder(productionsequenceRvBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull productionsequenceadapter.productionsequenceViewHolder holder, int position) {
//    if (position==0){
//       productionsequenceRvBinding.productionrepair.setTextColor(Color.parseColor("#FF0000"));
//       productionsequenceRvBinding.defectnameCheckBox.setTextColor(Color.parseColor("#FF0000"));
//       productionsequenceRvBinding.productionnotes.setTextColor(Color.parseColor("#FF0000"));
//        productionsequenceRvBinding.qcnotes.setTextColor(Color.parseColor("#FF0000"));
//
//productionsequenceRvBinding.productionrepair.setText("Not ok");
//
//    }
//    else if (position==1){
//        productionsequenceRvBinding.defectnameCheckBox.setText("2");
//
//    }
//    else {
//        productionsequenceRvBinding.defectnameCheckBox.setText("3");
//
//
//    }
        holder.sequencenumber.setText(Productionsequenceresponse.get(position).getLoadingSequenceNumber().toString());
        holder.childdesc.setText(Productionsequenceresponse.get(position).getChildDescription());
        holder.loadingqty.setText(Productionsequenceresponse.get(position).getLoadingQty().toString());
        holder.status.setText(Productionsequenceresponse.get(position).getLoadingSequenceStatus().toString());
    }

    @Override
    public int getItemCount() {
        return Productionsequenceresponse.size();
    }
    class productionsequenceViewHolder extends RecyclerView.ViewHolder{
        CheckBox sequencenumber;

        TextView childdesc,loadingqty,status;

        public productionsequenceViewHolder(@NonNull ProductionsequenceRvBinding itemView) {
            super(itemView.getRoot());
            sequencenumber=itemView.sequencenumCheckBox;
            childdesc=itemView.childdesc;
            loadingqty=itemView.loadingqty;
            status=itemView.status;
        }
    }

}
