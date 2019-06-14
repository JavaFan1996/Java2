package domain;

/**
 * @author java_fan
 * @create 2019-05-15 22:06
 */
public class Architect extends Desianer  {
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+getStock()+"\t"+getEquipment().getDescription();
    }

    @Override
    public String getDetailForTeam() {
        return getMemberId()+"/"+getId()+"\t\t"+getName()+"\t"+getAge()+"\t\t"+getSalary()+"\t"+"架构师"+"\t"+getBonus()+"\t"+getStock();
    }
}
