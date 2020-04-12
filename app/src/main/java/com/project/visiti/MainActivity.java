package com.project.visiti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputEmail;
    private TextInputLayout inputPassword;
    private Button submitButton;
    private List<User> users = new ArrayList<>();
    public String path = "db_for_log_in.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEmail = (TextInputLayout)findViewById(R.id.inputEmail);
        inputPassword = (TextInputLayout)findViewById(R.id.inputPassword);
        submitButton = (Button)findViewById(R.id.submitButton);
    }

    public void Submit(View view) {
        String inputEmailText = inputEmail.getEditText().getText().toString().trim();
        String inputPasswordText = inputPassword.getEditText().getText().toString().trim();

        InputStream is = getResources().openRawResource(R.raw.db_for_log_in);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                Log.d("Size", "tokens[] size: " + tokens.length);
                User user = new User();
                user.setEmail(tokens[2]);
                user.setPassword(tokens[3]);
                user.setRights(tokens[6]);
                users.add(user);
                Log.d("MyActivity", "just created: " + user);
            }
        } catch (IOException e) {
            Log.wtf("myActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (User us : users) {
            if(inputEmailText.equals(us.getEmail()) &&
                    inputPasswordText.equals(us.getPassword())) {
                userRights(us);
            }
        }
    }

    private void userRights(User us) {
        if (us.getRights().equals("user")) {
            Toast.makeText(getApplicationContext(), "User rights enabled, 3id screen open...", Toast.LENGTH_LONG).show();
            Intent userLayout = new Intent(getApplicationContext(), ChooseCityActivity.class);
            startActivity(userLayout);
        } else if (us.getRights().equals("agency")) {
            Toast.makeText(getApplicationContext(), "Agency rights enabled, 1st screen open...", Toast.LENGTH_LONG).show();
            Intent agencyLayout = new Intent(getApplicationContext(), AgencyActivity.class);
            startActivity(agencyLayout);
        } else if (us.getRights().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Admin rights enabled, Admin panel open...", Toast.LENGTH_LONG).show();
        }
    }
}
