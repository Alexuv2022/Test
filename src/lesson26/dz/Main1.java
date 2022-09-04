package lesson26.dz;

public class Main1 {
    public static void main(String[] args) {
        MultiMapImpt<String, String> phoneBook = new MultiMapImpt<>();

        phoneBook.put("�����", "+798734838438");
        phoneBook.put("�����", "+98734384444");
        phoneBook.put("�����", "+33333333");
        phoneBook.put("����", "+7985-533-43-22");
        phoneBook.put("�����", "+98836667890");
        phoneBook.put("�����", "+98811111111");

        System.out.println("����������� ���������� �����");
        phoneBook.print();

        System.out.println();
        // ������� ���������� �������� �� �����
        System.out.println("���������� �������� �� ����� \"�����\": " + phoneBook.countValues("�����"));
        System.out.println("���������� �������� �� ����� \"����\": " + phoneBook.countValues("����"));
        System.out.println();

        // �������� �� �����
        System.out.println("�������� �� ����� \"�����\"");
        phoneBook.valuesIterator("�����");
        phoneBook.valuesIterator("�����");
        phoneBook.valuesIterator("�����");
        phoneBook.valuesIterator("�����");
        phoneBook.valuesIterator("�����");
        System.out.println();

        // �������� ��������� �� null, ���� null, �� Yes
        System.out.println("�������� ��������� �� null, ���� null, �� Yes");
        if (phoneBook.valuesIterator("�����") == null) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println();
        System.out.println("��������� ����������� ������� �� ����� \"�����\"");
        System.out.println(phoneBook.get("�����"));

        System.out.println();
        // �������� ���� �������� �� ����� "�����"
        phoneBook.remove("�����");

        System.out.println("����������� ���������� ����� ����� �������� �������� �� ����� \"�����\"");
        phoneBook.print();
        System.out.println();

        System.out.println("��������� ����������� ������� �� ����� \"�����\" ��� ��������");
        System.out.println(phoneBook.get("�����"));
        System.out.println();

        // �������� ��������� �� ����� ��� �������� �� null, ���� null, �� Yes
        System.out.println("�������� ��������� �� ����� ��� �������� �� null, ���� null, �� Yes");
        if (phoneBook.valuesIterator("�����") == null) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println();
    }
}
