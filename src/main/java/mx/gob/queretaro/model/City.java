package mx.gob.queretaro.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id", unique=true, nullable=false)
	private Short cityId;

	@NotNull(message ="El nombre dela ciudad no deber ser nulo")
	@NotEmpty(message ="El nombre del ciudad no deber ser vacío")
	@Column(nullable=false, length=50)
	private String city;

	@NotNull(message ="El id del país no deber ser nulo")
	@Column(name="country_id", nullable=false)
	private short countryId;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	@Column(nullable=false, length=2)
	private String status;

	public City (Short cityId, String city) {
		this.cityId = cityId;
		this.city = city;
	}

}