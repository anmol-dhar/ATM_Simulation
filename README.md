
# ATM Simulation Project

This Java Swing, AWT and MySQL-based ATM Simulation Project is designed to provide a realistic and interactive way of simulating the operations of an Automated Teller Machine (ATM). It allows users to experience ATM functionalities such as withdrawals, deposits, balance inquiries, PIN change, and mini statement generation and more in a user-friendly graphical interface.

## Features

- User-friendly Graphical User Interface (GUI) built with Java Swing and AWT.
- Secure user authentication with PIN verification.
- Real-time account balance display.
- Cash Withdrawal, Deposit, PIN change and Mini Statement functionalities.
- Transaction history for tracking previous transactions.
- Secure communication with MySQL database for data storage.

## Usage

- Sign up for the application to obtain your Card number and PIN.
- Run the application and log in with your Card number and PIN.
- Perform ATM operations, including balance inquiries, withdrawals, deposits, and PIN Change.
- View transaction history to track your recent transactions.


## Run Locally

- Download and Install JDK 21 and add the Environment Variables Path.

&ensp;&ensp;&ensp;&ensp;[Click Here](https://www.oracle.com/in/java/technologies/downloads/)

- Download JDBC Connector and JCalendar.

&ensp;&ensp;&ensp;&ensp;[Click Here](https://drive.google.com/drive/folders/1f8bX-xJnemvlPhoy7j2jQuFyKgqaWZGb?usp=sharing)


- Download and Install MySQL Workbench.

&ensp;&ensp;&ensp;&ensp;[Click Here](https://dev.mysql.com/downloads/)

- Clone the project.

```bash
  git clone https://github.com/anmol-dhar/ATM_Simulation.git
```

- Create a Database.

```bash
  create database bank_management_system;
```

- Select that Database.

```bash
  use bank_management_system;
```

- Create First Table for Signup 1 Details.

```bash
  create table signup(Form_No varchar(20), Name varchar(20), Father_Name varchar(20) , DOB varchar(20), Gender varchar(20), Email varchar(30), Marital_Status varchar(20), Address varchar(40), City varchar(25), State varchar(25), Country varchar(20), Pincode varchar(20));
```

- Create Second Table for Signup 2 Details.

```bash
  create table signupTwo(Form_No varchar(20), Religion varchar(20), Category varchar(20) , Annual_Income varchar(20), Education_Qualification varchar(20), Occupation varchar(20), Pan_Card varchar(20), Aadhaar_Card varchar(20), Senior_Citizen varchar(20), Existing_Account varchar(20));
```

- Create Thrid Table for Signup 3 Details.

```bash
create table signupThree(Form_No varchar(20), Account_Type varchar(20), Card_Number varchar(20) , Pin varchar(20), Services varchar(100));
```

- Create Fourth Table for Login Details.

```bash
create table login(Form_No varchar(20), Card_Number varchar(20), Pin varchar(20));
```

- Create Fifth Table for Transaction Related Details.

```bash
create table bank(Pin varchar(20), date varchar(50), type varchar(20), amount varchar(20));
```

- Change the username and password inside the `DatabaseConnection` class.

- Add JDBC Connector and JCalendar files in the Project. `Project Structure => Libraries`

- Compile and run the `Login.java` file to start the ATM simulator.


## Contributors

- [Anmol Dhar](https://github.com/anmol-dhar)


## License

This project is open-source and available under the [MIT](https://github.com/anmol-dhar/ATM_Simulation/blob/main/LICENSE) License.

Feel free to contribute and enhance the project or use it as a reference for your own ATM simulation system.

