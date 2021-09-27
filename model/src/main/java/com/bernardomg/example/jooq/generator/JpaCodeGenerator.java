
package com.bernardomg.example.jooq.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jooq.codegen.GenerationTool;

public class JpaCodeGenerator {

    public static void main(String[] args) throws IOException, Exception {
        GenerationTool.generate(Files.readString(Paths.get(
                ClassLoader.getSystemResource("jooq-config.xml").toURI())));
    }

}
