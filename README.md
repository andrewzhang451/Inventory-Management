Application Summary:
- This application serves as an inventory management tool for a windows company.
It accepts new users as well as manages inventory quantity, which will dynamically update after each purchase/restock. 
This application also offers tracking for shipment that is included within customer account as well as providers and admin.
The user layout is intuitive without many clutters to reduce confusion and serves its purpose well for a small windows company.
I created different reusable domains where I can use it as template for when creating new objects such as new customer. I also created the user and group security layer
user and group to connect accounts to database relationship as well as user for authentication. 
The service layer also manages many to many relationships especially with the users list. The security layer also handles CRUD operation such as readALL() to fetch all groups.
There is also a UserPasswordHash within the security layer which automatically hashes user password during @PrePersist or @preUpdate lifecycle of events for User entity.
The Web layer will then act as the interface where users can interact, controllers will be the middle man between the business logic of the application and the user interactions. 

Design:
-I have made the design to be as intuitive and simple as possible since it is meant for the organization to use, not for the general public. Therefore, designs will be kept at a minimal amount.
Semantics were correctly used within this application to minimize confusion as well readability. The navigation can bring users from one page to another and can also go back. Also depending on the role of the user, certain
functionalities are not accessable. 

Requirements:
- To set this application up, you will pull source code from github, then open it up using apache netbean. The dependencies will be within the pom.xml file, which will streamline the process
- Go into terminal and type in "brew services start my@sql8.0 to initialize back-end database.
- Finally, run project
- The tools used within the project are Apache Netbean as IDE(Apache Netbeans IDE 22), Java Version: OpenJDK 23.0.1,
Jakarta EE Plugin: Java Web and EE (Version 1.49)
- Tools and Libraries: Jarkarta EE API (version 10.0.0), MySQL Connector (8.0.33), EclipseLink JPA (version 4.0.4), Hibernate validator (version 8.0.1.Final), GlassFish Expressly (version 5.0.0), JUnit Jupiter (version 5.10.2), Mavin Compiler Plugin (version 3.8.1), Maven WAR plugin (version 3.3.2)
- Framework : JavaServer Faces (JSF)
- Server: Payara Server 6.2024.8

Expected Results/Known Issues
- there is Issue with creating the javadoc. I can not seem to get it to appear within the folder. I have tried fixing it through terminal/maven, but no luck. there also seem to be some database issues with newly created customer accounts.
- some test accounts would be {[user:admin password:admin],[user:customer1, password:customer1]}

Development Insights:
-I have learned a lot from working on this application, especially building this
full-stack application with Jakarta Enterprise tools and using Java. This application has
given me the opportunity to obtain invaluable experiences which will help me as I progressively improve with each application I built.
This application truly served as the foundation for many of the future works i'll be doing in the future.

1). Proof of working authentication:
<img width="386" alt="image" src="https://github.com/user-attachments/assets/657189a4-3b9c-4435-8e13-19eb79a76e27">
<img width="877" alt="image" src="https://github.com/user-attachments/assets/a1d69199-3bc7-44d5-9f5b-9699e1d1cf1e">
<img width="1465" alt="image" src="https://github.com/user-attachments/assets/3255936e-2895-458a-909f-69f318d66246">

2). Test Case User and Password combinations:
<img width="583" alt="image" src="https://github.com/user-attachments/assets/85f3cc39-a722-407f-8bd9-59cbe82c5c2b">













