package com.ualr.intentsassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ualr.intentsassignment.model.Contact;

public class ContactFormActivity extends AppCompatActivity {
    public static final String CONTACT_INFO = "ContactInfo";
    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_form_layout);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ContactInfoActivity.class);
        Contact c = newContact();
        intent.putExtra(CONTACT_INFO, c);
        startActivity(intent);
    }

    public Contact newContact(){
        Contact c = new Contact();

        EditText firstName = (EditText) findViewById(R.id.first_name_tv);
        c.setFirstName(firstName.getText().toString());

        EditText lastName = (EditText) findViewById(R.id.last_name_tv);
        c.setLastName(lastName.getText().toString());

        EditText phone = (EditText) findViewById(R.id.phone_number_tv);
        c.setPhoneNumber(phone.getText().toString());

        EditText email = (EditText) findViewById(R.id.email_tv);
        c.setEmailAddress(email.getText().toString());

        EditText address = (EditText) findViewById(R.id.map_tv);
        c.setAddress(address.getText().toString());

        EditText website = (EditText) findViewById(R.id.website_tv);
        c.setWebsite(website.getText().toString());

        return c;
    }
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
}
