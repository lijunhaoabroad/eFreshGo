package com.example.lijunhao.testapplication;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.example.lijunhao.testapplication.Product;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1.SAVE DATA TO FIREBASE
 * 2. RETRIEVE
 * 3.RETURN AN ARRAYLIST
 */
public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    ArrayList<Product> Products =new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */
    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
//    //WRITE IF NOT NULL
//    public Boolean save(Product Products)
//    {
//        if(Products==null)
//        {
//            saved=false;
//        }else
//        {
//            try
//            {
//                db.child("Spacecraft").push().setValue(Products);
//                saved=true;
//            }catch (DatabaseException e)
//            {
//                e.printStackTrace();
//                saved=false;
//            }
//        }
//        return saved;
//    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        Products.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Product pp =ds.getValue(Product.class);
            Products.add(pp);
        }
    }
    //RETRIEVE

    public ArrayList<Product> retrieve()
    {

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              fetchData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return Products;
    }
}