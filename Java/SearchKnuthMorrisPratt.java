//Knuth-Moriss-Pratt

import java.util.Scanner;

public class SearchKnuthMorrisPratt {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //искомая строка/текст/предложение
        String text;
        //строка для поиска
        String searchText;

        //ввод строк
        text = in.nextLine();
        searchText = in.nextLine();

        //нахождения подстроки в строке, по КМП
        checkKMP(text, searchText);
    }

    //нахождение префикс-фукнции строки
    public static int[] getPrefix(String text){
        //массив с префикс-функцией
        int[] tempPrefix;
        //длина строки
        int textLength;

        //проверяемая позиция
        int j;

        //длина строки
        textLength = text.length();
        //инициализация массива с префикс-функцией
        tempPrefix = new int[textLength];

        //начальное значение равно 0
        tempPrefix[0] = 0;

        //пробегаемся по всей строке
        for(int i = 1; i < textLength; i++){
            //проверяемая позиция равна предыдущему значению префикс-функции
            j = tempPrefix[i-1];

            //если искомая позиция строки не равна проверяемой, находим последнее актуальное значение
            //префикс-функции
            while(j > 0 && text.charAt(i) != text.charAt(j))
                j = tempPrefix[j-1];

            //если искомая позиция строки равна проверяемой, увеличиваем счетчик
            if(text.charAt(i) == text.charAt(j))
                ++j;

            //заносим итоговое значение в префикс-функцию
            tempPrefix[i] = j;
        }

        //возвращаем префикс-функцию
        return tempPrefix;
    }

    //нахождение подстроки в строке по Кнуту-Морису-Прату
    public static void checkKMP(String text, String searchText){
        //временная строка
        String temp;
        //префикс-функция
        int[] prefix;
        //длина подстроки, которую нужно найти
        int searchTextLength;
        //подстрока найдена или нет?
        boolean found;

        //создаем временную строку, соединив искомую строку и подстроку,
        //добавив между ними символ, который не должен встречаться ни у кого
        temp = searchText + "@" + text;

        searchTextLength = searchText.length();
        prefix = new int[temp.length()];
        found = false;

        //находим префикс-функцию от временной строки
        prefix = getPrefix(temp);

        //пробегаемся по префикс-функции и проверяем, есть ли значение
        //равное длине проверяемой подстроки.
        //если есть, значит подстрока входит в строку
        for(int i = 0; i < text.length(); i++)
            if (prefix[searchTextLength + 1 + i] == searchTextLength) {
                System.out.println("s[" + (i - searchTextLength + 1) + "..." + i + "] = searchText");

                found = true;
            }

        //если подстрока не входит в строку
        if(!found)
            System.out.println("Нет результатов");
    }

    //второй способ нахождения префикс-функции
    public static int[] getPrefix1(String text){
        //массив с префикс-функцией
        int[] tempPrefix;
        //длина проверяемой строки
        int textLength;

        //сопоставимые позиции строки
        int j;
        int i;

        textLength = text.length();
        tempPrefix = new int[textLength];

        //начальная инициализация
        tempPrefix[0] = 0;
        i = 1;
        j = 0;

        //пока не рассмотрели всю строку
        while(i < textLength){
            /* если сопоставимые позиции не равны, то:
            если позиция j больше 0, то находим последнее совпавшие символы,
            через префикс-функцию
            иначе, продолжаем рассматривать следующую позицию в строке */
            if(text.charAt(j) != text.charAt(i))
                if(j > 0)
                    j = tempPrefix[j-1];
                else
                    ++i;
            else{
                //если сопоставимые позиции равны, то продолжаем сравнивать позиции
                tempPrefix[i] = j + 1;
                ++i;
                ++j;
            }
        }

        //возвращаем префикс-функцию
        return tempPrefix;
    }
}
