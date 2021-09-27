/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2021 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.jooq.test.integration.read;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.jdbc.Sql;

import com.bernardomg.example.jooq.model.generated.tables.ExampleEntities;
import com.bernardomg.example.jooq.test.config.annotation.PersistenceIntegrationTest;

@PersistenceIntegrationTest
@DisplayName("JPA queries")
public class ITPersistentExampleEntityRead {

    @Value("${jdbc.url}")
    private String     url;

    @Value("${jdbc.username}")
    private String     username;

    @Value("${jdbc.password}")
    private String     password;

    private DSLContext context;

    /**
     * Default constructor.
     */
    public ITPersistentExampleEntityRead() {
        super();
    }

    @BeforeEach
    public void loadDsl() {
        context = DSL.using(url, username, password);
    }

    @Test
    @DisplayName("Returns entities with an empty sample")
    @Sql("/sql/test_entity_single.sql")
    public final void testQuery_NoSample() {
        final Result<Record> entities;

        entities = context.select().from(ExampleEntities.EXAMPLE_ENTITIES)
                .fetch();

        Assertions.assertEquals(1, entities.size());
    }

}
