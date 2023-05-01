# Term-Project

* Administrator Class
 
 Contains (for now) basic functionality to create admin objects
 Will have a method that allows to validate times


* Athlete Class (Abstract)
  
  Contains the base functionality shared among all athletes
  3 Different child classes are created from it (Football, Swimming, Track) for different types of athletes

* Password(Storage) Class

  Creates a HashMap where Admin usernames and passwords are stored
  Creates a list of Administrators

  Creates a HashMap where Athletes usernames and passwords are stored
  Creates a list of Athletes

  Methods: 

  1) Register for Admin
   -> Adds username and password to the hashmap
   -> Creates an Admin Object and adds it to the list
  2) Register for Athletes
   -> Adds username and password to the hashmap
   -> Creates an Athlete Object and add it to the list
  
  3) Login for Admin
   -> Checks if the username and password given exist in the Storage Hashmap for Administrators
  4) Login for Athlete
   -> Checks if the username and password given exist in the Storage Hashmap for Athletes
  
  
* Leaderboard Class
