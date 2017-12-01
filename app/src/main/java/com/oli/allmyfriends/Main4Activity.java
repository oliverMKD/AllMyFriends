package com.oli.allmyfriends;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main4Activity extends AppCompatActivity {
    @BindView(R.id.kopcezakonekcija)
    Button kopceKonekcija;
    @BindView(R.id.txtKonekcija)
    TextView tekstKonekcija;
    @BindView(R.id.kopceNazad)
    Button kopceNazad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.kopcezakonekcija)
    public void ResiverRegister(View view) {
        NetworkChangeReceiver receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @OnClick(R.id.kopceNazad)
    public void BackNet(View view) {
        Intent intentnetwork = new Intent();
        String networkState = tekstKonekcija.getText().toString();
        intentnetwork.putExtra("internet", networkState);
        setResult(RESULT_OK, intentnetwork);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intentnetwork = new Intent();
        String networkState = tekstKonekcija.getText().toString();
        intentnetwork.putExtra("internet", networkState);
        setResult(RESULT_OK, intentnetwork);
        finish();
    }
}
//    @Override
//    protected void onPause() {
//        if (receiver != null) {
//            unregisterReceiver(receiver);
//        }
//        super.onPause();
//    }
//}





