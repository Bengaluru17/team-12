package org.kshamata.www.kshamata_team12.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.kshamata.www.kshamata_team12.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void onClick (View view) {
        EditText editText = (EditText)findViewById(R.id.input_password);
        String val = editText.getText().toString().trim();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        if(val.equals("1")){
            intent.putExtra("id",val);
        } else {
            intent.putExtra("id",val);
        }
        startActivity(intent);
    }
}
