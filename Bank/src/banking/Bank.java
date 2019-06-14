package banking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �������ж���
 *
 * @author Think Pad
 */
public class Bank {

    private List<Customer> customers;


    private Bank() {
        customers = new ArrayList<>();
    }

    private static Bank instance = new Bank();

    public static Bank getBank() {
        return instance;
    }

    /**
     * @param firstName
     * @param lastName
     */
    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers.add(customer);
    }

    /**
     * ���� ��ʾ customers �������ж��ٸ������� Customer ���������
     *
     * @return
     */
    public int getNumOfCustomers() {
        return customers.size();
    }

    /**
     * ����ָ��������Ӧ�� Customer ����
     *
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    /**
     *
     * @return 获取cus list的迭代器
     */
    public Iterator<Customer> getCustomers(){
        return customers.iterator();
    }
}
