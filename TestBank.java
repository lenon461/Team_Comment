
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class NewAccountManager extends JFrame {
    private static final String Orientation = null;
	private static Object getContentPane;
    private Image screenImage;
    
	public NewAccountManager() {  
		
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
        
        JLabel hello = new JLabel("�Ѿ����࿡ �湮���ּż� �����մϴ�.");
        panel1.add(hello);
        JButton button1 = new JButton("����");
        JButton button2 = new JButton("Ż��");
        JButton button3 = new JButton("�ֱٰŷ�");
        JButton button4 = new JButton("�α���");
        JButton button5 = new JButton("������ü");
        JButton button6 = new JButton("�ܾ���ȸ");
        JButton button7 = new JButton("�Ա�");
        JButton button8 = new JButton("���");
        panel3.setLayout(new GridLayout(5,1));      // �׸��� ���̾ƿ� = ǥ ���� (5����, 1)
        panel2.setLayout(new GridLayout(3,1));
        panel2.add(button1);
        panel3.add(button3);
        panel2.add(button2);
        panel3.add(button5);
        panel2.add(button4);
        panel1.add(panel2);
        panel1.add(panel3);
        panel3.add(button6);
        panel3.add(button7);
        panel3.add(button8);
        this.add(panel1);
        this.add(panel2,BorderLayout.WEST);  //ǥ�� WEST��
        this.add(panel3,BorderLayout.EAST);  	//ǥ�� EAST�� 
        setResizable(false);
        setVisible(true);

       
        
        ActionListener newAccount = new ActionListener() {
        	
        	
			public void LogonFrame() {
				
				JLabel id = new JLabel("���̵� �Է�");
				setVisible(true);
				
			}
			public void actionPerformed(ActionEvent e) {
				final JFrame LogonFrame = new JFrame("����â");
				
				System.out.println("@");
				LogonFrame.setVisible(true);

				LogonFrame.setSize(300,300);
				LogonFrame.setLocation(200, 200);

				LogonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		};
		button1.addActionListener(newAccount);
    }
}
 
public class TestBank {
    public static void main(String[] args) {
        NewAccountManager f = new NewAccountManager();
    }
}
