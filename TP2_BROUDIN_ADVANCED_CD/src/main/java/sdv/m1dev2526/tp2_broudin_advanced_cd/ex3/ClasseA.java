package sdv.m1dev2526.tp2_broudin_advanced_cd.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ClasseA {

    private ClasseB classeB;

    @Autowired
    @Lazy
    public ClasseA(ClasseB classeB) {
        this.classeB = classeB;
    }
}
