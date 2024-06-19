interface  Warda{
    default void show()
    {
        System.out.println("nknk");
    }
    void Fault();

}
class a implements  Warda
{
    public void Fault()
    {
        System.out.println("ss");
    }

}


public class test {
    public static void main(String[] args) {

    }
}
