package com.example.android.homey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by user on 03-Feb-18.
 */

public class DisplayLandlordDetailsActivity extends AppCompatActivity {

    private ImageView photoImageView;
    private TextView mName;
    private TextView mGender;
    private TextView mAddress;
    private TextView mCity;
    private TextView mState;
    private TextView mZipCode;
    private TextView mPhoneNumber;
    private TextView mEmail;
    private TextView mAvailableRooms;
    private TextView mACRooms;
    private TextView mAttachedWashrooms;
    private TextView mParking;
    private TextView mWifi;
    private TextView mDescription;
    private TextView mPrice;

    private static String Uid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_landlord_details);

        photoImageView = (ImageView) findViewById(R.id.photoImageView);
        Uid = getIntent().getExtras().getString("current_uid");
        mName = (TextView)findViewById(R.id.name_text_view);
        mGender = (TextView)findViewById(R.id.gender_text_view);
        mAddress = (TextView)findViewById(R.id.address_text_view);
        mCity = (TextView)findViewById(R.id.city_text_view);
        mState = (TextView)findViewById(R.id.state_text_view);
        mZipCode = (TextView)findViewById(R.id.zip_code_text_view);
        mPhoneNumber = (TextView)findViewById(R.id.phone_number_text_view);
        mEmail = (TextView)findViewById(R.id.email_text_view);
        mAvailableRooms = (TextView)findViewById(R.id.available_rooms_text_view);
        mACRooms = (TextView)findViewById(R.id.ac_rooms_text_view);
        mAttachedWashrooms = (TextView)findViewById(R.id.attached_washrooms_text_view);
        mParking = (TextView)findViewById(R.id.parking_text_view);
        mWifi = (TextView)findViewById(R.id.wifi_text_view);
        mDescription = (TextView)findViewById(R.id.description_text_view);
        mPrice = (TextView)findViewById(R.id.price_text_view);

        FirebaseSDKs.mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Glide.with(photoImageView.getContext()).load(dataSnapshot.child(Uid).child("user_landlord_info").child("photoUrl").getValue().toString()).into(photoImageView);
                mName.setText(dataSnapshot.child(Uid).child("user_gen_info").child("mName").getValue().toString());
                mGender.setText(dataSnapshot.child(Uid).child("user_gen_info").child("mGender").getValue().toString());
                mPhoneNumber.setText(dataSnapshot.child(Uid).child("user_gen_info").child("mPhoneNumber").getValue().toString());
                mEmail.setText(dataSnapshot.child(Uid).child("user_gen_info").child("mEmail").getValue().toString());

                mAddress.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mAddress").getValue().toString());
                mCity.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mCity").getValue().toString());
                mState.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mState").getValue().toString());
                mZipCode.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mZipCode").getValue().toString());
                mDescription.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mDescription").getValue().toString());
                mAvailableRooms.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mRooms").getValue().toString());
                mPrice.setText(dataSnapshot.child(Uid).child("user_landlord_info").child("mPrice").getValue().toString());

                if(Boolean.parseBoolean(dataSnapshot.child(Uid).child("user_landlord_info").child("mACRooms").getValue().toString())) {
                    mACRooms.setText("Available");
                } else {
                    mACRooms.setText("Not Available");
                }

                if(Boolean.parseBoolean(dataSnapshot.child(Uid).child("user_landlord_info").child("mAttachedWashrooms").getValue().toString())) {
                    mAttachedWashrooms.setText("Available");
                } else {
                    mAttachedWashrooms.setText("Not Available");
                }

                if(Boolean.parseBoolean(dataSnapshot.child(Uid).child("user_landlord_info").child("mParking").getValue().toString())) {
                    mParking.setText("Available");
                } else {
                    mParking.setText("Not Available");
                }

                if(Boolean.parseBoolean(dataSnapshot.child(Uid).child("user_landlord_info").child("mWifi").getValue().toString())) {
                    mWifi.setText("Available");
                } else {
                    mWifi.setText("Not Available");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
