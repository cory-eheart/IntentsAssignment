package com.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ualr.intentsassignment.model.Contact;

import com.ualr.intentsassignment.R;

public class ContactInfoActivity extends AppCompatActivity {
    Contact c;
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info_layout);

        c = getIntent().getParcelableExtra(ContactFormActivity.CONTACT_INFO);

        TextView name = findViewById(R.id.name_tv);
        name.setText(c.getFullName());

        TextView phone = findViewById(R.id.info_phone_tv);
        phone.setText(c.getPhoneNumber());

        TextView email = findViewById(R.id.info_email_tv);
        email.setText(c.getEmailAddress());

        TextView address = findViewById(R.id.info_map_tv);
        address.setText(c.getAddress());

        TextView web = findViewById(R.id.info_web_tv);
        web.setText(c.getWebsite());
    }
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    public void callNumber(View view){
        String number = "tel:" + c.getPhoneNumber();
        Uri dial = Uri.parse(number);
        Intent intent = new Intent(Intent.ACTION_DIAL, dial);
        startActivity(intent);
    }
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    public void sendText(View view){
        String number = "smsto:" + c.getPhoneNumber();
        Uri text = Uri.parse(number);
        Intent intent = new Intent(Intent.ACTION_SENDTO, text);
        startActivity(intent);
    }
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    public void openMaps(View view){
        Uri address = Uri.parse("geo:0,0?q=" + Uri.encode(c.getAddress()));
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    public void sendEmail(View view){
        String mail = "mailto:" + c.getEmailAddress();
        Uri email = Uri.parse(mail);
        Intent intent = new Intent(Intent.ACTION_SENDTO, email);
        startActivity(intent);
    }
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
    public void openWeb(View view){
        Uri web = Uri.parse("googlechrome://navigate?url=" + c.getWebsite());
        Intent intent = new Intent(Intent.ACTION_VIEW, web);
        startActivity(intent);
    }
}
