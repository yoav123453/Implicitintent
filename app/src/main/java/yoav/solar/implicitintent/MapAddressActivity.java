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

public class MapAddressActivity extends AppCompatActivity {
    private EditText etAddress;
    private Button btnShowAddress;
    private Button btnBackMapAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_address);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etAddress = findViewById(R.id.etAddress);
        btnShowAddress = findViewById(R.id.btnShowAddress);
        btnBackMapAddress = findViewById(R.id.btnBackMapAddress);
        setOnListeners();
    }

    private void setOnListeners() {
        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = etAddress.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + address);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                startActivity(intent);
            }
        });
        btnBackMapAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}