package ieslavereda.es;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Pais españa = new Pais("España", 47000000);
        Pais portugal= new Pais("Portugal", 35000000);
        Pais francia = new Pais("Francia", 50000000);
        Pais alemania = new Pais("Alemania", 55000000);
        Pais marruecos = new Pais("Marruecos", 33000000);

        List<Pais> paises = List.of(españa, portugal, francia, alemania, marruecos);

        System.out.println(
                paises.stream().sorted().map(p-> p.getNombre()).collect(Collectors.joining(",", "Paises: ", "."))
        );

        System.out.println(
                paises.stream()
                        .sorted(Comparator.comparingInt(Pais::getPoblacion))
                        .map(p-> p.getNombre())
                        .collect(Collectors.joining(",", "Paises: ", "."))
        );

        System.out.println(paises.stream()
                .sorted(Pais.SORT_BY_POBLACION.reversed())
                .map(p-> p.getNombre())
                .collect(Collectors.joining(",", "Paises: ", "."))
        );

        System.out.println(paises.stream()
                .filter(Pais.SORT_BY_PAR)
                        .filter(p-> p.getNombre().charAt(0)!= 'A' &&
                                p.getNombre().charAt(0)!= 'E' &&
                                p.getNombre().charAt(0)!= 'I' &&
                                p.getNombre().charAt(0)!= 'O' &&
                                p.getNombre().charAt(0)!= 'U')
                .map(p-> p.getNombre())
                .collect(Collectors.joining(",", "Paises: ", "."))
        );

        Optional<Pais> optionalPais = paises.stream().filter(p-> p.getPoblacion()<50000000).findFirst();

        if (optionalPais.isPresent()){
            System.out.println("Pais: " + optionalPais.get());
        }
    }
}