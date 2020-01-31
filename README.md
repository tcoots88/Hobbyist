# Hobbyist
### A project by Jerome, Peter, and Travis

##### Hobbyist is an application which allows the user to sign up for a subscription box service.  The user will be able to select from a list of hobbies/skills in which each box would be themed.  

##### Some examples of hobbies can be found at:
https://docs.google.com/document/d/1SSFvkg1nykHV6AsbwNrRrVHWKcIqb9XQm33SHm49jys/edit?usp=sharing

##### A visual of one such box:
Example: A new user sets up an account to receive a box every two weeks and is open to anything new...They might receive a box for Leather-working containing things like in this picture http://leatherworkforbeginners.com/wp-content/uploads/2018/04/how-to-start-leatherworking.png(689 kB)

###### Domain Modeling

![Image of Domain Modeling](DomainModeling.png)

###### Trello Board w/ User Stories
https://trello.com/c/3amkiffZ/2-user-stories

###### User Stories –

  - As a user I would like to be able to order a monthly box that will help me learn a new interesting skill, because this will make it easier with a busy schedule to learn something new.

  - As a user I would like to be able to learn new skills and hobbies while fitting into my strict budget.

  - As a user I would like to be able to search through different categories, because I would like to explore new things I normally may not do.

  - As a user I would like to view and share input on the different boxes, because it will help me and others decide on which are the best products.

  - As a user I would like to be able to order a second more advanced version of the box, because I would like the option to be able to continue to increase my skill level on that hobby.

  - As a user I would like to be able to select a category I like and save it to my profile.

  - As a user I would like to be able to delete categories I no longer want.

  - As a user I would like to be able to see if my location is within the range for shipping
  
 ``` 
## Database Schemas
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  email VARCHAR(9,6),
  frequency VARCHAR(255),
  preferences VARCHAR(255),
  FOREIGN KEY(reviews_id) REFERENCES users(id)
);

One-to-Many
Primary Key Reviews ID
reviews VARCHAR(255)
```

##### Link to Wireframe
https://balsamiq.cloud/shrn0hl/pd0wc07/r2278
