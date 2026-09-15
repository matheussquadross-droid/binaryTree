
public class Arvore {
    private Node raiz;

    public Arvore() {
        this.raiz = null;
    }

    // -------------------------------------------------------------
    // 1. INSERÇÃO DE ELEMENTOS
    // -------------------------------------------------------------
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private Node inserirRecursivo(Node atual, int valor) {
        // Se a árvore/subárvore estiver vazia, cria um novo nó
        if (atual == null) {
            return new Node(valor);
        }

        // Se o valor for menor que o nó atual, insere na esquerda
        if (valor < atual.getInfo()) {
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(), valor));
        } 
        // Se for maior ou igual, insere na direita
        else {
            atual.setDireita(inserirRecursivo(atual.getDireita(), valor));
        }

        return atual;
    }

    // -------------------------------------------------------------
    // 2. BUSCA DE ELEMENTOS
    // -------------------------------------------------------------
    public Node buscar(int valor) {
        Node atual = raiz;

        // Percorre a árvore comparando o valor pretendido
        while (atual != null && atual.getInfo() != valor) {
            if (valor < atual.getInfo()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        // Retorna o nó encontrado ou null caso não seja localizado
        return atual; 
    }

    // -------------------------------------------------------------
    // 3. REMOÇÃO DE ELEMENTOS (Critério: Menor da Subárvore Direita)
    // -------------------------------------------------------------
    public boolean remover(int valor) {
        if (buscar(valor) == null) {
            System.out.println("Elemento " + valor + " não foi encontrado na árvore.");
            return false; // Elemento não encontrado
        }

        raiz = removerRecursivo(raiz, valor);
        System.out.println("Elemento " + valor + " removido com sucesso.");
        return true;
    }

    private Node removerRecursivo(Node atual, int valor) {
        if (atual == null) {
            return null;
        }

        // Navega até encontrar o elemento
        if (valor < atual.getInfo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        } else if (valor > atual.getInfo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        } else {
            // ELEMENTO ENCONTRADO! Tratamento dos casos de remoção:

            // Caso 1: Nó folha ou sem filho esquerdo
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } 
            // Caso 2: Sem filho direito
            else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            // Caso 3: Nó possui DOIS filhos
            // Critério: Substituir pelo menor elemento da subárvore direita
            Node menorDireita = encontrarMenorElemento(atual.getDireita());
            
            // Copia o valor do menor elemento da direita para o nó atual
            atual.setInfo(menorDireita.getInfo());

            // Remove o nó duplicado da subárvore direita
            atual.setDireita(removerRecursivo(atual.getDireita(), menorDireita.getInfo()));
        }

        return atual;
    }

    // Método auxiliar para obter o menor elemento (mais à esquerda) de uma subárvore
    private Node encontrarMenorElemento(Node raizSubarvore) {
        Node atual = raizSubarvore;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }
}