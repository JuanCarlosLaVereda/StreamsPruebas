package ieslavereda.es;

import java.util.Comparator;
import java.util.function.Predicate;

public class Pais implements Comparable<Pais>{

    public static Comparator<Pais> SORT_BY_POBLACION = (p1,p2) -> p1.getPoblacion()- p2.getPoblacion();
    public static Predicate<Pais> SORT_BY_PAR = (p -> p.getPoblacion()>20000000);
    private String nombre;
    private Integer poblacion;

    public Pais(String nombre, Integer poblacion){
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }
    public Integer getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int hashCode(){
        return nombre.hashCode()+poblacion;
    }

    @Override
    public int compareTo(Pais pais){
        return nombre.compareTo(pais.getNombre());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Pais)){
            return false;
        }
        Pais pais = (Pais) obj;
        return nombre.equals(pais.getNombre());
    }


    @Override
    public String toString(){
        return "\nNombre del pais: " + nombre +
                "\nNº de poblacion: " + poblacion;
    }
}
