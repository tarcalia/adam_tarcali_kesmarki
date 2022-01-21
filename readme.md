Kesmarki Person Handler Console Application.

How to Install: 

- clone from https://github.com/tarcalia/adam_tarcali_kesmarki
- under src/main/resources/application.properties, set your username and password and change url if necessary
- run application with spring-boot:run command

*Important:
spring.jpa.hibernate.ddl-auto has been set to create-drop, so if you don't want
to lose your database then change it which suit for you.

Also note, application will auto-generate tables.

How to use:

When first start application the "main menu" will welcome you, then you can select
menu options by typing number of each menu points. e.g.: for make query type 1 and 
hit enter.

All sub menus works same as above.

under src/main/resources/misc there is a data.sql, contains some queries which you can 
run to have some sample data.

Other information:

This program is not finished. e.g. unit tests missing
