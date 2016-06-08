package com.example.neven.xml_parsing_0806;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import dataFromServer.note;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText to;
    EditText from;
    EditText body;
    EditText heading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        to = (EditText) findViewById(R.id.etToOutputID);
        from = (EditText) findViewById(R.id.etFromOutputID);
        body = (EditText) findViewById(R.id.etBodyOutputID);
        heading = (EditText) findViewById(R.id.etHeadingOutputID);

        getRemoteData();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_getdata) {





        }

        return super.onOptionsItemSelected(item);
    }

    public void getRemoteData() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.w3schools.com/xml/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        RestApi restAPI = retrofit.create(RestApi.class);
        Call<note> call = restAPI.getData();
        call.enqueue(new Callback<note>() {
            @Override
            public void onResponse(Call<note> call, Response<note> response) {

                try {

                    String textFromTo=response.body().getTo();
                    String textFromFrom=response.body().getFrom();
                    String textFromBody=response.body().getBody();
                    String textFromHeading=response.body().getHeading();

                    to.setText(textFromTo);
                    from.setText(textFromFrom);
                    body.setText(textFromBody);
                    heading.setText(textFromHeading);


                } catch (Exception e) {


                    e.printStackTrace();


                }


            }

            @Override
            public void onFailure(Call<note> call, Throwable t) {

                Toast.makeText(MainActivity.this, "failed to receive data", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
