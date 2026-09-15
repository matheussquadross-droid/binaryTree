public class Node{
    private Node direita;
    private Node esquerda;
    private int info;

    public Node(int valor){
        this.info = valor;
        this.direita = null;
        this.esquerda = null;
    }

    public void setEsquerda(Node esquerda){this.esquerda = esquerda;}
    public Node getEsquerda(){return esquerda;}

    public void setDireita(Node direita){this.direita = direita;}
    public Node getDireita(){return direita;}

    public int getInfo(){return info;}
    public void setInfo(int info){this.info = info;}
}