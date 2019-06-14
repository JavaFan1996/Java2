package service;

import domain.Architect;
import domain.Desianer;
import domain.Employee;
import domain.Programmer;

/**
 * @author java_fan
 * @create 2019-05-16 0:39
 */
public class TeamService {
    /**
     * 用于制作TID
     * 最多团员
     * 存放团队成员的team数组
     * 记录团队的实际人数
     */
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;


    public Programmer[] getTeam() {
        Programmer[] test = new Programmer[total];
        for (int i = 0; i < total; i++) {
            test[i] = team[i];
        }
        return test;
    }

    public void addMember(Employee e) throws TeamException {
//		成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
//		该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//		该员工已在本开发团队中
        if (isExist((Programmer) e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
//		该员工已是某团队成员
//		该员正在休假，无法添加
        Programmer p = (Programmer) e;//一定不会出现ClassCastException
//        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {//if(p.getStatus().getNAME().equals("BUSY")){
//            throw new TeamException("该员工已是某团队成员");
//        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//            throw new TeamException("该员正在休假，无法添加");
//        }
        switch (p.getStatus()){
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VACATION:
                throw new TeamException("该员工在休假");


        }

//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员

        //获取team已有成员中架构师，设计师，程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Desianer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        //正确的
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Desianer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //错误的
//		if(p instanceof Architect && numOfArch >= 1){
//			throw new TeamException("团队中至多只能有一名架构师");
//		}else if(p instanceof Designer && numOfDes >= 2){
//			throw new TeamException("团队中至多只能有两名设计师");
//		}else if(p instanceof Programmer && numOfPro >= 3){
//			throw new TeamException("团队中至多只能有三名程序员");
//		}


        //将p（或e）添加到现有的team中
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) {
                return true;
            }

        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {

            int i = 0;
            for (; i < total; i++) {
                if (team[i].getMemberId() == memberId) {
                    team[i].setStatus(Status.FREE);
                    break;
                }
            }

            //未找到指定memberId的情况
            if (i == total) {
                throw new TeamException("找不到指定memberId的员工，删除失败");
            }


            //后一个元素覆盖前一个元素，实现删除操作
            for (int j = i + 1; j < total; j++) {
                team[j - 1] = team[j];
            }

            //写法一：
//		team[total-1] = null;
//		total--;
            //写法二：
            team[--total] = null;


        }
    }


