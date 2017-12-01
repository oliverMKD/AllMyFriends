package com.oli.allmyfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.Txtview1)
    TextView Podatoci;
    @BindView(R.id.editPrvo)
    EditText editIme;
    @BindView(R.id.editVtoro)
    EditText editPrezime;
    @BindView(R.id.editTreto)
    EditText editUser;
    @BindView(R.id.M)
    RadioButton masko;
    @BindView(R.id.F)
    RadioButton zensko;
    @BindView(R.id.kopceNEXT)
    Button kopceSledno;
    UserDetails podatoci = new UserDetails();
    char gender = 'N';
    String operacijaKopce = "";

    UserDetails useredit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
        podatoci = new UserDetails();

        Intent intenadd = getIntent();
        if (intenadd.hasExtra("Add")) {
            operacijaKopce = intenadd.getExtras().getString("Add");
        }

        Intent intent5 = getIntent();
        if (intent5.hasExtra("extraExtra")) {
            operacijaKopce = intent5.getExtras().getString("Edit");
            useredit = (UserDetails) intent5.getExtras().getSerializable("extraExtra");
            editIme.setText(useredit.getName());
            editPrezime.setText(useredit.getLastname());
            editUser.setText(useredit.getUsername());

            if (useredit.gender == 'M') {
                masko.setChecked(true);
            } else {
                zensko.setChecked(true);
            }

        }
        }



    @OnClick ({R.id.M,R.id.F})
    public void RadioKlik(RadioButton radioButton){
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()){
            case R.id.M:
                if (checked){
                    gender ='M';
                }break;
            case R.id.F:
                if (checked){
                    gender='F';
                }
        }
    }

    @OnClick(R.id.kopceNEXT)
    public void onClick(View view) {

        if (operacijaKopce.equals("Edit")) {
            Intent intent6666 = new Intent();
            String Ime = editIme.getText().toString();
            String Prezime = editPrezime.getText().toString();
            String User = editUser.getText().toString();
            useredit = new UserDetails(Ime, Prezime, User, gender);
            Intent intent88 = intent6666.putExtra("Edit", (Serializable) useredit);
            setResult(RESULT_OK, intent88);
            finish();

        } else if (operacijaKopce.equals("Add")){
            Intent intent6667 = new Intent();
            String Ime = editIme.getText().toString();
            String Prezime = editPrezime.getText().toString();
            String User = editUser.getText().toString();
            useredit = new UserDetails(Ime, Prezime, User, gender);
            Intent intent = intent6667.putExtra("Add", (Serializable) useredit);
            setResult(RESULT_OK, intent);
            finish();

        }

         else if(editIme.getText().length()>0 && editPrezime.getText().length()>0&&editUser.getText().length()>0) {
            podatoci.setName(editIme.getText().toString());
            podatoci.setLastname(editPrezime.getText().toString());
            podatoci.setUsername(editUser.getText().toString());
            podatoci.setGender(gender);
            Intent intent2 = new Intent(this, Main3Activity.class);
            intent2.putExtra("EXTRA", (Serializable) podatoci);
            startActivity(intent2);
        }

    }
}
