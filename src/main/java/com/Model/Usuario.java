package com.Model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf", nullable = false, length = 14, unique = true)
    private String cpf;

    /*@ManyToOne
    @JoinColumn(name="nivel_accesso_id")
    private NivelAcesso nivelAcessoExemplo;*/

    @ManyToMany
    private List<NivelAcesso> nivelAcesso;

    @ManyToMany
    @JoinTable(name = "usuario_noticia",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "noticia_id"))
    private List<Noticia> noticias;

    @ManyToMany
    @JoinTable(name = "usuario_nivel_acesso",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "nivel_acesso_id"))
    private List<NivelAcesso> niveisAcesso;

    @Column(name = "ativo", nullable = true)
    @ColumnDefault("true")
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

   
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}



