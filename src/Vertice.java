
import java.util.Vector;

class Vertice {
      String label;
      Object elem;
      Vector node = new Vector();

      public void RecorridoProfundidad() {
         // Si ya explorado volver
         if (this.elem == Boolean.TRUE) return;
         this.elem = Boolean.TRUE; // Marcar como explorado
         for (int i = 0; i < this.node.size(); i++) {
            Arista e = (Arista) this.node.elementAt(i);
               if (e.elem == null) {
                  Vertice w;                  // el otro extremo de e
                  if (e.inicio == this) w = e.fin;
                  else w = e.inicio;
                  if (w.elem == null) {      // w no explorado
                     e.elem = Boolean.TRUE;
                     w.RecorridoProfundidad(); // recursion
                  }
                  else e.elem = Boolean.FALSE;
               }
            }
         }

      public void print(String i) {
         System.out.println(i + "|_" + this.label);
         for (int j = 0; j < this.node.size(); j++) {
            Arista e = (Arista)this.node.elementAt(j);
            if (e.elem != Boolean.TRUE)
              continue;
              e.elem = null;
              if (e.inicio == this) e.fin.print(i + "| ");
              else e.inicio.print(i + "| ");
         }
      }
   }