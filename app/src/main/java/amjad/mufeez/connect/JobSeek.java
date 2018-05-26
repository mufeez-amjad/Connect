package amjad.mufeez.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class JobSeek extends AppCompatActivity {

    private Button btn_add;
    private Button btn_apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seek);
        btn_add = (Button) findViewById(R.id.btn_add);
    }
}
