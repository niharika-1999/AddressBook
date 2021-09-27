package com.bridgelabz6;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		System.out.println("Enter your first name: ");
		first_name = sc.nextLine();
		if(checkDuplicate(first_name) == false)
		{
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
		}

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
				address_book.displayAddressBook();
				System.out.println("Enter the number of the detail you want to edit \n1.First Name\n2.Last Name\n3.Address\n4.City\n"
						+ "5.State\n6.Zip\n7.Phone Number\n8.Email ID");
				int choose = sc.nextInt();
				switch(choose)
				{
				case 1: {
					System.out.println("Enter your first name: ");
					address_book.first_name = sc.nextLine();
					break;
				}
				case 2: {
					System.out.println("Enter your last name: ");
					address_book.last_name = sc.nextLine();
					break;
				}
				case 3: {
					System.out.println("Enter your Address: ");
					address_book.address = sc.nextLine();
					break;
				}
				case 4: {
					System.out.println("Enter your city: ");
					address_book.city = sc.nextLine();
					break;
				}
				case 5: {
					System.out.println("Enter your state: ");
					address_book.state = sc.nextLine();
					break;
				}
				case 6: {
					System.out.println("Enter your city PIN Code: ");
					address_book.zip = sc.nextLine();
					break;
				}
				case 7: {
					System.out.println("Enter your contact number: ");
					address_book.phone_number = sc.nextLine();
					break;
				}
				case 8: {	
					System.out.println("Enter your Email ID: ");
					email = sc.nextLine();
					break;
				}
				default: System.out.println("Invalid.");
				}
			}
			else
				System.out.println("Contact not found.");
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

	public Boolean checkDuplicate(String name)//Method to check duplicate values
	{
		for (int j=0; j<contact.size(); j++)
		{   
			AddressBookMain object = contact.get(j);
			if(object.first_name.equals(name))
			{
				System.out.println("Contact already exists"); 
				return true;
			}
		}
		return false;
	}

	public void searchContact(String place)//Method to search person by city or state 
	{
		for (int j=0;j<contact.size();j++)
		{   
			AddressBookMain address_book  = contact.get(j);
			if(address_book.city.equals(place)||address_book.state.equals(place))
			{
				address_book.displayAddressBook();  
			}
		}

	}
	@SuppressWarnings({"unchecked","rawtypes"})
	public void viewPersonByCity()//Method to view persons by city
	{
		Map<String,List<String>> mapCity = new HashMap<> ();
		for (int j=0;j<contact.size();j++)
		{   
			AddressBookMain object=contact.get(j);
			if(mapCity.containsKey(object.city))
			{
				List<String> temp= mapCity.get(object.city);
				temp.add(object.first_name);
				mapCity.put(object.city, temp);
			}
			else
			{
				List<String> temp=new ArrayList<>();
				temp.add(object.first_name);
				mapCity.put(object.city, temp);
			}
		}
		for(Map.Entry m: mapCity.entrySet()) 
		{
			System.out.println(m.getKey()+" : "+m.getValue());
			System.out.println("There are "+((List<String>) m.getValue()).size()+" people in City "+m.getKey());
		}
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	public void viewPersonByState() //Method to view person by state
	{
		Map<String,List<String>> mapState = new HashMap<> ();
		for (int j=0;j<contact.size();j++)
		{   
			AddressBookMain object=contact.get(j);
			if(mapState.containsKey(object.state))
			{
				List<String> temp= mapState.get(object.state);
				temp.add(object.first_name);
				mapState.put(object.state, temp);
			}
			else
			{
				List<String> temp=new ArrayList<>();
				temp.add(object.first_name);
				mapState.put(object.state, temp);
			}
		}
		for(Map.Entry m: mapState.entrySet()) 
		{
			System.out.println(m.getKey()+" : "+m.getValue());
			System.out.println("There are "+((List<String>) m.getValue()).size()+" people in state "+m.getKey());
		}
	} 

	public void sortEntriesByNameCityStateZip(int option){   //Method to sort entries by name or city or state or zip

		Map<String,List<AddressBookMain>> map = new HashMap<> ();
		if(option == 1) 
		{
			for (int j=0;j<contact.size();j++)
			{   
				AddressBookMain object=contact.get(j);
				if(map.containsKey(object.first_name))
				{
					List<AddressBookMain> temp= map.get(object.first_name);
					temp.add(object);
					map.put(object.first_name, temp);
				}
				else
				{
					List<AddressBookMain> temp=new ArrayList<>();
					temp.add(object);
					map.put(object.first_name, temp);
				}
			}
		}
		else if(option == 2) 
		{
			for (int j=0;j<contact.size();j++)
			{   
				AddressBookMain object=contact.get(j);
				if(map.containsKey(object.city))
				{
					List<AddressBookMain> temp= map.get(object.city);
					temp.add(object);
					map.put(object.city, temp);
				}
				else
				{
					List<AddressBookMain> temp=new ArrayList<>();
					temp.add(object);
					map.put(object.city, temp);
				}
			}
		}
		else if(option == 3) 
		{
			for (int j=0;j<contact.size();j++)
			{   
				AddressBookMain object=contact.get(j);
				if(map.containsKey(object.state))
				{
					List<AddressBookMain> temp= map.get(object.state);
					temp.add(object);
					map.put(object.state, temp);
				}
				else
				{
					List<AddressBookMain> temp=new ArrayList<>();
					temp.add(object);
					map.put(object.state, temp);
				}
			}
		}
		else if(option == 4) 
		{
			for (int j=0;j<contact.size();j++)
			{   
				AddressBookMain object=contact.get(j);
				if(map.containsKey(object.zip))
				{
					List<AddressBookMain> temp= map.get(object.zip);
					temp.add(object);
					map.put(object.zip, temp);
				}
				else
				{
					List<AddressBookMain> temp=new ArrayList<>();
					temp.add(object);
					map.put(object.zip, temp);
				}
			}
		}
		else {
			System.out.println("choose correct option");
		}
		Map<String, List<AddressBookMain>> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue,LinkedHashMap::new));
		for (Map.Entry<String, List<AddressBookMain>> entry : sortedMap.entrySet()) {
			for(AddressBookMain sort: entry.getValue()) {
				System.out.println("First Name:"+sort.first_name);
				System.out.println("Last Name:"+sort.last_name);
				System.out.println("Address:"+sort.address);
				System.out.println("City:"+sort.city);
				System.out.println("State:"+sort.state);
				System.out.println("Zip:"+sort.zip);
				System.out.println("Phone number:"+sort.phone_number);
				System.out.println("E-mail:"+sort.email);
			}
		}
	}
	/**
	 * Method write files writes into the file containing
	 * contact details of a person
	 */
	public void writeFile(String file) 
	{
		try 
		{
			FileWriter writer = new FileWriter(file+".txt");
			for (int j=0;j<contact.size();j++)
			{
				AddressBookMain object=contact.get(j);
				writer.write("\nFirst Name:"+object.first_name+"\nLast Name:"+object.last_name+
						"\nAddress:"+object.address+"\nCity:"+object.city+"\nState:"+object.state
						+"\nPIN:"+object.zip+"\nContact number:"+object.phone_number+"\nEmail ID:"
						+object.email+"\n");
			}
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}    
	}

	/*
	 * Method readFile reads the file containing contact details of the person
	 */
	public void readFile(String file) throws IOException
	{
		FileReader reader =new FileReader(file+".txt");
		int i;
		while ((i=reader.read()) != -1)
			System.out.print((char) i);
	}

}


