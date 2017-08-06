server.port=7777

spring.datasource.url = jdbc:mysql://masteraaa-mig21bb.cpubtuxhdvny.us-east-1.rds.amazonaws.com:3306/housem8_schema
spring.datasource.username = housem8user
spring.datasource.password = housem8pass
 
# Keep the connection alive if idle for a long time (needed in production)
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1
 
# Show or not log for each sql query
spring.jpa.show-sql = true
 
# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = update
 
# Naming strategy
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
 
# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager)
 
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

# Hot swapping
spring.thymeleaf.cache = false