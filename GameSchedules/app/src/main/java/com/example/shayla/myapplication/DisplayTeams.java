package com.example.shayla.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class DisplayTeams extends Activity {
//    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb ;

    TextView name;
    TableLayout table_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_teams);
        name = (TextView) findViewById(R.id.editTextName);
        table_layout = (TableLayout) findViewById(R.id.tableLayout1);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            String fullName = extras.getString("name").trim();
            int firstPar = fullName.indexOf('(');
            String team = fullName.substring(0,firstPar).trim();
            String sport = fullName.substring(firstPar+1,fullName.length()-1).trim();

            if(team!=null){

                name.setText((CharSequence)team);
                name.setFocusable(false);
                name.setClickable(false);

                //Make Table with Schedule
                Cursor c = mydb.getGamesForTeam(team, sport);
                int rows = c.getCount();
                int cols = c.getColumnCount();

                c.moveToFirst();

                // outer for loop
                for (int i = 0; i < rows; i++) {

                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                            LayoutParams.WRAP_CONTENT));

                    // inner for loop
                    for (int j = 0; j < cols; j++) {

                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(14);
                        tv.setPadding(0, 5, 0, 5);

                        tv.setText(c.getString(j));

                        row.addView(tv);

                    }

                    c.moveToNext();

                    table_layout.addView(row);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if(extras !=null)
        {
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.display_teams, menu);
            }

            else{
                getMenuInflater().inflate(R.menu.menu_main, menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
//        super.onOptionsItemSelected(item);
//        switch(item.getItemId())
//        {
//            case R.id.Edit_Contact:
//                Button b = (Button)findViewById(R.id.button1);
//                b.setVisibility(View.VISIBLE);
//                name.setEnabled(true);
//                name.setFocusableInTouchMode(true);
//                name.setClickable(true);
//                return true;
//            case R.id.Delete_Contact:
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setMessage(R.string.deleteContact)
//                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
////                                mydb.deleteContact(id_To_Update);
////                                Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                                startActivity(intent);
//                            }
//                        })
//                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                // User cancelled the dialog
//                            }
//                        });
//                AlertDialog d = builder.create();
//                d.setTitle("Are you sure");
//                d.show();
//
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
        return false;
    }

    public void run(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int Value = extras.getInt("id");
            if(Value>0){
//                if(mydb.updateContact(id_To_Update,name.getText().toString(), phone.getText().toString(), email.getText().toString(), street.getText().toString(), place.getText().toString())){
//                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
//                }
            }
            else{
//                if(mydb.insertContact(name.getText().toString(), phone.getText().toString(), email.getText().toString(), street.getText().toString(), place.getText().toString())){
//                    Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
//                }
//
//                else{
//                    Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
//                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
