package com.oli.allmyfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.slikaprva)
    ImageView slikaPrvo;
    @BindView(R.id.kopceLOGIN)
    Button kopceLogIn;
    @BindView(R.id.kopceGUEST)
    Button kopcegostin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       slikaPrvo.setImageResource(R.drawable.ic_launcher);

    }

    @OnClick(R.id.kopceLOGIN)
    public void onClick(View view) {
        Intent intent1 = new Intent(this, Main2Activity.class);
        startActivity(intent1);
    }

    @OnClick(R.id.kopceGUEST)
    public void Klik(View view) {
        Intent intent2 = new Intent(MainActivity.this, Main3Activity.class);
        UserDetails guestuser = new UserDetails("", "", "Guest", 'M');
        intent2.putExtra("Guest", guestuser);
        startActivity(intent2);


    }

}
