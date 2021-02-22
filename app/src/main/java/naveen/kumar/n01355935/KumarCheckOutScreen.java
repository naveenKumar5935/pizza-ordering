//Naveen Kumar N01355935 Section B

package naveen.kumar.n01355935;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Random;

public class KumarCheckOutScreen extends AppCompatActivity {

    String icon;
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

    public void setIcon(String imgName){
        this.icon=imgName;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumar_check_out_screen);
        TextView size = findViewById(R.id.naveenCheckOutSizeDisplay);
        TextView crust = findViewById(R.id.naveenCheckOutCrustDisplay);
        TextView toppings = findViewById(R.id.naveenCheckOutToppingsDisplay);
        TextView name = findViewById(R.id.naveenCheckOutNameDisplay);
        TextView email = findViewById(R.id.naveenCheckOutEmailDisplay);
        TextView phone = findViewById(R.id.naveenCheckOutPhoneDisplay);
        TextView address = findViewById(R.id.naveenCheckOutAddressDisplay);
        TextView city = findViewById(R.id.naveenCheckOutCityDisplay);
        TextView state = findViewById(R.id.naveenCheckOutStateDisplay);
        TextView postal = findViewById(R.id.naveenCheckOutPostalDisplay);
        TextView credit = findViewById(R.id.naveenCheckOutCreditNoDisplay);
        TextView expiry = findViewById(R.id.naveenCheckOutExpiryDisplay);
        TextView cvv = findViewById(R.id.naveenCheckOutCVVDisplay);
        Intent intent = new Intent();
        size.setText(getIntent().getStringExtra("size"));
        crust.setText(getIntent().getStringExtra("crust"));
        toppings.setText(getIntent().getStringExtra("toppings"));
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        phone.setText(getIntent().getStringExtra("phone"));
        address.setText(getIntent().getStringExtra("address"));
        city.setText(getIntent().getStringExtra("city"));
        state.setText(getIntent().getStringExtra("state"));
        postal.setText(getIntent().getStringExtra("postal"));
        credit.setText(getIntent().getStringExtra("credit"));
        expiry.setText(getIntent().getStringExtra("expiry"));
        cvv.setText(getIntent().getStringExtra("cvv"));
        String imgName = getIntent().getStringExtra("imgName");
        setIcon(imgName);



    }
    public void alertFunction(View view){

     Random r = new Random();
        int i1 = r.nextInt(1023 - 111) + 111;
        AlertDialog.Builder alert = new AlertDialog.Builder(KumarCheckOutScreen.this);
        alert.setMessage(getString(R.string.Alert_confirmation_no)+ String.valueOf(i1)+getString(R.string.alert_readyTime));
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(),NaveenActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        alert.show();


    }

}