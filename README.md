## SuperAPI

This is the full implementation of the GSG workshop. Below are the details 
to make use of the project

###  Setup

1. Set the `PROD_IP` property in `build.gradle` to the IP/Hostname of the server you will be deploying to
2. Java 1.8 required for development and on server
2. Remote server should have the new relic java agent and config file installed in `/opt/newrelic` 


###  Gradle commands

| Gradle Task | Description |
| --- | --- | 
| deployAPI | Deploys the shadow (fat) JAR to the specified IP | 
| shadowJar | Builds a deployable fat jar |
| runShadow | Runs the HTTP Server (fat jar) locally using the local config |
| run | Runs the HTTP Server (local build) locally using the local config |

| Deploy Property  | Description |
| --- | --- |
| `app_id` | A unique id that will be used for the tmux session when deploying |
| `identity` | Path to the private key file to use when establishing the ssh connection |


### Deployment process

1. Build shadowJar - `./gradlew shadowJar`
2. Start Deployment over ssh connection - `./gradlew deployAPI -Pidentity=$HOME/.ssh/id_rsa -Papp_id=CA34EA --info`
	2. Kill existing tmux session ignoring any errors
	3. Upload fat jar and prod config to deployment server - Upload root direction is `/opt/superapi`
	4. Start new tmux session and start java api
	5. Run some basic health checks 	
