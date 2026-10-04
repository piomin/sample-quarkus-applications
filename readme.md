# Guide to Quarkus Demo Project [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

[![CircleCI](https://circleci.com/gh/piomin/sample-quarkus-applications.svg?style=svg)](https://circleci.com/gh/piomin/sample-quarkus-applications)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/dashboard?id=piomin_sample-quarkus-applications)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-quarkus-applications&metric=bugs)](https://sonarcloud.io/dashboard?id=piomin_sample-quarkus-applications)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-quarkus-applications&metric=coverage)](https://sonarcloud.io/dashboard?id=piomin_sample-quarkus-applications)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-quarkus-applications&metric=ncloc)](https://sonarcloud.io/dashboard?id=piomin_sample-quarkus-applications)

In this project I'm demonstrating the most interesting features of [Quarkus](https://quarkus.io/) for building applications in Kotlin.

## Getting Started 
Here's a full list of available examples:
1. Using Quarkus for building REST application that connects to H2 database using Hibernate ORM. The example is available in the module [employee-service](https://github.com/piomin/sample-quarkus-applications/tree/master/employee-service). A detailed guide may be found in the following article: [Guide to Quarkus with Kotlin](https://piotrminkowski.com/2020/08/09/guide-to-quarkus-with-kotlin/)
2. Using Quarkus Kubernetes extensions to deploy application easily on Kubernetes. The example is available in the module [employee-service](https://github.com/piomin/sample-quarkus-applications/tree/master/employee-service). A detailed guide may be found in the following article: [Guide to Quarkus on Kubernetes](https://piotrminkowski.com/2020/08/10/guide-to-quarkus-on-kubernetes/)
3. Using Quarkus OAuth2 extension to provide RBAC authorization based on integration with Keycloak. The example is available in the module [employee-secure-service](https://github.com/piomin/sample-quarkus-applications/tree/master/employee-secure-service). A detailed guide may be found in the following article: [Quarkus OAuth2 and security with Keycloak](https://piotrminkowski.com/2020/09/16/quarkus-oauth2-and-security-with-keycloak/)
4. Using Quarkus with SmallRye Graph extension to GraphQL API and integration with a database with Panache. The example is available in the module [sample-app-graphql](https://github.com/piomin/sample-quarkus-applications/tree/master/sample-app-graphql). A detailed guide may be found in the following article: [An Advanced GraphQL with Quarkus](https://piotrminkowski.com/2021/04/14/advanced-graphql-with-quarkus/)
5. Using Quarkus Funqy HTTP and Azure Extensions to build and run serverless apps on Azure Functions. The example is available in the module [account-function](https://github.com/piomin/sample-quarkus-applications/tree/master/account-function). A detailed guide may be found in the following article: [Serverless on Azure Function with Quarkus](https://piotrminkowski.com/2024/01/19/serverless-on-azure-with-spring-cloud-function/)

## Repository Description

This repository is a collection of sample [Quarkus](https://quarkus.io/) applications showcasing a wide range of features and integrations available in the Quarkus ecosystem. It is organized as a Maven multi-module project, with each module demonstrating a distinct use case or technology integration.

### Modules

| Module | Description | Language |
|---|---|---|
| [`employee-service`](employee-service) | REST CRUD API backed by Hibernate ORM Panache, with Kubernetes deployment manifests, Micrometer metrics, and OpenAPI documentation | Kotlin |
| [`employee-secure-service`](employee-secure-service) | Role-based access control (RBAC) on a REST API using Quarkus OAuth2 and Keycloak | Kotlin |
| [`sample-app-graphql`](sample-app-graphql) | Advanced GraphQL API using SmallRye GraphQL with nested entity relationships, queries, mutations, and filtering | Java |
| [`account-function`](account-function) | Serverless account management functions built with Quarkus Funqy HTTP and deployed to Azure Functions | Java |
| [`person-service`](person-service) | REST service using Liquibase for database migrations and GraalVM native image support | Java |
| [`person-virtual-service`](person-virtual-service) | REST service demonstrating Java Virtual Threads (Project Loom) with the Vert.x reactive PostgreSQL client | Java |
| [`person-grpc-service`](person-grpc-service) | gRPC service built with Quarkus gRPC and Hibernate Reactive Panache using Mutiny for fully reactive, non-blocking I/O | Java |
| [`performance-tests`](performance-tests) | Gatling load tests (Scala) targeting the GraphQL endpoint | Scala |

### Key Technologies

- **Quarkus** — supersonic, subatomic Java framework
- **Kotlin & Java** — polyglot application development on the JVM
- **Hibernate ORM / Reactive Panache** — simplified persistence layer
- **SmallRye GraphQL** — MicroProfile-compliant GraphQL API support
- **Quarkus gRPC** — Protocol Buffers-based RPC communication
- **Quarkus Funqy + Azure Functions** — serverless deployment on Azure
- **Java Virtual Threads** — high-throughput concurrency via Project Loom
- **Keycloak / OAuth2** — secure, role-based API authorization
- **Liquibase** — database schema versioning and migrations
- **Kubernetes & OpenShift** — cloud-native deployment with generated manifests
- **Micrometer + Prometheus** — metrics collection and observability
- **Gatling** — performance and load testing

### Building the Project

To build all modules, run the following command from the repository root:

```bash
mvn clean install
```

To build a specific module:

```bash
mvn clean install -pl <module-name>
```

To compile and verify the build without running tests:

```bash
mvn clean compile
```