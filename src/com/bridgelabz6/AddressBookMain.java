package com.bridgelabz6;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	public static ArrayList<AddressBookMain> contact=new ArrayList<>();//collection class array list is used to store different contacts in address book

	//Class members 
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String phoneNumber;
	private String email;

	public AddressBookMain(String firstName, String lastName, String address, String city, String state, String pin, String phoneNumber, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


	public void Display()//Display Contact Information
	{	
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Address: " +address + ", " + city + ", "+ state + " - " + pin);
		System.out.println("Contact Number: " +phoneNumber);
		System.out.println("Email ID: " + email + "\n");
	}

	public void editContact(String firstName, String lastName, String address, String city, String state, String pin, String phoneNumber, String email)//Edits the detail of contact present in Address Book
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.email=email;
	}

	//Function to delete a contact-UC4
	public static void deleteContact(AddressBookMain deletionObject)
	{
		contact.remove(deletionObject); //using built in method to remove objects

	}

	public static void main(String[] args) {
		//Display Message. 
		System.out.println("Welcome to Address Book Program");
				
		Scanner sc = new Scanner(System.in);
		String firstName;
		String lastName;
		String address ;
        String city;
		String state;
		String pin ;
		String phoneNumber;
		String email;

		int k = 1;

		do
		{
			System.out.println("Enter your choice\n 1) Add Contact \n 2) Edit existing Contact\n 3) Delete contact\n 4) Display Address Book\n 5) Exit"); //user selection
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: {
				System.out.println("Add Contacts: ");
				System.out.println("Enter your first name: ");
				firstName = sc.nextLine();
				System.out.println("Enter your last name: ");
				lastName = sc.nextLine();
				System.out.println("Enter your Address: ");
				address = sc.nextLine();
				System.out.println("Enter your city: ");
				city = sc.nextLine();
				System.out.println("Enter your state: ");
				state = sc.nextLine();
				System.out.println("Enter your city PIN Code: ");
				pin = sc.nextLine();
				System.out.println("Enter your contact number: ");
				phoneNumber = sc.nextLine();
				System.out.println("Enter your Email ID: ");
				email = sc.nextLine();
				contact.add(new AddressBookMain(firstName,lastName,address,city,state,pin,phoneNumber,email));//object creation
				System.out.println("Details Added. \n");	
				break;
			} 
			case 2:{
				//Editing contacts 
				System.out.println("Enter the person's First Name: ");
				String editFirstName = sc.nextLine();
				System.out.println("Enter the person's Last Name: ");
				String editLastName = sc.nextLine();
				for (int j=0;j<contact.size();j++)
				{
					AddressBookMain contacts = contact.get(j);
					if(contacts.firstName.equals(editFirstName) && contacts.lastName.equals(editLastName))
					{
						int edit1=j;
						System.out.println("Enter your first name: ");
						firstName = sc.nextLine();
						System.out.println("Enter your last name: ");
						lastName = sc.nextLine();
						System.out.println("Enter your Address: ");
						address = sc.nextLine();
						System.out.println("Enter your city: ");
						city = sc.nextLine();
						System.out.println("Enter your state: ");
						state = sc.nextLine();
						System.out.println("Enter your city PIN Code: ");
						pin = sc.nextLine();
						System.out.println("Enter your contact number: ");
						phoneNumber = sc.nextLine();
						System.out.println("Enter your Email ID: ");
						email = sc.nextLine();
						contacts.editContact(firstName,lastName,address,city,state,pin,phoneNumber,email);//calling Edit Contact
					}
				}
				break;
			}
			case 3:{
				//Deleting a contact
				System.out.println("Enter the person's First Name: ");
				String deleteFirstName = sc.nextLine();
				System.out.println("Enter the person's Last Name: ");
				String deleteLastName = sc.nextLine();
				for (int j=0;j<contact.size();j++)
				{
					AddressBookMain contacts = contact.get(j);
					if(contacts.firstName.equals(deleteFirstName) && contacts.lastName.equals(deleteLastName))//to delete a contact
					{
						deleteContact(contacts);
						System.out.println("Contact Deleted.");
					}
				}
				break;
			}
			case 4: {
				System.out.println("Contacts in Address Book: ");
				for(int j=0; j<contact.size() ;j++)
				{
					AddressBookMain contacts = contact.get(j);
					System.out.println("Contact details of person: "+ (j+1));
					contacts.Display();
				}
				break;
			} 
			case 5: {
				System.out.println("Exit.");
				break;
			} 
			default: 
				System.out.println("Enter Valid Option");
			}

		}while(k!=5);
		sc.close();
	}

}




