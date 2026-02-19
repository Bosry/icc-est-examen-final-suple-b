import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ProductoController{

  public TreeSet<Producto> ordenarProducto(List<Producto> lista){
    TreeSet<Producto> productos = new TreeSet<>();
    for (Producto p : lista) {
      productos.add(p);
    }
    return productos;
  }

  public Map<String, List<Producto>> clasificarPorUnicidad(Set<Producto> productos){
    Map<String, List<Producto>> mapa = new LinkedHashMap<>();
      mapa.put("A", new LinkedList());
      mapa.put("B", new LinkedList());
      mapa.put("C", new LinkedList());
      mapa.put("D", new LinkedList());
      mapa.put("E", new LinkedList());
    for (Producto p : productos) {
      int porcentaje = p.porcentajeCaracteresUnicos();
      String categorias;
      if(porcentaje >= 90){
        categorias = "A";
      } else if(porcentaje >= 70){
        categorias = "B";
      } else if (porcentaje >= 50){
        categorias = "C";
      } else if (porcentaje >= 30){
        categorias = "D";
      } else{
        categorias = "E";
      }
      mapa.get(categorias).add(p);
    }
    return mapa;
  }

  public List<Producto> obtenerDestacados(List<Producto> lista){
    List<Producto> destacados = new ArrayList<Producto>();
    for (Producto p : lista) {
      if(p.cantidadPreciosRepetidos() > 0){
        destacados.add(p);
      }
    }
    Collections.sort(destacados);
    return destacados;
  }

  public Producto buscarPorNombre(List<Producto> lista, String nombre){
    int inicio = 0;
    int fin = 0;
    while (inicio <= fin) {
      int medio = (inicio + fin) / 2;
      Producto actual = lista.get(medio);
      int comparacion = actual.getNombre().compareTo(nombre);
      if(comparacion == 0){
        return actual;
      } else if(comparacion < 0){
        inicio = medio + 1;
      } else {
        fin = medio -1;
      }
    }
    return lista.get(fin);
  }
}