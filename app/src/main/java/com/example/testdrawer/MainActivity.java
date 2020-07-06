package com.example.testdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    DatabaseHelper db;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    ArrayList<Itemmenu> arrayList;
    Menuadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        actionBar();
        acctionmenu();
        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.edit1);
        e2=(EditText)findViewById(R.id.edit2);
        b2=(Button)findViewById(R.id.bu2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });
        b1=(Button)findViewById(R.id.bu1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                boolean chkemailpassword=db.emailpassword(email,password);
                if(chkemailpassword==true)
                    //Neu dung chuuyen sang man hinh chinh
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void anhXa()
    {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView=(NavigationView)findViewById(R.id.navigationView);
        listView=(ListView)findViewById(R.id.listview);
    }
    private void actionBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void acctionmenu()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new Itemmenu("import",R.drawable.ic_baseline_menu_book_24));
        arrayList.add(new Itemmenu("Chủ đề",R.drawable.ic_baseline_storefront_24));
        arrayList.add(new Itemmenu("Người dùng",R.drawable.ic_baseline_supervised_user_circle_24));
        arrayList.add(new Itemmenu("Trợ giúp",R.drawable.ic_baseline_menu_book_24));
        arrayList.add(new Itemmenu("Cài đặt",R.drawable.ic_baseline_control_point_24));
        adapter= new Menuadapter(this,R.layout.dong_item,arrayList);
        listView.setAdapter(adapter);
    }

}