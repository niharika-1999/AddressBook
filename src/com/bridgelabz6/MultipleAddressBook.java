package com.bridgelabz6;
import java.util.Scanner;
import java.util.Hashtable;

public class MultipleAddressBook {
	public static int k=0;//To iterate program
	public static Scanner sc=new Scanner(System.in);
	/** 
	 * @param User choice to perform different operations on address book
	 */
	public static void choiceUser(int choice,AddressBookMain object)
	{
		switch(choice)
		{
		case 2:object.addContact();
		break;

		case 3:object.editContact();
		break;

		case 4:object.delete();
		break;

		case 5:object.displayAddressBook();
		break;

		}
	}
	public static void main(String[]args)
	{
		Hashtable<String,AddressBookMain> MultipleAddressBook=new Hashtable<String,AddressBookMain>();
		AddressBookMain address_book=new AddressBookMain();
		
		String AddressBookName="AddressBookSystem";
		MultipleAddressBook.put(AddressBookName,address_book);
		
		while(k!=7)
		{
			System.out.println("Enter your choice\n1.addContact contact\n2.editContact contact\n3.delete\n4.displayAddressBook\n5.create AnotherAdressBook");
			int choice=sc.nextInt();
			if(choice==1)//To create new Address Book
			{
				System.out.println("Enter name of the Address Book: ");
				AddressBookName=sc.next();
				AddressBookMain object1=new AddressBookMain();
				MultipleAddressBook.put(AddressBookName,object1);
			}
			if(choice==5)  
			{
				System.out.println("Enter the name of the Address Book: ");
				AddressBookName = sc.next();
				if(MultipleAddressBook.containsKey(AddressBookName))
				{
				    System.out.println("Address Book already exists.");
				    AddressBookName=sc.next();
				}
				AddressBookMain object2 = new AddressBookMain();  
				MultipleAddressBook.put(AddressBookName, object2);							
			}
			else 
			{
				System.out.println("Enter name of the Address Book to modify the contact: ");
				AddressBookName=sc.next();
				choiceUser(choice,MultipleAddressBook.get(AddressBookName));
			}
		}
		
		
	}

}

