package todolist;

import javax.swing.*;
import java.util.ArrayList;

public class Group extends JInternalFrame {

    GroupPanel groupPanel;
    private JPanel controlPanel;
    
    private JButton addTask, removeTask;
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
  

    public Group(GroupPanel groupPanel, String title, int x, int y) {
        super(title, true, true, false, false);
        this.groupPanel = groupPanel;
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        init();
        
        this.setBounds(x, y, 250, 250);
        this.setVisible(true); 
    }
    
    public void init() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        
        addTask = new JButton("Add Task");

        
        addTask.addActionListener(e -> {
            String taskName = JOptionPane.showInputDialog("Enter task name");
            JCheckBox checkBox = new JCheckBox(taskName);
            checkBox.setAlignmentX(CENTER_ALIGNMENT);
            
            checkBoxes.add(checkBox);
            this.add(checkBox);
            this.revalidate();
        });

        removeTask = new JButton("Remove");
        
        removeTask.addActionListener(e -> {
            for (int i = checkBoxes.size() - 1; i >= 0; i--) {
                if (checkBoxes.get(i).isSelected()) {
                    this.remove(checkBoxes.get(i)); 
                    checkBoxes.remove(i); 
                }
            }
            this.revalidate();
            this.repaint();
        });
        
        controlPanel.add(addTask);
        controlPanel.add(removeTask);
        
        this.add(controlPanel);
    }
    
}