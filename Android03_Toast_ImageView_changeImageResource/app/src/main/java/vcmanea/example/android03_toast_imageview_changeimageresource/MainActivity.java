package vcmanea.example.android03_toast_imageview_changeimageresource;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    boolean flag = true;

    public void change(View view) {
        Toast.makeText(this, "Image changed", Toast.LENGTH_LONG).show();
        if (flag) {
            imageView.setBackgroundResource(R.drawable.bee);
        } else {
            imageView.setBackgroundResource(R.drawable.ugly);
        }
        flag = !flag;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.ugly);


    }
}
