 package com.example.thirdmonth_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {
private EditText et_email,et_theme,et_massage;
private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email=findViewById(R.id.et_mail);
        et_theme=findViewById(R.id.et_theme);
        et_massage=findViewById(R.id.et_massage);
        btn_send=findViewById(R.id.btn_one);
        btn_send.setOnClickListener(view -> {
            String email = et_email.getText().toString();
            String theme = et_theme.getText().toString();
            String massage = et_massage.getText().toString();

            setSend(email,theme,massage);

        });
        String email=et_email.getText().toString();
        String theme = et_theme.getText().toString();
        String massage = et_massage.getText().toString();

        setSend(email,theme,massage);
    }

     private void setSend(String email, String theme, String massage) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,email);
        intent.putExtra(Intent.EXTRA_SUBJECT,theme);
        intent.putExtra(Intent.EXTRA_TEXT,massage);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"send"));

     }
 }