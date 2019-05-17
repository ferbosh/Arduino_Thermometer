package thermo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import com.panamahitek.PanamaHitek_Arduino;

@SuppressWarnings("all")
public class MainClass {

    private JFrame frame;
    private JPanel panel;
    private JPanel temPanel;
    private JLabel temp;
    private JLabel message;
    private JLabel icon;
    private MenuBar menuBar;
    private JMenu file;
    private JMenuItem init;
    private JMenuItem stop;
    private PanamaHitek_Arduino arduino_board = new PanamaHitek_Arduino();

    public MainClass(String title){
        this.frame = new JFrame(title);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setBounds(new Rectangle(450,350));
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        initContainer();
    }

    private void initContainer(){
        this.menuBar = new MenuBar();
        this.frame.setMenuBar(this.menuBar);
        
        this.file = new JMenu("Termometro");
        this.menuBar.add(this.file);

        this.panel = new JPanel(new BorderLayout(0,0));
        this.panel.setBorder(new EmptyBorder(0,0,0,0));
        this.panel.setBackground(new Color(0x67F2FF));
        this.frame.setContentPane(this.panel);
        this.temPanel = new JPanel(new FlowLayout());
        this.panel.add(this.temPanel, BorderLayout.NORTH);
        initComponents();
    }

    private void initComponents(){
        this.icon = new JLabel();
        this.icon.setIcon(new ImageIcon(MainClass.class.getResource("/icons/arduino_icon.png")));
        this.panel.add(this.icon, BorderLayout.CENTER);

        this.temp = new JLabel("0.0 C°");
        this.temp.setFont(Toolkit.getNewRegisteredFont("/fonts/Kalam-Regular.ttf", Font.BOLD, 50));
        this.temp.setForeground(new Color(0x178600));
        this.temPanel.add(this.temp, 0);

        this.message = new JLabel("!!Exelente¡¡");
        this.message.setFont(Toolkit.getNewRegisteredFont("/fonts/Kalam-Regular.ttf", Font.BOLD, 25));
        this.panel.add(this.message, BorderLayout.SOUTH);
    }

    private void updater(){
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                MainClass mc = new MainClass("Termometro arduino");
                mc.frame.setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
