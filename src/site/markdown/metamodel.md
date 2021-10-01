# Metamodel

jOOQ requires a metamodel for the queries. This is generated with the processor plugin:

```
<plugin>
   <!-- jOOQ Code Generator -->
   <groupId>org.jooq</groupId>
   <artifactId>jooq-codegen-maven</artifactId>
   <version>${jooq.version}</version>
   <executions>
      <execution>
         <id>generate-jpa</id>
         <goals>
            <goal>generate</goal>
         </goals>
      </execution>
   </executions>
   <configuration>
      <generator>
         <database>
            <name>org.jooq.meta.extensions.jpa.JPADatabase</name>
            <includes>.*</includes>
            <properties>
               <property>
                  <key>packages</key>
                  <value>com.bernardomg.example.jooq.model</value>
               </property>
            </properties>
         </database>
         <target>
            <packageName>com.bernardomg.example.jooq.model.generated</packageName>
            <directory>${project.build.directory}/generated-sources/jooq</directory>
         </target>
      </generator>
   </configuration>
   <dependencies>
      <dependency>
         <!-- jOOQ Meta Hibernate -->
         <groupId>org.jooq</groupId>
         <artifactId>jooq-meta-extensions-hibernate</artifactId>
         <version>${jooq.version}</version>
      </dependency>
      <dependency>
         <!-- JPA API -->
         <groupId>javax.persistence</groupId>
         <artifactId>javax.persistence-api</artifactId>
         <version>${javaee.api.version}</version>
      </dependency>
   </dependencies>
</plugin>
```

This is handled by the generator module.

The project will load the generated sources as part of the code. Thanks to the build helper plugin.
