public class ListaEncadeadaSimples<T> implements ListaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    
    public ListaEncadeadaSimples() {
        this.primeiro = null;
        this.ultimo = null;
    }
    
    public void adicionar(T info) {
        No<T> novoNo = new No<T>(info);
        
        if (this.primeiro == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
        }
    }
    
    public No<T> remover(T info) {
        No<T> noAnterior = null;
        No<T> noAtual = this.primeiro;
        
        while (noAtual != null && !noAtual.getInfo().equals(info)) {
            noAnterior = noAtual;
            noAtual = noAtual.getProximo();
        }
        
        if (noAtual == null) {
            return null;
        }
        
        if (noAnterior == null) {
            this.primeiro = noAtual.getProximo();
        } else {
            noAnterior.setProximo(noAtual.getProximo());
        }
        
        if (noAtual == this.ultimo) {
            this.ultimo = noAnterior;
        }
        
        return noAtual;
    }
    
    public void imprimir() {
        No<T> noAtual = this.primeiro;
        
        while (noAtual != null) {
            System.out.print(noAtual.getInfo() + " ");
            noAtual = noAtual.getProximo();
        }
        
        System.out.println();
    }
}