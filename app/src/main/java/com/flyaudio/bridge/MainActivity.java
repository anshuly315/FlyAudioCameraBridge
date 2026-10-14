package com.flyaudio.bridge;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        Button button = new Button(this);
        button.setText("REAR CAMERA");
        button.setTextSize(22);
        button.setOnClickListener(v -> openRearCamera());
        setContentView(button);
    }

    private void openRearCamera() {
        try {
            Intent i = new Intent();
            i.setComponent(new ComponentName(
                "com.flyaudio.carvideo",
                "com.flyaudio.carvideo.external.ExternalService"
            ));
            i.putExtra("key_video_cmd", "cmd_show_video");
            i.putExtra("key_video_way", "back");
            startService(i);
            Toast.makeText(this, "Rear-camera command sent", Toast.LENGTH_SHORT).show();
        } catch (SecurityException e) {
            Toast.makeText(this, "FlyAudio permission denied: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Camera service error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
