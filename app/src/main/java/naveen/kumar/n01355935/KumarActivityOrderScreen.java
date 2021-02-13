package naveen.kumar.n01355935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class KumarActivityOrderScreen extends AppCompatActivity {

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