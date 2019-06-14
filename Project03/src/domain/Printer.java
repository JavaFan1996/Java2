package domain;

/**
 * @author java_fan
 * @create 2019-05-15 21:52
 */
public class Printer implements Equipment {
    private String name;
    private String type;


    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
