package com.bridgelabz6;
import java.util.*;

public class MultipleAddressBook {
	public static Scanner sc=new Scanner(System.in);
	public static void choice(int choice,AddressBookMain object)
	{
		switch(choice)
		{
		case 1:object.addContact();
		break;
		
		case 2:object.editContact();
		break;
		
		case 3:object.delete();
		break;
		
		case 4:object.addContact();
		break;
		
		case 5:object.display();
		break;
		
		case 6:object.displayAddressBook();
		break;
		
		}
	}
	public static void main(String[]args)
	{
		Hashtable<String,AddressBookMain> MultipleAddressBook=new Hashtable<String,AddressBookMain>();
		AddressBookMain address_book=new AddressBookMain();
		
		String AddressBookName="AddressBookSystem";
		MultipleAddressBook.put(AddressBookName,address_book);
		
		while(true)
		{
			System.out.println("Enter your choice\n1.addContact contact\n2.editContact contact\n3.delete\n4.display\n5.displayAddressBook\n6.create AnotherAdressBook");
			int choice=sc.nextInt();
			if(choice==6)//To create new Address Book
			{
				System.out.println("Enter name of the Address Book: ");
				AddressBookName=sc.next();
				AddressBookMain object1=new AddressBookMain();
				MultipleAddressBook.put(AddressBookName,object1);
				
				
			}
			else if(choice==7)//Exit
				System.exit(0);
			else 
			{
				System.out.println("Enter name of the Address Book to modify the contact: ");
				AddressBookName=sc.next();
				choice(choice,MultipleAddressBook.get(AddressBookName));
			}
		}
		
		
	}

}
