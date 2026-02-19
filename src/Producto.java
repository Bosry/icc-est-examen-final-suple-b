import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Producto {
  private String nombre;
  private String codigo;
  private double precio;
  private Array[] precios;
  
  public Producto(String nombre, String codigo, Array[] precios) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precios = precios;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public double getPrecios() {
    return precio;
  }
  public void setPrecios(double precios) {
    this.precio = precios;
  }

  public int porcentajeCaracteresUnicos(){
    String texto = nombre.replace(" ", "");
    Set<Character> unicos = new HashSet<>();
    for (int i = 0; i < texto.length(); i++) {
      unicos.add(texto.charAt(i));
    }
    int total = texto.length();
    int cantidadUnicos = unicos.size();
    if(total == 0){
      return 0;
    }
    return (cantidadUnicos * 100) / total;
  }

  public int cantidadPreciosRepetidos(){
    int repetidos = 0;
    for (int i = 0; i < precios.length - 1; i++) {
      for (int j = i + 1; j < precios.length; j++) {
        if(i == j){
          repetidos = repetidos + 1;
          break;
        }
      }
    }
    return repetidos;
  }
  @Override
  public String toString() {
    return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precios=" + Arrays.toString(precios) + "]";
  }
  @Override
  public boolean equals (Object obj){
    if(this == obj){
      return true;
    }
    if(obj instanceof Producto){
      return false;
    }
    Producto p = (Producto) obj;
    return this.codigo.equals(p.codigo);
  }

}
