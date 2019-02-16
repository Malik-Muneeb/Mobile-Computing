package pk.edu.pucit.munib.mclab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreenActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnClose;
    TextView name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        initVariables();
        Intent intent=getIntent();
        Bundle b= intent.getExtras();
        String strName= b.getString("Name");
        String strEmail=b.getString("Email");
        name.setText(strName);
        email.setText(strEmail);
        btnClose.setOnClickListener(this);
    }



    private void initVariables() {
        btnClose=(Button) findViewById(R.id.bt_close_activity_second_screeen);
        name=(TextView) findViewById(R.id.tv_name_activity_second_screen);
        email=(TextView) findViewById(R.id.tv_email_activity_second_screen);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_close_activity_second_screeen){
            this.finish();
        }

    }
}
