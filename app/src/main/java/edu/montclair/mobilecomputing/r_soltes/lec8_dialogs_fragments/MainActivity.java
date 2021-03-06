package edu.montclair.mobilecomputing.r_soltes.lec8_dialogs_fragments;

import android.app.DatePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_main);
        LinearLayout childLayout = new LinearLayout(this);
        childLayout.setOrientation(LinearLayout.VERTICAL);
        textView = new TextView(this);
        childLayout.addView(textView);


        for(int i = 0; i <= 9; i++){

            Button button = new Button(this);
            button.setText("" + i);
            button.setWidth(30);
            button.setHeight(10);
            button.setOnClickListener(new MyLstn());
            childLayout.addView(button);

        }

        linearLayout.addView(childLayout);
    }

    class MyLstn implements View.OnClickListener{
        @Override
        public void onClick(View view){

            //Toast.makeText(MainActivity.this, "You clicked " + ((Button)view).getText() , Toast.LENGTH_LONG).show();

            switch (((Button)view).getText().toString()){
               case "0":
                   AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
                   alertBox.setTitle("Alert When Click");
                   alertBox.setMessage("Button zero is clicked");
                   alertBox.show();
                   break;
                case "1":
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){

                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day){
                            textView.setText((month + 1) + "/" +  day  + "/" + year);
                        }
                    },2017,1,05);
                    datePickerDialog.show();
                    break;

            }

        }
    }


}
