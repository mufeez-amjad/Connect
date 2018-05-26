package amjad.mufeez.connect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmployeeInput extends AppCompatActivity {

    private EditText et_name;
    private EditText et_phone;
    private EditText et_email;
    private EditText et_linkedin;
    private EditText et_github;
    private EditText et_devpost;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seek_input);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_linkedin = (EditText) findViewById(R.id.et_linkedin);
        et_github = (EditText) findViewById(R.id.et_github);
        et_devpost = (EditText) findViewById(R.id.et_devpost);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }

}
