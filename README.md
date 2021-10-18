# spring-boot-microservices

Implemented fault tolerant and resilient three microservices which communicates with each other. 
1. Movie Info Service : Movie details (Name , description)
2. Movie user profile service : This microservice consumes data from other two microservices ahd gives combined result about Movies watched by user with given ratings.
3. Rating info service : User and Movie Ids wit ratings
-------------------------------------------------------------------------
Used Netflix Eureka for service discovery.
Circuit breaker pattern implemented using Netflix Hystrix to achieve fault tolerance.
