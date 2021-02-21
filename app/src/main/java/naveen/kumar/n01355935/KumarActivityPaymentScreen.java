package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class KumarActivityPaymentScreen extends AppCompatActivity {

    String size;
    String crust;
    String toppings;
    String province;




    public void orderClick(View view){

        EditText name = findViewById(R.id.naveenYourName);
        EditText email = findViewById(R.id.naveenEmail);
        EditText phoneNo = findViewById(R.id.naveenPhoneNo);
        EditText address = findViewById(R.id.naveenAddress);
        EditText postal = findViewById(R.id.naveenPosalCode);
        EditText city = findViewById(R.id.naveenCity);
        EditText creditNo = findViewById(R.id.naveenCreditNo);
        EditText expiryDate = findViewById(R.id.naveenExpiryDate);
        EditText cvv = findViewById(R.id.naveenCVV);


        Boolean allConditionCheck=true;

        char[] numbers = "0123456789".toCharArray();

        for(char number: numbers){
            if(name.getText().toString().contains(String.valueOf(number))){
                name.setError(getString(R.string.name_alpha_error));
                allConditionCheck=false;
            }
            if(city.getText().toString().contains(String.valueOf(number))){
                city.setError(getString(R.string.city_alpha_error));
                allConditionCheck=false;
            }
        }
        if(name.length()<3){
            name.setError(getString(R.string.name_length_error));
            allConditionCheck=false;
        }

        if(phoneNo.length()<10){
            phoneNo.setError(getString(R.string.phoneNo_length_error));
            allConditionCheck=false;
        }
        if(postal.length()<6){
            postal.setError(getString(R.string.postal_length_error));
            allConditionCheck=false;
        }
        if(creditNo.length()<16){
            creditNo.setError(getString(R.string.creditNo_length_error));
            allConditionCheck=false;
        }
        if(expiryDate.length()<4){
            expiryDate.setError(getString(R.string.expirydate_length_error));
            allConditionCheck=false;
        }
        if(cvv.length()<3){
            cvv.setError(getString(R.string.cvv_length_error));
            allConditionCheck=false;
        }

        if(name.length()==0){
            name.setError(getString(R.string.enter_name_error));
            allConditionCheck=false;
        }
        if(email.length()==0){
            email.setError(getString(R.string.enter_email_error));
            allConditionCheck=false;
        }
        if(phoneNo.length()==0){
            phoneNo.setError(getString(R.string.enterphn_error));
            allConditionCheck=false;
        }
        if(address.length()==0){
            address.setError(getString(R.string.enter_address_error));
            allConditionCheck=false;
        }
        if(postal.length()==0){
            postal.setError(getString(R.string.enter_postal_error));
            allConditionCheck=false;
        }
        if(city.length()==0){
            city.setError(getString(R.string.enter_City_error));
            allConditionCheck=false;
        }
        if(creditNo.length()==0){
            creditNo.setError(getString(R.string.enter_credit_error));
            allConditionCheck=false;
        }
        if(expiryDate.length()==0){
            expiryDate.setError(getString(R.string.enter_expiry_error));
            allConditionCheck=false;
        }
        if(cvv.length()==0){
            cvv.setError(getString(R.string.enter_cvv_error));
            allConditionCheck=false;
        }

        if(allConditionCheck){


            Intent intent = new Intent(this,KumarCheckOutScreen.class);
            intent.putExtra("size",size);
            intent.putExtra("crust",crust);
            intent.putExtra("toppings",toppings);
            intent.putExtra("name",name.getText().toString());
            intent.putExtra("email",email.getText().toString());
            intent.putExtra("phone",phoneNo.getText().toString());
            intent.putExtra("address",address.getText().toString());
            intent.putExtra("city",city.getText().toString());
            intent.putExtra("state",province);
            intent.putExtra("postal",postal.getText().toString());
            intent.putExtra("credit",creditNo.getText().toString());
            intent.putExtra("expiry",expiryDate.getText().toString());
            intent.putExtra("cvv",cvv.getText().toString());

            startActivity(intent);

        }

    }


    public void pizzaValues(String size,String crust,String topping,String province){
        this.size = size;
        this.crust=crust;
        this.toppings=topping;
        this.province=province;
    }















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumar_payment_screen);
        TextView t1 = findViewById(R.id.naveenPaymentSizeDisplay);
        TextView t2 = findViewById(R.id.naveenPaymentCrustDisplay);
        TextView t3 = findViewById(R.id.naveenPaymentToppingsView);

        Intent intent = getIntent();
       String size = getIntent().getStringExtra("sizeSelected");
       String crust = getIntent().getStringExtra("crustSelected");
        ArrayList<String> list = getIntent().getStringArrayListExtra("toppingSelected");

        String topp = list.get(0);
        for(int i=1;i<list.size();i++){
            topp = topp + ","+list.get(i);
        }

        t1.setText(size);
        t2.setText(crust);
        t3.setText(topp);



        //Spinner Code for province
        String[] province = {"ON","QC","BC","PE","NS","NB","NL","MB","SK","AB","YT","NT","NU"};
      Spinner provinceSpinner = findViewById(R.id.naveenSpinner);
        ArrayAdapter pA = new ArrayAdapter(this,android.R.layout.simple_spinner_item,province);
        pA.setDropDownViewResource(R.layout.spinner_list);
        provinceSpinner.setAdapter(pA);


        //Calling PizzaValues
        pizzaValues(size,crust,topp,provinceSpinner.getSelectedItem().toString());
    }
}