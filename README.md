# TestingTask
## Technologies:
1. Java 8
2. Hibernate 5.x
3. Play Framework 2.5.x (scala-templating)
4. Database: PostgreSQL 9.x
5. Bootstrap, HTML, CSS, JavaScript/JQuery

## To run application:
1. Download ZIP
2. Unzip it.
3. Open the console in the project directory.
4. Enter without the quotes 'sbt' (download can take for several minutes)
5. When the loading is ends: enter 'compile' without quotes.
6. After successful compilation: enter 'run' without quotes.
7. If your settings of database are not default, change them in the file conf/application.conf on lines 337-340
8. Run the sql script (SCRIPT.SQL).
9. Then open in your browser 'localhost:9000'.

### Data base settings
  *default.driver = org.postgresql.Driver
  default.url = "jdbc:postgresql://localhost:5432/play"
  default.username = "postgres"
  default.password = "pass"
  
  You can change it in the file conf/application.conf on lines 337-340
