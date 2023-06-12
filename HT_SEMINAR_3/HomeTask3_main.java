
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


/**
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, 
разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
 */
public class HomeTask3_main {

    public static void main(String[] args) {
    boolean check2 = true;
    while(check2) {
      try {  

      /*
         * Приложение должно проверить введенные данные по количеству. 
         * Если количество не совпадает с требуемым, вернуть код ошибки, 
         * обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
         */
        String str = InputString.InputData();
        int count = 0;
        boolean check = true;
        do {
        
        if (count!=0) str = InputString.InputData();
        String[] userData = str.split(" ");

        try{
        if (userData.length == 6) { check = false;}
        else if (userData.length<6) {
            count++;
            throw new RuntimeException("Введено недостаточно данных");}
        else    { 
            count++;
            //System.out.println(userData.length);
            throw new RuntimeException("Введено больше данных");}

        }catch (Exception ex){
            System.out.println("Ошибка ввода! Попробуйте еще раз");
            System.out.println(ex);
        }
      
        } while(check);

        /* 
         * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
         * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
         * Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
         * пользователю выведено сообщение с информацией, что именно неверно.
        */
        String[] userDataProm = str.split(" ");
        String[] userDataRight = new String[6];
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(userDataProm));
       
    //************************************SEX********************************************************** */
     userDataRight[5] = CheckData.Sex(list);
  
//* ****************************************DateOfBirth************************************************************* */

    userDataRight[3] = CheckData.DateOfBirth(list);
    
/* ************************************PHONE*********************************************************** */
    userDataRight[4] = CheckData.TelNamber(list);

   
//* ********************************************NAME********************************************************** */
   CheckData.Name(list);
   for (int j = 0; j < 3; j++) {

    userDataRight[j] = list.get(j);
    
   }
   /*
    * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
    в него в одну строку должны записаться полученные данные, вида 
    <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
    */

   System.out.println("Вы ввели :");
   System.out.println("Фамилия :"+userDataRight[0]);
   System.out.println("Имя :"+userDataRight[1]);
   System.out.println("Отчество :"+userDataRight[2]);
   System.out.println("Дата рождения :"+userDataRight[3]);
   System.out.println("Телефон :"+userDataRight[4]);
   System.out.println("Пол :"+userDataRight[5]);

   check2 = false;
    FileWrite.WriteData(userDataRight);


} catch (Exception e) {
        check2 = true;
        System.out.println("INPUT DATA ERROR!");
        System.out.println(e);
    }   //try
} //while
}
}
