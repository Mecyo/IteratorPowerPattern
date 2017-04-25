package patterniteratorpower;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson
 */
public class IteratorSuperPower {
    
    private Collection lista;
    private String atributo;
    private String verificador;
    private Object valor;
    private Object next;

    
    public IteratorSuperPower(Collection lista, String atributo, String verificador, Object valor) {
        this.lista = lista;
        this.atributo = converteAtributo(atributo);
        this.verificador = verificador;
        this.valor = valor;
    }
    
    public boolean hasNext() {
        if(this.lista != null) {
            for (Object object : this.lista) {
                if(verificaCondicao(object)) {
                    next = object;
                    return true;
                } 
            }
        }
        return false;
    }
    
    public Object next() {
        return this.next;
    }
    
    private boolean verificaCondicao(Object object) {
        switch(verificador) {
            case ">": object.break;
            case "<":break;
            case "==":break;
            case "!=":break;
            default: return false;
        }
    }
    
    private boolean executaBusca(Object object, String verificador) {
        
        Method method = null;
        try {
            method = object.getClass().getMethod(this.atributo);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(IteratorSuperPower.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(method != null) {
                switch(verificador) {
                    case ">": {
                        Object result = method.invoke(object);
                        if(this.valor < result)
                            return false;
                        else
                            return true;
                    } 
                    case "<":break;
                    case "==":break;
                    case "!=":break;
                    default: return false;
                }
                return method.invoke();
                
            }
        } catch (IllegalArgumentException e) {  }
          catch (IllegalAccessException e) {  }
          catch (InvocationTargetException e) {  }
            }
    
    private String converteAtributo(String atributo) {
        String inicial = "get" + atributo.substring(0, 0).toLowerCase();
        String fim = atributo.substring(1);
        
        return inicial + fim;
    }
    
}
