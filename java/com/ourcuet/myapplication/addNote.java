package com.ourcuet.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class addNote extends AppCompatActivity {

    public static final String EXTRA_TITLE=
            "com.ourcuet.myapplication.Extra_TITLE";
    public static final String EXTRA_priority=
            "com.ourcuet.myapplication.Extra_priority";
    public static final String EXTRA_Description=
            "com.ourcuet.myapplication.Extra_des";
    public static final int RESULT_OK=1;
    private EditText editText_title;
    private EditText editText_description;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editText_title=findViewById(R.id.text_title);
        editText_description=findViewById(R.id.text_description);
        numberPicker=findViewById(R.id.Number_picker);
        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Add Note");



    }

    private void saveNote(){
        String title =editText_title.getText().toString();
        String description=editText_description.getText().toString();
        int priority =numberPicker.getValue();

        if(title.trim().isEmpty()||description.trim().isEmpty()){

            Toast.makeText(this, "Please Insert A title and Description", Toast.LENGTH_SHORT).show();
        }
        else{

            Intent intent=new Intent();

            intent.putExtra(EXTRA_TITLE,title);
            intent.putExtra(EXTRA_Description,description);

            intent.putExtra(EXTRA_priority,priority);
            setResult(RESULT_OK,intent);

            finish();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_button:
                saveNote();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
