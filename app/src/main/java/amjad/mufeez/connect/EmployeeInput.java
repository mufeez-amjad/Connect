package amjad.mufeez.connect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EmployeeInput extends AppCompatActivity {

    private EditText et_name;
    private EditText et_phone;
    private EditText et_email;
    private EditText et_linkedin;
    private EditText et_github;
    private EditText et_devpost;
    private Button btn_save;

    private FirebaseAuth mAuth;


    // Access a Cloud Firestore instance from your Activity

    private FirebaseFirestore db;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seek_input);

        db =  FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

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
                // Create a new user with a first and last name
                Map<String, Object> profile = new HashMap<>();

                String name = et_name.getText().toString();
                String phone = et_phone.getText().toString();
                String email = et_email.getText().toString();
                String linkedin = et_linkedin.getText().toString();
                String git = et_github.getText().toString();
                String devpost = et_devpost.getText().toString();

                profile.put("name", name);
                profile.put("phone", phone);
                profile.put("email", email);
                profile.put("linkedin", linkedin);
                profile.put("github", git);
                profile.put("devpost", devpost);



                // Add a new document with a generated ID

                db.collection("seekers").document(user.getUid()).set(profile);

                /*db.collection("seekers/" + user.getUid())
                        .add(profile)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });*/


            toBeam();
            }

        });
    }

    public void toBeam(){
        //Intent intent = new Intent(this, SignUp.class);
        Intent intent = new Intent(this, Beam.class);
        startActivity(intent);
    }

}
