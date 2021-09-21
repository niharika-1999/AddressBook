package com.bridgelabz6;
import java.util.ArrayList;
import java.util.Scanner;


public class AddressBookMain {
	public ArrayList<AddressBookMain>  contact=new ArrayList<AddressBookMain>();
	public Scanner sc=new Scanner(System.in);

	//class members
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone_number;
	private String email;

	public AddressBookMain()
	{
		System.out.println("Welcome to Address Book Program");//Welcome Message
	}


	public AddressBookMain(String first_name,String last_name,String address,String city,String state,String zip, String phone_number,String email)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone_number=phone_number;
		this.email=email;

	}

	public void addContact()//Adding person details to Address Book
	{
		System.out.println("Enter contact details:");
		System.out.println("first_name:");
		first_name=sc.next();
		System.out.println("last_name:");
		last_name=sc.next();
		System.out.println("address:");
		address=sc.next();
		System.out.println("city:");
		city=sc.next();
		System.out.println("state:");
		state=sc.next();
		System.out.println("zip:");
		zip=sc.next();
		System.out.println("phone_number:");
		phone_number=sc.next();
		System.out.println("email:");
		email=sc.next();
		contact.add(new AddressBookMain(first_name,last_name,address,city,state,zip,phone_number,email));
		System.out.println("Added the details\n");
	}

	public void editContact()//Edits the details of the contact present in Address Book
	{
		System.out.println("Enter the person whose contact needs to be edited");
		System.out.println("Enter first Name:");
		String firstName =sc.next();
		System.out.println("Enter Last Name:");
		String lastName =sc.next();
		for(int j=0;j<contact.size();j++)
		{
			AddressBookMain address_book=contact.get(j);
			if(address_book.first_name.equals(firstName)&&address_book.last_name.equals(lastName))
			{
				System.out.println("Enter first_name:");
				first_name=sc.next();
				System.out.println("Enter last_name:");
				last_name=sc.next();
				System.out.println("Enter address:");
				address=sc.next();
				System.out.println("Enter city:");
				city=sc.next();
				System.out.println("Enter state:");
				state=sc.next();
				System.out.println("Enter zip:");
				zip=sc.next();
				System.out.println("Enter phone_number:");
				phone_number=sc.next();
				System.out.println("Enter email:");
				email=sc.next();
			}

		}
	}

	public void delete()//Method to delete contact
	{
		System.out.println("Enter the prson whose contact needs to be deleted");
		System.out.println("Enter first Name:");
		String deleteFirstName =sc.next();
		System.out.println("Enter Last Name:");
		String deleteLastName =sc.next();
		for(int j=0;j<contact.size();j++)
		{
			AddressBookMain address_book=contact.get(j);
			if(address_book.first_name.equals(deleteFirstName)&&address_book.last_name.equals(deleteLastName))
			{
				contact.remove(address_book);
				System.out.println("Contact is deleted");
			}
			else
			{
				System.out.println("Name does not exist");
			}
		}
	}

	public void displayAddressBook()//Method to Display all the contents in AddressBook
	{
		System.out.println("Contacts in this Address Book: ");

		for(int j=0;j<contact.size();j++)
		{
			AddressBookMain object = contact.get(j);
			//Displaying the details
			System.out.println("First Name:"+object.first_name);
			System.out.println("Last Name:"+object.last_name);
			System.out.println("Address:"+object.address);
			System.out.println("City:"+object.city);
			System.out.println("State:"+object.state);						
			System.out.println("Zip:"+object.zip);
			System.out.println("Phone Number:"+object.phone_number);
			System.out.println("E mail:"+object.email);
		}
	}


}