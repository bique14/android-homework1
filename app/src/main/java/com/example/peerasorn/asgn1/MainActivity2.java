package com.example.peerasorn.asgn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ImageView img = (ImageView) findViewById(R.id.imageView);
        String name = getIntent().getStringExtra("name");
        String lastName = getIntent().getStringExtra("lastName");
        String age = getIntent().getStringExtra("age");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");

        if(Integer.parseInt(calculateAge(age)) <= 15) {
            img.setImageResource(R.mipmap.child);
        } else if (Integer.parseInt(calculateAge(age)) > 15 && Integer.parseInt(calculateAge(age)) <= 25) {
            img.setImageResource(R.mipmap.teenage);
        } else if (Integer.parseInt(calculateAge(age)) > 25 && Integer.parseInt(calculateAge(age)) <= 60) {
            img.setImageResource(R.mipmap.worker);
        } else {
            img.setImageResource(R.mipmap.oldman);
        }

        EditText editName = (EditText) findViewById(R.id.editText1);
        String capName = name.substring(0, 1).toUpperCase() + name.substring(1);
        editName.setText(capName);
        editName.setFocusable(false);

        EditText editLastName = (EditText) findViewById(R.id.editText2);
        String capLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        editLastName.setText(capLastName);
        editLastName.setFocusable(false);

        EditText editAge = (EditText) findViewById(R.id.editText3);
        editAge.setText(calculateAge(age));
        editAge.setFocusable(false);

        EditText editEmail = (EditText) findViewById(R.id.editText4);
        editEmail.setText(email);
        editEmail.setFocusable(false);

        EditText editPhone = (EditText) findViewById(R.id.editText5);
        editPhone.setText(formatPhoneNumber(phone));
        editPhone.setFocusable(false);
    }

    public String formatPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
    }

    public String calculateAge(String birthdate) {
//        String regex = "(0?[1-9]|[12][0-9]|3[01])\\W(0?[1-9]|1[012])\\W((18|19|20|21)\\d\\d)";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(birthdate);
//        int calAge = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
//        if(matcher.find()) {
//            calAge = Integer.parseInt(dateFormat.format(date)) - Integer.parseInt(matcher.group(3));
//        }
        String[] spl = birthdate.split("/");
        int calAge = Integer.parseInt(dateFormat.format(date)) - Integer.parseInt(spl[2]);

        return String.valueOf(calAge);
    }
}
