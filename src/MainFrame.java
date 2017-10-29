import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpn = new JPanel(new GridLayout(4, 3));
    private JPanel jpn1 = new JPanel(new GridLayout(0, 2));
    private JPanel jpn2 = new JPanel(new GridLayout(4, 1));
    private JButton cn = new JButton("C");
    private JButton amo = new JButton("=");
    private JButton ad = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    private long num;
    private byte op;
    long result;
    private JTextField jtf = new JTextField();
    private JButton jbts[] = new JButton[10];
    private LoginFrame loginFrame;

    public MainFrame(LoginFrame login) {
        loginFrame = login;
        initComp();
    }

    private void initComp() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5, 3));
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        this.setBounds(100, 100, 500, 500);

        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.add(jtf, BorderLayout.NORTH);
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jpn1, BorderLayout.SOUTH);
        cp.add(jpn2, BorderLayout.EAST);
        jtf.setEditable(false);

        jpn1.add(cn);
        cn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn=(JButton) e.getSource();

                if (btn == cn){
                    result=0L;
                    num=0L;
                    op=0;
                    jtf.setText(Long.toString(num));
                }
            }
        });

        jpn2.add(ad);
        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if (btn == ad){
                    save_num(ad);
                    op=1;
                }
            }
        });
        jpn2.add(sub);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if (btn == sub) {
                    save_num(sub);
                    op = 2;
                }
            }
        });
        jpn2.add(mul);
        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if (btn == mul) {
                    save_num(mul);
                    op = 3;
                }
            }
        });
        jpn2.add(div);
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if (btn == div) {
                    save_num(div);
                    op = 4;
                }
            }
        });
        jpn1.add(amo);
        amo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result=Long.parseLong(jtf.getText());

                switch(op){
                    case 1:
                        num+=result;
                        break;
                    case 2:
                        num-=result;
                        break;
                    case 3:
                        num*=result;
                        break;
                    case 4:
                        num/=result;
                        break;
                    default:
                }
                result=0L;
                jtf.setText(Long.toString(num));
            }

        });

        for (int i = 0; i <= 9; i++) {
            jbts[i] = new JButton(Integer.toString(i));
            jpn.add(jbts[i]);
            jbts[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton) e.getSource();
                    jtf.setText(jtf.getText() + tmpButton.getText());
                }
            });
        }
    }
    private void save_num(JButton oper){
        num=Long.parseLong(jtf.getText());
        jtf.setText(Long.toString(0L));
    }
}



