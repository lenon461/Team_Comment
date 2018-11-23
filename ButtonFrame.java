/**
 * 
 */
package testtest;

import java.awt.*;
import javax.swing.*;

import javafx.geometry.Orientation;
class MyFrame extends JFrame {
    private static final String Orientation = null;
	private static Object getContentPane;
    private Image screenImage;
    private Graphics screenGraphic;
    
	public MyFrame() {  
		
    	Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        Image img = kit.getImage("hanyang.png");
        this.setIconImage(img);
        this.setLocation((screenSize.width / 3)+100, (screenSize.height / 2)-100);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HY Bank");
        
        
       
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        JLabel hello = new JLabel("한양은행에 방문해주셔서 감사합니다.");
        panel1.add(hello);
        JButton button1 = new JButton("가입");
        JButton button2 = new JButton("탈퇴");
        JButton button3 = new JButton("최근거래");
        JButton button4 = new JButton("로그인");
        JButton button5 = new JButton("계좌이체");
        JButton button6 = new JButton("잔액조회");
        
        panel3.setLayout(new GridLayout(3,1));
        panel2.setLayout(new GridLayout(3,1));
        panel2.add(button1);
        panel3.add(button3);
        panel2.add(button2);
        panel3.add(button5);
        panel2.add(button4);
        panel1.add(panel2);
        panel1.add(panel3);
        panel3.add(button6);
        this.add(panel1);
        this.add(panel2,BorderLayout.WEST);
        this.add(panel3,BorderLayout.EAST);
        
        setVisible(true);
        ((Container) MyFrame.getContentPane).add(panel1);
        
        
    }
}
 
public class ButtonFrame {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}
