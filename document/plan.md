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

## 4. Tasks

-[ ] I'm user, I can use Charon's **performance schema component** to query my MySQL Database's performance schema to get 
the runtime state of MySQL.


-[ ] I'm user, I can use Charon's by load external configuration file in Disk.
  
-[ ] I'm user, If I don't specific a path of external configuration file, I want Charon will load `${CHARON_HOME}/conf/charon-conf.yml` file instead.

-[ ] I'm user, I want to start Charon by single shell script, such as `sh charon start`, and close charon by 'sh charon stop'.
    It's very easy to use, Right?.
 
-[ ] I'm user, I want to have a Web UI embedded in Charon so that I can simply view my MySQL Database state in Browser.
-[ ] I'm user, I want to have a monitor configuration item to config the monitor interval of Charon .
-[ ] I'm user, I want to have an Alerter Configuration item, with two sub configuration of Rule and Notify.
  -[ ] I'm user, I want to have a Rule sub-configuration item to define the alert threshold of Monitor Data. If Monitor 
        Data over the threshold, Charon can use notify component to let me know my database have something warning.
  -[ ] I'm user, I want to have a notify sub-configuration item to define the way to let to know Charon have something occur. Simply By Email.
