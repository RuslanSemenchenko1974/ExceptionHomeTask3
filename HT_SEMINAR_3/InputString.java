
import java.util.Scanner;

public class InputString {
    
    
    public  static String InputData() {
        Boolean check = true;
        String str = "";
        
        while(check){
    try{
        Scanner  scan = new Scanner(System.in);
        System.out.print("Введите ФИО, Телефон, Дату рождения dd-MM-yyyy, пол ('f','m'): ");
        str = scan.nextLine();
        if (str.isEmpty()) {
            //System.out.println("Empty string");
            throw new RuntimeException("Empty string");
        } 
            return str;}
        
    catch (Exception ex){
        System.out.println("Ошибка ввода! Попробуйте еще раз");
        System.out.println(ex);
        }
        }
        return str;
    } 

}

