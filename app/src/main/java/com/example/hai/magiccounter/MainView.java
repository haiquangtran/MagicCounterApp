package com.example.hai.magiccounter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.NoSuchElementException;


public class MainView extends Activity {
    private Player player1;
    private Player player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        // Create a new game
        newGame(this.findViewById(android.R.id.content));
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

    /**
     *  Increments the life of the given player when
     *  the add life button has been pressed and
     *  displays the updated life score on the screen.
     *
     * @param view
     */
    public void incrementLife(View view) {
        int elementId = view.getId();

        switch (elementId) {
            // Player 1
            case R.id.buttonAdd1:
                player1.incrementScore();
                updateLifeTextView(R.id.player1Life);
                break;
            // Player 2
            case R.id.buttonAdd2:
                player2.incrementScore();
                updateLifeTextView(R.id.player2Life);
                break;
            default:
                throw new NoSuchElementException();
        }
    }

    /**
     *  Decrements the life of the given player when
     *  the minus life button has been pressed and
     *  displays the updated life score on the screen.
     *
     * @param view
     */
    public void decrementLife(View view) {
        int elementId = view.getId();

        switch (elementId) {
            // Player 1
            case R.id.buttonMinusOne:
                player1.decrementScore();
                updateLifeTextView(R.id.player1Life);
                break;
            // Player 2
            case R.id.buttonMinus2:
                player2.decrementScore();
                updateLifeTextView(R.id.player2Life);
                break;
            default:
                throw new NoSuchElementException();
        }

    }

    /**
     * Updates the life score text view with the the players score given the player id
     *
     * @param playerId
     */
    public void updateLifeTextView(int playerId) {
        switch (playerId) {
            case R.id.player1Life:
                TextView player1View = (TextView) findViewById(playerId);
                player1View.setText(player1.getScore());
                break;
            case R.id.player2Life:
                TextView player2View = (TextView) findViewById(playerId);
                player2View.setText(player2.getScore());
                break;
            default:
                throw new NoSuchElementException();
        }
    }

    /**
     *  Creates a new game with 2 players starting with 20 life
     */
    public void newGame(View view) {
        player1 = new Player(20, "Player 1");
        player2 = new Player(20, "Player 2");
        // Update the views
        updateLifeTextView(R.id.player1Life);
        updateLifeTextView(R.id.player2Life);
    }

}
