package controller_presenter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class InitialPresenter{

    public void presentNum(ArrayList<Integer> lst){
        JFrame f= new JFrame("Number of players");
        JLabel l = new JLabel("Write number of players, between 2-4");
        JButton done = new JButton("DONE");
        JTextField tx = new JTextField();
        l.setBounds(100,50, 500, 50);
        done.setBounds(100, 200, 100, 50);
        tx.setBounds(100, 100, 100, 50);
        String message = tx.getText();
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x = Integer.parseInt(tx.getText());
                lst.set(0, x);
                f.dispose();

            }
        });

        f.add(done);
        f.add(l);
        f.add(tx);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void presentName(ArrayList<String> name) {
        JFrame f= new JFrame("Name of Player");
        JLabel l = new JLabel("Give a name to this player");
        JButton done = new JButton("DONE");
        JTextField tx = new JTextField();
        l.setBounds(100,50, 500, 50);
        done.setBounds(100, 200, 100, 50);
        tx.setBounds(100, 100, 100, 50);
        String message = tx.getText();
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = tx.getText();
                name.set(0, x);
                f.dispose();


            }
        });

        f.add(done);
        f.add(l);
        f.add(tx);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void startGame(ArrayList<Object> bool){
        JFrame f= new JFrame("Start");
        JLabel l = new JLabel("Do you want to start the game?");
        JButton done = new JButton("Start");
        l.setBounds(100,50, 500, 50);
        done.setBounds(100, 200, 100, 50);


        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                bool.set(0, true);
                f.dispose();

            }
        });

        f.add(done);
        f.add(l);

        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }

}
