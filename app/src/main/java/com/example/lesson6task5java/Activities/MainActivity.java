package com.example.lesson6task5java.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.lesson6task5java.Adapters.RecyclerAdapter;
import com.example.lesson6task5java.R;
import com.example.lesson6task5java.module.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<User> users = prepareUserList();
        refreshAdapter(users);
    }
    void initView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }
    private void refreshAdapter(List<User> users){
        RecyclerAdapter adapter = new RecyclerAdapter(context, users);
        recyclerView.setAdapter(adapter);
    }

    private List<User> prepareUserList(){
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            if (i == 0 || i == 5 || i == 10 || i == 15 || i == 20){
                users.add(new User("Nick" + i, "Johnson",false));
            }
            else {
                users.add(new User("Nick" + i, "Johnson" ,true));

            }
        }
        return users;
    }
}