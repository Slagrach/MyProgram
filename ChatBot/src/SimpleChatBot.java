import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

class SimpleChatBot extends JFrame implements ActionListener {
    //Константы окна
    final String TITLE_OF_PROGRAM = "Chatter: simple chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String CHB_AI = "AI";
    final String BTN_ENTER = "Enter";

    JTextArea dialogue;
    JCheckBox ai;
    JTextField message;
    SimpleBot sbot;
    SimpleAttributeSet botStyle;

    public static void main(String[] args) {
        new SimpleChatBot();
    }
    SimpleChatBot(){
        //Общее окно
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        //Диалог
        dialogue = new JTextArea();
        dialogue.setLineWrap(false);
        //dialogue.setContentType("text/html");
        JScrollPane scrollBar = new JScrollPane(dialogue);
        //Сообщения
        botStyle = new SimpleAttributeSet();
        StyleConstants.setItalic(botStyle, true);
        StyleConstants.setForeground(botStyle, Color.blue);
        //Панель кнопок
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox("AI");
        ai.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        //Кнопки
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        sbot = new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (message.getText().trim().length() > 0) {
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 9) + sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
        }
            /*try {
            StyledDocument doc = dialogue.getStyledDocument();
            doc.insertString(doc.getLength(), message.getText() + "\n",
                    new SimpleAttributeSet());
            doc.insertString(doc.getLength(),
                    TITLE_OF_PROGRAM.substring(0, 9) +
                            sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n",
                    botStyle);
        } catch (Exception e) {
        }*/
        message.setText("");
        message.requestFocusInWindow();
    }
}
