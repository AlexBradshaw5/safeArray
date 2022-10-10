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
Examples for such relationships are: $$\text{Username:User ID | Shopping Session ID:Cart Items | Supplier:Product}$$ respectively.  

## Key Definition
With our tables created, we now look at what attributes for each table we can use as keys. 

### 1. Primary Keys 
REMINDER: Primary keys are columns with all unique and non-null values and are used to uniquely specify any certain row of data. These are typically attributes that have a 1:1 relationship with their respective table such as:
$$\text{Product:Product ID | User:User ID | Order:Order ID}$$

### 2. Foreign Keys
REMINDER: Foreign Keys are Primary Keys from other tables. These are typically used when a table is missing any attribute with a 1:1 relationship yet has a 1:1 relationship with another table and can therefore use its primary key such as:
$$\text{Order Items:Product ID | Shopping Session:User ID | Order Items:Order ID}$$

### 3. Composite Keys
REMINDER: Composite Keys are combinations of two or more columns in a table that work together to function as a primary key. These are typically used in tables that describe the relationships between Many:Many objects such as:
$$\text{Supplier ID + Product ID:Supplier-Products | User ID + Created_at:Shopping Session}$$


### 4. Unique Keys
REMINDER: Unique Keys are simply any column that contains all unique values such as:
$$\text{}$$

NOTE: Some DBMS require columns to be completely unique (no multiple null values) while others only require non-null entries to be unique (can have multiple null values). 


## Conclusion
DataBase Keys are fundamental tool to create and manage a database management system, strong understanding and assignment of keys are detrimental to traverse the DBMS smoothly.

## 
## Technical Specifications

To use this notebook you need to run the following command:
```
git clone https://github.com/maneelusf/dbkeys_repo.git
```
You also need the following python libraries:
```
tabulate
sqllite3
