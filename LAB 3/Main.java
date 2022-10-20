import java.util.*;

public class Main {
    public static void main(String[] args) {
        manipulateLists lists = new manipulateLists();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random rand = new Random();
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        numbers.add(rand.nextInt(5));
        System.out.println(lists.destructive(numbers));

        ArrayList<Sort> text = new ArrayList<>();
        WordGen word = new WordGen();
        text.add(new Sort(word.make()));
        text.add(new Sort(word.make()));
        text.add(new Sort(word.make()));
        text.add(new Sort(word.make()));



        Sort comp = new Sort("");
        System.out.println(lists.constructive(text, comp));
        System.out.println(lists.constructive(numbers));
    }
}

class manipulateLists implements Comparable {

    public <E> List<E> destructive(List<E> list) {
        E temp = list.get(0);
        for (int i=0; i<list.size(); i++) {
            temp = list.get(i);
            for (int j=0; j<list.size(); j++) {
                if (temp.equals(list.get(j)) && i!=j) {
                    list.remove(j);
                    j=-1;
                }
            }
        }
        return list;
    }

    public <E> List<E> constructive(List<E> list, Comparator<E> comp) {
        Collections.sort(list, comp);
        return list;
    }

    public <E> List<E> constructive(List<E> list) {
        E temp = list.get(0);
        List<E> newList = new ArrayList<E>();
        for (int i=0; i<list.size(); i++) {
            temp = list.get(i);
            for (int j=0; j<list.size(); j++) {
                if (temp.equals(list.get(j))) {
                    newList.add(list.get(j));
                }
            }
        }
        quicksort(newList, 0, 0);
        return newList;
    }

    public <E> void quicksort(List<E> list, int left, int right) {
        int q;
        if (right > left) {
            q = partition(list, left, right);
            quicksort(list, left, q-1);
            quicksort(list, q+1, right);
        }
    }

    <E> int partition (List<E> list, int low, int high) {
        E pivot = list.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (compareTo(list.get(j)) <= compareTo(pivot)) {
                i++;
                E swapTemp = list.get(i);
                list.add(i, list.get(j));
                list.add(j, swapTemp);
            }
        }

        E swapTemp = list.get(i + 1);
        list.add(i + 1, list.get(high));
        list.add(high, swapTemp);

        return i + 1;

    }


    public int compareTo(Object val) {
        return 1;
    }
}

class Sort implements Comparator<Sort> {
    private String text;

    public Sort(String t) {
        this.text = t;
    }

    public int compare(Sort s1, Sort s2) {
        return s1.toString().compareTo(s2.toString());
    }

    public String toString() {
        return this.text;
    }
}