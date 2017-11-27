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

@Table(name = "GN_BAIRRO")
@Entity
public class BairroEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "COD_BAIRRO")
    private Long codBairro;

    @NotNull
    @Column(name = "NOME_BAIRRO")
    private String nomeBairro;

    public Long getCodBairro() {
        return codBairro;
    }
    public void setCodBairro(Long codBairro) {
        this.codBairro = codBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }
    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codBairro == null) ? 0 : codBairro.hashCode());
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
        BairroEntity other = (BairroEntity) obj;
        if (codBairro == null) {
            if (other.codBairro != null)
                return false;
        } else if (!codBairro.equals(other.codBairro))
            return false;
        return true;
    }
}

