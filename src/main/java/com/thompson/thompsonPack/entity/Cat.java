package com.thompson.thompsonPack.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cats")
@Data
@AllArgsConstructor // без анотации надо удалить id или добавить в DTO id(БД сама генерит id)

@Builder //https://habr.com/ru/companies/otus/articles/552412/   иммутабельность+

public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;

    private int age;

    private int weight;

    public Cat(String name, int age, int weight) {

        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat() {
    }


}
