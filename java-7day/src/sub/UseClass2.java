package sub;

import basic.Parent1;

public class UseClass2 {
    Parent1 p2 = new Parent1();

    void method3() {
        p2.a = 1000; //public
        // p2.b = 2000; //protected
        // p2.c = 3000; //default
        // p2.d = 4000; // private
    }
}
