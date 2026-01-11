package com.example.light_control;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.light_control.R;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity4 extends AppCompatActivity {
    private Button btnlogout;
    private TextView nhietdoTextView;
    private TextView mq2TextView;
    private TextView humidityTextView;
    private TextView muccanhbao;
    private SeekBar thanhcanhbao;
//    private boolean isbtnwnOn = true;
////  private boolean isOn = true;
//    private boolean isOn2 = true;
//    private boolean isOn3 = true;
//    private boolean isOn4 = true;
    private boolean[] isOn = {false,false, false, false,false};
//    final boolean[] isbtnOn = {false,false,false,false};
//    boolean isbtnwnOn = false;
//    boolean isbtnwnOn1 = false;
//    boolean isbtnwnOn2 = false;
//    boolean isbtnwnOn3 = false;
//    boolean isbtnwnOn4 = false;

    boolean isFirebaseUpdate = false;
    boolean isFirebaseUpdate1 = false;
    boolean isFirebaseUpdate2 = false;
    boolean isFirebaseUpdate3 = false;
    boolean isFirebaseUpdate4 = false;

    private ImageButton btnwarning;
    private ImageButton relay1;
    private ImageButton relay2;
    private ImageButton relay3;
    private ImageButton relay4;
    DatabaseReference btnwarningdata;
    DatabaseReference sw1data;
    DatabaseReference sw2data;
    DatabaseReference sw3data;
    DatabaseReference sw4data;
    DatabaseReference thanhcanhbao_data;
    DatabaseReference nhietdodata;
    DatabaseReference gasdata;
    DatabaseReference humiditydata;
    int giatriCanhbao;
    Integer btnwrdata ;
    Integer btnwrdata1 ;
    Integer btnwrdata2 ;
    Integer btnwrdata3 ;
    Integer btnwrdata4 ;
//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btnlogout=findViewById(R.id.btnlogout);
        muccanhbao=findViewById(R.id.muccanhbao);
        thanhcanhbao=findViewById(R.id.thanhcanhbao);

        btnwarning = findViewById(R.id.buttonwarning);
        relay1 = findViewById(R.id.Relay1);
        relay2 = findViewById(R.id.Relay2);
        relay3 = findViewById(R.id.Relay3);
        relay4 = findViewById(R.id.Relay4);
        nhietdoTextView=findViewById(R.id.nhietdoTextView);
        mq2TextView = findViewById(R.id.mq2TextView);
        humidityTextView = findViewById(R.id.humidityTextView);

        thanhcanhbao_data=FirebaseDatabase.getInstance().getReference().child("MUC CANH BAO");
        btnwarningdata=FirebaseDatabase.getInstance().getReference().child("BUTTONWARNING");
        sw1data=FirebaseDatabase.getInstance().getReference().child("SWT 1");
        sw2data=FirebaseDatabase.getInstance().getReference().child("SWT 2");
        sw3data=FirebaseDatabase.getInstance().getReference().child("SWT 3");
        sw4data=FirebaseDatabase.getInstance().getReference().child("SWT 4");
///nhom12@gmail.com ///1234567

        //BUTTONWARNING
        btnwarningdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    isFirebaseUpdate = true;
                    btnwrdata = snapshot.getValue(Integer.class);
                    isOn[4] = (btnwrdata != null && btnwrdata == 1 );
                    btnwarning.setSelected(isOn[4]);
                } else {
                    isOn[4] = false;
                    btnwarning.setSelected(isOn[4]);
                }
            }
            public void onCancelled(@NonNull DatabaseError error) {
                //NOP
            }
        });
        btnwarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn[4]) {
                    btnwarning.setSelected(isOn[4]);
                    btnwarningdata.setValue(0);
                    isOn[4] = false;
                } else {
                    btnwarning.setSelected(isOn[4]);
                    btnwarningdata.setValue(1);
                    isOn[4] = true;
                }
            }
        });
        //RELAY1
        sw1data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    isFirebaseUpdate1 = true;
                    btnwrdata1 = snapshot.getValue(Integer.class);
                    isOn[0] = (btnwrdata1 != null && btnwrdata1 == 1);
                    relay1.setSelected(isOn[0]);
                }else {
                    isOn[0] = false;
                    relay1.setSelected(isOn[0]);
                }
            }
            public void onCancelled(@NonNull DatabaseError error) {
                //NOP
            }
        });
        relay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn[0]) {
                    relay1.setSelected(isOn[0]);
                    sw1data.setValue(0);
                    isOn[0] = false;
                } else {
                    relay1.setSelected(isOn[0]);
                    sw1data.setValue(1);
                    isOn[0] = true;
                }
//                isbtnOn[0] = !isbtnOn[0];
//                relay1.setSelected(isbtnOn[0]);
            }
        });
        //RELAY2
        sw2data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    isFirebaseUpdate2 = true;
                    btnwrdata2 = snapshot.getValue(Integer.class);
                    isOn[1] = (btnwrdata2 != null && btnwrdata2 == 1);
                    relay2.setSelected(isOn[1]);
                }else {
                    isOn[1] = false;
                    relay2.setSelected(isOn[1]);
                }
            }
            public void onCancelled(@NonNull DatabaseError error) {
                //NOP
            }
        });
        relay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn[1]) {
                    relay2.setSelected(isOn[1]);
                    sw2data.setValue(0);
                    isOn[1] = false;
                } else {
                    relay2.setSelected(isOn[1]);
                    sw2data.setValue(1);
                    isOn[1] = true;
                }
            }
        });
        //RELAY3
        sw3data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    isFirebaseUpdate3 = true;
                    btnwrdata3 = snapshot.getValue(Integer.class);
                    isOn[2] = (btnwrdata3 != null && btnwrdata3 == 1);
                    relay3.setSelected(isOn[2]);
                }else {
                    isOn[2] = false;
                    relay3.setSelected(isOn[2]);
                }

            }
            public void onCancelled(@NonNull DatabaseError error) {
                //NOP
            }
        });
        relay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn[2]) {
                    relay3.setSelected(isOn[2]);
                    sw3data.setValue(0);
                    isOn[2] = false;
                } else {
                    relay3.setSelected(isOn[2]);
                    sw3data.setValue(1);
                    isOn[2] = true;
                }
//                isbtnOn[2] = !isbtnOn[2];
//                relay3.setSelected(isOn[2]);
            }
        });
        //RELAY4
        sw4data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    isFirebaseUpdate4 = true;
                    btnwrdata4 = snapshot.getValue(Integer.class);
                    isOn[3] = (btnwrdata4 != null && btnwrdata4 == 1);
                    relay4.setSelected(isOn[3]);
                }else {
                    isOn[3] = false;
                    relay4.setSelected(isOn[3]);
                }

            }
            public void onCancelled(@NonNull DatabaseError error) {
                //NOP
            }
        });
        relay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn[3]) {
                    relay4.setSelected(isOn[3]);
                    sw4data.setValue(0);
                    isOn[3] = false;
                } else {
                    relay4.setSelected(isOn[3]);
                    sw4data.setValue(1);
                    isOn[3] = true;
                }
//                isbtnOn[3] = !isbtnOn[3];
//                relay4.setSelected(isOn[3]);
            }
        });
        //SEEKBARCANHBAO
        thanhcanhbao_data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    giatriCanhbao = snapshot.getValue(Integer.class);
                    isFirebaseUpdate = true;
                    thanhcanhbao.setProgress(giatriCanhbao);
                    muccanhbao.setText(giatriCanhbao + "Ppm");
                }
            }
            public void onCancelled(@NonNull DatabaseError error) {
                //NOP
            }
        });
        //SEEKBARCANHBAO
        thanhcanhbao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (!isFirebaseUpdate) {
                    thanhcanhbao_data.setValue(i);
                    muccanhbao.setText(i + "Ppm");
                }
                isFirebaseUpdate = false;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        //DHT11
        nhietdodata=FirebaseDatabase.getInstance().getReference();
        final ValueEventListener nd_dht11 = nhietdodata.child("ND DHT11").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                nhietdoTextView.setText(snapshot.getValue().toString() + "\u00B0C");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        //GAS
        gasdata = FirebaseDatabase.getInstance().getReference();
        final ValueEventListener gas_value = gasdata.child("KHI GAS").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mq2TextView.setText(snapshot.getValue().toString() + "Ppm");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        //HUMIDITY
        humiditydata = FirebaseDatabase.getInstance().getReference();
        final ValueEventListener humidity_value = humiditydata.child("HUMIDITY").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                humidityTextView.setText(snapshot.getValue().toString() + "\u0025");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        // xu ly nut logout
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
///////////////
    }

}