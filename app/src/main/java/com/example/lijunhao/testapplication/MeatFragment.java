package com.example.lijunhao.testapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by win8 on 2017-07-12.
 */

public class MeatFragment extends Fragment {
    View myView;
    DatabaseReference db;
    CustomAdapter adapter;
    ListView lv;
    ArrayList<Product> Products =new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.first_layout,container,false);
        lv=(ListView)myView.findViewById(R.id.prodList);
        db = FirebaseDatabase.getInstance().getReference();
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
                adapter = new CustomAdapter(getActivity(),Products);
                lv.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
                adapter = new CustomAdapter(getActivity(),Products);
                lv.setAdapter(adapter);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        return myView;
    }
    private void fetchData(DataSnapshot dataSnapshot) {
        Products.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Product pp = ds.getValue(Product.class);
            String t = "M";
            if (pp.getpCategory().equals(t)) {
                Products.add(pp);
            }
        }
    }
    @Override
    public String toString() {
        String title="Meat";
        return title;
    }
}
