package com.amazon.videogames.consols.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consols")
public class Consols {

    @Id
    @Column(name = "idConsols")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsols;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "platform", length = 50)
    private String platform;

    @Column(name = "stars", length = 10)
    private String stars;

    @Column(name = "money", length = 20)
    private String money;

    @Column(name = "productInf", length = 100)
    private String productInf;


    /**
     *  TODO: Example for test
     */
    public static Consols buildExample() {
        Consols consols = new Consols();

        consols.setIdConsols(3333);
        consols.setName("Nombre de la consola de videojugoes");
        consols.setPlatform("Empresa que pertenece");
        consols.setStars("4.5");
        consols.setMoney("$6,499");
        consols.setProductInf("Descripcion del producto");

        return consols;
    }

}
