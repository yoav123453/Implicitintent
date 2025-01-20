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

public class WhatsAppActivity extends AppCompatActivity {
    private EditText editTextMessage;
    private Button btnSendWA;
    private Button btnBackWA;
    private EditText etPhoneNumber;
    private Button btnSendWANoNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_whats_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
         editTextMessage = findViewById(R.id.etMessage);
         btnSendWA = findViewById(R.id.btnSendWA);
         etPhoneNumber = findViewById(R.id.etPhoneNumber);
         btnSendWANoNumber = findViewById(R.id.btnSendWANoNumber);
         btnBackWA = findViewById(R.id.btnBackWA);

        setOnListeners();
    }

    private void setOnListeners() {
        btnSendWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editTextMessage.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + message));
                startActivity(sendIntent);
            }
        });
        btnSendWANoNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editTextMessage.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
                    startActivity(intent);
                }
            }
        });
        btnBackWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}