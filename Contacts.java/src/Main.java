import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Contact {
    private String name;
    public String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name Of Contact: " + name + ", Contact Number: " + phoneNumber;
    }
}

class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    // Insert contact function
    public void insertContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        JOptionPane.showMessageDialog(null, "Contact " + name + " added.");
    }

    // Search for contact function
    public Contact searchContact(String searchName) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                return contact;
            }
        }
        return null;
    }

    // Displaying contacts
    public String displayContacts() {
        if (contacts.isEmpty()) {
            return "PhoneBook is Empty.";
        } else {
            StringBuilder contactList = new StringBuilder();
            for (Contact contact : contacts) {
                contactList.append(contact).append("\n");
            }
            return contactList.toString();
        }
    }

    // Deleting a contact
    public void deleteContact(String deleteName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(deleteName)) {
                contacts.remove(i);
                JOptionPane.showMessageDialog(null, "Contact " + deleteName + " deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contact not found.");
    }

    // Updating a contact's information
    public void updateContact(String updateName, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(updateName)) {
                contact.phoneNumber = newPhoneNumber;
                JOptionPane.showMessageDialog(null, "Contact " + updateName + " updated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contact not found.");
    }

    // Sorting contacts
    public void sortContacts() {
        contacts.sort(Comparator.comparing(Contact::getName));
        JOptionPane.showMessageDialog(null, "Contacts sorted by name.");
    }
}

public class Main extends JFrame {
    private PhoneBook phoneBook;
    private JTextArea textArea;
    private JTextField nameField;
    private JTextField phoneField;

    public Main() {
        phoneBook = new PhoneBook();
        setTitle("Phone Book");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area for displaying contacts
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Panel for input fields and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneField.getText();
                phoneBook.insertContact(name, phoneNumber);
                nameField.setText("");
                phoneField.setText("");
                updateContactList();
            }
        });
        panel.add(addButton);

        JButton searchButton = new JButton("Search Contact");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Contact contact = phoneBook.searchContact(name);
                if (contact != null) {
                    JOptionPane.showMessageDialog(null, "Contact found: " + contact);
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found.");
                }
            }
        });
        panel.add(searchButton);

        JButton updateButton = new JButton("Update Contact");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String newPhoneNumber = phoneField.getText();
                phoneBook.updateContact(name, newPhoneNumber);
                updateContactList();
            }
        });
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete Contact");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                phoneBook.deleteContact(name);
                updateContactList();
            }
        });
        panel.add(deleteButton);

        JButton displayButton = new JButton("Display Contacts");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateContactList();
            }
        });
        panel.add(displayButton);

        JButton sortButton = new JButton("Sort Contacts");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                phoneBook.sortContacts();
                updateContactList();
            }
        });
        panel.add(sortButton);

        add(panel, BorderLayout.SOUTH);
    }

    private void updateContactList() {
        textArea.setText(phoneBook.displayContacts());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
