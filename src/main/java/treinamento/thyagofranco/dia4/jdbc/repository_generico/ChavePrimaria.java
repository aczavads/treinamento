package treinamento.thyagofranco.dia4.jdbc.repository_generico;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Retention estará disponível em RUNTIME 
// Exemplo Override é uma anotação SOURCE, funciona apenas no código

@Retention(RetentionPolicy.RUNTIME) 
public @interface ChavePrimaria {

}
