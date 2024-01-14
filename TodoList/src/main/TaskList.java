package main;

import org.w3c.dom.events.DocumentEvent;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskList {
    public JPanel taskListPanel;
    private JButton removeTaskButton;
    private JPanel controlPanel;
    private JPanel taskContainer;
    private JButton addTaskButton;
    public JTextField taskNameFeild;
    private JLabel taskListName;
    private ArrayList<String> Tasks = new ArrayList<String>();
    private int taskCount = 1;

    public TaskList(String name) {
        taskListName.setText(name);
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

        taskContainer.setLayout(new BoxLayout(taskContainer, BoxLayout.Y_AXIS));

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameFeild.getText();
                JCheckBox checkBox = new JCheckBox(taskName);
                taskListPanel.add(checkBox);

                taskContainer.repaint();
                taskContainer.revalidate();
                taskNameFeild.setText("");
                addTaskButton.setEnabled(false);
            }
        });
        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : taskListPanel.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;

                        // If the JCheckBox is selected, remove it
                        if (checkBox.isSelected()) {
                            taskListPanel.remove(checkBox);
                        }
                    }
                }
                taskListPanel.repaint();
                taskListPanel.revalidate();
            }
        });
        taskNameFeild.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                addTaskButton.setEnabled(true);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {

            }
        });
    }

}
