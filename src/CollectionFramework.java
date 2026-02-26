import java.util.HashMap;

public class CollectionFramework {
    public static void main(String[] args){
        HashMap<String,Integer> studentMarks = new HashMap<>();
        studentMarks.put("John" , 90);
        studentMarks.put("Aline" , 80);
        System.out.println(studentMarks);
        System.out.println("John's mark:" + studentMarks.get("John"));
    }
}
