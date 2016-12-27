package enterprise.sample.com.add_logline_text_to_file;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    int value = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String filename = "sd.txt";

                File file = new File(Environment.getExternalStorageDirectory(), filename);

                    // Add permission to AndroidManifest.xml <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

                try
                {

                    FileWriter fw = new FileWriter(file,true); //the true will append the new data
                    fw.write(Integer.toString(value)+" add a line\n");//appends the string to the file
                    fw.close();
                    value=value+1;
                }
                catch(IOException ioe)
                {
                    System.err.println("IOException: " + ioe.getMessage());
                }

                // handle exception

            }
        });



    }
}

