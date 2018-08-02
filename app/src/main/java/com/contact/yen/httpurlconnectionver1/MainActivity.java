package com.contact.yen.httpurlconnectionver1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserTask.onLoadDataFinishedListener {
    private RecyclerView mRecyclerView;
    public static final String END_POINT_URL = "https://api.github.com/users/google/repos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        new UserTask(this).execute(END_POINT_URL);
    }

    @Override
    public void onLoadDataFinished(List<User> users) {
        UserAdapter userAdapter = new UserAdapter(users, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(userAdapter);
    }
}
