package todolist;

import javax.swing.*;

public class GroupPanel extends JDesktopPane{
    
    App app;
    private int currentX = 20, currentY = 70;
    
    public GroupPanel(App app) {
        this.app = app;
        this.setLayout(null);
        this.setBounds(0, 0, 2000, 2000);
        this.setBackground(app.getBackground().brighter());
    }
    
    public void addGroup() {
        String name = JOptionPane.showInputDialog("Enter group name");
        app.groupPanel.add(new Group(app.groupPanel, name, currentX, currentY));
        app.revalidate();
        
        if (currentX + 250 < app.getWidth()) {
            currentX += 250;
        } else {
            currentY += 250;
            currentX = 20;
        }
        
    }
    public void addGroup(String name) {
        int dimension = 400;
        int x = (app.getWidth() / 2 - dimension / 2);
        
        
        app.groupPanel.add(new Group(app.groupPanel, name, x, currentY, dimension, dimension));
        app.revalidate();

        

    }
    
}
