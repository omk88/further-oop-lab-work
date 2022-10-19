public class Ex2 {

    private String name;
    private String status;

    public Ex2(String personName, int age) {
        name = personName;

        if (age < 65) status = " is of working age";
        else status = " is of retirement age";
    }
    public String getValues(){
        return ""+name+status;
    }
    public static void main(String arg[]){ // you can use the main method to test your code
        System.out.println((new Ex2("John",80)).getValues());
    }
}
