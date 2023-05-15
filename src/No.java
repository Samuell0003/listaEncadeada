public class No<T> {
    private T info;
    private No<T> proximo;
    
    public No(T info) {
        this.info = info;
        this.proximo = null;
    }
    
    public T getInfo() {
        return this.info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
    
    public No<T> getProximo() {
        return this.proximo;
    }
    
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}