
import java.util.ArrayList;
import java.util.Vector;

   class Grafo {
      Vector aristas  = new Vector();
      Vector vertices = new Vector();

      public void insertarArista(Arista e) {
         System.out.println("nueva arista entre "+ e.inicio.label
                            + " y " + e.fin.label);
         this.aristas.addElement(e);
         e.inicio.node.addElement(e);
         e.fin.node.addElement(e);
      }

      public void eliminarArista(Arista e) {
         this.aristas.removeElement(e);
         e.inicio.node.removeElement(e);
         e.fin.node.removeElement(e);
      }

      public void insertarVertice(Vertice v) {
         this.vertices.addElement(v);
      }

      static public void main(String args[]) {
         Grafo ejemplo = new Grafo();

         // los args de main son los vertices
          ArrayList<String> prueba = new ArrayList<>();
          prueba.add("hola");
          prueba.add("como");
          prueba.add("estas");
          prueba.add("tu");

         for (int i = 0; i < prueba.size(); i++) {
            Vertice v =  new Vertice();
            v.label = prueba.get(i);
            ejemplo.insertarVertice(v);
         }

         // hay una arista entre v1 y v2 si coinciden
         // en algún caracter
         
         
         
         for (int i = 0; i < prueba.size(); i++) {
            Vertice v1 = (Vertice)ejemplo.vertices.elementAt(i);
            for (int j = i+1; j < prueba.size(); j++) {
               Vertice v2 = (Vertice)ejemplo.vertices.elementAt(j);
               Arista e = new Arista(v1,v2);
               for (int k=0; k < prueba.get(i).length(); k++) {
                   char c = prueba.get(i).charAt(k);
                   if (prueba.get(j).indexOf(c) >= 0)
                     ejemplo.insertarArista(e);
               }
            }
         }

         ((Vertice)ejemplo.vertices.elementAt(0)).RecorridoProfundidad();
         ((Vertice)ejemplo.vertices.elementAt(0)).print("");
      }
   }