package bean;
// Generated 14/09/2023 13:29:20 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * KvmJogos generated by hbm2java
 */
@Entity
@Table(name="kvm_jogos"
    ,catalog="db_kelvin_morel"
)
public class KvmJogos  implements java.io.Serializable {


     private int idKvmJogos;
     private String kvmNome;
     private String kvmPlataforma;
     private String kvmTipoDeJogo;
     private String kvmClassificacaoIndicativa;
     private String kvmNumeroDeJogadores;
     private String kvmValor;
     private String kvmCodigoDoJogo;
     private Set kvmVendaJogos = new HashSet(0);

    public KvmJogos() {
    }

	
    public KvmJogos(int idKvmJogos) {
        this.idKvmJogos = idKvmJogos;
    }
    public KvmJogos(int idKvmJogos, String kvmNome, String kvmPlataforma, String kvmTipoDeJogo, String kvmClassificacaoIndicativa, String kvmNumeroDeJogadores, String kvmValor, String kvmCodigoDoJogo, Set kvmVendaJogos) {
       this.idKvmJogos = idKvmJogos;
       this.kvmNome = kvmNome;
       this.kvmPlataforma = kvmPlataforma;
       this.kvmTipoDeJogo = kvmTipoDeJogo;
       this.kvmClassificacaoIndicativa = kvmClassificacaoIndicativa;
       this.kvmNumeroDeJogadores = kvmNumeroDeJogadores;
       this.kvmValor = kvmValor;
       this.kvmCodigoDoJogo = kvmCodigoDoJogo;
       this.kvmVendaJogos = kvmVendaJogos;
    }
   
     @Id 

    
    @Column(name="id_kvm_jogos", unique=true, nullable=false)
    public int getIdKvmJogos() {
        return this.idKvmJogos;
    }
    
    public void setIdKvmJogos(int idKvmJogos) {
        this.idKvmJogos = idKvmJogos;
    }

    
    @Column(name="kvm_nome", length=45)
    public String getKvmNome() {
        return this.kvmNome;
    }
    
    public void setKvmNome(String kvmNome) {
        this.kvmNome = kvmNome;
    }

    
    @Column(name="kvm_plataforma", length=45)
    public String getKvmPlataforma() {
        return this.kvmPlataforma;
    }
    
    public void setKvmPlataforma(String kvmPlataforma) {
        this.kvmPlataforma = kvmPlataforma;
    }

    
    @Column(name="kvm_tipoDeJogo", length=45)
    public String getKvmTipoDeJogo() {
        return this.kvmTipoDeJogo;
    }
    
    public void setKvmTipoDeJogo(String kvmTipoDeJogo) {
        this.kvmTipoDeJogo = kvmTipoDeJogo;
    }

    
    @Column(name="kvm_classificacaoIndicativa", length=45)
    public String getKvmClassificacaoIndicativa() {
        return this.kvmClassificacaoIndicativa;
    }
    
    public void setKvmClassificacaoIndicativa(String kvmClassificacaoIndicativa) {
        this.kvmClassificacaoIndicativa = kvmClassificacaoIndicativa;
    }

    
    @Column(name="kvm_numeroDeJogadores", length=45)
    public String getKvmNumeroDeJogadores() {
        return this.kvmNumeroDeJogadores;
    }
    
    public void setKvmNumeroDeJogadores(String kvmNumeroDeJogadores) {
        this.kvmNumeroDeJogadores = kvmNumeroDeJogadores;
    }

    
    @Column(name="kvm_valor", length=45)
    public String getKvmValor() {
        return this.kvmValor;
    }
    
    public void setKvmValor(String kvmValor) {
        this.kvmValor = kvmValor;
    }

    
    @Column(name="kvm_codigoDoJogo", length=45)
    public String getKvmCodigoDoJogo() {
        return this.kvmCodigoDoJogo;
    }
    
    public void setKvmCodigoDoJogo(String kvmCodigoDoJogo) {
        this.kvmCodigoDoJogo = kvmCodigoDoJogo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="kvmJogos")
    public Set getKvmVendaJogos() {
        return this.kvmVendaJogos;
    }
    
    public void setKvmVendaJogos(Set kvmVendaJogos) {
        this.kvmVendaJogos = kvmVendaJogos;
    }




}


