package gui;

import com.sun.tools.javac.Main;
import network.Client;
import network.ServerBroadcast;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TwitterApp extends JFrame {

    private JPanel panel;
    private JButton closeButton;
    private JTextField portTextBox;
    private JTextField ipAddressTextBox;
    private JTextField dbPortLabelTextBox;
    private JButton twitterStartButton;
    private JTextField dbUsernameTextBox;
    private JList clientListTextBox;
    private JButton selectButton;
    private JButton allButton;
    private JList messsagesTextBox;
    private JLabel portLabel;
    private JLabel ipAddressLabel;
    private JLabel dbPortLabel;
    private JLabel dbUsernameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordTextBox;
    private JLabel clientLabel;
    private JLabel messagesLabel;
    private JScrollPane messagesScrollPane;
    private DefaultListModel demoList = new DefaultListModel();
    private DefaultListModel clients = new DefaultListModel();
    private boolean startServer = false;
    private final Main main = new Main();

    public TwitterApp() {

        add(panel);
        setSize(1080,480);
        setTitle("New Twitter");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        twitterStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                portTextBox.setText("1234");
                ipAddressTextBox.setText("myhost");
                dbPortLabelTextBox.setText("1521");
                dbUsernameTextBox.setText("username");
                passwordTextBox.setText("password");

                //Client Client1 = new Client();
                //Client Client2 = new Client();
                //Client Client3 = new Client();
                //Client Client4 = new Client();
                //Client Client5 = new Client();

                startServer = true;

                Main main = new Main();


            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int index = clientListTextBox.getSelectedIndex()+1;
                System.out.println(index);
            }
        });
        allButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }

    public boolean getStartServer(){
        return this.startServer;
    }

    public void showClients(int clientNumber){

        ArrayList<String> ipAdress = new ArrayList<>();
        ipAdress.add("150.254.11.60");
        ipAdress.add("150.254.11.52");
        ipAdress.add("71.09.05.233");
        ipAdress.add("109.254.239.11");
        ipAdress.add("150.254.11.68");

        ArrayList<String> portNumber = new ArrayList<>();
        portNumber.add("4585");
        portNumber.add("4585");
        portNumber.add("1089");
        portNumber.add("2024");
        portNumber.add("2098");
        //clients.addElement("C"+clientNumber);

        clients.addElement("C"+clientNumber+" - "+ipAdress.get(clientNumber-1)+":"+portNumber.get(clientNumber-1));
        clientListTextBox.setModel(clients);
        clientListTextBox.setVisible(true);
    }

    public void showMessages(int clientNumber,String message){
        //System.out.println("Show Message"+message);
        demoList.addElement("Client "+clientNumber+" :"+message);
        messsagesTextBox.setModel(demoList);

    }

   private void createUIComponents() {



   }
}
