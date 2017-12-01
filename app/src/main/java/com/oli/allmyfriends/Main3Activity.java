package com.oli.allmyfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.spiner)
    Spinner mojSpiner;
    @BindView(R.id.kopceEDIT)
    Button kopceedit;
    @BindView(R.id.kopceADD)
    Button kopceadd;
    @BindView(R.id.povtorenIzbor)
    TextView izberiPol;
    @BindView(R.id.CheckPakMasko)
    RadioButton pakMasko;
    @BindView(R.id.CheckPakZensko)
    RadioButton pakZensko;
    @BindView(R.id.slikavora)
    ImageView slikaVtora;
    @BindView(R.id.ImePrezime)
    TextView imeprezime;
    @BindView(R.id.konekcija)
    TextView imakonekcija;
    @BindView(R.id.kopceProverikonekcija)
    Button proveriKonekcija;
    UserDetails podatoci = new UserDetails();
    ArrayList<UserDetails> listaUseri = new ArrayList<UserDetails>();
    UserDetails guest;
    UserDetails user;
    UserDetails selektiranUser;
    int kluc = 1000;
    int kluc2 = 1000;
    int kluc3 = 1000;
    char pol;
    String add = "Add";
    String edit = "Edit";
    ArrayAdapter<UserDetails> mojAdapter;
   UserDetails user1 = new UserDetails();
   @BindView(R.id.radiogrupa)
    RadioGroup Radiogrupa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        UserDetails podatoci = new UserDetails();

        Intent intent1 = getIntent();
        if (intent1.hasExtra("EXTRA")) {

            user = (UserDetails) intent1.getSerializableExtra("EXTRA");
            listaUseri.add(user);
        }
        Intent intent = getIntent();
        if (intent.hasExtra("Guest")) {
            guest = (UserDetails) intent.getExtras().getSerializable("Guest");
            listaUseri.add(guest);
        }
       final ArrayAdapter<UserDetails> mojAdapter = new ArrayAdapter<UserDetails>(this, android.R.layout.simple_spinner_item, listaUseri);
        mojSpiner.setAdapter(mojAdapter);

        mojSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selektiranUser = mojAdapter.getItem(position);
                pol = selektiranUser.getGender();
                String ispisi = selektiranUser.getName() + " " + selektiranUser.getLastname();
                imeprezime.setText(ispisi);
                if (pol == 'F') {
                    slikaVtora.setImageDrawable(getResources().getDrawable(R.drawable.mujer));
                } else {
                    slikaVtora.setImageDrawable(getResources().getDrawable(R.drawable.man));
                }
//
            }

            //
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @OnClick(R.id.kopceEDIT)
    public void OnClick(View view) {
        Intent intent2 = new Intent(this, Main2Activity.class);
        intent2.putExtra("extraExtra", selektiranUser);
        intent2.putExtra("Edit", edit);
        startActivityForResult(intent2, kluc);
    }

    @OnClick(R.id.kopceADD)
    public void OnKlick(View view) {
        Intent intent3 = new Intent(this, Main2Activity.class);

        intent3.putExtra("Add", add);
        startActivityForResult(intent3, kluc2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == kluc2 || resultCode == RESULT_OK && requestCode == kluc || resultCode == RESULT_OK && requestCode == 1000) {

            if (data.hasExtra("Add")) {
                UserDetails detali = (UserDetails) data.getExtras().getSerializable("Add");
                listaUseri.add(detali);
            }
            else if (data.hasExtra("Edit")) {

                UserDetails user1 = (UserDetails) data.getExtras().getSerializable("Edit");
                selektiranUser.setGender(user1.gender);
                selektiranUser.setName(user1.getName());
                selektiranUser.setLastname(user1.getLastname());
                selektiranUser.setUsername(user1.getUsername());
                String imePrezime = selektiranUser.getName() + " " + selektiranUser.getLastname();
                imeprezime.setText(imePrezime);
                pol = selektiranUser.getGender();
                final ArrayAdapter<UserDetails> mojAdapter = new ArrayAdapter<UserDetails>(this, android.R.layout.simple_spinner_item, listaUseri);
                mojSpiner.setAdapter(mojAdapter);
                if (pol == 'F') {
                    pakZensko.setChecked(true);
                    slikaVtora.setImageDrawable(getResources().getDrawable(R.drawable.mujer));
                } else {
                    pakMasko.setChecked(true);
                    slikaVtora.setImageDrawable(getResources().getDrawable(R.drawable.man));

                }
                Radiogrupa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int checked = group.getCheckedRadioButtonId();

                        switch (checked) {
                            case R.id.CheckPakMasko:
                                pol = 'M';
                                selektiranUser.setGender('M');
                                slikaVtora.setImageDrawable(getResources().getDrawable(R.drawable.man));
                                break;

                            case R.id.CheckPakZensko:
                                pol = 'F';
                                selektiranUser.setGender('F');
                                slikaVtora.setImageDrawable(getResources().getDrawable(R.drawable.mujer));
                                break;
                        }
                    }
                });
            } else if (data.hasExtra("internet")) {
                imakonekcija.setText(data.getStringExtra("internet"));
            } else {
                Toast.makeText(this, "No new users", Toast.LENGTH_SHORT).show();
            }



        }
    }
        @OnClick(R.id.kopceProverikonekcija)
        public void onKlik (View view){
            Intent intent4 = new Intent(this, Main4Activity.class);
            startActivityForResult(intent4, 1000);
        }

}