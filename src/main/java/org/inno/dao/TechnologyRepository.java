package org.inno.dao;

import org.inno.model.Technology;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *
 * @author spindizzy
 */
public interface TechnologyRepository extends GraphRepository<Technology>{
    
}
