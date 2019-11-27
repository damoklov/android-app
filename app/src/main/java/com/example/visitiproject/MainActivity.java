package com.example.visitiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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
import java.util.Comparator;
import java.util.List;


public class MainActivity extends AppCompatActivity {
//    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
//         //   "(?=.*[0-9])" +
//            //"(?=.*[a-z])" +
//            //"(?=.*[A-Z])" +
//      //      "(?=.*[a-zA-Z])" +
//           // "(?=.*[@#$^&+=])" +
//        //    "(?=\\\\S+$)" +
//          //  ".{6,}" +
//            "$"
//    );

    private TextInputLayout inputEmail;
    private TextInputLayout inputPassword;
    private Button submitButton;
    public String path = "db_for_log_in.csv";

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = (TextInputLayout)findViewById(R.id.inputEmail);
        inputPassword = (TextInputLayout)findViewById(R.id.inputPassword);
        submitButton = (Button)findViewById(R.id.submitButton);
//        Intent userLayout = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(userLayout);
       dbHelper = new DBHelper(this);
    }

//    private boolean validateEmail() {
//        //inputEmail = (TextInputLayout)findViewById(R.id.inputEmail);
//        String inputEmailText = inputEmail.getEditText().getText().toString().trim();
//        if (inputEmailText.isEmpty()) {
//            inputEmail.setError("Field can't be empty");
//            return false;
//
//        } else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmailText).matches()){
//            inputEmail.setError("Please enter a valid email address");
//            return false;
//        } else {
//            inputEmail.setError(null);
//            return true;
//        }
//    }
//
//    private boolean validatePassword() {
//        //inputPassword = (TextInputLayout)findViewById(R.id.inputPassword);
//        String inputPasswordText = inputPassword.getEditText().getText().toString();
//        if (inputPasswordText.isEmpty()) {
//            inputPassword.setError("Field can't be empty");
//            return false;
//        } else if (inputPasswordText.length() > 15) {
//            inputPassword.setError("Password can't be more than 15 symbols");
//            return false;
//        }
////        } else if (!PASSWORD_PATTERN.matcher(inputPasswordText).matches()){
////            inputPassword.setError("Password too weak");
////            return false;
////        }
//        else {
//            inputPassword.setError(null);
//            return true;
//        }
//    }

//    private List<UserExample> userExamples = new ArrayList<>();
    public void Submit(View view) {
        String inputEmailText = inputEmail.getEditText().getText().toString().trim();
        String inputPasswordText = inputPassword.getEditText().getText().toString().trim();
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.Email, "Email");
        database.insert(DBHelper.TABLE_FOR_LOGIN, null, values);

//            InputStream is = getResources().openRawResource(R.raw.db_for_log_in);
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(is, Charset.forName("UTF-8"))
//            );
//            String line = "";
//            try {
//                reader.readLine();
//                while ((line = reader.readLine()) != null) {
//                    String[] tokens = line.split(",");
//                    Log.d("Size", "tokens[] size: " + tokens.length);
//                    UserExample user = new UserExample();
//                    user.setEmail(tokens[2]);
//                    user.setPassword(tokens[3]);
//                    user.setRights(tokens[6]);
//                    userExamples.add(user);
//                    Log.d("MyActivity", "just created: " + user);
//                }
//            } catch (IOException e) {
//                Log.wtf("myActivity", "Error reading data file on line" + line, e);
//                e.printStackTrace();
//            } finally {
//                try {
//                   reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//
//            for (UserExample us : userExamples) {
//               if(inputEmailText.equals(us.getEmail()) &&
//                       inputPasswordText.equals(us.getPassword())) {
//                   userRights(us);
//               }
//            }
    }

//    private void userRights(UserExample us) {
//        if (us.getRights().equals("user")) {
//            Toast.makeText(getApplicationContext(), "User rights enabled, 3id screen open...", Toast.LENGTH_LONG).show();
//            Intent userLayout = new Intent(getApplicationContext(), ChooseCityActivity.class);
//            startActivity(userLayout);
//        } else if (us.getRights().equals("agency")) {
//            Toast.makeText(getApplicationContext(), "Agency rights enabled, 1st screen open...", Toast.LENGTH_LONG).show();
//            Intent agencyLayout = new Intent(getApplicationContext(), AgencyActivity.class);
//            startActivity(agencyLayout);
//        } else if (us.getRights().equals("admin")) {
//            Toast.makeText(getApplicationContext(), "Admin rights enabled, Admin panel open...", Toast.LENGTH_LONG).show();
//        }
//    }
//
//              String inputEmailText = inputEmail.getEditText().getText().toString().trim();
//              String inputPasswordText = inputPassword.getEditText().getText().toString().trim();
//
//              readEmail(inputEmailText);
//              readPassword(inputPasswordText, "db_for_log_in.csv_log_in.csv");

//            inputStream = getResources().openRawResource(R.raw.db_for_log_in);
//            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
//
//            try {
//                String csvLine;
//                while ((csvLine = buffer.readLine()) != null) {
//                    data = csvLine.split(",");
//                    Log.i("Data", data[0]);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try (FileReader fr = new FileReader(path)){
//                int symbol;
//                while ((symbol = fr.read()) != -1) {
//                    System.out.println((char)symbol);
//                }
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Toast.makeText(getApplicationContext(), "successful submit", Toast.LENGTH_LONG).show();

       // }




}
