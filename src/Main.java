import java.util.Scanner;
public class Main {
    public static void main(String[] args)  throws Exception {
        Scanner scanner = new Scanner(System.in);
        String ex = scanner.nextLine();  // Чтение с консоли
        char action;
        String[] data;
        if
        (ex.contains(" - ")) {
            data = ex.split(" \\- ");
            action = '-';
        }  else if
        (ex.contains(" + ")) {
            data = ex.split(" \\+ ");
            action = '+';
        } else  if
        (ex.contains(" / ")) {
            data = ex.split(" \\/ ");
            action = '/';
        }  else if
        (ex.contains(" * ")) {
            data = ex.split(" \\* ");
            action = '*';
        }else{    // 8-24 строки проверяем знак
            throw new Exception("Некорректный знак действия");
        }  // ошибка при вводе других знаков
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        } /* если знак * или / то ниже прописываем,
         что второе выражение должно быть числом (без кавычек), иначе исключение */
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", ""); // убыраем кавычки в процессе действий)
        }
        if (action == '+') {
            writeInQuotes(data[0] + data[1]); //сложение строк
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){ // если в первом выражений нет того что отнимаем, то выводим первое выражение
                writeInQuotes(data[0]);
            } else if (action == '*') {
                int N = Integer.parseInt(data[1]);
                String result = "";
                for (int i = 0; i < N; i++) {  // повторяем строку N раз
                    result+=data[0];
                }
                writeInQuotes(result);
            }else{
                String result = data[0].substring(0, index); // отнимать с того индекса где наблюдается схожесть
                result+=data[0].substring(index+data[1].length());
                // прибавляем к результату длину текст ( пример от "501" отнять "0" = "51"
                writeInQuotes(result);
            }
        }else{
            int division = data[0].length()/Integer.parseInt(data[1]);
            // длину первого выражения делим на второе выражение
            String result = data[0].substring(0,division);
            writeInQuotes(result);
        }
    }
    static void writeInQuotes(String generalexpression){
        System.out.println("\""+generalexpression+"\""); // выводим результат
    }
}