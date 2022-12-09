package controllerpresenter;
import usecase.UserRollDice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayGamePresenter {


    public void rollDice(UserRollDice urd, ArrayList<Integer> rolls, String name) {
        JFrame f = new JFrame("Roll Dice");
        JLabel l = new JLabel("Now its " + name + "'s turn, Please roll dice" );
        JButton roll = new JButton("Roll");
        f.setSize(500, 400);
        l.setBounds(100, 100, 300, 80);
        roll.setBounds(150, 200, 200, 100);
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Integer> lst = urd.react();



                JFrame frame = new JFrame("Result");
                frame.setSize(400, 300);
                JLabel result = new JLabel(lst.get(0) + " , " + lst.get(1));
                result.setBounds(125, 100, 50, 100);
                frame.add(result);
                frame.setLayout(null);
                frame.setVisible(true);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                JButton ok = new JButton("ok");
                ok.setBounds(175, 200, 50, 50);
                frame.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame.dispose();
                    }
                });

                rolls.set(0, lst.get(0));
                rolls.set(1, lst.get(1));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                f.dispose();

            }
        });
        f.add(l);
        f.add(roll);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void buildOption(ArrayList<Object> build){
        JFrame f=new JFrame("Building options");
        JButton b1=new JButton("Yes");
        JButton b2=new JButton("No");
        JLabel l=new JLabel("Would you like to build a house/hotel?");
        b1.setBounds(50,150,95,30);
        b2.setBounds(200,150,95, 30);
        l.setBounds(60,70,300,30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                build.set(0, true);
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                build.set(0, false);
                f.dispose();
            }
        });
        f.add(b1);
        f.add(b2);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void buyProperty(ArrayList<Object> buy, String name){
        JFrame f=new JFrame("Buy property");
        JButton b1=new JButton("Yes");
        JButton b2=new JButton("No");
        JLabel l=new JLabel("Would you like to buy " + name);
        b1.setBounds(50,150,95,30);
        b2.setBounds(200,150,95, 30);
        l.setBounds(60,70,300,30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buy.set(0, true);
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buy.set(0, false);
                f.dispose();
            }
        });
        f.add(b1);
        f.add(b2);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void buyPropertySuccessful(String name) {
        JFrame f=new JFrame("Buy property succeed");
        JLabel l=new JLabel("Purchase succeed, now you have " + name + " .");
        l.setBounds(60,70,300,30);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
            }
        });
        f.add(l);
        f.add(ok);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void notEnoughMoney() {
        JFrame f=new JFrame("Unsuccessful");
        JLabel l=new JLabel("You don't have enough money");
        l.setBounds(60,70,300,30);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
            }
        });
        f.add(l);
        f.add(ok);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void payRent(Integer amount, String tile, boolean mortgaged, String name){
        JFrame f=new JFrame("Pay rent");
        JLabel l;
        if (!mortgaged) {
            l = new JLabel("You landed on " + tile + " ," + amount + " dollars are paid");
        }
        else{
            l = new JLabel("You landed on " + tile + " ," + name + " is mortgaged to avoid bankruptcy");
        }
        l.setBounds(60,70,300,30);


        f.add(l);

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void bankrupt(){
        JFrame f=new JFrame("Bankrupt Notice");
        JLabel l=new JLabel("Sorry, you're broke");
        l.setBounds(120,120,300,30);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void mortgage(String name){
        JFrame f=new JFrame("Mortgage Notice");
        JLabel l=new JLabel("You mortgaged " + name + " to avoid bankruptcy");
        l.setBounds(120,120,300,30);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void useJailFreeCard(ArrayList<Object> use){
        JFrame f=new JFrame("Use jail free card");
        JButton b1=new JButton("Yes");
        JButton b2=new JButton("No");
        JLabel l=new JLabel("Would you like to use your jail free card");
        b1.setBounds(50,150,95,30);
        b2.setBounds(200,150,95, 30);
        l.setBounds(60,70,300,30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                use.set(0, true);
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                use.set(0, false);
                f.dispose();
            }
        });
        f.add(b1);
        f.add(b2);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void buyUtility(ArrayList<Object> utility){
        JFrame f=new JFrame("Buy Utility");
        JButton b1=new JButton("Yes");
        JButton b2=new JButton("No");
        JLabel l=new JLabel("Would you like to buy the utility");
        b1.setBounds(50,150,95,30);
        b2.setBounds(200,150,95, 30);
        l.setBounds(60,70,300,30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                utility.set(0, true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                utility.set(0, false);
            }
        });
        f.add(b1);
        f.add(b2);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void getOutOfJailFreeCard(){
        JFrame f=new JFrame("Opportunity Card");
        JLabel l=new JLabel("Congrats! You get a jail free card");
        l.setBounds(120,120,300,30);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void taxPlayer(Integer amount) {
        JFrame f = new JFrame("Taxed");
        JLabel l = new JLabel("You have been taxed for " + amount + " dollars");
        JButton ok = new JButton("OK");
        f.setSize(400, 300);
        l.setBounds(100, 200, 200, 80);
        ok.setBounds(180, 300, 40, 40);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
            }
        });

        f.add(l);
        f.add(ok);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void playerGoToJail(){
        JFrame f=new JFrame("Go to jail");
        JLabel l=new JLabel("So sad, you are send to jail");
        l.setBounds(120,120,300,30);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void communityCardPresenter(String message){
        JFrame f=new JFrame("Received community card");
        JLabel l=new JLabel(message);
        l.setBounds(120,120,300,30);
        f.add(l);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}