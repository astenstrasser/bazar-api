# API for [bazar app](https://bah-zar.herokuapp.com/)

## Setup

1. If you are running local DB, you can run mongo container locally with docker
   ```docker-compose up```
2. By default, the app is expecting the mongo container to be running on mongodb://localhost:27017. If you run on a
   different URI, please set MONGODB_URI as environment variable.
3. Run
   ````mvn spring-boot:run````