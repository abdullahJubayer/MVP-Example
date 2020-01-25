package com.example.loginmvp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.loginmvp.Model.MainActivityModelImp;
import com.example.loginmvp.Model.MainActivity_Model;
import com.example.loginmvp.Presenter.MainActivityPresenter;
import com.example.loginmvp.Presenter.MainActivityPresenterImp;
import com.example.loginmvp.R;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private EditText EBtn,PBtn;
    private ProgressBar PgBtn;
    private Button BBtn;
    private MainActivityPresenterImp presenter;
    private MainActivity_Model mainActivity_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EBtn=findViewById(R.id.eId);
        PBtn=findViewById(R.id.pId);
        BBtn=findViewById(R.id.BId);
        PgBtn=findViewById(R.id.PgID);

        mainActivity_model=new MainActivityModelImp();
        presenter=new MainActivityPresenterImp(this,mainActivity_model);


        BBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.isLogin(EBtn.getText().toString(),PBtn.getText().toString());
            }
        });
    }

    @Override
    public void progressBarVisibility(int visibility) {
        PgBtn.setVisibility(visibility);
    }

    @Override
    public void SuccessLogin(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FailesLogin(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}
