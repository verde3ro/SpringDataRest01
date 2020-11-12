package mx.gob.queretaro;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

	private final EntityManager entityManager;

	@Autowired
	public RestConfiguration(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override // Para configurar la salida del JSON de cada Rest
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		// Exponemos lod id en json
		config.exposeIdsFor(entityManager.getMetamodel().getEntities() // traeme la entities
				.stream() // las preparo para modificar
				.map(EntityType::getJavaType) // las modifico
				.collect(Collectors.toList()).toArray(new Class[0])); // regreso el resultado

	}
}
