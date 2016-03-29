This project uses Spring, Struts2, Hibernate (in-memory), and jetty to facilitate story creation and reading service.

1. Prerequisites: 
Maven

2. Execution
a) after downloading the source code, you may test is with:
	mvn clean verify

b) run the service on your local machine with:
	mvn jetty:run
c) access with url:
	http://localhost:8080/stories/index.jsp

3. TODO:
- introduce acts inside stories
- add pictures and configurable graphics