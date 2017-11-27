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

@Table(name = "GN_AVALIACAO")
@Entity
public class AvaliacaoEntity{


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codAvaliacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CODMEDICO")
    private PerfilEntity medico = new PerfilEntity();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CODPACIENTE")
    private PerfilEntity paciente = new PerfilEntity();

    @NotEmpty
    @Column(name = "NOTA")
    private int nota;


    public Long getCodAvaliacao() {
        return codAvaliacao;
    }

    public void setCodAvaliacao(Long codAvaliacao) {
        this.codAvaliacao = codAvaliacao;
    }

    public PerfilEntity getMedico() {
        return medico;
    }

    public void setMedico(PerfilEntity medico) {
        this.medico = medico;
    }

    public PerfilEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PerfilEntity paciente) {
        this.paciente = paciente;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codAvaliacao == null) ? 0 : codAvaliacao.hashCode());
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
        AvaliacaoEntity other = (AvaliacaoEntity) obj;
        if (codAvaliacao == null) {
            if (other.codAvaliacao != null)
                return false;
        } else if (!codAvaliacao.equals(other.codAvaliacao))
            return false;
        return true;
    }
}
