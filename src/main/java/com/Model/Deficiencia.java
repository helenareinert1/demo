package com.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
    
    
    @Entity
    @Table(name = "deficiencia")
    public class Deficiencia {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
    
        @Column(name = "nome", nullable = false, length = 100)
        private String nome;

         @ManyToOne
         @JoinColumn(name = "categoria_id")
        private Categoria categoria;

         @ManyToMany(mappedBy = "deficiencias")
        private List<Pessoa> pessoas;
    
        
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    }
    

