public class ListaEncadeadaCircular<T> implements ListaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public ListaEncadeadaCircular() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void adicionar(T info) {
        No<T> novoNo = new No<>(info);
        if (this.vazia()) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
            novoNo.setProximo(primeiro);
        } else {
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
            novoNo.setProximo(this.primeiro);
        }
        this.tamanho++;
    }

    public No<T> remover(T info) {
        if (this.vazia()) {
            return null;
        }
        No<T> atual = this.primeiro;
        No<T> anterior = null;
        do {
            if (atual.getInfo().equals(info)) {
                if (this.tamanho == 1) {
                    this.primeiro = null;
                    this.ultimo = null;
                } else if (atual == this.primeiro) {
                    this.primeiro = atual.getProximo();
                    this.ultimo.setProximo(this.primeiro);
                } else if (atual == this.ultimo) {
                    this.ultimo = anterior;
                    this.ultimo.setProximo(this.primeiro);
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                this.tamanho--;
                return atual;
            }
            anterior = atual;
            atual = atual.getProximo();
        } while (atual != this.primeiro);
        return null;
    }

    public void imprimir() {
        if (this.vazia()) {
            System.out.println("Lista vazia.");
            return;
        }
        No<T> atual = this.primeiro;
        do {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getProximo();
        } while (atual != this.primeiro);
        System.out.println();
    }
}
