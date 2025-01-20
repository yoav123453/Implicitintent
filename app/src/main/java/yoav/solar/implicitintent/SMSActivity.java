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

public class SMSActivity extends AppCompatActivity {
    private EditText etMessageSms;
    private EditText etPhoneNumberSms;
    private Button btnSendSms;
    private Button btnBackSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_smsactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etMessageSms = findViewById(R.id.etMessageSms);
        etPhoneNumberSms = findViewById(R.id.etPhoneNumberSms);
        btnSendSms = findViewById(R.id.btnSendSms);
        btnBackSms = findViewById(R.id.btnBackSms);

        setOnListeners();
    }

    private void setOnListeners() {
        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumberSms.getText().toString();
                String message = etMessageSms.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + phoneNumber));
                intent.putExtra("sms_body", message);
                startActivity(intent);
            }
        });
        btnBackSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}