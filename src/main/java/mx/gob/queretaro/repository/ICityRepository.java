package mx.gob.queretaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mx.gob.queretaro.model.City;

@RepositoryRestResource(collectionResourceRel = "ciudad", path = "ciudad")
public interface ICityRepository extends JpaRepository<City, Short> {

}
