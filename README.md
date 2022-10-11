# Database Keys Group Presentation

**By**: Nishchal Mishra, Maneel Reddy, Yu Hsin Wang, Alex Bradshaw.

This repository contains our group presentation for our MSDS 610: Communication for Analytics course, where we are describing how database keys are used in the real world. 

## Objective
The objective of our presentation is to help our audience deeply understand database keys both on a theoretical and practical level. On a theretical level, we aim to have our audience understand when and why certain keys are or aren't used in databases. On a practical level, we aim to show our audience how these certain keys are implemented into real-world databases.

## Introduction
Our presentation begins by introducing a hypothetical situation where our friend Cody wants to sell his saxophones and wants our help setting up a database to keep everything organized. 

## Table Initialization
Given this scenario, we start by brainstorming tables that would help us capture every piece of information possible. 
Our example tables include: $\textit{Product, User, Orders, Cart Item, Order Items, Shopping Session}$. 
Each table includes a number of related attributes such as product-ID, quantity, price etc.

Tables and attributes can have one of three types of relationships: $$\text{1:1 | 1:Many | Many:Many}$$ 
Examples for such relationships are: $$\text{Username : User ID | Shopping Session ID : Cart Items | Supplier : Product}$$ respectively.  

## Key Definition $\text{(See Graphic Below)}$
With our tables created, we now look at what attributes for each table we can use as keys. 

### 1. Primary Keys 
REMINDER: Primary keys are columns with all unique and non-null values and are used to uniquely specify any certain row of data. These are typically attributes that have a 1:1 relationship with their respective table such as:
$$\text{Product : Product ID | User : User ID | Order : Order ID}$$

### 2. Foreign Keys
REMINDER: Foreign Keys are Primary Keys from other tables. These are typically used when a table is missing any attribute with a 1:1 relationship yet has a 1:1 relationship with another table and can therefore use its primary key such as:
$$\text{Order Items : Product ID | Shopping Session : User ID | Order Items : Order ID}$$

### 3. Composite Keys
REMINDER: Composite Keys are combinations of two or more columns in a table that work together to function as a primary key. These are typically used in tables that describe the relationships between Many:Many objects such as:
$$\text{Supplier ID + Product ID : Supplier-Products | User ID + Created-at : Shopping Session}$$

### 4. Unique Keys
REMINDER: Unique Keys are simply any column that contains all unique values such as:
$$\text{Product Name | Username | Supplier Name}$$

<img width="705" alt="Screen Shot 2022-10-10 at 4 56 43 PM" src="https://user-images.githubusercontent.com/69922736/194998817-84eb1a90-e183-4041-a4a2-2facc2fc6ecb.png">

NOTE: Some DBMS require columns to be completely unique (no multiple null values) while others only require non-null entries to be unique (can have multiple null values). 

## Complexities of Keys
Our database is complete for now, but let's say our friend Cody wants to expand his business beyond just saxophones. In order to maximize profits for multiple musical intruments, it would be helpful to track product features such as color, size, material, frequency etc. The issue comes from the fact musical instruments not only have unique musical features, they also have unique sound features, both of which may have their own attributes. 

This could lead to $\textbf{runtime issues}$ of trying to insert similar features across multiple tables OR querying across multiple tables to find specific results, $\textbf{key errors}$ since some primary keys may not be unique or non-null anymore, and $\textbf{storage overload}$ from the additional tables. 

## Solutions
In order to solve our problem of getting lost in the forest of attributes and tables, we can create and use a key-value database (such as a json file) as an attribute in a table. This would keep the integrity and importance of our keys, as well as encompass the complex varieties of musical instruments while keeping storage and runtime to a minimum. 

<img width="902" alt="Screen Shot 2022-10-10 at 9 45 12 PM" src="https://user-images.githubusercontent.com/69922736/194999274-58196415-1e81-449d-8a25-0225f2cc7e0e.png">


## Conclusion
Real world data is messy. Databases and keys are very important ways to keep data organized and easily accessible. Primary keys for quick access, foreign keys to keep data integrity and structure, composite keys to ensure uniqueness, and uniqueness for EDA. Like everything keys aren't perfect, but as we've demonstrated there are many ways to make adjustments and do what we need to do. 

