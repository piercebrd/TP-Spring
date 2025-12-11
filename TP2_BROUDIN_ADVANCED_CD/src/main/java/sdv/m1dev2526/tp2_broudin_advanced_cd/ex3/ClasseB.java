package sdv.m1dev2526.tp2_broudin_advanced_cd.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClasseB {

    private ClasseA classeA;

    @Autowired
    public ClasseB(ClasseA classeA) {
        this.classeA = classeA;
    }
}
