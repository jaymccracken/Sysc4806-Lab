package Labs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUI extends JFrame implements ActionListener {
    static JTextField t;
    static JButton b;
    static JFrame f;
    private JList<AddressBook> addressList = new JList <AddressBook>();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> buddyList;
    private AddressBook newbook = new AddressBook();

    public GUI() {
        setDefaultCloseOperation(1);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar); // Add the menu bar to the window

        JMenu AddressMenu = new JMenu("Address Book"); // Create File menu
        JMenu buddyListMenu = new JMenu("BuddyList"); // Create Elements menu
        menuBar.add(AddressMenu); // Add the file menu
        menuBar.add(buddyListMenu); // Add the element menu

        JMenuItem item;

        item = new JMenuItem ("New");
        item.addActionListener( this );
        AddressMenu.add( item );
    /*    item = new JMenuItem ( "Display" );
        item.addActionListener( this );
        AddressMenu.add( item );
        item = new JMenuItem ( "Save" );
        item.addActionListener( this );
        AddressMenu.add( item );
        item = new JMenuItem ( "Load" );
        item.addActionListener( this );
        AddressMenu.add( item );*/
        item = new JMenuItem ( "Add" );
        item.addActionListener( this );
        buddyListMenu.add( item );
        item = new JMenuItem ( "Remove" );
        item.addActionListener( this );
        buddyListMenu.add( item );


        buddyList = new JList<>(listModel);
        this.add(buddyList);
        buddyList.setVisible(false);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("New")) {
            JFrame gui = new GUI();
            newbook = new AddressBook();
        }
/*        if (s.equals("Save")) {
            String name = JOptionPane.showInputDialog("Enter Project Name");
            newbook.save(name);
        }
        if (s.equals("Load")) {
            String name = JOptionPane.showInputDialog("Enter Project Name");
            Labs.BuddyInfo newBuddy;
            newBuddy = Labs.BuddyInfo.Import(name);
            newbook.addBuddy(newBuddy);
            listModel.addElement(newBuddy.toString());
        }*/

        if (s.equals("Add")) {
            String name = JOptionPane.showInputDialog("Please enter their Name");
            String address = JOptionPane.showInputDialog("Please enter their address");
            String phoneNumber = JOptionPane.showInputDialog("Please enter their phone number");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter their age"));

            BuddyInfo newBuddy = new BuddyInfo(name,address,phoneNumber,age);
            newbook.addBuddy(newBuddy);
            listModel.addElement(newBuddy.write());
            buddyList.setVisible(true);

        }
        if (s.equals("Remove")) {
            listModel.remove(buddyList.getSelectedIndex());
        }
    }

/*    public static void main (String[] args) {
        JFrame gui = new Labs.GUI();
    }*/

}