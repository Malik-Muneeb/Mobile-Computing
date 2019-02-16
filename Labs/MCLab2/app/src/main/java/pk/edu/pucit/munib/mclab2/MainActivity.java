package pk.edu.pucit.munib.mclab2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDone;
    EditText name, fatherName, address, age, gender, dob, city, district, phone,
            email, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        btnDone.setOnClickListener(this);
    }

    private void initVariables() {
        btnDone = (Button) findViewById(R.id.bt_done_activity_main);
        name = (EditText) findViewById(R.id.et_name_activity_main);
        fatherName = (EditText) findViewById(R.id.et_fName_activity_main);
        address = (EditText) findViewById(R.id.et_address_activity_main);
        age = (EditText) findViewById(R.id.et_age_activity_main);
        gender = (EditText) findViewById(R.id.et_gender_activity_main);
        dob = (EditText) findViewById(R.id.et_dob_activity_main);
        city = (EditText) findViewById(R.id.et_city_activity_main);
        district = (EditText) findViewById(R.id.et_district_activity_main);
        phone = (EditText) findViewById(R.id.et_phone_activity_main);
        email = (EditText) findViewById(R.id.et_email_activity_main);
        dept = (EditText) findViewById(R.id.et_dept_activity_main);

    }


    @Override
    public void onClick(View v){

        if (v.getId() == R.id.bt_done_activity_main) {
            Student std = new Student();
            std.name = name.getText().toString();
            std.fatherName = fatherName.getText().toString();
            std.address = address.getText().toString();
            String strAge = age.getText().toString();
            if (!strAge.isEmpty())
                std.age = Integer.parseInt(strAge);
            else
                 std.age = 0;
            std.gender = gender.getText().toString();
            std.DOB = dob.getText().toString();
            std.city = city.getText().toString();
            std.district = district.getText().toString();
            std.phone = phone.getText().toString();
            std.email = email.getText().toString();
            std.department = dept.getText().toString();

            String info;
            Intent intent =new Intent(this,ShowInfoActivity.class);
            intent.putExtra("student",std);
            //startActivityForResult(intent,100);



            /*if (!std.name.equals("") && !std.fatherName.equals("") && !std.address.equals("")
                    && !std.gender.equals("") && !std.DOB.equals("") && !std.city.equals("")
                    && !std.district.equals("") && !std.phone.equals("") && !std.email.equals("")
                    && !std.department.equals("")) {

                info = std.name + " personal info is: \n" +
                        "Father Name: " + std.fatherName + "\nAddress: " +
                        std.address + "\nAge: " + std.age + "\nGender: " +
                        std.gender + "\nDOB: " + std.DOB + "\nCity: " + std.city +
                        "\nDistrict: " + std.district + "\nPhone No: " + std.phone +
                        "\nEmail: " + std.email + "\nDepartment: " + std.department;

                intent.putExtra("info",info);

                //startActivity(intent);

                startActivityForResult(intent,100);
            } else {
                info = "Please Enter All fields";

                //startActivity(intent);

                startActivityForResult(intent,100);

            }
            TextView tv = (TextView) findViewById(R.id.tv_info_activity_main);
            tv.setText(info);*/


            //impicit intents
           /* Intent i=new Intent(Intent.ACTION_VIEW);
            String url= "http://www.google.com";
            i.setData(Uri.parse(url));
            startActivity(i);*/

           Intent i = new Intent(Intent.ACTION_SEND);
           i.setType("text/plain");
           i.putExtra(Intent.EXTRA_TEXT,"News for You");
           startActivity(i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle=new Bundle();
        if(data.hasExtra("isInfoReceived"))
            bundle=data.getExtras();
        if(requestCode==100)
        {
            if(resultCode==RESULT_OK){
                Toast.makeText(getApplicationContext(),bundle.getBoolean("isInfoReceived")+"",Toast.LENGTH_LONG).show();

            }
        }

    }
}

