package yoav.solar.implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton IbCamera;
    private ImageButton IbWA;
    private ImageButton IbDial;
    private ImageButton IbSms;
    private ImageButton IbEmail;
    private ImageButton IbMapLines;
    private ImageButton IbMapAdress;
    private ImageButton IbWeb;
    private ImageButton IbYoutube;
    private ImageButton IbGoogleMaps;
    private ImageButton IbWaze;
    private ImageButton IbText_Message;
    private ImageButton IbAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        IbCamera = findViewById(R.id.IbCamera);
        IbWA = findViewById(R.id.IbWA);
        IbDial = findViewById(R.id.IbDial);
        IbSms = findViewById(R.id.IbSms);
        IbEmail = findViewById(R.id.IbEmail);
        IbMapLines = findViewById(R.id.IbMapLines);
        IbMapAdress = findViewById(R.id.IbMapAdress);
        IbWeb = findViewById(R.id.IbWeb);
        IbYoutube = findViewById(R.id.IbYoutube);
        IbGoogleMaps = findViewById(R.id.IbGoogleMaps);
        IbWaze = findViewById(R.id.IbWaze);
        IbText_Message = findViewById(R.id.IbText_Message);
        IbAlarm = findViewById(R.id.IbAlarm);

        setOnListeners();
    }

    private void setOnListeners() {
        IbCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
            }
        });

        IbWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WhatsAppActivity.class));
            }
        });

        IbDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DialActivity.class));
            }
        });

        IbSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SMSActivity.class));
            }
        });

        IbEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EmailActivity.class));
            }
        });

        IbMapLines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapLocationActivity.class));
            }
        });

        IbMapAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapAddressActivity.class));
            }
        });
        IbWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebActivity.class));
            }
        });

        IbYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, YouTubeActivity.class));
            }
        });

        IbGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GoogleMapsActivity.class));
            }
        });

        IbWaze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WazeActivity.class));
            }
        });

        IbText_Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TextMessageActivity.class));
            }
        });

        IbAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlarmActivity.class));
            }
        });
    }
}