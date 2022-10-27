import java.util.*;

class Biggest
{
    public static <E> E biggest (List<E> list, Comparator<? super E> comp)
    // Returns the largest element of list according to the natural order of
    // its element type.  If there are more than one which are equally the
    // largest, returns the lowest indexed.
    {
        E biggest = list.get(0);
        for (int i=1; i<list.size(); i++) {
            E next = list.get(i);
            if (comp.compare(next,biggest)>0) { biggest = next; }
        }
        return biggest;
    }

    public static <E> Collection<E> listBiggest(Collection<E> list, Comparator<? super E> comp)
    // Returns the largest element of list according to the natural order of
    // its element type as an ArrayList containig just that item.
    // If there are more than one which are equally the largest, returns
    // them all in an ArrayList ordered by their position in list..
    {
        Iterator<E> iterator1 = list.iterator();
        E biggest = iterator1.next();
        ArrayList<E> bigList = new ArrayList<E>();
        bigList.add(biggest);
        for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
            E next=iterator.next();
            if(comp.compare(next,biggest)<0)
            {
                biggest=next;
                bigList = new ArrayList<E>();
                bigList.add(biggest);
            }
            else if(comp.compare(next,biggest)==0)
                bigList.add(next);
        }
        return bigList;
    }

}