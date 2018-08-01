package sg.edu.rp.c346.reservationenhanced;



import android.app.DatePickerDialog;

import android.app.TimePickerDialog;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;

import android.util.Log;

import android.view.View;

import android.widget.Button;

import android.widget.CheckBox;

import android.widget.DatePicker;

import android.widget.EditText;

import android.widget.Spinner;

import android.widget.TextView;

import android.widget.TimePicker;

import android.widget.Toast;

import android.widget.ToggleButton;



import java.util.Calendar;

import java.util.Date;



public class MainActivity extends AppCompatActivity {



    EditText name;

    EditText mobile;

    EditText pax;

    EditText date;

    EditText time;

    CheckBox smoke;

    Button reset;

    Button confirm;





    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        name = findViewById(R.id.editTextName);

        mobile = findViewById(R.id.editTextMobile);

        date = findViewById(R.id.editTextDay);

        time = findViewById(R.id.editTextTime);

        smoke = findViewById(R.id.checkBox);

        reset = findViewById(R.id.buttonReset);

        confirm = findViewById(R.id.buttonConfirm);

        pax = findViewById(R.id.editTextPax);



        date.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {

                    @Override

                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        date.setText("Date: " + dayOfMonth + "/" + (month+1) + "/" + year);

                    }

                };



                // Create the Date Picker Dialog

                Calendar calender = Calendar.getInstance();

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,

                        myDateListener, calender.get(Calendar.YEAR),calender.get(Calendar.MONTH)+1,calender.get(Calendar.DAY_OF_MONTH));

                date.setText("Date: " + calender.get(Calendar.DAY_OF_MONTH) + "/" + (calender.get(Calendar.MONTH)+1) + "/" + calender.get(Calendar.YEAR));

                myDateDialog.show();

            }

        });



        time.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                // Create the Listener to set the time

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {

                    @Override

                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        time.setText("Time: " + hourOfDay + ":" + minute);

                    }

                };



                // Create the Time Picker Dialog

                Date currentTime = Calendar.getInstance().getTime();

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,

                        myTimeListener,currentTime.getHours(),currentTime.getMinutes(),true);



                myTimeDialog.show();



            }

        });





        confirm.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {





                String smokeornot ="";

                if (smoke.isChecked()) {

                    smokeornot = "Smoking Area";

                }

                else {

                    smokeornot = "Non-smoking Area";

                }





                String mobilenum = mobile.getText().toString();

                String namee = name.getText().toString();

                String paxx = pax.getText().toString();



                if (TextUtils.isEmpty(mobilenum) || TextUtils.isEmpty(namee) || TextUtils.isEmpty(paxx)) {

                    Toast.makeText(MainActivity.this,"One of the fields is empty", Toast.LENGTH_LONG).show();

                }

                else {

                    Context context = MainActivity.this;

                    CharSequence text = "Reservation confirmed for " + name.getText().toString()

                            + "\n" + "Mobile Number: " + mobile.getText().toString()

                            + "\n" + "Pax: " + pax.getText().toString()

                            + "\n" + date.getText().toString()

                            + "\n" + time.getText().toString()

                            + "\n" + "Location: " + smokeornot;

                    int duration = Toast.LENGTH_LONG;



                    Toast toast = Toast.makeText(context,text,duration);

                    toast.show();

                }



            }

        });



        reset.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                name.setText("");

                mobile.setText("");

                pax.setText("");

                date.setText("");

                time.setText("");

                smoke.setChecked(false);

            }

        });

    }

}