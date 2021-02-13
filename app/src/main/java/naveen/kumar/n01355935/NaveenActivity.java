package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class NaveenActivity extends AppCompatActivity {

    RadioButton dominosButton,pizzaPizzaButton,pizzaHutButton;


    public void radioButtonClick(View view){

       dominosButton = (RadioButton) findViewById(R.id.naveenDominosButton);
         pizzaPizzaButton = (RadioButton) findViewById(R.id.naveenPizzaButton);
         pizzaHutButton = (RadioButton) findViewById(R.id.naveenPizzaHutButton);

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
        if(dominosButton.isChecked()){
            imageChoosen("dominos_pizza");
        }
        else if(pizzaPizzaButton.isChecked()) {
            imageChoosen("pizza_pizza");
        }
        else if(pizzaHutButton.isChecked()){
            imageChoosen("pizza_hut");
        }
        else {
            finish();
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


}