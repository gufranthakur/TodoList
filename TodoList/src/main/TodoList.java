package main;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList extends JFrame{
    private JPanel mainPanel;
    private JButton addButton;
    private JButton removeAllButton;
    private JTextField taskListTextFeild;
    private JPanel controlPanel;
    private JScrollPane scrollPane;
    private JPanel taskListContainer;
    private JLabel prompt;
    private JLabel prompt2;
    private JLabel prompt3;
    private JLabel prompt4;

    public TodoList() {

        this.setContentPane(mainPanel);
        this.setTitle("ToDo List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setResizable(false);
        this.setVisible(true);

        taskListContainer.setLayout(new BoxLayout(taskListContainer, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(taskListContainer);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskListName = taskListTextFeild.getText();
                TaskList taskList = new TaskList(taskListName);
                taskListContainer.add(taskList.taskListPanel);
                taskList.taskListPanel.setAlignmentY(TOP_ALIGNMENT);
                repaint();
                revalidate();
                taskListTextFeild.setText("");
                addButton.setEnabled(false);


                controlPanel.remove(prompt);
                controlPanel.remove(prompt2);
                controlPanel.remove(prompt3);
                controlPanel.remove(prompt4);
            }
        });
        taskListTextFeild.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                addButton.setEnabled(true);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {

            }
        });

        removeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskList taskList;
                //Get the components in the panel
                Component[] componentList = taskListContainer.getComponents();

            //Loop through the components
                for(Component c : componentList){

                    //Find the components you want to remove
                    if(c instanceof JPanel){

                        //Remove it
                        taskListContainer.remove(c);
                    }
                }

            //IMPORTANT
                taskListContainer.revalidate();
                taskListContainer.repaint();
            }
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        new TodoList();
    }
}
