## Online Real Estate

A real estate website to search add, update, deltet apartments.

## Prerequisties

* Java

* Apache

* Postgres

## Running

* Clone or download the project

* Open the Postgres Server

* Run the SQL script

* Open the Apache Server (will be running when run the project if it is set up successfuly)

* Run the project on the server

## Deployment

Deploy Website: https://pacific-anchorage-97765.herokuapp.com/

## Test Scenarios

In order to test the project via deploy website, please follow the instruction in the following text:

UserName and Password:

User: u1, 123; 

Administrator: a1, 123

### FeatureA:

1.	Input the username and the password (u1, 123) and click Log In
2.	The main page will be shown and the username can be seen in the navigation bar.
3.	Choose your favorite apartment and input your favorite inspection time and click Book.
4.	The cart page will be shown and all your inspection orders can be found.
5.	Change one of the orders inspection time and click update button. Then the inspection time will be updated.
6.	If you want to delete one order, click delete button.
7.	If you want to return to main page, click back button.
8.	Click the username in the navigation bar can also go to the cart page.

### FeatureB:

#### Session Information:

1.	If the browser has not browse the website, an information (Hello new User) will be shown on the website.
2.	If a user has been logged in to the system and then logged out, an information (Welcome back USERNAME) will be shown on the website.

#### Register a new user:

1.	Click a register button
2.	Input your first name, last name, username and password
3.	A new user has been created and can be used to log in.

#### Log in as an administrator:

1.	Click the administration Log In button
2.	Input username and password (a1, 123) to log in as an administrator

#### Add a new apartment:

1.	Log in as an administrator.
2.	Click Add Apartment button on the navigation bar to add a new apartment.
3.	Input all required information and click confirm button
4.	A newly apartment can be seen in the main page.

#### Update a specific apartment

1.	Log in as an administrator.
2.	Choose an apartment and click update button.
3.	All information that related to this apartment will be shown.
4.	Change a little bit information and click confirm button.
5.	The information of the apartment has been updated.

#### Delete a specific apartment

1.	Log in as an administrator.
2.	Choose an apartment and click delete button.
3.	The information of this apartment will be deleted.

---
