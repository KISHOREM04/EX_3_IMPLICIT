## EXPERIMENT:03  Implement an application that uses Intent(Implicit) using Android Studio.
Design an Android application with a text field and an "Open in Browser" button. On pressing the button, the app should fetch the URL from the text field and open it in a browser using an Implicit Intent.

## AIM:

To design an Android application with a TextField and a button labeled "Open in Browser." Upon pressing the button, the application should retrieve the URL entered in the TextField and open it in the device's web browser using an implicit intent.
## EQUIPMENTS REQUIRED:

Latest Version Android Studio

## ALGORITHM:

Step 1: Open Android Stdio and then click on File -> New -> New project.

Step 2: Then type the Application name as implicitintent and click Next.

Step 3: Then select the Minimum SDK as shown below and click Next.

Step 4: Then select the Empty Activity and click Next. Finally click Finish.

Step 5: Design layout in activity_main.xml.

Step 6: Type any url, click navigate and that will take you to the expected url.

Step 7: Save and run the application.


## PROGRAM:
```
Program to print the text “Implicitintent”.
Developed by: KISHORE M
Registeration Number : 212222040079

```
## MainActivity.java:
```
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
```
## activitymain.xml:
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/urlText"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="100dp"
        android:ems="10" />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/btnNavigate"
        android:layout_below="@+id/urlText"
        android:text="Navigate"
        android:layout_centerHorizontal="true" />
</RelativeLayout>
```

## OUTPUT


![image](https://github.com/user-attachments/assets/f0404fe8-4029-45c4-9e4f-06595f23c75e)
![image](https://github.com/user-attachments/assets/9cd8b82d-9d85-45fd-bd65-14fb13a82559)
![Screenshot 2024-09-17 134638](https://github.com/user-attachments/assets/36c956fe-1df2-4e07-9011-cdb2e0619cfe)


## RESULT
Thus a Simple Android Application create a navigate button using Implicit Intent to display the web page using Android Studio was developed and executed successfully.
