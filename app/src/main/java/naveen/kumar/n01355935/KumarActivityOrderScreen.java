package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class KumarActivityOrderScreen extends AppCompatActivity {



    public void sizeGroupCheck(View view) {
        String sizeSelected=" ", crustSelected=" ";
        ArrayList<String> toppingList = new ArrayList<String>();
        RadioGroup sizeGroup = (RadioGroup) findViewById(R.id.naveenSizeGroup);
        RadioGroup crustGroup = (RadioGroup) findViewById(R.id.naveenCrustGroup);

        int sizeID = sizeGroup.getCheckedRadioButtonId();
        int crustID = crustGroup.getCheckedRadioButtonId();
        
        CheckBox capsicum = (CheckBox) findViewById(R.id.naveenCapsicumCheck);
        CheckBox gPeppers = (CheckBox) findViewById(R.id.naveenGPeppersCheck);
        CheckBox onions = (CheckBox) findViewById(R.id.naveenOnionCheck);
        CheckBox pepperoni = (CheckBox) findViewById(R.id.naveenPepperoniCheck);
        CheckBox mushroom = (CheckBox) findViewById(R.id.naveenMushroomCheck);
        CheckBox bOlives = (CheckBox) findViewById(R.id.naveenOlivesCheck);
        CheckBox spinach = (CheckBox) findViewById(R.id.naveenSpinachCheck);

        if (sizeID == -1) {
            Snackbar.make(view, "Please select size", Snackbar.LENGTH_LONG).show();
        }else{
            RadioButton sizeButton = findViewById(sizeID);
            sizeSelected = sizeButton.getText().toString();
        }
        if (crustID == -1) {
            Snackbar.make(view, "Please select crust", Snackbar.LENGTH_LONG).show();
        }else {
            RadioButton crustButton = findViewById(crustID);
            crustSelected = crustButton.getText().toString();
        }

        if(capsicum.isChecked()) {
                        toppingList.add(capsicum.getText().toString());
        }if(onions.isChecked()){
            toppingList.add(onions.getText().toString());
        }if(gPeppers.isChecked()){
            toppingList.add(gPeppers.getText().toString());
        } if(pepperoni.isChecked()){
            toppingList.add(pepperoni.getText().toString());
        }if(mushroom.isChecked()){
            toppingList.add(mushroom.getText().toString());
        } if(bOlives.isChecked()){
            toppingList.add(bOlives.getText().toString());
        } if(spinach.isChecked()){
            toppingList.add(spinach.getText().toString());
        }
        else {
                Log.i("Toppings:", "not selected");
                Snackbar.make(view, "Please select toppings", Snackbar.LENGTH_LONG).show();
            }

        if ((capsicum.isChecked() || gPeppers.isChecked() || onions.isChecked() || pepperoni.isChecked() || mushroom.isChecked() || bOlives.isChecked() || spinach.isChecked()) && sizeID != -1 && crustID != -1) {
            Snackbar.make(view, "Condition Satisfied", Snackbar.LENGTH_LONG).show();
            Intent intent = new Intent(this,KumarActivityPaymentScreen.class);
            intent.putExtra("sizeSelected",sizeSelected);
            intent.putExtra("crustSelected",crustSelected);
            intent.putExtra("toppingSelected",toppingList);
            startActivity(intent);

        }


        }



















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumar_order_screen);

        ImageView imageView = findViewById(R.id.naveenSelectedStoreImg);
        Intent intent = getIntent();
        String imageName = intent.getStringExtra("imageDisplay");
       int resID = getResources().getIdentifier(imageName,"drawable",getPackageName());
       imageView.setImageResource(resID);



    }
}