package gr.aueb.cf.loginscreensimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;
    private TextView registerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        registerTV = findViewById(R.id.registerTV);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

               if (isValidCredentials(username, password)) {
                   displayWelcomeMessage(username);
               } else {
                   displayErrorMessage();
               }
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("admin@gmail.com") && password.equals("password");
    }
    private void displayWelcomeMessage(String username) {
        String message = "Welcome " + username;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    private void displayErrorMessage() {
        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
    }

}