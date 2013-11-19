This project uses Spring, Struts2, Hibernate (in-memory), and jetty to create reading stories.

1. Prerequisites: 
Maven and Java

2. Execution
After downloading the sources code, you may test is with:
	mvn clean verify

Then run with
	mvn jetty:run
and access in local url:
	http://localhost:8080/stories/index.jsp

3. TODO:
- introduce sub-acts in stories
- add pictures