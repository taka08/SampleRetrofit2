package com.taka08.takashi.sampleretrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.taka08.takashi.sampleretrofit2.rest.Pojo.CheckerPojo;
import com.taka08.takashi.sampleretrofit2.rest.RestManager;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView response_text;
    private Button check_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        response_text = (TextView)findViewById(R.id.responseText);
        check_button = (Button)findViewById(R.id.checkButton);

        check_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                serverChecker();
            }
        });
    }

    private void serverChecker(){
        RestManager restManager = new RestManager();
        restManager.serverCheck(new Callback<CheckerPojo>() {
            @Override
            public void onResponse(retrofit2.Call<CheckerPojo> call, Response<CheckerPojo> response) {
                if(response.code() == 200) {
                    response_text.setText("200");
                }
                else {
                    response_text.setText("500");
                }
            }
            @Override
            public void onFailure(retrofit2.Call<CheckerPojo> call, Throwable t) {
            }
        });
    }
}
