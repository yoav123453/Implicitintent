package yoav.solar.implicitintent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WazeActivity extends AppCompatActivity {
    private EditText etWazeLocation;
    private Button btnOpenWaze;
    private Button btnBackWaze;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_waze);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etWazeLocation = findViewById(R.id.etWazeLocation);
        btnOpenWaze = findViewById(R.id.btnOpenWaze);
        btnBackWaze = findViewById(R.id.btnBackWaze);

        setOnListeners();
    }

    private void setOnListeners() {
        btnOpenWaze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = etWazeLocation.getText().toString();
                Uri wazeUri = Uri.parse("waze://?q=" + location);
                Intent wazeIntent = new Intent(Intent.ACTION_VIEW, wazeUri);
                wazeIntent.setPackage("com.waze");

                if (isAppInstalled("com.waze")) {
                    startActivity(wazeIntent);
                } else {
                    Toast.makeText(WazeActivity.this, "Waze is not installed on this device.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBackWaze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private boolean isAppInstalled(String packageName) {
        PackageManager packageManager = getPackageManager();
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}