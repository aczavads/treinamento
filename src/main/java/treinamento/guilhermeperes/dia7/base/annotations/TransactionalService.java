package treinamento.guilhermeperes.dia7.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
@Transactional
public @interface TransactionalService {
}
