# Movie-Seating-Arrangement
This project illustrates the low-level system design, programming and testing of a Movie theatre seating process. The low-level system design for a movie theatre depicts the various classes used in order to provide different functionalities like handling I/0, business logic, and assumptions.

## Business Requirements:
There are two main business requirements for the movie seat allocation systems:
- Customer Satisfaction:
    1. Generally, customers have a preference for seats that are in the back because of better view and presence of recliner seats. So, we start to allocate seats in a first come first serve (FCFS) basis from the back. 
    2. Another factor that is pertinent to customer satisfaction is Availability. We allocate seats in such a manner that we try to utilize maximum seating capacity and don't leave too much empty seats.
    3. Customers booking seats for a larger group have a preference for getting all the seats in the same row. 
  
 - Public Safety:
    1. We assume that the movie theatre is operating during Coronavirus Pandemic, and due to the Protocols set by Government, it cannot operate at full capacity. It needs to follow social distancing protocols, and allocate seats for customers so that public safety can effectively be enforced.
    2. We assume a buffer of 3 seats and/or 1 row in order to fulfill the above requirement. 
 
 ## Low-Level System Design:
 We need to develop individual classes for handling different programming aspects of our system. I have created three different classes:
 - MainClass: This is the driver program. It takes command line arguments for the input and output files.
 - InputOutput: This class contains logic for handling the I/O read and write. 
 - MovieTheatreGrid: This class contains the algorithm for fulfilling the business logic. 
 
 ![alt text](https://github.com/GauravDevc123/Movie-Seating-Arrangement/blob/master/Class_Diagram_Movie_Seating.png)
 
## Algorithm:
The algorithm needs to handle both customer satisfaction and public safety. The algorithm follows a First-Come-First-Serve(FCFS) basis and starts allocating seats from the back in the order A,B,C,D...X,Y,Z. Also, because of the assumption that the movie theatre is operating during Coronavirus pandemic, we restrict the number of tickets an end user can book.

Pseudo-Code:
1. Check if the number of seats the user wants to book exceeds the restrictions set-forth.
2. If no, then we try to look for the row where the number of people can be easily accomodated. We look for a buffer of 3 seats within the same row. If such row exists, we book the seat in that row.
3. If no such row exists, we cannot book tickets for the user because the theatre needs to enforce public safety set-forth by the goverment. 

## Assumptions:
1. The customers are allocated movie seats based on the order in which we receive the booking order. 
2. Customers have a preference to get all their seats allocated in the same row. 
3. The movie theatre is operating during the CoronaVirus Pandemic and cannot operate at its full capacity.
4. To enforce public safety, we try to book tickets for a new user with a buffer of 3 seats per row and/or 1 row. 

## Instructions for building the solution:
Note: The program handles I/O from the command line arguments. Make sure to build and test the solution from the command line arguments.
1. Navigate to "Code" button in the top-right of the Repository.
2. Click on the Download Zip option. This will download a zip file for you. 
3. Before running or compiling any of the .java files in the src folder, make sure you have JDK installed on your machine and set the environment path variable.
4. After setting up the JDK on your machine, make sure you have your command lines setup. The MainClass.java has the main method that accepts command line arguments for the input and output file. After compiling the MainClass.java and solving any syntatical or logical error, follow the below steps for providing the command line arguments:
> java Mainclass "Location of Input.txt File" "Location of Output.txt File"

## Instruction for testing the solution:
The program accepts input from the a text file through command line. For testing purpose, make a text file 'input.txt' and provide rows of input in the below format:
- Request_ID Number of Tickets

Example:
 - R001 4
 - R002 3
 - R003 2
 - R004 5
