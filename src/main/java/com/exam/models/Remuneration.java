package com.exam.models;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public  class Remuneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    protected int salaire;
    int type;

    int calculeRem(int salaire, int type) {
        if(type==1){
            return salaire*200;
        }else{
            return salaire*300;
        }
    }
}
