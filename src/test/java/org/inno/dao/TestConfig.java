package org.inno.dao;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author spindizzy
 */
@Configuration
@ComponentScan(basePackages = {"org.inno.model", "org.inno.dao"})
@EnableTransactionManagement
@EnableNeo4jRepositories
public class TestConfig extends Neo4jConfiguration {

    public TestConfig() {
        setBasePackage("org.inno.model");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
                // if you want to use Neo4j as a REST service
        // return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
        // Use Neo4j as Odin intended (as an embedded service)
        String path = System.getProperty("user.dir") + File.separator + "build" + File.separator + "test";

        return new GraphDatabaseFactory().newEmbeddedDatabase(path);
    }
}
