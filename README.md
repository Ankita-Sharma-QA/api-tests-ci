# api-tests-ci

API test automation with Java 17, Maven, TestNG and RestAssured, written to practise CI/CD.

Tests run against https://jsonplaceholder.typicode.com (a free fake REST API).

## Run locally

    mvn clean test

Run against a different environment:

    mvn clean test -DbaseUrl=https://your-api.example.com

Reports are generated in `target/surefire-reports/`.
