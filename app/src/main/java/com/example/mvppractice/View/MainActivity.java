package com.example.mvppractice.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvppractice.Model.Model;
import com.example.mvppractice.Model.ModelImplementation;
import com.example.mvppractice.Presenter.MainActivityPresenterImplementation;
import com.example.mvppractice.Presenter.Presenter;
import com.example.mvppractice.R;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private ListView listView;
    private ProgressBar progressBar;
    private Model model;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        progressBar=findViewById(R.id.progressBarID);

        model=new ModelImplementation();
        presenter=new MainActivityPresenterImplementation(this,model);

        presenter.getCityList();


    }

    @Override
    public void progressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void fetchListSuccess(List<String> cityList) {
            ArrayAdapter cityAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,cityList);
            listView.setAdapter(cityAdapter);

    }

    @Override
    public void fetchListFailer(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
    }
}
