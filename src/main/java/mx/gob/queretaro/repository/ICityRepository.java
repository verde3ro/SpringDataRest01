package mx.gob.queretaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.swagger.v3.oas.annotations.tags.Tag;
import mx.gob.queretaro.model.City;

@Tag(name="Ciudad End Point", description="Realiza operaciones sobre la tabla Ciudad")
@RepositoryRestResource(collectionResourceRel = "ciudad", path = "ciudad")
public interface ICityRepository extends JpaRepository<City, Short> {

	@RestResource(path = "porCiudad", rel = "porCiudad")
	City findByCity(@Param("city") String city);


	@RestResource(path = "porId", rel = "porId")
	@Query("SELECT NEW City(c.cityId, c.city) FROM City c WHERE c.cityId = :cityId")
	City obtenerPorId(@Param("cityId") Short cityId);

	// Para omitir la salida del end point Delete
	@Override
	@RestResource(exported = false)
	void delete(City t);
}
