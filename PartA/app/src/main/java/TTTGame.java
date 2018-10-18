import javax.swing.*;
import java.awt.*;

public class TTTGame {

    JPanel bottomPanel = new JPanel();
    TTTButton[] buttons = new TTTButton[9];
    int current = 0;
    Player[] players = new Player[2];
    JPanel topPanel = new JPanel();
    JLabel turnLabel = new JLabel("Who");
    JLabel winnerLabel = new JLabel("The winner is ");

    public void  CreateBoard(Container container){


        //Separating concerns rather than adding this logic to the GameBoard UX
      GameBoard game = (GameBoard)container;
        current = 1;
      game.turnLabel.setText("Player " + current);




    }


}
