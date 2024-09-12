# MongoDB Standalone to Replica Set Migration

This project is a really simple Springboot Example that implements a transactional on MongoDB.

However, the main goal of this project is to show how to migrate a standalone MongoDB to a Replica Set. And before you migrate the MongoDB into a Replica Set, you can't run the API because it will throw an exception.

To access the API on local you can just hit the Swagger UI at http://localhost:8080/swagger-ui/index.html

## How to run the project
- Run your mongodb, in this tutorial we used Ubuntu on WSL, you can see the detail on the [official documentation](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/)

- Then, create the dbUser & admin user (with clusterAdmin & readAnyDatabase role permission) for the database, you can see the detail on the [official documentation](https://www.mongodb.com/docs/manual/reference/method/db.createUser/)

- Then, follow the steps from this [official documentation](https://www.mongodb.com/docs/manual/tutorial/convert-standalone-to-replica-set/) (For converting a single standalone instance to a replica set, we only need follow the first 3 steps)


*additional information about why we need to implement ReplicaSet on mongodb for transactional can be found [here](https://www.mongodb.com/community/forums/t/why-replica-set-is-mandatory-for-transactions-in-mongodb/9533)*
