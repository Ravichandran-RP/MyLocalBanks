package sg.edu.rp.c346.id20026389.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView displayDBS;
    TextView displayOCBC;
    TextView displayUOB;
    String wordClicked;
    String favBank="empty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayDBS=findViewById(R.id.textviewDBS);
        displayOCBC=findViewById(R.id.textViewOCBC);
        displayUOB=findViewById(R.id.textViewUOB);
        registerForContextMenu(displayDBS);
        registerForContextMenu(displayOCBC);
        registerForContextMenu(displayUOB);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");
        if(v==displayDBS){
            wordClicked="dbs";
        }
        else if (v==displayOCBC){
            wordClicked="ocbc";
        }
        else if (v==displayUOB){
            wordClicked="uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Bank website is chosen", Toast.LENGTH_SHORT).show();

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18001111111"));
                startActivity(intentCall);
                Toast.makeText(MainActivity.this, "Contact the bank is chosen", Toast.LENGTH_SHORT).show();
                return true;  //menu item successfully handled
            }
            else if(item.getItemId()==2){
                if(!favBank.equalsIgnoreCase("dbs")){
                    displayDBS.setTextColor(Color.RED);
                    favBank="dbs";
                }else{
                    displayDBS.setTextColor(Color.BLACK);
                    favBank="empty";
                }
            }

        }
        else if(wordClicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Bank website is chosen", Toast.LENGTH_SHORT).show();

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18003633333"));
                startActivity(intentCall);
                Toast.makeText(MainActivity.this, "Contact the bank is chosen", Toast.LENGTH_SHORT).show();

                return true;  //menu item successfully handled
            }
            else if(item.getItemId()==2){
                if(!favBank.equalsIgnoreCase("ocbc")){
                    displayOCBC.setTextColor(Color.RED);
                    favBank="ocbc";
                }else{
                    displayOCBC.setTextColor(Color.BLACK);
                    favBank="empty";
                }
            }
        }
        else if(wordClicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Bank website is chosen", Toast.LENGTH_SHORT).show();

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                Toast.makeText(MainActivity.this, "Contact the bank is chosen", Toast.LENGTH_SHORT).show();

                return true;  //menu item successfully handled
            }
            else if(item.getItemId()==2){
                if(!favBank.equalsIgnoreCase("uob")){
                    displayUOB.setTextColor(Color.RED);
                    favBank="uob";
                }else{
                    displayUOB.setTextColor(Color.BLACK);
                    favBank="empty";
                }
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            displayDBS.setText("DBS");
            displayOCBC.setText("OCBC");
            displayUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            displayDBS.setText("星展银行");
            displayOCBC.setText("华侨银行");
            displayUOB.setText("大华银行");
            return true;
        } else {
            displayDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


}