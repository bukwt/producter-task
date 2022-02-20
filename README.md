# producter-task

SpringBoot application with maven as solution to the task given by Producter company team.Using MySQL database.

# Requirements to Run The Project

In order to establish a database connection you can add your password to the password field in the application.yml file at producter-task/src/main/resources/application.yml.

To create the database, the required table and dummy data (optionally) the SQL statements at data.txt (at producter-task/data.txt) file can be used.

# Example Usages

-Example Query 

Query for listing all basketball players' name and surnames in the system:

{allPlayer{
name
surname}}

-Example Mutations

Mutation for adding new player:

mutation{
addPlayer(name:"John",surname:"Doe",position:"C"){
name
surname}
}

Mutation for deleting a player in the system:

mutation{deletePlayer(id:1)}






