public class CustomException {
    static class AgeException extends Exception {
        public AgeException(String message) {
            super(message);
        }
    }
    static void checkAge(int age) throws AgeException {
        if(age < 18) {
            throw new AgeException("You must be 18+");
        }else {
            System.out.println("Access granted.");
        }
    }
    public static void main(String[] args){
        try {
            checkAge(21);
        } catch (AgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println("Program continues normally.");
    }



}

