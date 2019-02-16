package pk.edu.pucit.munib.mclab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInfoActivity extends Activity {

    TextView tvInfo;
    boolean isReceived = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Student std = new Student();
        if (intent.hasExtra("student")) {
            std = (Student) bundle.get("student");
            String info;
            if (!std.name.equals("") && !std.fatherName.equals("") && !std.address.equals("")
                    && !std.gender.equals("") && !std.DOB.equals("") && !std.city.equals("")
                    && !std.district.equals("") && !std.phone.equals("") && !std.email.equals("")
                    && !std.department.equals("")) {

                isReceived = true;
                info = std.name + " personal info is: \n" +
                        "Father Name: " + std.fatherName + "\nAddress: " +
                        std.address + "\nAge: " + std.age + "\nGender: " +
                        std.gender + "\nDOB: " + std.DOB + "\nCity: " + std.city +
                        "\nDistrict: " + std.district + "\nPhone No: " + std.phone +
                        "\nEmail: " + std.email + "\nDepartment: " + std.department;
            } else {
                info = "Please Enter All fields";
            }


            tvInfo = (TextView) findViewById(R.id.tv_info_activity_show_info);
            tvInfo.setText(info);
        }

        /*if (intent.hasExtra("info")) {
            String info = bundle.getString("info");
            isReceived = true;
            //Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();


            tvInfo = (TextView) findViewById(R.id.tv_info_activity_show_info);
            tvInfo.setText(info);
        }*/

    }

    @Override
    public void finish() {
        Intent i = new Intent();
        i.putExtra("isInfoReceived", isReceived);
        setResult(RESULT_OK, i);
        super.finish();
    }

}
