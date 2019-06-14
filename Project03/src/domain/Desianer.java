package domain;

/**
 * @author java_fan
 * @create 2019-05-15 22:03
 */
public class Desianer extends Programmer  {
    private double bonus;

    public Desianer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t\t设计师\t"+getStatus()+"\t"+getBonus()+"\t\t\t"+getEquipment().getDescription();
    }

    @Override
    public String getDetailForTeam() {
        return getMemberId()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t"+"设计师"+"\t"+getBonus();
    }
}
