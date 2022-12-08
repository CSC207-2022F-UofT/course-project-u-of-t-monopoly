package ControllerPresenter;
import Entity.Player;
import UseCase.UserRollDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class PlayerInJailPresenter {

    public void RollDice(ArrayList<Integer> rolls, Player player){
        JFrame f = new JFrame("Roll Dice");
        JLabel l = new JLabel("You are not using Get out of Jail Free Card, please roll dice");
        JButton roll = new JButton("Roll");
        f.setSize(500, 400);
        l.setBounds(100, 100, 300, 50);
        roll.setBounds(150, 200, 200, 100);
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserRollDice urd = new UserRollDice(player);
                ArrayList<Integer> lst = urd.react();
                rolls.set(0, lst.get(0));
                rolls.set(1, lst.get(1));
            }
        });

        f.add(l);
        f.add(roll);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void youAreFree() {
        JFrame f = new JFrame("Free message");
        JLabel l = new JLabel("Congratulations! You are now free");
        f.setSize(500, 400);
        l.setBounds(100, 175, 300, 50);


        f.add(l);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void youAreNotFree() {
        JFrame f = new JFrame("Not free message");
        JLabel l = new JLabel("Unfortunately, you have to stay in jail for this turn");
        f.setSize(500, 400);
        l.setBounds(100, 175, 300, 50);


        f.add(l);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void askRollDice(ArrayList<Object> bool){
        JFrame f = new JFrame("Roll Dice?");
        JLabel l = new JLabel("Do you wanna roll dice?");
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        f.setSize(500, 400);
        l.setBounds(175, 175, 200, 50);
        yes.setBounds(100, 250, 75, 75);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bool.set(0, true);
            }
        });
        no.setBounds(325, 250, 75, 75);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bool.set(0, false);
            }
        });

        f.add(l);
        f.add(yes);
        f.add(no);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void askUsingFreeCard(ArrayList<Object> bool){
        JFrame f = new JFrame("Use card?");
        JLabel l = new JLabel("Do you wanna use your Get out of Jail Free Card?");
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        f.setSize(500, 400);
        l.setBounds(100, 175, 300, 50);
        yes.setBounds(100, 250, 75, 75);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bool.set(0, true);

                f.dispose();
            }
        });
        no.setBounds(325, 250, 75, 75);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bool.set(0, false);

                f.dispose();
            }
        });


        f.add(l);
        f.add(yes);
        f.add(no);
        f.setLayout(null);
        f.setVisible(true);
    }
}
