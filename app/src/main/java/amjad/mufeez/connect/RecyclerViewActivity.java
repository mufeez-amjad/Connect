package amjad.mufeez.connect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private RecyclerView rv;

    private FirebaseAuth mAuth;

    private FirebaseFirestore db;
    private FirebaseUser user;

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
    }

    private void initializeData(){
        profiles = new ArrayList<>();
        profiles.add(new JobSeekProfile("Jason1", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason2", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason3", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason4", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason5", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason6", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason7", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        profiles.add(new JobSeekProfile("Jason8", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
        List<String> UIDs = new ArrayList<String>();
        UIDs.add("ptmg5vytYSNRFP6QvZbARTZ08ph2");
                        Toast.makeText(RecyclerViewActivity.this, "Success!", Toast.LENGTH_SHORT).show();


                    } else {

                    }
                } else {

                }
            }
        });

        /*for (String str: UIDs) {
            DocumentReference docRef = db.collection("seekers").document(str);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Map<String, Object> profile = new HashMap<>();
                            profile = document.getData();
                            String name = profile.get("name").toString();
                            String phone = profile.get("phone").toString();
                            String email = profile.get("email").toString();
                            String linkedin = profile.get("linkedin").toString();
                            String github = profile.get("github").toString();
                            String devpost = profile.get("devpost").toString();
                            profiles.add(new JobSeekProfile(name,email,phone,linkedin,github,devpost, "lol"));
                            Log.i("Name", name);

                            Toast.makeText(RecyclerViewActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        } else {

                        }
                    } else {

                    }
                }
            });
        }*/

        profiles.add(new JobSeekProfile("Jason1", "test@gmail.com", "416-444-4444", "www.linkedin.com/test", "github.com/user/test", "Android Developer", "Devpost URL Here"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(profiles);
        rv.setAdapter(adapter);
    }
}