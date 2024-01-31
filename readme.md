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