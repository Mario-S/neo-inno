package org.inno.context;

import static com.google.common.collect.Sets.newHashSet;

import org.inno.converter.StatePropertyToStringConverterFactory;
import org.inno.converter.StringPropertyToStringConverterFactory;
import org.inno.converter.StringToStatePropertyConverterFactory;
import org.inno.converter.StringToStringPropertyConverterFactory;

import org.neo4j.graphdb.GraphDatabaseService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ConversionServiceFactoryBean;

import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;


/**
 * @author spindizzy
 */
@Configuration
@ComponentScan("org.inno")
@EnableTransactionManagement
@EnableNeo4jRepositories("org.inno.dao")
public class AppConfig extends Neo4jConfiguration {
    public AppConfig() {
        setBasePackage("org.inno.model");

        addConversionService();
    }

    private void addConversionService() {
        ConversionServiceFactoryBean conversionService = new ConversionServiceFactoryBean();
        conversionService.setConverters(newHashSet(new StringPropertyToStringConverterFactory(),
                new StringToStringPropertyConverterFactory(),
                new StatePropertyToStringConverterFactory(),
                new StringToStatePropertyConverterFactory()));
        conversionService.afterPropertiesSet();
        setConversionService(conversionService.getObject());
    }

    @Bean
    @Lazy
    public GraphDatabaseService graphDatabaseService() {
        String url = Settings.Instance.getRestUrl();

        // if you want to use Neo4j as a REST service
        // return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
        // Use Neo4j as Odin intended (as an embedded service)
        String path = System.getProperty("user.dir") + File.separator + "build";

        return new SpringCypherRestGraphDatabase(url);
    }
}
