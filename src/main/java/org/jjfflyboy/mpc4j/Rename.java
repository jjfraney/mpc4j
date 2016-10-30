package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Rename extends Simple {
    public Rename(String name, String newName) {
        super(adapt(name), adapt(newName));
    }
}
