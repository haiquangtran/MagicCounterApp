package com.example.hai.magiccounter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    /**
     *  Rolls a 6 sided dice:
     *  Chooses a random number between 1 and 6
     *  and displays the result at the center of the screen.
     */
    public void rollDiceAndDisplayResult(View view) {
        Toast diceResult = Toast.makeText(getApplicationContext(),  String.format("You rolled a %d on the dice.", randomNumber(6)), Toast.LENGTH_SHORT);
        diceResult.setGravity(Gravity.CENTER, 0, 0);
        diceResult.show();
    }

    /**
     *  Flips a coin:
     *  Chooses either heads or tails and
     *  displays the result at the center of the screen.
     *
     * @param view
     */
    public void flipCoinAndDisplayResult(View view) {
        Toast coinResult = Toast.makeText(getApplicationContext(), String.format("You flipped a %s on the coin.", flipCoin()), Toast.LENGTH_SHORT);
        coinResult.setGravity(Gravity.CENTER, 0, 0);
        coinResult.show();
    }

    /**
     *  Randomly chooses either heads or tails
     *  and returns the result as a string.
     *
     *  Throws a no such element exception if it is anything else.
     *
     * @return string type of heads or tails
     */
    private String flipCoin() {
        switch (randomNumber(2)) {
            case 1:
                return "heads";
            case 2:
                return "tails";
            default:
                throw new NoSuchElementException();
        }
    }

    /**
     *  Produces a random number from 1
     *  to the maximum number specified.
     *  The maximum number is inclusive.
     *
     * @param max number
     * @return random number within the range
     */
    public int randomNumber(int max) {
        return (int)(Math.random()*max+1);
    }

}
