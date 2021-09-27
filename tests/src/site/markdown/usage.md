# Usage

The project is meant to be an example showcasing QueryDSL queries.

There are some tests included to verify that these work as expected, and can be run with the verify command:

```
mvn verify -P h2,hibernate
```

The tests require two profiles, one defining the database to be used, and another defining the provider.

Only the in-memory databases, such as H2, do not require additional configuration. Any other, such as MySQL, will require a running database service.

## Profiles

### Database profiles

| Profile  | Database   | Kind      |
|----------|------------|-----------|
| h2       | H2         | In-memory |
| hsqldb   | HSQLDB     | In-memory |
| mysql    | MySQL      | Service   |
| postgres | PostgreSQL | Service   |

### JPA provider profiles

| Profile     | Provider    |
|-------------|-------------|
| hibernate   | Hibernate   |

## Differences between databases

There are three kinds of databases used by the profiles:

* Service databases, which require a service running
* Embedded databases, which require a file storing the DB
* In-memory databases, which are loaded into volatile memory

The project comes prepared to use any of the databases for testing, and they are used, with help of Jenkins, on the CI tests.

## JDK

The project works on JDK 8.
