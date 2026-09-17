//Arvore binaria

public class Main{
    public static void main(String[] args){
        
        Arvore arvore = new Arvore();
        arvore.inserir(32);
        arvore.inserir(48);
        arvore.inserir(8);
        arvore.inserir(16);
        arvore.inserir(2);

        arvore.remover(32);
        arvore.remover(48);



   
        arvore.exibir(8);

    



    }
}