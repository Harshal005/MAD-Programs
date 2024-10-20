import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewStudents = findViewById(R.id.listViewStudents);

        // Create a list of students
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 20));
        studentList.add(new Student("Bob", 22));
        studentList.add(new Student("Charlie", 21));
        studentList.add(new Student("David", 23));
        studentList.add(new Student("Eve", 19));

        // Create an adapter
        StudentAdapter adapter = new StudentAdapter(this, studentList);

        // Set the adapter to the ListView
        listViewStudents.setAdapter(adapter);
    }
}
