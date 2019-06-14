package domain;

import com.sun.xml.internal.bind.v2.model.core.ID;
import service.Status;

import javax.naming.Name;

/**
 * @author java_fan
 * @create 2019-05-15 21:48
 */
public class Programmer extends Employee  {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;


    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);

        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public Status getStatus() {
        return status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t\t程序员\t"+getStatus()+"\t\t\t\t\t"+equipment.getDescription();
    }

    public String getDetailForTeam() {
        return getMemberId()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t"+"程序员";
    }
}
