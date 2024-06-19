import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

class Cal implements ActionListener
{
    JFrame frame;
    JLabel l1,l2,l3;
    Container c;
    TextField t1,t2,t3;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    int a;
    int b;
    BigInteger result;
    public Cal()
    {
        frame=new JFrame();
        frame.setVisible(true);
//        frame.setSize(500,500);
//        frame.setLocation(150,50);
        frame.setTitle("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150,50,500,700);
        c=frame.getContentPane();
        Color col=new Color(6, 28, 85);
        c.setBackground(col);
        c.setLayout(null);
        frame.setResizable(false);
        l1=new JLabel("Enter 1st Number: ");
        l1.setBounds(50,50,150,50);
        c.add(l1);
        l1.setForeground(Color.WHITE);
        Font f=new Font("Arial",Font.BOLD,15);
        l1.setFont(f);
        //l1.setText("Hello");
        t1=new TextField();
        t1.setBounds(250,50,150,50);
        c.add(t1);
        Font f1=new Font("Arial",Font.BOLD,35);
        t1.setFont(f1);

        l2=new JLabel("Enter 2nd Number: ");
        l2.setBounds(50,150,150,50);
        c.add(l2);
        l2.setForeground(Color.WHITE);
        l2.setFont(f);

//        JPasswordField p=new JPasswordField();
//        p.setBounds(250,150,150,50);
//        c.add(p);
//        p.setFont(f1);
//        p.setEchoChar('#');
//        p.setEchoChar((char) 0);

        t2=new TextField();
        t2.setBounds(250,150,150,50);
        c.add(t2);
        t2.setFont(f1);

        l3=new JLabel("Expected Output:");
        l3.setBounds(50,250,150,50);
        c.add(l3);
        l3.setForeground(Color.WHITE);
        l3.setFont(f);

        t3=new TextField();
        t3.setBounds(250,250,150,50);
        c.add(t3);
        t3.setFont(f1);
        t3.setEditable(false);

        Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
        btn1=new JButton("+");
        btn1.setBounds(50,350,75,75);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        c.add(btn1);
        btn1.addActionListener(this);
        // btn1.setEnabled(false);

        btn2=new JButton("-");
        btn2.setBounds(150,350,75,75);
        btn2.setFont(f1);
        btn2.setCursor(cursor);
        c.add(btn2);
        btn2.addActionListener(this);


        btn3=new JButton("x");
        btn3.setBounds(250,350,75,75);
        btn3.setFont(f1);
        btn3.setCursor(cursor);
        c.add(btn3);
        btn3.addActionListener(this);


        btn4=new JButton("/");
        btn4.setBounds(350,350,75,75);
        btn4.setFont(f1);
        btn4.setCursor(cursor);
        c.add(btn4);
        btn4.addActionListener(this);

        btn5=new JButton("!");
        btn5.setBounds(50,450,75,75);
        btn5.setFont(f1);
        btn5.setCursor(cursor);
        c.add(btn5);
        btn5.addActionListener(this);

        btn6=new JButton("%");
        btn6.setBounds(150,450,75,75);
        btn6.setFont(f1);
        btn6.setCursor(cursor);
        c.add(btn6);
        btn6.addActionListener(this);

        btn7=new JButton("C");
        btn7.setBounds(250,450,75,75);
        btn7.setFont(f1);
        btn7.setCursor(cursor);
        c.add(btn7);
        btn7.addActionListener(this);

        btn8=new JButton("P");
        btn8.setBounds(350,450,75,75);
        btn8.setFont(f1);
        btn8.setCursor(cursor);
        c.add(btn8);
        btn8.addActionListener(this);

    }

    private static BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= a; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger calculatePermutation(int a, int b) {
        if (a < 0 || b < 0 || b > a) {
            throw new IllegalArgumentException("Invalid input for permutation");
        }
        return factorial(a).divide(factorial(a - b));
    }

    public static BigInteger calculateCombination(int a, int b) {
        if (a < 0 || b < 0 || b > a) {
            throw new IllegalArgumentException("Invalid input for combination");
        }
        return factorial(a).divide(factorial(b).multiply(factorial(a - b)));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result= BigInteger.valueOf(a+b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.cyan);
            btn2.setBackground(Color.RED);
        }
        if(e.getSource()==btn2)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result= BigInteger.valueOf(a-b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.BLUE);
        }
        if(e.getSource()==btn3)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result= BigInteger.valueOf(a*b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.RED);
        }
        if(e.getSource()==btn4)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result= BigInteger.valueOf(a/b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.PINK);
        }

        if(e.getSource()==btn5)
        {
            a= Integer.parseInt(t1.getText());
            t2.setVisible(false);
            l2.setVisible(false);
            result=factorial(a);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.PINK);
        }
        if(e.getSource()==btn6)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result= BigInteger.valueOf(a%b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.PINK);
        }
        if(e.getSource()==btn7)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=calculateCombination(a,b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.PINK);
        }
        if(e.getSource()==btn8)
        {
            t2.setVisible(true);
            l2.setVisible(true);
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=calculatePermutation(a,b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.PINK);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Cal cal=new Cal();
    }
}