package amjad.mufeez.connect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Intro extends AppCompatActivity {

    //private Button button;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        view = (View) findViewById(R.id.introV);

        view.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                openLogin();
            }
        });
    }

    public void openLogin(){
        startActivity(new Intent(this, Login.class));
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}
