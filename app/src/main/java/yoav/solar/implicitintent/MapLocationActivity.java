package yoav.solar.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MapLocationActivity extends AppCompatActivity {
    private EditText etLatitude;
    private Button btnShowLocation;
    private EditText etLongitude;
    private Button btnBackMapLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_location);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        btnShowLocation = findViewById(R.id.btnShowLocation);
        btnBackMapLocation = findViewById(R.id.btnBackMapLocation);

        setOnListeners();
    }

    private void setOnListeners() {
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String latitude = etLatitude.getText().toString();
                String longitude = etLongitude.getText().toString();

                Uri locationUri = Uri.parse("geo:" + latitude + "," + longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);
                startActivity(intent);
            }
        });
        btnBackMapLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}