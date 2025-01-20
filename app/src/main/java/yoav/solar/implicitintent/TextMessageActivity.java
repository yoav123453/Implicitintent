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

public class TextMessageActivity extends AppCompatActivity {
    private EditText etPhoneNumberTextMessage;
    private Button btnSendMessage;
    private Button btnBackTextMessage;
    private EditText etMessageBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etPhoneNumberTextMessage = findViewById(R.id.etPhoneNumberTextMessage);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnBackTextMessage = findViewById(R.id.btnBackTextMessage);
        etMessageBody = findViewById(R.id.etMessageBody);

        setOnListeners();
    }

    private void setOnListeners() {
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = etPhoneNumberTextMessage.getText().toString();
                String messageBody = etMessageBody.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + phoneNumber));
                intent.putExtra("sms_body", messageBody);
                startActivity(intent);
            }
        });
        btnBackTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}