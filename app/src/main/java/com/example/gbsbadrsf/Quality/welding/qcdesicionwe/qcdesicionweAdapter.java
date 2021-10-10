package com.example.gbsbadrsf.Quality.welding.qcdesicionwe;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gbsbadrsf.Quality.paint.qcdesicionpaint.qcdesicionpaintAdapter;
import com.example.gbsbadrsf.databinding.DefectqtnsLstBinding;

public class qcdesicionweAdapter  extends RecyclerView.Adapter<qcdesicionweAdapter.qcdesicionweViewHolder> {
    DefectqtnsLstBinding defectqtnsLstBinding;

    @NonNull
    @Override
    public qcdesicionweAdapter.qcdesicionweViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        defectqtnsLstBinding = DefectqtnsLstBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new qcdesicionweAdapter.qcdesicionweViewHolder(defectqtnsLstBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull qcdesicionweAdapter.qcdesicionweViewHolder holder, int position) {
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
    class qcdesicionweViewHolder extends RecyclerView.ViewHolder{
        TextView defectname,sampleqty,defectqty,repairedqty,approvedqty;

        public qcdesicionweViewHolder(@NonNull DefectqtnsLstBinding itemView) {
            super(itemView.getRoot());
            defectname=itemView.defectname;
            sampleqty=itemView.sampleqty;
            defectqty=itemView.defectqty;
            repairedqty=itemView.repairedqty;
            approvedqty=itemView.approvedqty;
        }
    }

}
