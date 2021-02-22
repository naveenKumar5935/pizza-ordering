package naveen.kumar.n01355935;

import androidx.annotation.NonNull;
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
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class NaveenActivity extends AppCompatActivity {



    public void radioButtonClick(View view){

        RadioButton  dominosButton = (RadioButton) findViewById(R.id.naveenDominosButton);
        RadioButton  pizzaPizzaButton = (RadioButton) findViewById(R.id.naveenPizzaButton);
        RadioButton  pizzaHutButton = (RadioButton) findViewById(R.id.naveenPizzaHutButton);


        switch (view.getId()){

            case R.id.naveenDominosButton:
                dominosButton.setChecked(true);
                pizzaPizzaButton.setChecked(false);
                pizzaHutButton.setChecked(false);
              //  invalidateOptionsMenu();

                break;

            case R.id.naveenPizzaButton:
                dominosButton.setChecked(false);
                pizzaPizzaButton.setChecked(true);
                pizzaHutButton.setChecked(false);
             //   invalidateOptionsMenu();
                break;

            case  R.id.naveenPizzaHutButton:
                dominosButton.setChecked(false);
                pizzaPizzaButton.setChecked(false);
                pizzaHutButton.setChecked(true);
              //  invalidateOptionsMenu();
                break;

            default:
                break;
        }

    }

    public void nextButtonClicked(View view){

        RadioButton  dominosButton = (RadioButton) findViewById(R.id.naveenDominosButton);
        RadioButton  pizzaPizzaButton = (RadioButton) findViewById(R.id.naveenPizzaButton);
        RadioButton  pizzaHutButton = (RadioButton) findViewById(R.id.naveenPizzaHutButton);




            if(dominosButton.isChecked()){
            imageChoosen("dominos_pizza");
        }else if(pizzaPizzaButton.isChecked()) {
            imageChoosen("pizza_pizza");
        }else if(pizzaHutButton.isChecked()){
            imageChoosen("pizza_hut");
        } else {
            Snackbar.make(view,"Select any restaurant",Snackbar.LENGTH_LONG).show();

        }


    }

    public void imageChoosen(String imgName){
        Intent intent = new Intent(this,KumarActivityOrderScreen.class);
        intent.putExtra("imageDisplay",imgName);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                RadioButton  pizzaPizzaButton = (RadioButton) findViewById(R.id.naveenPizzaButton);
                pizzaPizzaButton.setChecked(true);
                Toast.makeText(getApplicationContext(),"My favourite restaurant is selected",Toast.LENGTH_LONG).show();
                Log.i("nameID: ",String.valueOf(R.id.naveenMenuName));
                break;

            case R.id.naveenMenuPizza:
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.youtube.com"));
                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(NaveenActivity.this);
        alert.setMessage("Do you want to exit ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }
}