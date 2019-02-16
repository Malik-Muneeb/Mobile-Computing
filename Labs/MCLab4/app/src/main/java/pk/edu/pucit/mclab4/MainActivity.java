package pk.edu.pucit.mclab4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewPreviousActivityMain;
    EditText editTextFoodActivityMain, editTextShoppingActivityMain,
            editTextFuelActivityMain, editTextTelephoneActivityMain;
    Button buttonCalcActivityMain;
    SharedPreferences sp;
    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        buttonCalcActivityMain.setOnClickListener(this);
         sp = getSharedPreferences("lab4", Context.MODE_PRIVATE);
        String expense = sp.getString("expense","");
        if(!expense.equals("")){
            textViewPreviousActivityMain.setText("Your Previous Expense was: "+expense);
        }
    }

    private void initVariables() {
        textViewPreviousActivityMain=findViewById(R.id.text_view_previous_activity_main);
        editTextFoodActivityMain= findViewById(R.id.edit_text_food_activity_main);
        editTextShoppingActivityMain=findViewById(R.id.edit_text_shopping_activity_main);
        editTextTelephoneActivityMain=findViewById(R.id.edit_text_telephone_activity_main);
        editTextFuelActivityMain=findViewById(R.id.edit_text_fuel_activity_main);
        buttonCalcActivityMain=findViewById(R.id.bt_calc_activity_main);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_calc_activity_main){
            sum = Integer.parseInt(editTextFoodActivityMain.getText().toString())
                    +Integer.parseInt(editTextFuelActivityMain.getText().toString())+
                    Integer.parseInt(editTextShoppingActivityMain.getText().toString())+
                    Integer.parseInt(editTextTelephoneActivityMain.getText().toString());
            Toast.makeText(getApplicationContext(), String.valueOf(sum),Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("expense",String.valueOf(sum));
            editor.commit();
        }
    }
}
