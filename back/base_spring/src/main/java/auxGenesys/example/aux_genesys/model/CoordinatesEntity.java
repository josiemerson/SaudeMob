package auxGenesys.example.aux_genesys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "GN_COORDINATES")
@Entity
public class CoordinatesEntity {
	@Id
	@Column(name = "ID_USER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ID_ATTENDANCE")
	@NotNull
	private Long idAttendance;

	@Column(name = "COORDINATES")
	@NotEmpty(message = "Selecione um cargo valido!")
	@NotNull
	private String coordinates;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAttendance() {
		return idAttendance;
	}

	public void setIdAttendance(Long idAttendance) {
		this.idAttendance = idAttendance;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CoordinatesEntity coordinates = (CoordinatesEntity) o;

		return id.equals(coordinates.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}