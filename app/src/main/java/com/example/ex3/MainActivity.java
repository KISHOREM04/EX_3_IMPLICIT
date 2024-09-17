package com.example.ex3;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.urlText);
        Button btn = findViewById(R.id.btnNavigate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editText.getText().toString();
                if (url.isEmpty()) {
                    editText.setError("Please enter a URL");
                    return;
                }

                // Check if the URL starts with "http://" or "https://"
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url; // Default to http if no protocol is specified
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                // Verify that there is at least one app that can handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    editText.setError("No application can handle this request.");
                }
            }
        });
    }
}
