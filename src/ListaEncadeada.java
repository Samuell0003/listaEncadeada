public interface ListaEncadeada<T> {
    void adicionar(T info);
    No<T> remover(T info);
    void imprimir();
}