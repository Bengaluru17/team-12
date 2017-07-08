package org.kshamata.www.kshamata_team12.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.kshamata.www.kshamata_team12.Classes.SurveyDetails;
import org.kshamata.www.kshamata_team12.R;


public class SurveyFragment extends Fragment {

    String questions[] = {"Your phone number?", "Email Id?", "Vocational Training Done?", "Skills?", "Current Salary?", "Current job?", "Future Plans?", "Latitude", "Longitude"};
    String answers[] = new String[10];
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private int i = 0;

    public SurveyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_messages, container, false);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("surveys");

        final TextView question = (TextView) rootView.findViewById(R.id.question);
        final TextView answer = (TextView) rootView.findViewById(R.id.answer);

        final Button next = (Button) rootView.findViewById(R.id.next);
        final int flag = 0;

        final SurveyDetails surveyDetails = new SurveyDetails();

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                if (i < questions.length - 1) {
                    answers[i] = String.valueOf(answer.getText());
                    i++;
                }

                else if (i == questions.length - 1) {
                    next.setText("SUBMIT");
                }

                if (next.getText() == "SUBMIT") {
                    surveyDetails.setPhone(questions[0]);
                    surveyDetails.setEmailId(questions[1]);
                    surveyDetails.setTraining(questions[2]);
                    surveyDetails.setSkills(questions[3]);
                    surveyDetails.setCurrentSalary(questions[4]);
                    surveyDetails.setJob(questions[5]);
                    surveyDetails.setFuturePlans(questions[6]);
                    surveyDetails.setCurrentLatitude(questions[7]);
                    surveyDetails.setCurrentLongitude(questions[8]);
                    mDatabaseReference.push().setValue(surveyDetails);

                }
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