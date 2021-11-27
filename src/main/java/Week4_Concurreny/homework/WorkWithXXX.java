package Week4_Concurreny.homework;

public class WorkWithXXX {

//    public static void main(String[] args) {
//
//
//
//    }

    public WorkWithXXX()
    {
        value = 0;
    }


    public WorkWithXXX(int i)
    {
        value = i;
    }
    private  int value = 0;
    public int add(int i)
    {
        return value = value +i;
    }

    @Override
    public String toString() {
        return "WorkWithXXX{" +
                "value=" + value +
                '}';
    }
}
