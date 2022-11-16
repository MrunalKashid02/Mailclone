package com.example.multiscreen_mail;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

    Button SendMail;
    EditText EmailAddress, EmailBody,EmailSubject;
    //String to = "mail@gmail.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SendMail= (Button) findViewById(R.id.SendMail);
        EmailAddress= (EditText) findViewById(R.id.emailadress);
        EmailBody= (EditText) findViewById(R.id.bodyofemail);
        EmailSubject= (EditText) findViewById(R.id.emailsubject);
        SendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EmailAddress.getText().length()==0){
                    EmailAddress.setError("Required");

                }
                else if(EmailBody.getText().length()==0){
                    EmailBody.setError("Required");

                }
                else if(EmailSubject.getText().length()==0){
                    EmailSubject.setError("Required");

                }
                else{
                    Intent SendEmail= new Intent(Intent.ACTION_SEND);
                    SendEmail.setData(Uri.parse("mailto::"));
                    SendEmail.setType("text/plain");
                    SendEmail.putExtra(Intent.EXTRA_EMAIL,EmailAddress.toString());
                    SendEmail.putExtra(Intent.EXTRA_SUBJECT,EmailSubject.getText().toString());
                    SendEmail.putExtra(Intent.EXTRA_TEXT,EmailBody.getText());
                    startActivity(SendEmail);
                }


            }
        });
    }
}