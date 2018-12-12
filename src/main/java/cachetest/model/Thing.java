package cachetest.model;

import java.io.Serializable;

public class Thing implements Serializable {
    private static final long serialVersionUID = 1L;
    private String one;
    private int two;
    
    public String getOne() {
        return one;
    }
    public void setOne(String one) {
        this.one = one;
    }
    public int getTwo() {
        return two;
    }
    public void setTwo(int two) {
        this.two = two;
    }
}
