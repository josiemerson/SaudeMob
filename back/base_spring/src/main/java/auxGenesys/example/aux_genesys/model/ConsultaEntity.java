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

@Table(name = "GN_CONSULTA")
@Entity
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "COD_CONSULTA")
    private Long codConsulta;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date dhConsulta;

    @NotNull
    @Column(name = "VALOR_CONSULTA")
    private Long vlrConsulta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CODMEDICO")
    private PerfilEntity medico = new PerfilEntity();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CODPACIENTE")
    private PerfilEntity paciente = new PerfilEntity();

    //	,CONSTRAINT `FK_CODMEDICO_PERFIL` FOREIGN KEY ( `CODMEDICO`) REFERENCES `PERFIL` ( `CODPERFIL`)
//	,CONSTRAINT `FK_CODPACIENTE_PERFIL` FOREIGN KEY ( `CODPACIENTE`) REFERENCES `PERFIL` ( `CODPERFIL`)
    public Long getCodConsulta() {
        return codConsulta;
    }
    public void setCodConsulta(Long codConsulta) {
        this.codConsulta = codConsulta;
    }
    public Long getVlrConsulta() {
        return vlrConsulta;
    }
    public void setVlrConsulta(Long vlrConsulta) {
        this.vlrConsulta = vlrConsulta;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codConsulta == null) ? 0 : codConsulta.hashCode());
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
        ConsultaEntity other = (ConsultaEntity) obj;
        if (codConsulta == null) {
            if (other.codConsulta != null)
                return false;
        } else if (!codConsulta.equals(other.codConsulta))
            return false;
        return true;
    }
}

