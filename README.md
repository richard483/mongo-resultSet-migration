# MongoDB Standalone to Replica Set Migration

This project is a really simple Springboot Example that implements a transactional on MongoDB.

However, the main goal of this project is to show how to migrate a standalone MongoDB to a Replica Set. And before you migrate the MongoDB into a Replica Set, you can't run the API because it will throw an exception.

To access the API you can just hit the Swagger UI at http://localhost:8080/swagger-ui/index.html

## How to run the project

Run the docker compose file to start the MongoDB.

```shell
docker-compose up
```

After that, you can run the Springboot application.

## How to migrate the MongoDB to a Replica Set

### Connect to Docker container:

List the running containers:
```shell
docker ps
```

Connect to the MongoDB container:
```shell
docker exec -it <container_id> bash
```

### Connect to MongoDB:

```shell
mongo
```

### Use the admin database:

```shell
use admin
```

### Shutdown the MongoDB:

```shell
db.shutdownServer()
```