package treinamento.thyagofranco.dia4.jdbc.repository_generico;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Retention estar� dispon�vel em RUNTIME 
// Exemplo Override � uma anota��o SOURCE, funciona apenas no c�digo

@Retention(RetentionPolicy.RUNTIME) 
public @interface ChavePrimaria {

}
