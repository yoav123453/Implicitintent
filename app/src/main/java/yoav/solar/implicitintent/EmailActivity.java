package yoav.solar.implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmailActivity extends AppCompatActivity {
    private EditText etEmailRecipient;
    private EditText etEmailSubject;
    private EditText etEmailMessage;
    private Button btnSendEmail;
    private Button btnBackEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_email);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();

    }

    private void initializeViews() {
        etEmailRecipient = findViewById(R.id.etEmailRecipient);
        etEmailSubject = findViewById(R.id.etEmailSubject);
        etEmailMessage = findViewById(R.id.etEmailMessage);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnBackEmail = findViewById(R.id.btnBackEmail);

        setOnListeners();
    }

    private void setOnListeners() {
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = etEmailRecipient.getText().toString();
                String subject = etEmailSubject.getText().toString();
                String message = etEmailMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });
        btnBackEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}