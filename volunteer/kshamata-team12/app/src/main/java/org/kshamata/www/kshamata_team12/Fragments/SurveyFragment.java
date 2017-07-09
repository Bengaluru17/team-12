package org.kshamata.www.kshamata_team12.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.kshamata.www.kshamata_team12.Classes.SurveyDetails;
import org.kshamata.www.kshamata_team12.R;


public class SurveyFragment extends Fragment {

    String questions[] = {"Your phone number?", "Email Id?", "Vocational Training Done?", "Tailoring Skill?","Embroidery skills?","Articrafts crafts?","Cooking skills?", "Baking skills?" ,"Current Salary?", "Current job?", "Future Plans?", "Latitude", "Longitude"};
    String answers[] = new String[20];
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
        View rootView = inflater.inflate(R.layout.survey_page, container, false);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("surveys");

        final TextView question = (TextView) rootView.findViewById(R.id.question);
        final EditText answer = (EditText) rootView.findViewById(R.id.answer);

        final Button next = (Button) rootView.findViewById(R.id.next);
        final int flag = 0;

        final SurveyDetails surveyDetails = new SurveyDetails();

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                if (i < questions.length - 1) {
                    answers[i] = String.valueOf(answer.getText());
                    i++;
                    question.setText(questions[i]);
                    answer.setText("");
                }

                else if (i == questions.length - 1) {
                    next.setText("SUBMIT");
                }

                if (next.getText() == "SUBMIT") {
                    surveyDetails.setPhone(answers[0]);
                    surveyDetails.setEmailId(answers[1]);
                    surveyDetails.setTraining(answers[2]);
                    surveyDetails.setTailoringSkill(answers[3]);
                    surveyDetails.setEmbroiderySkill(answers[4]);
                    surveyDetails.setArticraftsSkill(answers[5]);
                    surveyDetails.setCookingSkills(answers[6]);
                    surveyDetails.setBakingSkills(answers[7]);
                    surveyDetails.setCurrentSalary(answers[8]);
                    surveyDetails.setJob(answers[9]);
                    surveyDetails.setFuturePlans(answers[10]);
                    surveyDetails.setCurrentLatitude(answers[11]);
                    surveyDetails.setCurrentLongitude(answers[12]);
                    DatabaseReference db = mDatabaseReference.push();
                    db.setValue(surveyDetails);

                    Toast.makeText(getActivity(), "Survey sucessfully completed!", Toast.LENGTH_SHORT).show();

                    Bundle b = new Bundle();
                    b.putString("id", db.getKey().toString());

                    Fragment fragment = new FriendsFragment();

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragment.setArguments(b);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

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