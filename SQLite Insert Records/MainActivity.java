import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail;
    Button buttonInsert;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonInsert = findViewById(R.id.buttonInsert);

        // Create instance of DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Insert data on button click
        buttonInsert.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();

            // Insert the user into the database
            boolean isInserted = databaseHelper.insertUser(name, email);

            if (isInserted) {
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
