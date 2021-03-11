package com.example.projectnavernews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tv_rank, tv_title, tv_content, tv_link;
    private TextView tv_keyword;
    private EditText et_search;
    private Button btn_search;
//    String[][] result_data = new String[20][3];
    int rank = 1;

    private ArrayList<ResultData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

//    List<Items> items = new ArrayList<>();
    private NaverNewsApi naverNewsApi;

    int display = 20; // 보여지는 검색결과의 수
    String sort = "date"; // 날짜순으로 정렬

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_rank = (TextView)findViewById(R.id.tv_rank);
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_content = (TextView)findViewById(R.id.tv_content);
        tv_link = (TextView)findViewById(R.id.tv_link);

        et_search = (EditText)findViewById(R.id.et_search);

        recyclerView = (RecyclerView)findViewById(R.id.rv_result);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        btn_search = (Button)findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        et_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if( (keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    search();
                    return true;
                }
                return false;
            }
        });
    }

    public void search() {
        // 초기화
        rank = 1;
        arrayList.clear();

        String keyword = et_search.getText().toString();
        tv_keyword = (TextView)findViewById(R.id.tv_keyword);
        tv_keyword.setText("검색어 : "+keyword);
        tv_keyword.setVisibility(View.VISIBLE);

        String clientID = "AINAdj8QhDDClfeZPneY";
        String clientSecret = "DM8CS94a1s";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(naverNewsApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        naverNewsApi = retrofit.create(NaverNewsApi.class);

        Call<Result> call = naverNewsApi.getItems(clientID, clientSecret,keyword, display, sort);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "키워드를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                Result result = response.body();
                List<Items> items = result.getItems();

                for(Items item : items) {
//                            .replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "")
                    String title = item.getTitle().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "").replace("&quot;","");
                    String description  = item.getDescription().replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "").replace("&quot;","");
                    String link = item.getLink();
                    ResultData resultData = new ResultData(String.valueOf(rank), title, description, link);
                    arrayList.add(resultData);
                    mainAdapter.notifyDataSetChanged();
                    rank++;
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        et_search.setText("");
    }
}