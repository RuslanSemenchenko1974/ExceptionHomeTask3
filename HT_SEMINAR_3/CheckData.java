import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class CheckData {
    
    public static String Sex  (ArrayList<String> list) throws RuntimeException {
        int flag = 0;
        int i = -1;
        int nam = 0;
        String rez = null;
       for (String item : list) { 
        i++; 
        //System.out.println(item);             
        if (item.equals("f") || item.equals("m")) {
            rez = item;
            flag++;
            nam = i;
        }
        }
        try {
        if (flag!=1){
            //System.out.println("");
            throw new RuntimeException("Sex Error");
        }
        } catch(RuntimeException e) { throw new RuntimeException("Введите корректно пол 'm' или 'f'");}
        list.remove(nam);
        
        //System.out.println(rez);
        //System.out.println(list);
        return rez; 
    }

    public static String TelNamber (ArrayList<String> list) throws RuntimeException{
        int flag = 0;
        int i = -1;
        int nam = 0;
        String rez = null;
        BigInteger telNamber = null;
        for (String item : list) {
            i++;
            try {
                telNamber = BigInteger.valueOf(Long.parseLong(item));// Integer.parseInt (item);
                rez = item;
                nam = i;
                flag++;
            } catch (NumberFormatException e) {
            //System.out.println(e);
            }
        }
         try {
        if (flag!=1){
            
            throw new RuntimeException("Phone Error");
        }
        } catch(RuntimeException e) { throw new RuntimeException("Введите корректно телефон");}
        list.remove(nam);
        return rez;
        //System.out.println(userDataRight[4]);
        //System.out.println(list);
    }

    public static String DateOfBirth (ArrayList<String> list) throws RuntimeException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int flag = 0;
        int i = -1;
        int nam = 0;
        String rez = null;
        for (String item : list) {
            i++;
            try {
                LocalDate localDate = LocalDate.parse(item, formatter);
                //System.out.println(localDate);
                rez = item;
                nam = i;
                flag++;
            } catch (Exception e) {
            //System.out.println(e);
            }
        }
        try {
        if (flag!=1){
            
            throw new RuntimeException("Phone Error");
        }
        } catch(RuntimeException e) { throw new RuntimeException("Введите корректно дату рождения");}
        list.remove(nam);
        return rez;

    }
    public static  void Name(ArrayList<String> list) throws RuntimeException{
        
        for (String item : list) {
           if (item.length()<=1){ throw new RuntimeException("Введите корректно ФИО");}
        }
       
    }
}
