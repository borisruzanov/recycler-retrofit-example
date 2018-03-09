package com.borisruzanov.a20180308_borisruzanov_nycschools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.borisruzanov.a20180308_borisruzanov_nycschools.adapter.OnItemClickListener;
import com.borisruzanov.a20180308_borisruzanov_nycschools.adapter.SchoolAdapter;
import com.borisruzanov.a20180308_borisruzanov_nycschools.live.School;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<School> schoolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        schoolList = new ArrayList<>();

        recyclerView = findViewById(R.id.schools_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SchoolAdapter schoolAdapter = new SchoolAdapter(schoolList, setOnItemClickCallback());
        recyclerView.setAdapter(schoolAdapter);

        getSchoolData();
    }

    private OnItemClickListener.OnItemClickCallback setOnItemClickCallback(){
        OnItemClickListener.OnItemClickCallback onItemClickCallback = new OnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                School school = schoolList.get(position);
                getSupportFragmentManager().beginTransaction().replace(R.id.parent,
                        new DescriptionFragment().getInstance(school.getSatCriticalReadingAvgScore(),
                                school.getSatWritingAvgScore(), school.getSatMathAvgScore()))
                        .addToBackStack(null)
                        .commit();
            }

        };
        return onItemClickCallback;
    }

    public void getSchoolData(){
        Call<List<School>> call = SchoolApp.getSchoolApi().getData("734v-jeq5.json");
        call.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schoolList.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
