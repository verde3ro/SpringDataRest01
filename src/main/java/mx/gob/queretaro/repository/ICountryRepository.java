package mx.gob.queretaro.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import mx.gob.queretaro.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(name="Pais End Point", description="Realiza operaciones sobre la tabla Pais")
@RepositoryRestResource(collectionResourceRel = "pais", path = "pais")
public interface ICountryRepository extends JpaRepository<Country, Short> {
}
