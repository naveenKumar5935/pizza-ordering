package naveen.kumar.n01355935;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

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
                break;

            case R.id.naveenPizzaButton:
                dominosButton.setChecked(false);
                pizzaPizzaButton.setChecked(true);
                pizzaHutButton.setChecked(false);
                break;

            case  R.id.naveenPizzaHutButton:
                dominosButton.setChecked(false);
                pizzaPizzaButton.setChecked(false);
                pizzaHutButton.setChecked(true);
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