package org.inno.dao;

import org.inno.model.Project;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *
 * @author spindizzy
 */
public interface ProjectRepository extends GraphRepository<Project>{
    
}
