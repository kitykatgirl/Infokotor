package ph.me.infokotor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Switch switchColor = findViewById(R.id.switch1);
        ImageView kotek = findViewById(R.id.imageCat);
        Button prev = findViewById(R.id.buttonPrev);
        Button next = findViewById(R.id.buttonNext);
        EditText editText = findViewById(R.id.editTextKotek);
        LinearLayout main = findViewById(R.id.main);

        final int[] currentKotek = {0};

        int[] listKotki = {R.drawable.kot1,R.drawable.kot2,R.drawable.kot3,R.drawable.kot4};

        switchColor.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                        if (b){
                            main.setBackgroundColor(getResources().getColor(R.color.butTheyreBlue));
                        }
                        else {
                            main.setBackgroundColor(getResources().getColor(R.color.lighterGreen));
                        }
                    }
                }
        );

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentKotek[0] == 3){
                            currentKotek[0] = 0;
                        }
                        else {
                            currentKotek[0]++;
                        }
                        kotek.setImageDrawable(getDrawable(listKotki[currentKotek[0]]));
                    }
                }
        );

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentKotek[0] == 0){
                            currentKotek[0] = 3;
                        }
                        else {
                            currentKotek[0]--;
                        }
                        kotek.setImageDrawable(getDrawable(listKotki[currentKotek[0]]));
                    }
                }
        );
    }
}