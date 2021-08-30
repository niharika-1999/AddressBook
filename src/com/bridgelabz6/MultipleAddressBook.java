package com.bridgelabz6;
import java.util.*;

public class MultipleAddressBook {
	public Scanner sc=new Scanner(System.in);
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
		
		
	}

}
