## SuperAPI

SuperAPI is an example Gradle based API Server project for the Gaza Sky Geeks Continuous Delivery Workshop. 
With this workshop, you will build a basic HTTP based REST API and 
a continuous delivery pipeline that will deploy the API to a production 
server. We will also integrate the application with a monitoring service (New Relic).


###  Technologies


| Tool | Technology | Website |
| --- | --- | --- |
| Build Tool | Gradle | https://gradle.org/gradle-download/ |
| Language | Java 1.8 | http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| HTTP Framework | Dropwizard | www.dropwizard.io |
| Metrics Service | New Relic | www.newrelic.com |
| CI Servive | Snap CI | http://snap-ci.com |


### Schedule

The workshop will be divided into 3 sections

* Day 1 - Setting up Java API using Dropwizard/Spark 
	* Intro to Gradle & setup a simple Java project structure using Gradle
	* Implement a simple hello world API using either Dropwizard
	* Implement a simple test suite to be used for validation on CI

* Day 2 - Build a deployment pipeline
	- Introduction to Continuous Integration and Continuous delivery concepts 
	- Setup a build and deployment pipeline in SnapCI
	- Integrate example hello world server into the pipeline ready for deployment
	- Perform deploys directly from CI server into production with no manual intervention

* Day 3 - Monitoring your server 
	- Introduction into telemetry/monitoring and alerting concepts
	- Modify deployment to enable monitoring with New Relic

### Resources
* Continuous Delivery
    - http://martinfowler.com/delivery.html
    - https://continuousdelivery.com/
    - http://martinfowler.com/bliki/DeploymentPipeline.html

* Continuous Integration
    - http://www.martinfowler.com/articles/continuousIntegration.html

* Gradle
    - https://gradle.org/getting-started-gradle/
    
    



