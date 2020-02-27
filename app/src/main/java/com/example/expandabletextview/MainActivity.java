package com.example.expandabletextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ApiReference apiReference;
    private  List<Article> articles = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitiateApiProcess();
        getArticlesDetails();

//        Articles e = new Articles();
//        List<String>ab= new ArrayList<>();
//        ab.add("fadfa");
//        e.setAbstract(ab);
//        e.setDate("fafasda");
//        e.setTitle("fdafdfdsfda");
//        e.setScore((float) 1.2);
//        for(i=0;i<4;i++)
//        articles.add(e);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(articles,this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void getArticlesDetails() {
        Call<InitialApiBody> call = apiReference.getArticles();

        call.enqueue(new Callback<InitialApiBody>() {
            @Override
            public void onResponse(Call<InitialApiBody> call, Response<InitialApiBody> response) {
                if(response.isSuccessful())
                {
                    InitialApiBody initialApiBody = (InitialApiBody)response.body();
                    Responses responses1 = (Responses) initialApiBody.getResponse();
                    List<Article> docs = responses1.getDocs();
                    recyclerViewAdapter.setArticleList(docs);

                    Log.d("hello", String.valueOf(articles.size()));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failure while requesting token", Toast.LENGTH_LONG).show();
                    Log.d("RequestTokenCallback", "Code: " + response.code() + "Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<InitialApiBody> call, Throwable t) {
                Log.d("fail", "error", t);
            }
        });
    }

    private void InitiateApiProcess() {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.plos.org/")
                .addConverterFactory( GsonConverterFactory.create(gson) )
                .build();

        apiReference = retrofit.create(ApiReference.class);
    }


}
