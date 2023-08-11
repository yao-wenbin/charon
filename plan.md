I will plan this project through the guidance of [a-guide-to-software-delivery-plan](https://testwithnishi.com/2023/08/10/a-guide-to-software-delivery-plan/).


## 1. Define What Charon can do?

Charon is a MySQL Operating Platform for DBA 、 SRE 、 SDE. 
1. they can use Charon to Monitoring Performance Schema (which
is a feature in MySQL to monitoring MySQL Server execution) through a web browser
2. change the configuration in MySQL
3. Server or backup they tables or schemas and restore them in the future.


## 2. Planing how to develop Charon

Charon will develop by Java and Spring Boot Framework , release as a jar with a or many
configuration file. 

In Configuration file, the user of Charon can configure the MySQL connection property and some basic property for Charon.

The Development Time of Charon will be set to three month.

## 3. Implement

The frontend of Charon will implement by Vue or Just Thymeleaf.

The backend of Charon will implement by Spring Boot 2.7.x or Spring Boot 3.x.

The Store of Charon will implement FileSystem or H2 (in-memory database) to minimize the external dependencies.

The ORM and Datasource of Charon for connection and make a query to database will implement by MyBatis-flex and Druid.

That's it. It's the basic concept and plan for Charon.

Hope it will make a welcome to every user of MySQL which has a problem to operating and monitoring.

