package design.factory.simple;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Wuling implements Car {
    @Override
    public void name() {
        System.out.println("五菱宏光");
    }
}
