package com.zafproject.mvpdesignpatern.utama;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zafproject.mvpdesignpatern.R;
import com.zafproject.mvpdesignpatern.model.ResultModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// presenter , model, view

public class MainActivity extends AppCompatActivity implements MainView{
    //main acitivty butuh metod eror

    public  static final  String STATE= "STATE";
    //sebagai key untuk menjaga datanya

    @BindView(R.id.inputan_a)
    EditText inputanA;
    @BindView(R.id.inputan_b)
    EditText inputanB;
    @BindView(R.id.btn_calculate)
    Button btnCalculate;
    @BindView(R.id.tv_result)
    TextView tvResult;


//5 deklarasi prsenter 
    
     MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        //6 inisialisasi
        
        initPresenter();
        //onAttachView;

        // jaga datanya  ketika orientation change
        if (savedInstanceState!= null){
            String result =savedInstanceState.getString(STATE);
            tvResult.setText(result);
        }
    }

    private void initPresenter() {
        presenter = new MainPresenter();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString(STATE, tvResult.getText().toString().trim());
    }


    @OnClick(R.id.btn_calculate)
    public void onViewClicked() {
        String penampungA = inputanA.getText().toString().trim();
        String pennampungB = inputanB.getText().toString().trim();
        presenter.itung(penampungA,pennampungB);

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);

    }

    @Override
    public void onDetachView() {
        presenter.onDettach();

    }

    @Override
    protected void onStart() {
        onAttachView();
        super.onStart();
    }

    @Override
    protected void onStop() {
        onDetachView();
        super.onStop();
    }

    @Override
    public void Success(ResultModel dataModel) {
        tvResult.setText(dataModel.getResult());


    }

    @Override
    public void Error() {
        Toast.makeText(this, R.string.empty, Toast.LENGTH_SHORT).show();
    }
}


//menghubungkan view ke presenter