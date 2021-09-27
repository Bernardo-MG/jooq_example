# Metamodel

Querydsl requires a metamodel for the queries. This is generated with the processor plugin:

```
<plugin>
   <!-- Maven processor -->
   <!-- Processes Java annotations -->
   <groupId>org.bsc.maven</groupId>
   <artifactId>maven-processor-plugin</artifactId>
   <version>${plugin.processor.version}</version>
   <executions>
      <execution>
         <id>generate-jpa-metamodel</id>
         <goals>
            <goal>process</goal>
         </goals>
         <phase>generate-sources</phase>
         <configuration>
            <processors>
               <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
            </processors>
         </configuration>
      </execution>
   </executions>
   <dependencies>
      <dependency>
         <!-- Querydsl APT -->
         <groupId>com.querydsl</groupId>
         <artifactId>querydsl-apt</artifactId>
         <version>${querydsl.version}</version>
      </dependency>
   </dependencies>
</plugin>
```

The project will load the generated sources as part of the code. Thanks to the build helper plugin.
