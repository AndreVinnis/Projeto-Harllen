package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities;

public class QueueCards {
    private Card[] fila;
    private int head;
    private int tail;
    
    public QueueCards(int quantCartas){
        fila = new Card[quantCartas];
        head = -1;
        tail = -1;
    }
    
    public void enqueue(Card card) {
        if(!isFull()){
            if(isEmpty()){
                head = 0;
            }
            tail++;
            if (tail == fila.length) {
                tail = 0;
            }
            fila[tail] = card; 
        }
    }

    public Card dequeue(){
        Card aux = null;
        if(!isEmpty()){
            aux = fila[head];
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head++;
                if (head == fila.length) {
                    head = 0;
                }
            }
        }
        return aux;
    }

    public Card head(){
        if(!isEmpty()){
            return fila[head];
        }
        return null;
    }

    public boolean isEmpty(){
        return head == -1;
    }

    public boolean isFull(){
        return (((head == 0) && (tail == fila.length - 1)) || (tail + 1 == head));
    }

    public int busca(Card carta){
        int aux = head;
        int cont = 0;
        if(!isEmpty()){
            while(aux != tail){
                cont ++;
                if(carta.equals(fila[aux])){
                    return cont;
                }
                else{
                    aux ++;
                    if(aux == fila.length){
                        aux = 0;
                    }
                }
            }
            if(carta.equals(fila[aux])){
                cont ++;
                return cont;
            }
        }
        return 0;
    }
    public Card[] rotacaoAtual(){
        Card[] rotacao = new Card[3];
        for(int i = 0; i < 3; i ++){
            rotacao[i] = dequeue();
        }
        return rotacao;
    }
    public Card[] rotacaoAtualClone(){
        Card[] rotacao = new Card[3];
        int aux = head;
        for(int i = 0; i < 3; i ++){
            rotacao[i] = fila[aux];
            aux ++;
            if(aux == fila.length){
                aux = 0;
            }
        }
        return rotacao;
    }
    public void voltaCartas(Card[] cartas){
        for(int i = 0; i < cartas.length; i ++){
            if(!(cartas[i] == null)){
                enqueue(cartas[i]);
            }
        }
    }
}
