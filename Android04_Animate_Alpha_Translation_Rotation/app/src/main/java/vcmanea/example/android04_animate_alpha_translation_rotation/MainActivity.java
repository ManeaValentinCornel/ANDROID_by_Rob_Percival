package vcmanea.example.android04_animate_alpha_translation_rotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    boolean flag1=true;
    boolean flag2=true;
    boolean flag3=true;
    boolean flag4=true;

    public void alpha(View view){
        if(flag1){
            imageView.animate().alpha(0.0f).setDuration(2000);
        }
        else{
            imageView.animate().alpha(1.0f).setDuration(2000);
        }
        flag1=!flag1;

    }
    public void scale(View view){
        if(flag2){
            imageView.animate().scaleX(2.0f).scaleY(2.0f).setDuration(2000);
        }
        else{
            imageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);

        }
        flag2=!flag2;

    }
    public void translation(View view){
        if(flag3){
            imageView.animate().translationX(500f).setDuration(2000);
        }
        else{
            imageView.animate().translationX(-500f).setDuration(2000);
        }
        flag3=!flag3;

    }
    public void rotation(View view){
        if(flag4){
            imageView.animate().rotation(360).setDuration(2000);
        }
        else{
            imageView.animate().rotation(-360).setDuration(2000);
        }
        flag4=!flag4;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.asterix);

    }
}
