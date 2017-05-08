package patterniteratorpower;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson
 */
public class IteratorSuperPower {
    
    private List lista;
    private String atributo;
    private String verificador;
    private Integer valor;
    private Integer next;
    private Method method;

    
    public IteratorSuperPower(List lista, String atributo, String verificador, Integer valor) {
        this.lista = lista;
        this.atributo = converteAtributo(atributo);
        this.verificador = verificador;
        this.valor = valor;
        this.next = 0;
        this.method = retornaMetodo();
    }
    
    private Method retornaMetodo() {
        Method met = null;
        try {
            met = this.lista.get(0).getClass().getMethod(this.atributo);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(IteratorSuperPower.class.getName()).log(Level.SEVERE, null, ex);
        }
        return met;
    }
    
    public boolean hasNext() {
        if(this.lista != null) 
            return executaBusca();
        
        return false;
    }
    
    public Object next() {
        return this.lista.get(next++);
    }
    
    private boolean executaBusca() {
        
            for (int i = next; i < this.lista.size(); i++) {
                Object object = this.lista.get(i);

                try {
                    if(method != null) {
                        if(this.verificador.equals(">")) {
                            Integer result = (Integer) this.method.invoke(object);
                            if(result > this.valor) {
                                next = i;
                                return true;
                            }
                        } 
                        if(this.verificador.equals("<")) {
                            Integer result = (Integer) this.method.invoke(object);
                            if(result < this.valor) {
                                next = i;
                                return true;
                            }
                        }
                        if(this.verificador.equals("==")) {
                            Integer result = (Integer) this.method.invoke(object);
                            if(result == this.valor) {
                                next = i;
                                return true;
                            }
                        }
                        if(this.verificador.equals("!=")) {
                            Integer result = (Integer) this.method.invoke(object);
                            if(result != this.valor) {
                                next = i;
                                return true;
                            }
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {  }
            }
        
        return false;
    }
    
    private String converteAtributo(String atributo) {
        String inicial = "get" + atributo.substring(0, 1).toUpperCase();
        String fim = atributo.substring(1);
        
        return inicial + fim;
    }
    
}
