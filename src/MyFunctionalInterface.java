@FunctionalInterface
interface MyInterface {
    void performAction();
}

public class MyFunctionalInterface {
    public static void main(String[] args) {
        // Use a lambda expression to implement the single abstract method of the functional interface.
        MyInterface myLambda = () -> System.out.println("Performing an action using a lambda expression.");

        // Call the method using the lambda expression.
        myLambda.performAction();
    }
}