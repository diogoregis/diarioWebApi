package br.com.diogoregis.diarioapiweb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tregistro")
@Data
public class Registro implements Serializable {

    @Serial
    private static final long serialVersionUID = -884835466224355957L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @Lob
    private String texto;

    @PrePersist
    protected void onCreate(){
        if(this.data == null){
            this.data = LocalDate.now();
        }
    }


}
