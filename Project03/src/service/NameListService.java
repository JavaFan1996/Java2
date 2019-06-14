package service;

import domain.*;

import static service.Data.*;

/**
 * @author java_fan
 * @create 2019-05-15 22:07
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    //程序员有设备，所以这里要给出设备，
                    Equipment equipment = CreatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    Equipment equipment1 = CreatEquipment(i);
                    employees[i] = new Desianer(id, name, age, salary, equipment1, bonus);
                    break;
                case ARCHITECT:
                    Equipment equipment2 = CreatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment2, bonus, stock);
                    break;
            }
        }

    }

    private Equipment CreatEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        switch (type) {
            case PC:
                Equipment equipment = new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
                return equipment;
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                Equipment equipment1 = new NoteBook(EQUIPMENTS[index][1], price);
                return equipment1;
            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
        }
        return null;

    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee e : employees) {
            if (e.getId() == id)
                return e;
        }
        throw new TeamException("该员工不存在");
    }


}
