# Team 5 - Project 1
## Contributors
Shray Pungaliya  
Bram Lim  
Kartik Mahajan   
Connor Buckley  
Alec Jenab  

## Building
- Enter the directory: `cd ~/workspace/Team05-Project1`
- Build with Maven: `mvn clean install`
- Copy the war file into Tomcat: `sudo cp target/Team05-Project1-0.0.1-SNAPSHOT.war /var/lib/tomcat8/webapps/ROOT.war`
- Go to `localhost:8080` to access (chromium-browser preferable)

## Testing

### Black Box Testing
- Enter the directory: `cd ~/workspace/Team05-Project1/cucumber-test`
- Run: `cucumber`

### White Box Testing
- Open Eclipse from the Desktop
- Ensure project located at: `~/workspace/Team05-Project1` is imported
- Navigate to `src/test/java` within the project
- Right click `BackendUnitTest.java`
	- `Coverage As -> JUnit Test` which shows code coverage for the entire project according to the unit tests and EclEmma
	- `Run as -> JUnit Test` which shows which JUnit test cases pass and which fail

