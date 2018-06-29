package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private Button updateContact, deleteContact;
    private EditText nameField, businessNumberField, primaryBusinessField, addressField, provinceField;
    private MyApplicationData appState;
    Contact receivedPersonInfo;

    /**
     * Creates a new business contact and stores it into the database when the button is clicked
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        businessNumberField = (EditText) findViewById(R.id.number);
        primaryBusinessField = (EditText) findViewById(R.id.business);
        provinceField = (EditText) findViewById(R.id.province);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        deleteContact = (Button) findViewById(R.id.deleteButton);
        updateContact = (Button) findViewById(R.id.updateButton);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            businessNumberField.setText(receivedPersonInfo.businessNumber);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    /**
     * Modifies a business contact from the database when the button is clicked
     * @param v
     */
    public void updateContact(View v)
    {
        //TODO: Update contact functionality
        updateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receivedPersonInfo.name = nameField.getText().toString();
                receivedPersonInfo.businessNumber = businessNumberField.getText().toString();
                receivedPersonInfo.primaryBusiness = primaryBusinessField.getText().toString();
                receivedPersonInfo.address = addressField.getText().toString();
                receivedPersonInfo.province = provinceField.getText().toString();
                appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);

                finish();
            }
        });
    }

    /**
     * Deletes a business contact from the database when the button is clicked
     * @param v
     */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

                finish();
            }
        });

    }
}
