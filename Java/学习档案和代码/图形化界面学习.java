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
    private Label biaoqian1;//这个标签
    private Frame ct;//这个是窗体
    private Button jia,tishi;//这个是按钮
    private TextField xuan;//这个是单行文本框
    private TextArea xianshi;//这个是多行文本框
    private Dialog duihuakuang1;//这个是对话框
    private MenuBar caidanlan;//这个是菜单栏
    private Menu caidanxiang;//这个是菜单选项
    private MenuItem cailanli;//这个是选项里的表情
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
        //想使用对话框，必须依赖窗体进行初始化；
        duihuakuang1.add(biaoqian1);
        duihuakuang1.add(tishi);
        //setBounds设置窗体上边距，左边距，横向大小，纵向大小
        duihuakuang1.setBounds(200, 200, 300, 200);
        //设置窗体如何布局
        duihuakuang1.setLayout(new FlowLayout());
        caidanlan=new MenuBar();
        caidanxiang =new Menu("wenjian");
        cailanli=new MenuItem("haheheh");
        caidanxiang.add(cailanli);
        caidanlan.add(caidanxiang);
        //想要添加菜单栏，使用窗体的setMenuBar方法
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
        //窗口监听器WindowListener
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
        //动作监听器ActionLitener
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
        //键盘事件监听器KeyListener
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
