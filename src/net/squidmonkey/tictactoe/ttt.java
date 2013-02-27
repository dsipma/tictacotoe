package net.squidmonkey.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ttt extends Activity {
    private int[][] board = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private TextView message;
    private Button button;
    private int xwin = -1; // -1 if no winning row
    private int owin = -1;  // -1 is no winning row
    private int move = 0; //even is x's turn, y is y's turn

    /* x = 3, o = 4 so that the sums don't give false wins

                                7
    win rows           x  x  x  0
                       x  x  x  1
                       x  x  x  2
                       3  4  5  6
     */

    private void showToast(String text) {
        //DEBUGGING TOAST MESSAGES
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
        //END DEBUGGING
    }
    private void checkForWin() {

        //check for horizontal wins
        for (int i = 0; i < 3; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 9)
                xwin = i;
            if (board[i][0] + board[i][1] + board[i][2] == 12)
                owin = i;
        }

        //check for vertical wins
        for (int i = 0; i < 3; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == 9)
                xwin = i + 3;
            if (board[0][i] + board[1][i] + board[2][i] == 12)
                owin = i + 3;
        }

        //check for diagonal wins
        if (board[0][0] + board[1][1] + board[2][2] == 9)
            xwin = 6;
        if (board[0][0] + board[1][1] + board[2][2] == 12)
            owin = 6;
        if (board[0][2] + board[1][1] + board[2][0] == 9)
            xwin = 7;
        if (board[0][2] + board[1][1] + board[2][0] == 12)
            owin = 7;

        //if x won
        if (xwin != -1)    {
            showWinner(xwin, "X");
            showToast(Integer.toString(xwin));
        }

        if (owin != -1){
            showWinner(owin, "O");
            showToast(Integer.toString(owin));
        }

        //else show other's turn
        if(move % 2 == 0)
            message.setText("X's turn");
        else
            message.setText("O's turn");
    }

    private void showWinner(int winningRow, String winner) {
        message.setText(winner + " wins on row " + winningRow + "!!!");
        showToast(winner + " won!");

        button = (Button)findViewById(R.id.button00);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button01);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button02);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button10);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button11);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button12);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button20);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button21);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button22);
        button.setEnabled(false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        message = (TextView)findViewById(R.id.message);
    }

    public void move(View view) {
        button = (Button)findViewById(view.getId());
        button.setEnabled(false);
        if (move % 2 == 0) {

            button.setText("X");
            move++;

            switch(view.getId()) {
                case R.id.button00:
                    board[0][0] = 3;
                    break;
                case R.id.button01:
                    board[0][1] = 3;
                    break;
                case R.id.button02:
                    board[0][2] = 3;
                    break;
                case R.id.button10:
                    board[1][0] = 3;
                    break;
                case R.id.button11:
                    board[1][1] = 3;
                    break;
                case R.id.button12:
                    board[1][2] = 3;
                    break;
                case R.id.button20:
                    board[2][0] = 3;
                    break;
                case R.id.button21:
                    board[2][1] = 3;
                    break;
                case R.id.button22:
                    board[2][2] = 3;
                    break;

            }
        }

        else {
            move++;
            button.setText("O");

            switch(view.getId()) {
                case R.id.button00:
                    board[0][0] = 4;
                    break;
                case R.id.button01:
                    board[0][1] = 4;
                    break;
                case R.id.button02:
                    board[0][2] = 4;
                    break;
                case R.id.button10:
                    board[1][0] = 4;
                    break;
                case R.id.button11:
                    board[1][1] = 4;
                    break;
                case R.id.button12:
                    board[1][2] = 4;
                    break;
                case R.id.button20:
                    board[2][0] = 4;
                    break;
                case R.id.button21:
                    board[2][1] = 4;
                    break;
                case R.id.button22:
                    board[2][2] = 4;
                    break;
            }
        }
       checkForWin();
    }
}