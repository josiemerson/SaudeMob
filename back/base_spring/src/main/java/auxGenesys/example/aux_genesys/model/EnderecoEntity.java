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



@Table(name = "GN_ENDERECO")
@Entity
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "COD_ENDERECO")
    private Long codEndereco;

    @NotNull
    @Column(name = "DESCRICAO_ENDERECO")
    private String descrEnd;

    @NotNull
    @Column(name = "NRO_ENDERECO")
    private Long nroEndereco;

    public Long getCodEndereco() {
        return codEndereco;
    }
    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }
    public String getDescrEnd() {
        return descrEnd;
    }
    public void setDescrEnd(String descrEnd) {
        this.descrEnd = descrEnd;
    }
    public Long getNroEndereco() {
        return nroEndereco;
    }
    public void setNroEndereco(Long nroEndereco) {
        this.nroEndereco = nroEndereco;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codEndereco == null) ? 0 : codEndereco.hashCode());
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
        EnderecoEntity other = (EnderecoEntity) obj;
        if (codEndereco == null) {
            if (other.codEndereco != null)
                return false;
        } else if (!codEndereco.equals(other.codEndereco))
            return false;
        return true;
    }
}

