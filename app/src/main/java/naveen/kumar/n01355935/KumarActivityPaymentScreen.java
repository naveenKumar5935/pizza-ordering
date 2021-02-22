//Naveen Kumar N01355935 Section B

package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class KumarActivityPaymentScreen extends AppCompatActivity {

    String size;
    String crust;
    String toppings;
    String province;
    String icon;




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
        if(name.length()<3) {
            name.setError(getString(R.string.name_length_error));
            allConditionCheck=false;
        }
        if(!email.getText().toString().contains("@") || !email.getText().toString().contains(".")){
            email.setError("Please enter correct email");
        }
        if(email.getText().toString().contains(" ")){
            email.setError("No spacing is allowed");
        }

        if(phoneNo.length()<10 || phoneNo.getText().toString().contains(" ")){
            phoneNo.setError(getString(R.string.phoneNo_length_error));
            allConditionCheck=false;
        }
        if(postal.length()<6 || postal.getText().toString().contains(" ")){
            postal.setError(getString(R.string.postal_length_error));
            allConditionCheck=false;
        }
        if(creditNo.length()<16 || creditNo.getText().toString().contains(" ")){
            creditNo.setError(getString(R.string.creditNo_length_error));
            allConditionCheck=false;
        }
        if(expiryDate.length()<4 || expiryDate.getText().toString().contains(" ")){
            expiryDate.setError(getString(R.string.expirydate_length_error));
            allConditionCheck=false;
        }
        if(cvv.length()<3 || cvv.getText().toString().contains(" ")){
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
            intent.putExtra("imgName",icon);

            startActivity(intent);

        }

    }


    public void pizzaValues(String size,String crust,String topping,String province, String imgName){
        this.size = size;
        this.crust=crust;
        this.toppings=topping;
        this.province=province;
        this.icon=imgName;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){

            case R.id.naveenMenuHelp:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.youtube.com"));
                startActivity(intent);
                break;

            case R.id.naveenMenuName:
                Toast.makeText(getApplicationContext(), R.string.menu_name_toast,Toast.LENGTH_LONG).show();
                break;

            case R.id.naveenMenuPizza:
                Intent i = new Intent(Intent.ACTION_VIEW);
                if(icon.matches("dominos_pizza")){
                    i.setData(Uri.parse("http://www.dominos.ca"));
                    startActivity(i);
                }
                else if(icon.matches("pizza_hut")){
                    i.setData(Uri.parse("http://www.pizzahut.ca"));
                    startActivity(i);
                }else {
                    i.setData(Uri.parse("http://www.pizzapizza.ca"));
                    Log.i("icon",icon);
                    startActivity(i);
                }

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.naveenMenuPizza);
        item.setIcon(getResources().getIdentifier(icon,"drawable",getPackageName()));


        return super.onPrepareOptionsMenu(menu);
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
        String imgName = getIntent().getStringExtra("imgName");
        String topp = list.get(0);
        for(int i=1;i<list.size();i++){
            topp = topp + ", "+list.get(i);
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
        pizzaValues(size,crust,topp,provinceSpinner.getSelectedItem().toString(),imgName);
    }
}