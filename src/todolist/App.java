package todolist;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class App extends JFrame implements ComponentListener {
    
    public GroupPanel groupPanel;
    private JButton addGroupButton, removeAllGroupButton;
    
    public App() {
        this.setSize(800, 600);
        this.setTitle("Todo list");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addComponentListener(this);
        this.setLayout(null);
    }
    
    public void init() {
        groupPanel = new GroupPanel(this);
        
        addGroupButton = new JButton("Add Group");
        addGroupButton.setBounds(getWidth() / 2 - 25, 10, 100, 40);
        addGroupButton.addActionListener(e -> groupPanel.addGroup());
        
        removeAllGroupButton = new JButton("Remove All");
        removeAllGroupButton.setBounds(addGroupButton.getX() + 10, 10, 100, 40);
        removeAllGroupButton.addActionListener(e -> {
            for (Component comp : groupPanel.getComponents()) {
                if (comp instanceof JInternalFrame) {
                    groupPanel.remove(comp);
                }
            }
            groupPanel.revalidate();
            groupPanel.repaint();
        });
    }
    
    public void addComponent() {
        groupPanel.add(addGroupButton);
        groupPanel.add(removeAllGroupButton);
        this.add(groupPanel);
        this.setVisible(true);
    }
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        App app = new App();
        
        
        app.init();
        app.addComponent();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        addGroupButton.setBounds(this.getWidth() / 2 - 100, 10, 100, 30);
        removeAllGroupButton.setBounds(addGroupButton.getX() + 110, 10, 100, 30);
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
