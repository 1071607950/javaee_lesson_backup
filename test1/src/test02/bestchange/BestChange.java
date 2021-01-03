package test02.bestchange;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BestChange extends JFrame implements ActionListener{
	JFrame f;
	private JTextField jp=new JTextField(10);
    private JTextField jr=new JTextField(10);
    private JLabel lab1=new JLabel("商品价格");
    private JLabel lab2=new JLabel("付款");
    private JButton btn1=new JButton("查询");
    JPanel p1,p2,p3;
    private static TextArea show=new TextArea(15,65);
	
    BestChange()
	{	
		//super("查询系统");
		f=new JFrame("查询系统");
		//setSize(800,200);
		p1=new JPanel(new FlowLayout());
		
        p2=new JPanel(new FlowLayout());
        p3=new JPanel(new FlowLayout());
      
		p1.add(lab1);
		p1.add(jr);
		p1.add(lab2);
		p1.add(jp);
		p1.add(btn1);
		
		p2.add(show);
		btn1.addActionListener(this);
        f.add(p1,"North");
        f.add(p2,"Center");
        f.add(p3,"South");
        f.setSize(600,400);
        f.setVisible(true);
	}

    public void actionPerformed(ActionEvent e){
    	String inputP=jp.getText().trim();
    	
    	String inputR=new String(jr.getText()).trim();
    	if(e.getSource()==btn1)
    	{
    		int P =Integer.parseInt(inputP);//P 付款
    		int R =Integer.parseInt(inputR);//R 商品价格<100
    		show.append("-----------\n");
    		show.append("商品价格:"+R+"  ");
    		show.append("付款:"+P+"\n");
    		ab(P,R);	
    	}
    }

    public static final int[] RMB = {50,10,5,1};
	
	public static void findBestChange(int pay,int index){
		if(pay!=0){
			if(pay<0){
			show.append("invalid pay \n");
		}
		if(index >= RMB.length){
			show.append("can not find other change!\n");
		}
		
		if(pay < RMB[index]){
			findBestChange(pay, index+1);
		}else{
			int count = pay/RMB[index];
			int rest = pay%RMB[index];
			show.append(count+"个"+RMB[index]+"元");
			show.append("\n");
			if(rest>0){
				findBestChange(rest, index+1);
			}
		}}else{
			show.append("钱正好\n");
		}
	}
	
	public static void ab(int p,int r){
		if(p>100||r>100){
			show.append("金额不能超过100\n");
		}if(r<=0||p<=0){
			show.append("不能低于0或等于0\n");
		}
		if(p<r){ show.append("付款不能低于商品价格\n");}	
		if(r>0&&p>0&&p>r&&r<=100&p<=100){
			show.append("输入符合规范\n找零:\n");
			int RR=p-r;//找的钱
			findBestChange(RR, 0);
		}
	}
	
	public static void main(String[] args) {
		BestChange mt=new BestChange();
	}
}

