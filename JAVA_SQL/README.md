## Hi! This is Ferennia
I want to share my mini project, namely Digital Payment. This project is basically like a transaction in a mobile bank. I used Java to implement the logic and connect to the MySQL database. So here, I'm gonna explain the role of every file and how they are connected to each other.

<img width="293" height="345" alt="Image" src="https://github.com/user-attachments/assets/2726666b-8f04-4eeb-99a1-bcd00a6c7905" />

### 1. Drivers

We need the appropriate driver to connect the Java project to the MySQL database. First, we need to download it from https://dev.mysql.com/downloads/connector/j/ and choose the ZIP one. 

<img width="1361" height="675" alt="Image" src="https://github.com/user-attachments/assets/d9c397cd-c180-41da-a5c0-3d342879810b" />

After downloading and extracting the file, copy the extracted file into the Drivers folder at the same location as the project modules. After that, we should set the connector in Dependencies then apply it.

<img width="1365" height="714" alt="Image" src="https://github.com/user-attachments/assets/875ed185-0b9c-430e-ad82-1d73a992fe7b" />

### 2. Java
For connecting Java into MySQL Database, we use the DataBaseConnection class. As you can see, we have to import some packages that support the connection, and we must specify the name of the database and the password so that we can access the database when running the logic in Java. After creating the DataBaseConnection class, we can freely access the database and make the logic syntax in Java.

<img width="556" height="242" alt="Image" src="https://github.com/user-attachments/assets/389461db-538a-41fa-8bdd-9ba253c4b695" />

Here are the summaries of the logic classes I have made.
- BankAccount: define every bank account with accountNumber, fullName, and balance. This class contains methods: getAcc(), getName(), getBalance().
- BankAccountAccess: get the bank account from MySQL database and update the balance of bank account in MySQL database. Both actions use a connector that was created in the DataBaseConnection class.
- DataBaseConnection: connect our Java activities to MySQL database.
- TransactionAccess: update the transaction history to MySQL database.
- Services: define all logics needed for digital payment, such as deposit, withdraw, and transfer.
- MainPayment: the main place for digital payment activity.

### 3. SQL
In MySQL database, we create the database and also the two tables, bank_accounts and transactions_record. The bank_accounts table contains each user's account number, name, and balance. Moreover, all the transaction records are available in the transactions_record table.

### 4. Result
After successfully running the MainPayment class, we’re gonna see the success notification from the console output.

<img width="735" height="240" alt="Image" src="https://github.com/user-attachments/assets/71167e95-b37d-49b4-acc9-d3797fce9f90" />

You can also see the database updated after running the Java by looking at both tables,  bank_accounts and transactions_record.


<img width="586" height="174" alt="Image" src="https://github.com/user-attachments/assets/4acbed62-9338-4bd3-a21d-0a709db83db1" />

<img width="279" height="189" alt="Image" src="https://github.com/user-attachments/assets/195e596b-db41-4ea1-9789-eb07017ae208" />

