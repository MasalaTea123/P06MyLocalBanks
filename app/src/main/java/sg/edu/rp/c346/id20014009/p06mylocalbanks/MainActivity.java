package sg.edu.rp.c346.id20014009.p06mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked="";

    boolean togglefavouriteDBS=false;
    boolean togglefavouriteOCBC=false;
    boolean togglefavouriteUOB=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS=findViewById(R.id.tvDBS);
        tvOCBC=findViewById(R.id.tvOCBC);
        tvUOB=findViewById(R.id.tvUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);

        if (v==tvDBS){
            wordClicked="DBS";
        }
        else if(v==tvOCBC){
            wordClicked="OCBC";
        }
        else if(v==tvUOB){
            wordClicked="UOB";
        }

    }

        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(wordClicked.equalsIgnoreCase("DBS")){
            if (id==R.id.website) { //check whether the selected menu item ID is 0
                //code for action

                String website1=getString(R.string.URL1);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse((website1)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (id==R.id.phonenumber) { //check if the selected menu item ID is 1
                //code for action
                String phone1=getString(R.string.Number1);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(phone1));
                startActivity(intent);
                return true;  //menu item successfully handled
            }
            else if(id==R.id.togglefavourite){
                if(!togglefavouriteDBS){
                    togglefavouriteDBS=true;
                    tvDBS.setTextColor(Color.RED);
                }
                else{
                    togglefavouriteDBS=false;
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        }
        else if(wordClicked.equalsIgnoreCase("OCBC")){
            if (id==R.id.website) { //check whether the selected menu item ID is 0
                //code for action

                String website2=getString(R.string.URL2);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse((website2)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (id==R.id.phonenumber) { //check if the selected menu item ID is 1
                //code for action
                String phone2=getString(R.string.Number2);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse((phone2)));
                startActivity(intent);
                return true;  //menu item successfully handled
            }
            else if(id==R.id.togglefavourite){
                if(!togglefavouriteOCBC){
                    togglefavouriteOCBC=true;
                    tvOCBC.setTextColor(Color.RED);
                }
                else{
                    togglefavouriteOCBC=false;
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
        }
        else if(wordClicked.equalsIgnoreCase("UOB")){
            if (id==R.id.website) { //check whether the selected menu item ID is 0
                //code for action
                String website3=getString(R.string.URL3);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse((website3)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (id==R.id.phonenumber) { //check if the selected menu item ID is 1
                //code for action
                String phone3=getString(R.string.Number3);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse((phone3)));
                startActivity(intent);
                return true;  //menu item successfully handled
            }
            else if(id==R.id.togglefavourite){
                if(!togglefavouriteUOB){
                    togglefavouriteUOB=true;
                    tvUOB.setTextColor(Color.RED);
                }
                else{
                    togglefavouriteUOB=false;
                    tvUOB.setTextColor(Color.BLACK);
                }
            }

        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }





    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            String bankname1=getString(R.string.dbs);
            String bankname2=getString(R.string.ocbc);
            String bankname3=getString(R.string.uob);



            tvDBS.setText(bankname1);
            tvOCBC.setText(bankname2);
            tvUOB.setText(bankname3);
            return true;
        } else if (id == R.id.ChineseSelection) {
            String banknamec1=getString(R.string.bank1chinese);
            String banknamec2=getString(R.string.bank2chinese);
            String banknamec3=getString(R.string.bank3chinese);


            tvDBS.setText(banknamec1);
            tvOCBC.setText(banknamec2);
            tvUOB.setText(banknamec3);
            return true;
        } else {

            String error=getString(R.string.error);
            tvDBS.setText(error);
            tvOCBC.setText(error);
            tvUOB.setText(error);
        }

        return super.onOptionsItemSelected(item);
    }


}