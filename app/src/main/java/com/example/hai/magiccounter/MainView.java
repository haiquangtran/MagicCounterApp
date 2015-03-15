package com.example.hai.magiccounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainView extends Activity {
    private Player player1;
    private Player player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        player1 = new Player(20, "Player 1");
        player2 = new Player(20, "Player 2");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void incrementLife(View view) {
        switch(view.getId()){
            case R.id.buttonAdd1:
                player1.incrementScore();
                TextView player1View = (TextView) findViewById(R.id.player1Life);
                player1View.setText(player1.getScore());
                break;
            case R.id.buttonAdd2:
                player2.incrementScore();
                TextView player2View = (TextView) findViewById(R.id.player2Life);
                player2View.setText(player2.getScore());
                break;
            default:
                throw new NullPointerException();
        }
    }

    public void decrementLife(View view) {
        switch(view.getId()){
            case R.id.buttonMinusOne:
                player1.decrementScore();
                TextView player1View = (TextView) findViewById(R.id.player1Life);
                player1View.setText(player1.getScore());
                break;
            case R.id.buttonMinus2:
                player2.decrementScore();
                TextView player2View = (TextView) findViewById(R.id.player2Life);
                player2View.setText(player2.getScore());
                break;
            default:
                throw new NullPointerException();
        }
    }
}
