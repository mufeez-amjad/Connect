package amjad.mufeez.connect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewActivity extends Activity {

    private List<JobSeekProfile> profiles;

    private List<JobSeekProfile> seekers;

    private RecyclerView rv;

    private FirebaseAuth mAuth;

    private FirebaseFirestore db;
    private FirebaseUser user;

    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db =  FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        setContentView(R.layout.recyclerview_activity);

        rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        btn_add = (Button) findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReceive();
            }

        });
    }

    private void toReceive() {
        Intent intent = new Intent(this, Receive.class);
        startActivity(intent);
    }

    private void initializeData(){
        profiles = new ArrayList<>();
        seekers = new ArrayList<>();
        List<String> UIDs = new ArrayList<String>();
        UIDs.add("Jvq5GdCdoLeoIc1NhUD8BGqxSJP2");
        UIDs.add("ptmg5vytYSNRFP6QvZbARTZ08ph2");
        JobSeekProfile seeker;
        DocumentReference docRef = db.collection("seekers").document("ptmg5vytYSNRFP6QvZbARTZ08ph2");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String name = document.get("name").toString();
                        String phone = document.get("phone").toString();
                        String email = document.get("email").toString();
                        String linkedin = document.get("linkedin").toString();
                        String github = document.get("github").toString();
                        String devpost = document.get("devpost").toString();

                        JobSeekProfile seeker = new JobSeekProfile("" + name, "" + email,  "" + phone,"" + linkedin, "" + github,"lol", "" + devpost);
                        seekers.add(seeker);
                        //JobSeekProfile seeker = new JobSeekProfile("Name", "Email",  "Phone","linkedin", "github","lol", "devpost");

                        Log.i("Name", name);

                        Toast.makeText(RecyclerViewActivity.this, "Success!", Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });

        DocumentReference docRef2 = db.collection("seekers").document("Jvq5GdCdoLeoIc1NhUD8BGqxSJP2");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String name = document.get("name").toString();
                        String phone = document.get("phone").toString();
                        String email = document.get("email").toString();
                        String linkedin = document.get("linkedin").toString();
                        String github = document.get("github").toString();
                        String devpost = document.get("devpost").toString();

                        JobSeekProfile seeker = new JobSeekProfile("" + name, "" + email,  "" + phone,"" + linkedin, "" + github,"lol", "" + devpost);
                        seekers.add(seeker);
                        //JobSeekProfile seeker = new JobSeekProfile("Name", "Email",  "Phone","linkedin", "github","lol", "devpost");

                        Log.i("Name", name);

                        Toast.makeText(RecyclerViewActivity.this, "Success!", Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });

        for (JobSeekProfile s: seekers){
            //profiles.add(s);
        }

        profiles.add(new JobSeekProfile("Jason1", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason2", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(profiles);
        rv.setAdapter(adapter);
    }
}