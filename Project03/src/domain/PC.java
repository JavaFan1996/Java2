package domain;

/**
 * @author java_fan
 * @create 2019-05-15 21:51
 */
public class PC implements Equipment {

    private String model;
    private String display;


    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public String getDisplay() {
        return display;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
