package com.example.quickmart;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;

public class Feedback extends AppCompatActivity {

private Firebase Ref;
private EditText username,feedback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //find the username and feedback by their id
        username= (EditText) findViewById(R.id.username);
        feedback= (EditText) findViewById(R.id.Feedback);
        Firebase.setAndroidContext(this);
        Ref=new Firebase("https://quickmart-4da66.firebaseio.com/");

    }


    /**
     * @author Sukhmanjot
     * @param view

     * this is the onclick listener for feedbackSent
     *
     * when the users will add their username and feedback it will be saved
     */
    public void FeedbackSent(View view) {
      String usernameinput= username.getText().toString();
      String feedbackinput= feedback.getText().toString();
      Firebase Reusername=Ref.child("Username");
      Reusername.setValue(usernameinput);
      Firebase Reffeedback=Ref.child("Feedback");
      Reffeedback.setValue(feedbackinput);

    }
}