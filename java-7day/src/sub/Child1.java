package sub;

import basic.Parent1;

public class Child1 extends Parent1 {
    void someMethod() {
        a = 10000; //public
        b = 20000; //protected
        //c = 30000; //default
        //d = 40000; //priavate
    }
}
