package vcmanea.example.android02_edittext_settext_gettext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText myName;
    EditText myPassword;

    public void myButton(View view) {
        String user=myName.getText().toString();
        String password=myPassword.getText().toString();
        textView.setText(String.format("User is %s and the password is %s",user,password));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        myName = findViewById(R.id.myName);
        myPassword = findViewById(R.id.myPassword);

    }
}
