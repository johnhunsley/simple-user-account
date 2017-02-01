# simple-user-account
A simple Account, User, Role model for Spring Security integration. Provides a generic repository interface which can be implemented with various popular data stores. I created this as an example project to demonstrate the concept of true loose coupling in an n-tier system. The project consists of 4 components:

1. Simple-User-Account - defines stereotypes for domain and service
2. Simple-User-Account-jpa - A Spring-Data-JPA implementation which defines concrete domain, service and repository types
3. Simple-User-Account-api - A Spring-MVC RESTful API which exposes CRUD operations of domain types via HTTP. 
4. Simple-User-Account-vue - A Vue.js UI which uses the API from asynchronous calls from the browser

Often n-tier systems are created with the intent of loose coupling between layers but still exhibit binding between the UI and concrete domain types. This effectivley binds the UI and all subsequent layers to the data model. In this project the UI and API have no dependency what so ever on the model as all domain types are defined as stereotypes. Simple user management is something which is often common to many projects and any implementation should be truely portable across different persistent stores. This application design allows us to port the API to whatever backend system we like so long as we implement the simple-user-account interfaces. We can implement the basic Account -> User -> Role concept with whatever we like - LDAP, Relational DB, NoSql, File, without the need to make any change to the UI or API.

Please feel free to use this project however wish.

[![Circle CI](https://circleci.com/gh/johnhunsley/simple-user-account.svg?style=svg)](https://circleci.com/gh/johnhunsley/simple-user-account)
[![Code Climate](https://codeclimate.com/github/johnhunsley/simple-user-account/badges/gpa.svg)](https://codeclimate.com/github/johnhunsley/simple-user-account)
[![Code Climate](https://codeclimate.com/github/johnhunsley/simple-user-account/badges/gpa.svg)](https://codeclimate.com/github/johnhunsley/simple-user-account)

Build is available on jitpack.io

    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
    </repositories>

    <dependency>
	    <groupId>com.github.johnhunsley</groupId>
	    <artifactId>simple-user-account</artifactId>
	    <version>1.0</version>
	</dependency>

[![](https://jitpack.io/v/johnhunsley/simple-user-account.svg)](https://jitpack.io/#johnhunsley/simple-user-account)
