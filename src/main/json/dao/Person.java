package main.json.dao;

/**
 * Created by Tomecs on 2017/10/11.
 */
public class Person {
    private int id;
    private String name;
    private boolean status;

    /**
     * 这里需要一个空构造，由Spring转换对象时，进行初始化。
      */
    public Person() {
    }

    public Person(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
