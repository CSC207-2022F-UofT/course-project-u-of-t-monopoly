package controllerpresenter;
import entity.Player;
import usecase.PlayerNameGetter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameBoardPresenter extends JFrame {

    public void presentBoard(ArrayList<Player> name) {

        JFrame frame = new JFrame(); //JFrame Creation
        frame.setTitle("MonopolyBoard"); //Add the title to frame
        frame.setLayout(null); //Terminates default flow layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        frame.setBounds(100, 200, 350, 300); //Sets the position of the frame

        Container c = frame.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\JTQ\\Desktop\\course-project-u-of-t-monopoly\\src\\main" + "\\java\\Pictures\\MonopolyBoard.png")); //Sets the image to be displayed as an icon
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(50, 30, size.width, size.height); //Sets the location of the image
        c.add(label); //Adds objects to the container
        JLabel p1, p2, p3, p4;
        PlayerNameGetter png = new PlayerNameGetter();
        p1=new JLabel("Player1 : " + png.getName(name.get(0)));
        p1.setBounds(700,100, 100,30);
        p2=new JLabel("Player2 :  " + png.getName(name.get(1)) );
        p2.setBounds(900,100, 100,30);
        if (name.size() >= 3) {
            p3 = new JLabel("Player3 : " + png.getName(name.get(2)));
            p3.setBounds(700,150, 100,30);
            frame.add(p3);
        }
        if (name.size() >= 4) {
            p4 = new JLabel("Player4 : " + png.getName(name.get(3)));
            p4.setBounds(900, 150, 100, 30);
            frame.add(p4);
        }
        frame.add(p1);
        frame.add(p2);



        JTextArea area=new JTextArea("System log to keep track of the game");
        area.setBounds(700,200, 250,325);
        frame.add(area);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setVisible(true); // Exhibit the frame

    }
}
