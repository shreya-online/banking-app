1. **In this project, you don't need to manually configure the Hibernate dialect for your MySQL database because you are using Spring Boot 3.**

    Spring Boot 3 internally utilizes Hibernate 6. A key feature of Hibernate 6 is its ability to automatically detect and configure the appropriate dialect based on the JDBC driver dependency present in your project. Since the project includes the MySQL JDBC driver dependency, Hibernate 6 identifies the database type and sets the correct dialect automatically, removing the need for manual configuration.
2. **Add environmental variables "SECRET KEY"** 

   Click 3 dots beside Run in upper menu >> Edit >> Modify Options >> Check Environmental variables >> Click on Edit Environmental variables(Page icon) >> Add(+)