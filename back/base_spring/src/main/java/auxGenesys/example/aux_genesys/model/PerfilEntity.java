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
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "COD_PERFIL")
    private Long codPerfil;

    @NotNull
    @Column(name = "TIPO_PERFIL")
    private char tipoPerfil;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Column(name = "SOBRENOME")
    private String sobrenome;

    @NotNull
    @Column(name = "CGC_CPF")
    private String cgcCpf;

    @NotNull
    @Column(name = "COD_ESPECIALISTA")
    private String codEspecialista;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="CODENDERECO", value=ConstraintMode.CONSTRAINT))
    private EnderecoEntity endereco = new EnderecoEntity();

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="CODUSU", value=ConstraintMode.CONSTRAINT))
    private User usuario = new User();

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="CODUF", value=ConstraintMode.CONSTRAINT))
    private EstadoEntity estado = new EstadoEntity();

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="CODBAIRRO", value=ConstraintMode.CONSTRAINT))
    private BairroEntity bairro = new BairroEntity();

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="CODCIDADE", value=ConstraintMode.CONSTRAINT))
    private CidadeEntity cidade = new CidadeEntity();

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey=@ForeignKey(name="CODPAIS", value=ConstraintMode.CONSTRAINT))
    private PaisEntity pais = new PaisEntity();

    public Long getCodPerfil() {
        return codPerfil;
    }
    public void setCodPerfil(Long codPerfil) {
        this.codPerfil = codPerfil;
    }
    public char getTipoPerfil() {
        return tipoPerfil;
    }
    public void setTipoPerfil(char tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getCgcCpf() {
        return cgcCpf;
    }
    public void setCgcCpf(String cgcCpf) {
        this.cgcCpf = cgcCpf;
    }
    public String getCodEspecialista() {
        return codEspecialista;
    }
    public void setCodEspecialista(String codEspecialista) {
        this.codEspecialista = codEspecialista;
    }
    public EnderecoEntity getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
    public User getUsuario() {
        return usuario;
    }
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
    public EstadoEntity getEstado() {
        return estado;
    }
    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }
    public BairroEntity getBairro() {
        return bairro;
    }
    public void setBairro(BairroEntity bairro) {
        this.bairro = bairro;
    }
    public CidadeEntity getCidade() {
        return cidade;
    }
    public void setCidade(CidadeEntity cidade) {
        this.cidade = cidade;
    }
    public PaisEntity getPais() {
        return pais;
    }
    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codPerfil == null) ? 0 : codPerfil.hashCode());
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
        PerfilEntity other = (PerfilEntity) obj;
        if (codPerfil == null) {
            if (other.codPerfil != null)
                return false;
        } else if (!codPerfil.equals(other.codPerfil))
            return false;
        return true;
    }

//	,CONSTRAINT `FK_CODUSU_USUARIO` FOREIGN KEY ( `CODUSU`) REFERENCES `USUARIO` ( `CODUSU`)
//	,CONSTRAINT `FK_CODENDERECO_ENDERECO` FOREIGN KEY ( `CODENDERECO`) REFERENCES `ENDERECO` ( `CODENDERECO`)
//	,CONSTRAINT `FK_CODUF_ESTADO` FOREIGN KEY ( `CODUF`) REFERENCES `ESTADO` ( `CODUF`)
//	,CONSTRAINT `FK_CODBAIRRO_BAIRRO` FOREIGN KEY ( `CODBAIRRO`) REFERENCES `BAIRRO` ( `CODBAIRRO`)
//	,CONSTRAINT `FK_CODCIDADE_CIDADE` FOREIGN KEY ( `CODCIDADE`) REFERENCES `CIDADE` ( `CODCIDADE`)
//	,CONSTRAINT `FK_CODPAIS_PAIS` FOREIGN KEY ( `CODPAIS`) REFERENCES `PAIS` ( `CODPAIS`)
}

