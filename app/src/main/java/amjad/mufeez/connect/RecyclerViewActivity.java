package amjad.mufeez.connect;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<JobSeekProfile> profiles;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(profiles);
        rv.setAdapter(adapter);
    }
}