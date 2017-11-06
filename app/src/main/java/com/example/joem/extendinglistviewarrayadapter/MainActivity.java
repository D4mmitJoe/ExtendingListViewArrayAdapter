package com.example.joem.extendinglistviewarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Email> emails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populates with the following data; takes in subject, summary, sender
        emails.add(new Email("Hi", "Summary 1", "bsmith1@test.com"));
        emails.add(new Email("Hiiii", "Summary 2", "bsmith2@test.com"));
        emails.add(new Email("Hello", "Summary 3", "bsmith3@test.com"));
        emails.add(new Email("Whats up?", "Summary 4", "bsmith4@test.com"));
        emails.add(new Email("Hi", "Summary 5", "bsmith5@test.com"));
        emails.add(new Email("Hi", "Summary 6", "bsmith6@test.com"));
        emails.add(new Email("Hi", "Summary 7", "bsmith7@test.com"));

        ListView listView = (ListView) findViewById(R.id.listView); //(creates/instantiates?) listView



        //to use listView(s) we need to create an adaptor
        //the adaptor needs to know what kind of layout is going to be generated for each row of the listView and where it gets data from
        //have to tell it what is the type of the object of the data we're going to present (in this case an array of 'string')
        //adaptor can take in a lot of signatures of constructors; signature we use takes in:
        //context, resource, and a list (in this cases Emails)
        EmailAdapter adapter = new EmailAdapter(this, R.layout.email_item, emails);

        listView.setAdapter(adapter);

        //if you want to respond to (color) clicks you can do the following
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //AdapterView=parent which represents the whole view, View view = view that user clicked on, position = item clicked on within color array, id=id or row itself or item clicked on
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d("demo", "Clicked item " + position);
            }
        });
    }
}