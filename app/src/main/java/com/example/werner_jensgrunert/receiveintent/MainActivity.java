package com.example.werner_jensgrunert.receiveintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String content;
    private Uri data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();


        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        if ("text/plain".equals(type)) {
            content = intent.toString();
            data = intent.getData();
            textView.append("\n Type: "+type+"\n Action: "+action+"\n Content: "+content+intent.getDataString());
        } else {
            content = intent.getDataString();
            data = intent.getData();
            if (content != null){
                String s[] = content.split(":|,|\\?");
                textView.append("\n Type: "+type+"\n Action: "+action+"\n Content: "+content+data+"\n split: "+s[1]+" "+s[2]);
            }
        }

    }
}
