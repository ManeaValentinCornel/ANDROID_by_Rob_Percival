package vcmanea.example.android07_intent_listview_arrayadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView=findViewById(R.id.textView);
        Intent intet=getIntent();
        String name=intet.getStringExtra("id");
        textView.setText(name);
    }
}
