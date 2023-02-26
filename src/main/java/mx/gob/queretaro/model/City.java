package mx.gob.queretaro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the city database table.
 *
 */
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

	@Column(nullable=false, length=50)
	private String city;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	@Column(nullable=false, length=2)
	private String status;

	//bi-directional many-to-one association to Address
	@JsonIgnore
	@OneToMany(mappedBy="city")
	private List<Address> addresses;

	//bi-directional many-to-one association to Country
	// @JsonIgnoreProperties(value = {"cities", "hibernateLazyInitializer", "handler"}, allowSetters = true)
	@ManyToOne
	@JoinColumn(name="country_id", nullable=false)
	private Country country;

	public City(Short cityId, String city) {
		this.cityId = cityId;
		this.city = city;
	}

}


