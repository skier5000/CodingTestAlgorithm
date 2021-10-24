package Programmers.Challenge;

public class SampleClass {
    public void addAndStore(int i, int j) {
        i = 1 + j;
        System.out.println("i = " + i);
    }

}

class Sample {
    public static void main(String[] args) {
        SampleClass aClass = new SampleClass();
        int nut = 20;

        aClass.addAndStore(nut, 5);
        System.out.println(nut);
    }
}
