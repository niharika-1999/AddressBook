package com.bridgelabz6;
import java.util.Scanner;
import java.util.Hashtable;

public class MultipleAddressBook {
	public static int k=0;
	public static Scanner sc=new Scanner(System.in);
	public static void choiceUser(int choice,AddressBookMain object)
	{
		switch(choice)
		{
		case 1:object.addContact();
		break;

		case 2:object.editContact();
		break;

		case 3:object.delete();
		break;

		case 5:object.displayAddressBook();
		break;

		}
	}
	public static void main(String[] args) {

		Hashtable<String,AddressBookMain>  multipleAddressBook = new Hashtable<String, AddressBookMain>();  //dictionary for mapping different address book with key 
		AddressBookMain contact = new AddressBookMain();
		
		String n="";
		String y= "AddressBookName" ;
		multipleAddressBook.put(y, contact);//put the first Address book into dictionary
		
		while(k!=6)
		{
			System.out.println("Enter your choice\n 1) Create New Address Book\n 2) Add Contact \n 3) Edit existing Contact\n 4) Delete contact\n 5) Display Address Book\n 6) Exit"); //user selection
			int choice=sc.nextInt();
			if(choice==1)//to create a new address book
			{
				System.out.println("Enter the name of the Address Book:");
				n=sc.next();
				AddressBookMain addressBook1 = new AddressBookMain();// a new Address Book object is created 
				multipleAddressBook.put(n, addressBook1);
					
			}
			else
			{
				System.out.println("Enter the name of the AddressBook where you want to perform the operations: ");
				n=sc.next();
				choiceUser(choice,multipleAddressBook.get(n));
			}				
		}
}
}