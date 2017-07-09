package org.kshamata.www.kshamata_team12.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    String dest;
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
        final Button direcions = (Button)rootView.findViewById(R.id.directions);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        String id = getActivity().getIntent().getStringExtra("id");
        if(id.equals("1")){
            id = "114A14-2AA";
        }
        else
        {
            id = "114A14-2BB";
        }
        databaseReference.child("victims").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("results",dataSnapshot.toString());
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    if(ds.getKey().equals("name")){
                        name.setText(ds.getValue(String.class));

                        dest = "19.021324,72.842418";
                        if(ds.getValue(String.class).equals("Gouri"))
                        {
                            dest = "12.910491,77.585717";
                        }
                        direcions.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=12.943072,77.692183&daddr="+dest));
                                startActivity(intent);
                            }
                        });
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