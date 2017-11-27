package auxGenesys.example.aux_genesys.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "GN_PAIS")
@Entity
public class PaisEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "COD_PAIS")
    private Long codPais;

    @NotNull
    @Column(name = "NOME_PAIS")
    private String nomePais;

    public Long getCodPais() {
        return codPais;
    }
    public void setCodPais(Long codPais) {
        this.codPais = codPais;
    }
    public String getNomePais() {
        return nomePais;
    }
    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codPais == null) ? 0 : codPais.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PaisEntity other = (PaisEntity) obj;
        if (codPais == null) {
            if (other.codPais != null)
                return false;
        } else if (!codPais.equals(other.codPais))
            return false;
        return true;
    }
}

