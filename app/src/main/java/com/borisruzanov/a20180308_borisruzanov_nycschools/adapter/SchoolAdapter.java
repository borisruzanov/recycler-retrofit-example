package com.borisruzanov.a20180308_borisruzanov_nycschools.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.borisruzanov.a20180308_borisruzanov_nycschools.OnItemClickListener;
import com.borisruzanov.a20180308_borisruzanov_nycschools.R;
import com.borisruzanov.a20180308_borisruzanov_nycschools.models.School;

import java.util.List;

/**
 * Created by Boris on 3/8/2018.
 */

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder>{

    //Adapter for a recycler view
    private List<School> schoolList;
    OnItemClickListener.OnItemClickCallback onItemClickCallback;

    public SchoolAdapter(List<School> schoolList,
                         OnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.schoolList = schoolList;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        School school = schoolList.get(position);
        holder.name.setText(school.getSchoolName());
        holder.container.setOnClickListener(new OnItemClickListener(position,onItemClickCallback));
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.school_container);
            name = itemView.findViewById(R.id.school_name);
        }
    }

}
