package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class KumarActivityPaymentScreen extends AppCompatActivity {

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

        String str = list.get(0);
        for(int i=1;i<list.size();i++){
            str = str + ","+list.get(i);
        }

        t1.setText(size);
        t2.setText(crust);
        t3.setText(str);

        //Spinner Code for province
        String[] province = {"ON","QC","BC","PE","NS","NB","NL","MB","SK","AB","YT","NT","NU"};
        Spinner provinceSpinner = findViewById(R.id.naveenSpinner);
        ArrayAdapter pA = new ArrayAdapter(this,android.R.layout.simple_spinner_item,province);
        pA.setDropDownViewResource(R.layout.spinner_list);
        provinceSpinner.setAdapter(pA);


    }
}