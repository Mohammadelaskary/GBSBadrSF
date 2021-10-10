package com.example.gbsbadrsf.Quality.manfacturing.qualityrepair;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbsbadrsf.Production.ProductionrepairAdapter;
import com.example.gbsbadrsf.databinding.DefectlistinqualityrepairBinding;
import com.example.gbsbadrsf.databinding.DefectqtnsLstBinding;
import com.example.gbsbadrsf.databinding.QcnotesLstBinding;

import org.w3c.dom.Text;

public class qualityrepairAdapter extends RecyclerView.Adapter<qualityrepairAdapter.qualityrepairViewHolder> {

    DefectlistinqualityrepairBinding defectlistinqualityrepairBinding;
    @NonNull
    @Override
    public qualityrepairAdapter.qualityrepairViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        defectlistinqualityrepairBinding = DefectlistinqualityrepairBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new qualityrepairAdapter.qualityrepairViewHolder(defectlistinqualityrepairBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull qualityrepairAdapter.qualityrepairViewHolder holder, int position) {
        if (position==0){


            defectlistinqualityrepairBinding.defectnameCheckBox.setText("Defect 1");

        }
        else if (position==1){
            defectlistinqualityrepairBinding.defectnameCheckBox.setText("Defect 2");

        }
        else {
            defectlistinqualityrepairBinding.defectnameCheckBox.setText("Defect 3");


        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
    class qualityrepairViewHolder extends RecyclerView.ViewHolder{

       TextView defectchecbox,child,defectqty,repairedqty,approvedqty,notes;

        public qualityrepairViewHolder(@NonNull DefectlistinqualityrepairBinding itemView) {
            super(itemView.getRoot());
            defectchecbox=itemView.defectnameCheckBox;
            child=itemView.child;
            defectqty=itemView.defectqty;
            repairedqty=itemView.repairedqty;
            approvedqty=itemView.approvedqty;
            notes=itemView.notes;
        }
    }

}


