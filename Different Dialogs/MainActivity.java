package com.example.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAlertDialog, btnDatePickerDialog, btnTimePickerDialog, btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
        btnCustomDialog = findViewById(R.id.btnCustomDialog);

        // Show Alert Dialog
        btnAlertDialog.setOnClickListener(v -> showAlertDialog());

        // Show Date Picker Dialog
        btnDatePickerDialog.setOnClickListener(v -> showDatePickerDialog());

        // Show Time Picker Dialog
        btnTimePickerDialog.setOnClickListener(v -> showTimePickerDialog());

        // Show Custom Dialog
        btnCustomDialog.setOnClickListener(v -> showCustomDialog());
    }

    // Alert Dialog
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog")
                .setMessage("This is a simple alert dialog.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Date Picker Dialog
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    // Handle the selected date
                    String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                }, year, month, day);
        datePickerDialog.show();
    }

    // Time Picker Dialog
    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> {
                    // Handle the selected time
                    String selectedTime = hourOfDay + ":" + minute1;
                }, hour, minute, true);
        timePickerDialog.show();
    }

    // Custom Dialog
    private void showCustomDialog() {
        // Inflate the custom layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.custom_dialog_layout, null);
        EditText editText = dialogLayout.findViewById(R.id.editTextName);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom Dialog")
                .setView(dialogLayout)
                .setPositiveButton("Submit", (dialog, which) -> {
                    String name = editText.getText().toString();
                    // Handle the name input
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
