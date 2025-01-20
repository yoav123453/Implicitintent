package yoav.solar.implicitintent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
    private EditText etHour;
    private Button btnSetAlarm;
    private Button btnBackAlarm;
    private EditText etMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alarm);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }

    private void initializeViews() {
        etHour = findViewById(R.id.etHour);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        btnBackAlarm = findViewById(R.id.btnBackAlarm);
        etMinute = findViewById(R.id.etMinute);

        setOnListeners();
    }

    private void setOnListeners() {
        btnSetAlarm.setOnClickListener(v -> {
            String hourText = etHour.getText().toString().trim();
            String minuteText = etMinute.getText().toString().trim();

            if (hourText.isEmpty() || minuteText.isEmpty()) {
                Toast.makeText(this, "Please enter both hour and minute", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int hour = Integer.parseInt(hourText);
                int minute = Integer.parseInt(minuteText);

                if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                    Toast.makeText(this, "Please enter a valid time", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_HOUR, hour)
                        .putExtra(AlarmClock.EXTRA_MINUTES, minute)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No Clock app available to set the alarm", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid input. Please enter numbers only.", Toast.LENGTH_SHORT).show();
            }
        });
        btnBackAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}