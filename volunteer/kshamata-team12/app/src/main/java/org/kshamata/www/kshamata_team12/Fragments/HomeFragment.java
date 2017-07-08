package org.kshamata.www.kshamata_team12.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.kshamata.www.kshamata_team12.Classes.Victim;
import org.kshamata.www.kshamata_team12.R;


public class HomeFragment extends Fragment {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        final TextView name = (TextView)rootView.findViewById(R.id.name);
        final TextView dob = (TextView)rootView.findViewById(R.id.age);
        final TextView location = (TextView)rootView.findViewById(R.id.location);
        final TextView job = (TextView)rootView.findViewById(R.id.jobJoin);
        final TextView salary = (TextView)rootView.findViewById(R.id.salaryJoin);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        databaseReference.child("victims").child("id1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("results",dataSnapshot.toString());
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    if(ds.getKey().equals("name")){
                        name.setText(ds.getValue(String.class));
                    }
                    if(ds.getKey().equals("dob")){
                        dob.setText(ds.getValue(String.class));
                    }
                    if(ds.getKey().equals("latitude")){
                       location.setText(ds.getValue(String.class));
                    }
                    if(ds.getKey().equals("jobJoining")){
                        job.setText(ds.getValue(String.class));
                    }
                    if(ds.getKey().equals("salaryJoining")){
                        salary.setText(ds.getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}