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

public class YouTubeActivity extends AppCompatActivity {
    private EditText etYoutubeUrl;
    private Button btnOpenYoutube;
    private Button btnBackYoutube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_you_tube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etYoutubeUrl = findViewById(R.id.etYoutubeUrl);
        btnOpenYoutube = findViewById(R.id.btnOpenYoutube);
        btnBackYoutube = findViewById(R.id.btnBackYoutube);

        setOnListeners();
    }

    private void setOnListeners() {
        btnOpenYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etYoutubeUrl.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);
            }
        });

        btnBackYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}