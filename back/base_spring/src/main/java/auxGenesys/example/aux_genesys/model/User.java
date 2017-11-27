package auxGenesys.example.aux_genesys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "GN_USER")
@Entity
public class User {
    @Id
    @Column(name = "LONGID_USER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VARCHARUSER_NAME")
    @NotEmpty(message = "Digite um nome valido!")
    @NotNull
    private String name;


    @Column(name = "VARCHARUSER_OFFICE")
    @NotEmpty(message = "Selecione um cargo valido!")
    @NotNull
    private String office;

    @Column(name = "DATEUSER_BIRTHDATE")
    @NotNull(message = "Descreva sua data de nascimento!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(unique = true, name = "VARCHARUSER_EMAIL")
    @NotEmpty(message = "Digite um email valido!")
    private String email;

    @Column(name = "VARCHARUSER_PASSWORD")
    @NotEmpty(message = "Digite uma senha valida!")
    private String password;

    @Column(name = "VARCHARUSER_ADDRESS")
    @NotEmpty(message = "Digite um endereço de atendimento!")
    @NotNull
    private String address;

    @Column(name = "VARCHARUSER_COORDINATES")
    @NotEmpty(message = "Erro ao preencher coordenadas!")
    @NotNull
    private String coordinates;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
