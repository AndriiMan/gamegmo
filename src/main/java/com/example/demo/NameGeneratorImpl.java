package com.example.demo;

import java.util.Random;

public class NameGeneratorImpl implements NameGenerator {

    Random random = new Random();

    String[] namesArr = new String[]{
            "Andrii", "Vadym", "Kolya", "Alex",
            "Julia", "Michel", "Jaroslaw",
            "Michael", "Artur", "Etan",
            "Alexandera", "Oliver", "Daniel",
            "Lusia", "Ivan", "Petro",
            "Rembo", "Logan", "David", "Joseph",
            "Saimon", "Illia", "Oksana", "Sergii",
            "Tony", "Mykyta", "Volodymyr", "Julietta",
            "Lisa", "Anton"
    };
    String[] surnamesArr = new String[]{
            "Noah", "Liam", "Williams", "Mason",
            "Jam", "Benja", "Jaco",
            "Micha", "Elijah", "Ethan",
            "Alexan", "Olivert", "Daniep",
            "Lucar", "Matthef", "Aiden",
            "Jaki", "Logad", "Dalp", "Johm",
            "Samul", "Hery", "Owen", "Sebsan",
            "Gabriel", "Carter", "Jayden", "Jihn",
            "Loke", "Antiny"
    };

    @Override
    public String generateName() {
        return namesArr[random.nextInt(namesArr.length)].concat(" ").concat(surnamesArr[random.nextInt(surnamesArr.length)]);
    }
}
