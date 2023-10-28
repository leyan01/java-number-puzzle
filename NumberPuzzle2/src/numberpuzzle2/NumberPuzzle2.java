package numberpuzzle2;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class NumberPuzzle2 {
    //147
    //258
    //36
    JFrame f;
    Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 50);
    String list[] = {"1","2","3","4","5","6","7","8"," "};
    ArrayList<Integer> al = new ArrayList<>();
    JButton emptyBtn;
    int i;
    
    void btn(int x, int y, int width, int height, JButton button, int num){
        button.setBounds(x, y, width, height);
        button.setBackground(Color.white);
        button.setBorderPainted(false);
        button.setFont(font);
        button.setFocusPainted(false);
        f.add(button);
        if(" ".equals(button.getText())){
            emptyBtn = button;
            i = num;
        }
        button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent ae){
                    
                        if(!" ".equals(button.getText())){
                            if(num+1==i||num+3==i||num-1==i||num-3==i){
                                emptyBtn.setText(button.getText());
                                button.setText(" ");
                                emptyBtn = button;
                                i = num;
                                
                            }
                        }
               }
        }
        );
    }

    int ranNumber(){
        int a = (int) (Math.random()*9);
        if(al.contains(a)){
            return ranNumber();
        }else{
            al.add(a);
            return a;
        }
    }
    
    NumberPuzzle2(){
        
        f = new JFrame();
        f.setSize(500, 500);
        f.getContentPane().setBackground(Color.DARK_GRAY);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn(50, 70, 70, 70, new JButton(list[ranNumber()]), 1);
        btn(150, 70, 70, 70, new JButton(list[ranNumber()]), 2);
        btn(250, 70, 70, 70, new JButton(list[ranNumber()]), 3);
        btn(50, 160, 70, 70, new JButton(list[ranNumber()]), 4);
        btn(150, 160, 70, 70, new JButton(list[ranNumber()]), 5);
        btn(250, 160, 70, 70, new JButton(list[ranNumber()]), 6);
        btn(50, 250, 70, 70, new JButton(list[ranNumber()]), 7);
        btn(150, 250, 70, 70, new JButton(list[ranNumber()]), 8);
        btn(250, 250, 70, 70, new JButton(list[ranNumber()]), 9);
        
    }
  
    public static void main(String[] args) {
        new NumberPuzzle2();
    }
    
}
