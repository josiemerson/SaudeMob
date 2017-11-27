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



@Table(name = "GN_ESTADO")
@Entity
public class EstadoEntity {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "COD_UF")
        private Long codUf;

        @NotNull
        @Column(name = "UF")
        private String uf;

        @NotNull
        @Column(name = "DESCRICAO")
        private String descricao;

        public Long getCodUf() {
            return codUf;
        }
        public void setCodUf(Long codUf) {
            this.codUf = codUf;
        }
        public String getUf() {
            return uf;
        }
        public void setUf(String uf) {
            this.uf = uf;
        }
        public String getDescricao() {
            return descricao;
        }
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((codUf == null) ? 0 : codUf.hashCode());
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
            EstadoEntity other = (EstadoEntity) obj;
            if (codUf == null) {
                if (other.codUf != null)
                    return false;
            } else if (!codUf.equals(other.codUf))
                return false;
            return true;
        }
    }

