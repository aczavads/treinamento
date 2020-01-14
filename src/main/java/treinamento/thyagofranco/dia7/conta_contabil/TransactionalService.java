package treinamento.thyagofranco.dia7.conta_contabil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Transactional
@Service
public @interface TransactionalService {

}
