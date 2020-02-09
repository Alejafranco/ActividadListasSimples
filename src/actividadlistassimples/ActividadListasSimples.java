
package actividadlistassimples;

public class ActividadListasSimples {

    public static void main(String[] args) throws Exception {
        
       //Creo la lista de nodos
       OperacionesDeListas<Integer> lista = new OperacionesDeListas<>();
       //Creo la lista de nodos ordenados
       OperacionesDeListas<Integer> listaOrdenada = new OperacionesDeListas<>();
       //Add los datos a la lista
        lista.add(1);
        lista.add(3);
        lista.add(4);
        lista.add(8);
        lista.add(5);
        lista.add(2);
        
        // 1. Mostrar todos los datos de la lista.
        System.out.println("- Datos de la lista: "+lista.mostrarNodos());
        
        // 2. Mostrar la cantidad de datos.
        System.out.println("- Cantidad de datos de la lista: "+lista.getCont());
        
        // 3. Mostrar el dato mayor.
        System.out.println("- El dato MAYOR es: " + lista.datoMayor());
        
        // 4. Mostrar el dato menor.
        System.out.println("- EL dato MENOR es: "+lista.datoMenor());
        
        // 5. Mostrar el promedio de datos.
        System.out.println("- El promedio de datos es: "+lista.promedio());
        
        // 6. Determinar si un dato ingresado por el usuario existe en la lista.
        System.out.println("- Existe dato: "+lista.existeDato(8));
        
        // 7. Insertar nuevos nodos al final de la lista (si el dato ya se encuentra en la lista, no ingresarlo y lanzar excepción).
        lista.addLast(9);
        System.out.println("- Añadido de último: "+lista.mostrarNodos());
        
        // 8. Insertar nuevos nodos ordenados de mayor a menor e impedir datos duplicados (si el dato ya se encuentra en la lista, no ingresarlo y lanzar excepción)
        listaOrdenada.addOrdenado(1);
        listaOrdenada.addOrdenado(3);
        listaOrdenada.addOrdenado(4);
        listaOrdenada.addOrdenado(8);
        listaOrdenada.addOrdenado(5);
        listaOrdenada.addOrdenado(2);
        listaOrdenada.addOrdenado(9);
        System.out.println("- Nueva lista ordenada: "+listaOrdenada.mostrarNodos());
        
        // 9. Eliminar un nodo con un dato específico ingresado por el usuario.
        listaOrdenada.borrar(4);
        System.out.println("- Nodo borrado de lista ordenada: "+listaOrdenada.mostrarNodos());
        
        // 10. Insertar nuevos nodos después de un dato especificado por el usuario (si no se encuentra el dato, lanzar excepción).
        listaOrdenada.insertarDatoDespuesDe(9, 10);
        System.out.println("- Lista con nuevo nodo despues de un dato específico: "+listaOrdenada.mostrarNodos());
        
        // 11. Modificar el dato de un nodo especifico (solicitar el dato anterior).
        listaOrdenada.modificarDato(1, 11);
        System.out.println("- Lista con dato editado: "+listaOrdenada.mostrarNodos());
        
        // 12. Determinar si otra lista tiene el mismo tamaño.
        OperacionesDeListas<Integer> nuevaLista = new OperacionesDeListas<>();
        nuevaLista.add(10);
        nuevaLista.add(9);
        nuevaLista.add(8);
        nuevaLista.add(5);
        nuevaLista.add(3);
        nuevaLista.add(2);
        nuevaLista.add(11);

        //¿"nuevaLista" tiene el mismo tamaño que "listaOrdenada"?
        if(nuevaLista.contador() == listaOrdenada.contador()){
            System.out.println("- La <nuevaLista> tiene el mismo tamaño que <listaOrdenda>: "+true);
        }else{
            System.out.println("- La <nuevaLista> tiene el mismo tamaño que <listaOrdenda>: "+false);
        }
        
        // 13. Determinar si otra lista es igual.
            //¿"nuevaLista" tiene es igual que "listaOrdenada"?
        System.out.println("- Son iguales?: "+nuevaLista.comparar(nuevaLista, listaOrdenada));
        /*Para que sean iguales los números de la "nuevaLista" deben entrar en el siguiente orden:
            10-9-8-5-3-2-11
        */
    }  
}
