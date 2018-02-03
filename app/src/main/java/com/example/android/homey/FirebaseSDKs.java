package com.example.android.homey;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by user on 31-Jan-18.
 */

public class FirebaseSDKs {
    static FirebaseDatabase mFirebaseDatabase;
    static DatabaseReference mDatabaseReference;
    static FirebaseAuth mFirebaseAuth;
    static FirebaseAuth.AuthStateListener mAuthStateListener;
    static FirebaseUser user;
    static FirebaseStorage mFirebaseStorage;
    static StorageReference mChatPhotosStorageReference;
}
