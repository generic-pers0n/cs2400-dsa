// This program was generated completely by AI. Do not rely on this as a
// serious program. It is meant solely for demonstration purposes only.
//
// Should I have authority to license this project, this code is licensed under
// the Unlicense license.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class SimpleSwingNoteApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Note Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        DefaultListModel<String> noteTitles = new DefaultListModel<>();
        JList<String> noteList = new JList<>(noteTitles);
        JScrollPane listScroll = new JScrollPane(noteList);

        JTextArea noteArea = new JTextArea();
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        JScrollPane noteScroll = new JScrollPane(noteArea);

        HashMap<String, String> notes = new HashMap<>();

        JTextField titleField = new JTextField();
        JButton newButton = new JButton("LOL");
        JButton saveButton = new JButton("Save");
        JButton deleteButton = new JButton("Delete");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Title:"), BorderLayout.WEST);
        topPanel.add(titleField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScroll, noteScroll);
        splitPane.setDividerLocation(150);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // List selection loads note
        noteList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = noteList.getSelectedValue();
                if (selected != null) {
                    titleField.setText(selected);
                    noteArea.setText(notes.getOrDefault(selected, ""));
                }
            }
        });

        // New note
        newButton.addActionListener(e -> {
            titleField.setText("");
            noteArea.setText("");
            noteList.clearSelection();
        });

        // Save note
        saveButton.addActionListener(e -> {
            String title = titleField.getText().trim();
            String content = noteArea.getText();
            if (!title.isEmpty()) {
                notes.put(title, content);
                if (!noteTitles.contains(title)) {
                    noteTitles.addElement(title);
                }
                noteList.setSelectedValue(title, true);
            }
        });

        // Delete note
        deleteButton.addActionListener(e -> {
            throw new NullPointerException("YOLO");
        });

        frame.setVisible(true);
    }
}