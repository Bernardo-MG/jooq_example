# Querydsl Example

An example showing how to set up Querydsl.

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

[![Release javadocs](https://img.shields.io/badge/javadocs-release-blue.svg)][javadoc-release]
[![Development javadocs](https://img.shields.io/badge/javadocs-develop-blue.svg)][javadoc-develop]

## Features

- Querydsl with JPA and Hibernate

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].
- The [the latest release Javadoc site][javadoc-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [the latest snapshot documentation page][site-develop].
- The [the latest snapshot Javadoc site][javadoc-develop].

The documentation site sources come along the source code (as it is a Maven site), so it is always possible to generate them using the following Maven command:

```
mvn verify site -P h2,hibernate
```

The verify phase is required, as otherwise some of the reports won't be created.

## Usage

The application is coded in Java, using Maven to manage the project.

### Profiles

Maven profiles are included for setting up the database and JPA provider.

| Profile  | Database                  |
|----------|---------------------------|
| h2       | H2 in-memory database     |
| hsqldb   | HSQLDB in-memory database |
| mysql    | MySQL database            |
| postgres | PostgreSQL database       |

| Profile     | Provider    |
|-------------|-------------|
| hibernate   | Hibernate   |

### Running the tests

The project requires a database and a JPA provider for being able to run the integration tests:

```
mvn verify -P h2,hibernate
```

### Missing JPA metadata

Currently there are some problems when generating the JPA metadata classes automatically. Mainly that they are not generated when trying to refresh the Maven project on Eclipse.

To fix this just package the project:

```
mvn package
```

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License

The project has been released under the [MIT License][license].

[issues]: https://github.com/bernardo-mg/querydsl-example/issues
[javadoc-develop]: http://docs.bernardomg.com/development/maven/querydsl-example/apidocs/
[javadoc-release]: http://docs.bernardomg.com/maven/querydsl-example/apidocs
[license]: http://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/bernardo-mg/querydsl-example
[site-develop]: http://docs.bernardomg.com/development/maven/querydsl-example
[site-release]: http://docs.bernardomg.com/maven/querydsl-example
