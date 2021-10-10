package com.example.gbsbadrsf.Quality.manfacturing.qualitydesicion;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbsbadrsf.Quality.manfacturing.qualityrepair.qualityrepairAdapter;
import com.example.gbsbadrsf.databinding.DefectlistinqualityrepairBinding;
import com.example.gbsbadrsf.databinding.DefectqtnsLstBinding;

public class qualitydesicionAdapter extends RecyclerView.Adapter<qualitydesicionAdapter.qualitydesicionViewHolder> {
    DefectqtnsLstBinding defectqtnsLstBinding;

    @NonNull
    @Override
    public qualitydesicionAdapter.qualitydesicionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        defectqtnsLstBinding = DefectqtnsLstBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new qualitydesicionAdapter.qualitydesicionViewHolder(defectqtnsLstBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull qualitydesicionAdapter.qualitydesicionViewHolder holder, int position) {
        if (position==0){


            defectqtnsLstBinding.defectname.setText("Defect 1");

        }
        else if (position==1){
            defectqtnsLstBinding.defectname.setText("Defect 2");

        }
        else {
            defectqtnsLstBinding.defectname.setText("Defect 3");


        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
    class qualitydesicionViewHolder extends RecyclerView.ViewHolder{

        TextView defectname,sampleqty,defectqty,repairedqty,approvedqty;

        public qualitydesicionViewHolder(@NonNull DefectqtnsLstBinding itemView) {
            super(itemView.getRoot());
            defectname=itemView.defectname;
            sampleqty=itemView.sampleqty;
            defectqty=itemView.defectqty;
            repairedqty=itemView.repairedqty;
            approvedqty=itemView.approvedqty;



        }
    }

}


