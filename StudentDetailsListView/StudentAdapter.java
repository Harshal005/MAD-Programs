import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private final Context context;
    private final List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        super(context, R.layout.list_item_student, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the custom layout
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_student, parent, false);
        }

        // Get the current student
        Student currentStudent = students.get(position);

        // Populate the views with data
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewAge = convertView.findViewById(R.id.textViewAge);
        textViewName.setText(currentStudent.getName());
        textViewAge.setText("Age: " + currentStudent.getAge());

        return convertView;
    }
}
