package jisuanqi;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Created by Administrator on 2016/1/4.
 */
public class jsq {
    private Label biaoqian1;//�����ǩ
    private Frame ct;//����Ǵ���
    private Button jia,tishi;//����ǰ�ť
    private TextField xuan;//����ǵ����ı���
    private TextArea xianshi;//����Ƕ����ı���
    private Dialog duihuakuang1;//����ǶԻ���
    private MenuBar caidanlan;//����ǲ˵���
    private Menu caidanxiang;//����ǲ˵�ѡ��
    private MenuItem cailanli;//�����ѡ����ı���
    jsq(){
        runta();
    }
    public static void main(String[] abc){
        new jsq();
    }
    public void runta(){
        ct=new Frame("Notepad!!!");
        xuan=new TextField(20);
        xianshi=new TextArea(20,30);
        jia=new Button("delet");
        duihuakuang1=new Dialog(ct,"tisih",true);
        tishi=new Button("quren");
        biaoqian1=new Label("nicoule la");
        //��ʹ�öԻ��򣬱�������������г�ʼ����
        duihuakuang1.add(biaoqian1);
        duihuakuang1.add(tishi);
        //setBounds���ô����ϱ߾࣬��߾࣬�����С�������С
        duihuakuang1.setBounds(200, 200, 300, 200);
        //���ô�����β���
        duihuakuang1.setLayout(new FlowLayout());
        caidanlan=new MenuBar();
        caidanxiang =new Menu("wenjian");
        cailanli=new MenuItem("haheheh");
        caidanxiang.add(cailanli);
        caidanlan.add(caidanxiang);
        //��Ҫ��Ӳ˵�����ʹ�ô����setMenuBar����
        ct.setMenuBar(caidanlan);
        ct.setBounds(200, 200, 300, 500);
        ct.setVisible(true);
        ct.setLayout(new FlowLayout());
        ct.add(xuan);
        ct.add(jia);
        ct.add(xianshi);
        jianting();

    }
    void jianting(){
        //���ڼ�����WindowListener
        ct.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zhao();

            }
        });
        //����������ActionLitener
        tishi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                duihuakuang1.setVisible(false);
            }
        });

        tishi.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    duihuakuang1.setVisible(false);

            }
        });
        //�����¼�������KeyListener
        xuan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                    zhao();

            }
        });

    }
    void zhao(){
        String abc1 = xuan.getText();
        //System.out.println(abc1);
        File abc = new File(abc1);
        String[] chu = abc.list();
        xianshi.setText("");
        if (abc.exists() && abc.isDirectory()) {
            for (String chu1 : chu) {
                xianshi.append(chu1 + "\r\n");
            }
        } else {
            duihuakuang1.setVisible(true);
        }

    }
}
