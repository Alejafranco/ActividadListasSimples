
package actividadlistassimples;

public class OperacionesDeListas<T extends Comparable> {
    
    //Creo la cabeza del nodo
    private Node<T> head;
    private int cont = 0;
    private int acum = 0;
    

    public OperacionesDeListas() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return this.head == null;
    }

    //Crear el nuevo nodo
    //El siguiente del nuevo nodo = cabeza
    //Actualizar cabeza = nuevo nodo
    //Contarlos en un cont
    //Sumar los datos en un acum
    public void add(T d) throws Exception {
       Node<T> newNode = new Node<>(d);
       newNode.setNextNode(this.head);
       this.head = newNode;
       cont++;
       acum += d.hashCode();
    }
    
    //Mostrar los datos del nodo
    public String mostrarNodos() {
        String datos = "";
        Node<T> current = this.head;
        while (current != null) {
            datos = datos + current.getData() + " ";
            current = current.getNextNode();
        }
        return datos;
    }
    
    //@return the cont
    public int getCont() {
        return cont;
    }
    
    //@return the acum
    public int getAcum() {
        return acum;
    }
    
    //Mostrar del dato mayor
    public int datoMayor() throws Exception {
        if(isEmpty()){
            throw new Exception ("LA LISTA ESTÁ VACÍA");
        }else{
            T mayor = this.head.getData();
            Node<T> current = this.head;
            while(current != null){
                if (mayor.compareTo(current.getData()) == -1) {
                    mayor = current.getData();
                }
                current = current.getNextNode();
            }
            return mayor.hashCode();
        }    
    }
    
    //Mostrar el dato menor
    public int datoMenor() throws Exception {
        if(isEmpty()){
            throw new Exception ("LA LISTA ESTÁ VACÍA");
        }else{
            T menor = this.head.getData();
            Node<T> current = this.head;
            while(current != null){
                if (menor.compareTo(current.getData()) == 1) {
                    menor = current.getData();
                }
                current = current.getNextNode();
            }
            return menor.hashCode();
        }    
    }
    
    //Muestra el promedio de datos.
    public double promedio() throws Exception{
        double prom = 0;
        if(isEmpty()){
            throw new Exception ("La lista está vacía");
        }else{
           prom = getAcum() / getCont();
        }
        return prom;
    }
    //Buscar si existe el dato del nodo
    public boolean existeDato(T dato) throws Exception{
        if(isEmpty()){
            throw new Exception ("LA LISTA ESTÁ VACÍA");
        }else{
            Node<T> current = this.head;
            while(current != null){
               if (dato.compareTo(current.getData()) == 0){
                   return true;
               }
               current = current.getNextNode();
            }
            return false;
        }
    }
    //Add un dato de último
    public void addLast(T d) throws Exception{
        if (isEmpty()){
            add(d);
        }else if(existeDato(d)){
            throw new Exception ("EL DATO YA EXISTE!!");
        }else{
            Node<T> newNode = new Node<>(d);
            Node<T> current = this.head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }
    //Add los datos de mayor a menor
    public void addOrdenado(T d) throws Exception{
        Node<T> newNode = new Node<>(d);
        if (isEmpty() || d.compareTo(this.head.getData()) == -1) {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }else if (existeDato(d)){
            throw new Exception ("EL DATO YA EXISTE!!");
        }else{        
            Node<T> current = this.head;
            while (current.getNextNode() != null && d.compareTo(current.getNextNode().getData()) == 1) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
    }
    //Borra un tado ingresado por el usuario
    public void borrar(T d) throws Exception {
        if (isEmpty()) {
            throw new Exception("NO EXISTEN DATOS POR BORRAR");
        } else if(!existeDato(d)){
            throw new Exception("EL DATO QUE DESEA BORRAR NO EXISTE!");
        }else{
            Node<T> current = this.head;
            if(current.getData() == d){
                this.head = head.getNextNode();
            }else{
                while(current.getNextNode() != null){
                    if(current.getNextNode().getData() == d){
                        current.setNextNode(current.getNextNode().getNextNode());
                    }
                    current = current.getNextNode();
                }
            }
        }
    }
    
    public void insertarDatoDespuesDe(T d, T nuevoNodo) throws Exception{
        if(isEmpty()){
            throw new Exception ("LA LISTA ESTÁ VACÍA");
        }else if(!existeDato(d)){
            throw new Exception("EL DATO QUE INGRESÓ NO EXISTE");
        }else if(existeDato(nuevoNodo)){
            throw new Exception("EL NUEVO DATO QUE DESEA INGRESAR YA EXISTE");
        }else{
            Node<T> current = this.head;
            Node<T> newNode = new Node<>(nuevoNodo);
            if(current.getData() == d){
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
            }else{
                while(current.getNextNode()!= null){
                    if (current.getNextNode().getData() == d){
                        newNode.setNextNode(current.getNextNode().getNextNode());
                        current.getNextNode().setNextNode(newNode);
                    }
                    current = current.getNextNode();
                }
            }
        }
    }
    
    public void modificarDato(T anterior, T nuevo) throws Exception{
         if(isEmpty()){
            throw new Exception ("LA LISTA ESTÁ VACÍA");
        }else if(!existeDato(anterior)){
            throw new Exception("EL DATO ANTERIOR NO EXISTE");
        }else if(existeDato(nuevo)){
            throw new Exception("EL NUEVO DATO QUE DESEA INGRESAR YA EXISTE");
        }else{
            Node<T> current = this.head;
            if(current.getData() == anterior){
                current.setData(nuevo);
            }else{
                while(current.getNextNode()!= null){
                    if(current.getNextNode().getData() == anterior){
                        current.getNextNode().setData(nuevo);
                    }
                    current = current.getNextNode();
                }
            }
        }
    }
    //Cuenta el número de nodos de una lista
    public int contador(){
        int contador = 0;
        Node<T> current = this.head;
        while(current != null){
            contador++;
            current = current.getNextNode();
        } 
        return contador;
    }
    public boolean esIgual(){
        int contador = 0;
        T d = this.head.getData();
        Node<T> current = this.head;
        while(current != null){
            if (d.compareTo(current.getData()) == 0) {
                d = current.getData();
            }else{
                contador++;
            }
            current = current.getNextNode();
        }
        return contador <= 0;
    }
    
    public boolean comparar(OperacionesDeListas list1, OperacionesDeListas list2) throws Exception{
        int contador = 0;
        int size1 = list1.contador();
        int size2 = list2.contador();
        if(size1 != size2){
            throw new Exception ("LAS LISTAS NO TIENEN EL MISMO TAMAÑO");
        }else{
            Node<T> current1 = this.head;
            Node<T> current2 = list2.head;
            while(current1 != null && current2 != null){
                if (current1.getData() == current2.getData()) {
                contador++;
            }
            current1 = current1.getNextNode();
            current2 = current2.getNextNode();
            }
            return contador == size2;
        }
    }
}