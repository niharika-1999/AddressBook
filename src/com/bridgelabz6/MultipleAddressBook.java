package com.bridgelabz6;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

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
		Hashtable<String,AddressBookMain> multipleAddressBook=new Hashtable<>();
		AddressBookMain person=new AddressBookMain();

		int choice=0;
		String n ="";
		String addressBookName="AddressBookSystem";
		multipleAddressBook.put(addressBookName,person);

		while(choice!=8)
		{
			System.out.println("Enter your choice\n 1. Create New Address Book\n 2. Add Contact \n 3. Edit existing Contact\n 4. Delete contact\n 5. Display Address Book\n 6. Create Another AddressBook\n 7. Search a person based on City/State\n 8. Exit");
			choice=sc.nextInt();
			if(choice==1)//To create new Address Book
			{
				System.out.println("Enter name of the Address Book: ");
				n=sc.next();
				AddressBookMain object1=new AddressBookMain();
				multipleAddressBook.put(n,object1);
			}
			else if(choice==5)  
			{
				System.out.println("Enter the name of the Address Book: ");
				n = sc.next();
				if(multipleAddressBook.containsKey(n))
				{
					System.out.println("Address Book already exists.");
					n=sc.next();
				}
				AddressBookMain object2 = new AddressBookMain();  
				multipleAddressBook.put(n, object2);							
			}
			else if(choice==7)
			{
				System.out.println("Enter City/State: ");
				String place=sc.next();
				System.out.println("Person's whose State/City is: "+place);
				for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
				{
					AddressBookMain object3 = entry.getValue();
					object3.searchContact(place);
				}

			}
			else
			{
				System.out.println("Enter name of the Address Book to modify the contact: ");
				n=sc.next();
				choiceUser(choice,multipleAddressBook.get(n));
			}
		}
		if(choice==8)
		{
			System.exit(0);
		}


	}

}

