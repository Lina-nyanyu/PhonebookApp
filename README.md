# PhonebookApp
A phonebook application in Java

Group Leader: (224080008) Endelina Uugwanga (37)

Other Members:

~Ndati Kafidi (37) (224066765)

~Asanda Noludwe (37) (223008575)

~Jedidja Mbinga (37) (224016148)

~Petrus Amukugo (37) (224032119)

~Didilikeni Kronelius (37) (224025791)

Description Of The Project :
This PhoneBook program is a simple Java application that allows users to manage their contacts. It provides functionalities to add, search, update, delete, display, and sort contacts.
Key Features:
Contact Management: Users can add new contacts by entering a name and phone number.
Search Functionality: Users can search for a contact by name, and the program will display the contact's details if found.
Update and Delete: Users can update a contact's phone number or delete a contact from the phone book.
Display and Sort: The program can display all contacts and sort them alphabetically by name.
User Interaction: It uses a menu-driven interface, allowing users to choose actions easily.

Data Structure We used:
The program uses an ArrayList to store the contacts, which allows for dynamic resizing as contacts are added or removed. This makes it efficient for managing a variable number of contacts.

IDE used :
IntelliJ idea IDE

Below is a detailed description of its functions and modules:

Functionality Overview

Insert Contact:
Users can add a new contact by providing a name and phone number. The contact is stored in an ArrayList of Contact objects.

Search Contact:
Users can search for a contact by name. If the contact is found, its details are displayed; otherwise, a message indicates that the contact was not found.

Update Contact:
Users can update an existing contact's phone number by searching for the contact by name. If found, the phone number is updated accordingly.

Delete Contact:
Users can delete a contact by name. If the contact exists, it is removed from the list; if not, a message is displayed indicating that the contact was not found.

Display Contacts:
Users can view all contacts in the phonebook. If the list is empty, a message is shown indicating that the phonebook is empty.

Sort Contacts:
Users can sort the contacts alphabetically by name. The sorting is done using the Comparator interface.

Module Description
Contact Class:
Represents a single contact with attributes for the name and phone number. It includes methods to retrieve the name and phone number, as well as a toString method for displaying contact details.

PhoneBook Class:
Manages a list of Contact objects. It contains methods for inserting, searching, updating, deleting, displaying, and sorting contacts. The contacts are stored in an ArrayList, allowing dynamic resizing as contacts are added or removed.

Main Class:
Contains the main method, which serves as the entry point for the application. It presents a menu to the user, allowing them to choose various options for managing contacts. User input is handled through a Scanner object.

User Interaction
The application runs in a loop, presenting a menu of options until the user chooses to exit. Each option corresponds to a specific function, allowing for straightforward interaction with the phonebook system.

Overall, this phonebook application provides a simple and effective way to manage personal contacts through a command-line interface, making it easy for users to add, update, delete, search, display, and sort their contacts.
