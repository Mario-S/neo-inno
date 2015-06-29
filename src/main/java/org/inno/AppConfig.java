package org.inno;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import org.springframework.data.neo4j.aspects.config.Neo4jAspectConfiguration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;


/**
 * @author spindizzy
 */
@Configuration
@Import(Neo4jAspectConfiguration.class)
@EnableTransactionManagement
@EnableNeo4jRepositories("org.inno.model")
@EnableSpringConfigured
public class AppConfig extends Neo4jConfiguration {
    @Bean
    public GraphDatabaseService graphDatabaseService() {
        // if you want to use Neo4j as a REST service
        // return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
        // Use Neo4j as Odin intended (as an embedded service)
        String path = System.getProperty("user.dir") + File.separator + "build";

        return new GraphDatabaseFactory().newEmbeddedDatabase(path);
    }
}
