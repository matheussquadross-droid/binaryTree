public class Arvore {
    private Node raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void inserir(int valor){
        raiz = inserirRecursivo(raiz, valor);
    }

    private Node inserirRecursivo(Node atual, int valor){
        if(atual == null){
            return new Node(valor);
        }

        if(valor < atual.getInfo()){
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(), valor));
        } else {
            atual.setDireita(inserirRecursivo(atual.getDireita(), valor));
        }

        return atual;
    }

    public Node buscar(int valor){

        Node atual = raiz;

        while(atual != null && atual.getInfo() != valor){
            if(valor < atual.getInfo()){
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        return atual;

    }

    public boolean remover(int valor){

        if(buscar(valor) == null){
            return false;
        }

        raiz = removerRecursivo(raiz, valor);
        return true;
    }

    private Node removerRecursivo(Node atual, int valor){
        
        if (atual == null) {
            return null;
        }

        // 1. Navegação na Árvore
        if (valor < atual.getInfo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        } else if (valor > atual.getInfo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        } else {
            // 2. Nó encontrado! Trata os 3 casos de remoção:

            // Caso 1 e 2: Nó com apenas 1 filho ou nenhum
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) { // CORRIGIDO: Checa a direita
                return atual.getEsquerda();
            }

            // Caso 3: Nó com 2 filhos
            Node menorDireita = encontrarMenorElemento(atual.getDireita());
            atual.setInfo(menorDireita.getInfo());
            atual.setDireita(removerRecursivo(atual.getDireita(), menorDireita.getInfo()));
        }

        return atual;
    }

    private Node encontrarMenorElemento(Node raizSubArvore){
        Node atual = raizSubArvore;
        while(atual.getEsquerda() != null){
            atual = atual.getEsquerda();
        }
        return atual;
    }

    public void exibir(int valor){

        Node atual = raiz;

        while(atual != null && atual.getInfo() != valor){
            if(valor < atual.getInfo()){
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        if(atual == null){
            System.out.printf("Valor %d não encontrado%n", valor);
            return;
        }

        System.out.printf("Valor %d encontrado %n", atual.getInfo());

        if(atual.getDireita() != null){
            Node direita = atual.getDireita();
            System.out.printf("Valor à direita: %d%n", direita.getInfo());
 
        } else {
            System.out.println("Nenhum valor à direita");
        }

        if(atual.getEsquerda() != null){
            Node esquerda = atual.getEsquerda();
            System.out.printf("Valor à esquerda: %d%n", esquerda.getInfo());
        } else {
            System.out.println("Nenhum valor à esquerda");
        }

        
    }
}