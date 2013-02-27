package net.squidmonkey.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ttt extends Activity {
    private int[][] board = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    private TextView message = (TextView)findViewById(R.id.message);
    private int xwin = -1; // -1 if no winning row
    private int owin = -1;  // -1 is no winning row
    private int move = 0; //0 is x's turn, 1 is y's turn

    /* x = 3, o = 4 so that the sums don't give false wins

                                7
    win rows           x  x  x  0
                       x  x  x  1
                       x  x  x  2
                       3  4  5  6
     */

    private void checkForWin() {

        //check for horizontal wins
        for (int i = 0; i < 3; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 9)
                xwin = i;
            if (board[i][0] + board[i][0] + board[i][0] == 12)
                owin = i;
        }

        //check for vertical wins
        for (int i = 0; i < 3; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == 9)
                xwin = i + 3;
            if (board[0][i] + board[1][i] + board[2][i] == 12)
                xwin = i + 3;
        }

        //check for diagonal wins
        if (board[0][0] + board[1][1] + board[2][2] == 9)
            xwin = 6;
        if (board[0][0] + board[1][1] + board[2][2] == 12)
            owin = 6;
        if (board[0][2] + board[1][1] + board[0][2] == 9)
            xwin = 6;
        if (board[0][2] + board[1][1] + board[0][2] == 12)
            owin = 6;

        //if x won
        if (xwin != -1)
            showWinner(xwin, "X");
        if (owin != -1)
            showWinner(owin, "O");

        //else show other's turn
        if(move == 0)
            message.setText("X's turn");
        else
            message.setText("Y's turn");
    }

    private void showWinner(int winningRow, String winner) {
        message.setText(winner + " wins on row " + winningRow + "!!!");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void move(View view) {
        Button button = (Button)findViewById(view.getId());
        if (move ==0) {

            button.setText("X");
            move =1;

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
            move = 0;
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
