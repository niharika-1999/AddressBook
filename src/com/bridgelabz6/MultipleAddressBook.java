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

		while(choice!=10)
		{
			System.out.println("Enter your choice\n 1. Create New Address Book\n 2. Add Contact \n 3. Edit existing Contact\n 4. Delete contact\n 5. Display Address Book\n 6. Create Another AddressBook\n 7. Search a person based on City/State\n 9. View person by City or State\n 10. Exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:  //to create a new address book
			{
				System.out.println("Enter the name of the Address Book:");
				n=sc.next();
				AddressBookMain object1 = new AddressBookMain();  // a new addressbook object is created 
				multipleAddressBook.put(n, object1);
				break;	
			}
			case 5:
			{
				System.out.println("Enter the name of the AddressBook to perform modifications: ");
				n=sc.next();
				choiceUser(choice,multipleAddressBook.get(n));   //to perform required operation on desired addressbook
				break;
			}
			case 6: 
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
				break;
			}
			case 7:
			{
				System.out.println("Enter the City/State: ");
				String place=sc.next();
				System.out.println("Person's whose State/City is: "+place);
				for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
				{
					AddressBookMain object3 = entry.getValue();
					object3.searchContact(place);
				}
				break;
			}
			case 8: {
				for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
				{
					AddressBookMain object4 = entry.getValue();
					System.out.println("Addressbook:"+entry.getKey());
					object4.viewPersonByCity();
				}
				break;
			}
			case 9: {
				for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
				{
					AddressBookMain object5 = entry.getValue();
					System.out.println("Addressbook:"+entry.getKey());
					object5.viewPersonByState();
				}
				break;
			}
			case 10:{
				System.out.println("Sort By: 1)Name 2)city 3)state 4)Zip");
				int option = sc.nextInt(); 
				for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
				{
					AddressBookMain object6 = entry.getValue();
					System.out.println("Addressbook:"+entry.getKey());
					object6.sortEntriesByNameCityStateZip(option);
				}
				break;
			}

			case 11: System.exit(0);
			default: System.out.println("Enter a Valid Option.");
			}
		}
	}
}
