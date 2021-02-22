package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class KumarActivityOrderScreen extends AppCompatActivity {

    String icon;

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
            Snackbar.make(view, R.string.order_select_size, Snackbar.LENGTH_LONG).show();
        }else{
            RadioButton sizeButton = findViewById(sizeID);
            sizeSelected = sizeButton.getText().toString();
        }
        if (crustID == -1) {
            Snackbar.make(view, R.string.order_select_crust, Snackbar.LENGTH_LONG).show();
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
                Snackbar.make(view, R.string.order_select_toppings, Snackbar.LENGTH_LONG).show();
            }

        if ((capsicum.isChecked() || gPeppers.isChecked() || onions.isChecked() || pepperoni.isChecked() || mushroom.isChecked() || bOlives.isChecked() || spinach.isChecked()) && sizeID != -1 && crustID != -1) {
            Intent intent = new Intent(this,KumarActivityPaymentScreen.class);
            intent.putExtra("sizeSelected",sizeSelected);
            intent.putExtra("crustSelected",crustSelected);
            intent.putExtra("toppingSelected",toppingList);
            intent.putExtra("imgName",icon);
            startActivity(intent);

        }


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

    public void iconName(String imgName){
        this.icon=imgName;
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
        setContentView(R.layout.activity_kumar_order_screen);

        ImageView imageView = findViewById(R.id.naveenSelectedStoreImg);
        Intent intent = getIntent();
        String imageName = intent.getStringExtra("imageDisplay");
       int resID = getResources().getIdentifier(imageName,"drawable",getPackageName());
       imageView.setImageResource(resID);
       iconName(imageName);



    }
}