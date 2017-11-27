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

@Table(name = "GN_CIDADE")
@Entity
public class CidadeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "COD_CIDADE")
    private Long codCidade;

    @NotNull
    @Column(name = "NOME_CIDADE")
    private String nomeCidade;

    public Long getCodCidade() {
        return codCidade;
    }
    public void setCodCidade(Long codCidade) {
        this.codCidade = codCidade;
    }
    public String getNomeCidade() {
        return nomeCidade;
    }
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codCidade == null) ? 0 : codCidade.hashCode());
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
        CidadeEntity other = (CidadeEntity) obj;
        if (codCidade == null) {
            if (other.codCidade != null)
                return false;
        } else if (!codCidade.equals(other.codCidade))
            return false;
        return true;
    }
}

