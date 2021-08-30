package com.bridgelabz6;
import java.util.*;

public class AddressBookMain {
		public ArrayList<AddressBookMain>  contact=new ArrayList<AddressBookMain>();
		public Scanner sc=new Scanner(System.in);
		
		//class members
		public String first_name;
		public String last_name;
		public String address;
		public String city;
		public String state;
		public String zip;
		public String phone_number;
		public String email;
		
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
		}
		
		public void display()//Display contact information
		{
			System.out.println("Enter person's first name: ");
			String name =sc.next();
			for(int j=0;j<contact.size();j++)
			{
				AddressBookMain address_book=contact.get(j);
				if(address_book.first_name.equals(name))
				{
					System.out.println("First Name:"+first_name);
					System.out.println("Last Name:"+last_name);
					System.out.println("Address:"+address);
					System.out.println("City:"+city);
					System.out.println("State:"+state);
					System.out.println("Zip:"+zip);
					System.out.println("Phone Number:"+phone_number);
					System.out.println("E mail:"+email);
					
				}
			}
		}
			
			public void displayAddressBook()//Display complete contact in Address Book
			{
				if(contact.size()==0)
				{
					System.out.println("No contact present in the Address Book");
				}
				else
				{
					System.out.println("Following contacts are present in Address Book");
					for(int j=0;j<contact.size();j++)
					{
						AddressBookMain object = contact.get(j);
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
			
			public void editContact()//Edits the details of the contact present in Address Book
			{
				System.out.println("Enter the person whose contact needs to be edited");
				String name =sc.next();
				for(int j=0;j<contact.size();j++)
				{
					AddressBookMain address_book=contact.get(j);
					if(address_book.first_name.equals(name))
					{
						System.out.println("Enter first_name:");
						address_book.first_name=sc.next();
						System.out.println("Enter last_name:");
						address_book.last_name=sc.next();
						System.out.println("Enter address:");
						address_book.address=sc.next();
						System.out.println("Enter city:");
						address_book.city=sc.next();
						System.out.println("Enter state:");
						address_book.state=sc.next();
						System.out.println("Enter zip:");
						address_book.zip=sc.next();
						System.out.println("Enter phone_number:");
						address_book.phone_number=sc.next();
						System.out.println("Enter email:");
						address_book.email=sc.next();
					}
				}
			}
				
}		
		
			


