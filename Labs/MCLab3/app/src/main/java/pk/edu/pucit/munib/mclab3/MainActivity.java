package pk.edu.pucit.munib.mclab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOk;
    EditText name, email;
    String strName, strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        strName = name.getText().toString();
        strEmail = email.getText().toString();
        btnOk.setOnClickListener(this);
    }

    private void initVariables() {
        btnOk = (Button) findViewById(R.id.bt_ok_activity_main);
        name = (EditText) findViewById(R.id.et_name_activity_main);
        email = (EditText) findViewById(R.id.et_email_activity_main);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_ok_activity_main) {
            if (strName.equals("") && strName.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter All Fields", Toast.LENGTH_LONG).show();
            } else {

                Intent intent = new Intent(this, SecondScreenActivity.class);
                intent.putExtra("Name", strName);
                intent.putExtra("Email", strEmail);
                startActivity(intent);
                this.finish();
            }
        }

    }
}
