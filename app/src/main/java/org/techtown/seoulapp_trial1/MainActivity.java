package org.techtown.seoulapp_trial1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextClock;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button operationT;
    Button Road;
    Button gotoCalender;
    Button RecommendList_button;
    ImageView imageView;
    BitmapDrawable bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationT = (Button)findViewById(R.id.operationT);
        Road = (Button)findViewById(R.id.Road);
        gotoCalender = (Button)findViewById(R.id.gotoCalender);
        RecommendList_button = (Button) findViewById(R.id.RecommendList_button);
        imageView = (ImageView) findViewById(R.id.logo);

        operationT.setOnClickListener(this);
        Road.setOnClickListener(this);
        gotoCalender.setOnClickListener(this);
        RecommendList_button.setOnClickListener(this);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.logo);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    public void onClick(View view){
        if(view==operationT){
            Context mcContext = getApplicationContext();
            LayoutInflater inflater = (LayoutInflater) mcContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.operationt_popup,(ViewGroup)findViewById(R.id.popup1));
            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);

            aDialog.setTitle("운영 시간");
            aDialog.setView(layout);

            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog ad = aDialog.create();
            ad.show();
        }

        if(view==Road){
            Context mcContext = getApplicationContext();
            LayoutInflater inflater = (LayoutInflater) mcContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.road_popup,(ViewGroup)findViewById(R.id.popup2));
            AlertDialog.Builder aDialog = new AlertDialog.Builder(MainActivity.this);

            aDialog.setTitle("운영 시간");
            aDialog.setView(layout);

            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog ad = aDialog.create();
            ad.show();
        }
        if(view==gotoCalender){
            Intent intent = new Intent(this,Calender.class);
            startActivity(intent);
        }
        if(view==RecommendList_button){
            Intent intent = new Intent(this,RecommendList.class);
            startActivity(intent);
        }
    }

}

