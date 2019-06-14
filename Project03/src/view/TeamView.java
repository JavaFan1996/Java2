package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

/**
 * @author java_fan
 * @create 2019-05-16 23:38
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();


    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = '0';
        while (loopFlag) {
            if (menu != '1') {
                listALlEmployees();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
//
                    addMember();
                    break;
                case '3':
                    deleteMenber();
                    break;
                case '4':
                    System.out.print("确认是否退出（Y/N）:");
                    char key = TSUtility.readConfirmSelection();
                    if (key == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }

        }


    }


    private void listALlEmployees() {
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] allEmployees = listSvc.getAllEmployees();
        if (allEmployees.length == 0) {
            System.out.println("没有员工信息");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        }
        for (int i = 0; i < allEmployees.length; i++) {
            //此时没有重写toString 方法就直接输出地址值
            System.out.println(allEmployees[i]);
        }

    }


    private void getTeam() {
        System.out.println("查看开发团队情况");

        System.out.println("--------------------团队成员列表---------------------\n");

        Programmer[] team = teamSvc.getTeam();
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
        for (int i = 0 ;i <team.length;i++){
            System.out.println(team[i].getDetailForTeam());
        }

    }

    private void addMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，失败的原因："+e.getMessage());
        }
        TSUtility.readReturn();

    }


    private void deleteMenber() {

        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int memberId = TSUtility.readInt();

        System.out.print("确认是否删除(Y/N)：");
        char isDelete = TSUtility.readConfirmSelection();
        if(isDelete == 'N'){
            return;
        }

        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        //按回车键继续...
        TSUtility.readReturn();
    }


    public static void main(String[] args) {
        TeamView View = new TeamView();
        View.enterMainMenu();
    }


}
