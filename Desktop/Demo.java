import java.util.*;

/*
 * WORDS ARE SORTED FREQUENCY WISE.
 * IF FREQUENCY IS SAME THEN WORDS ARE SORTED ALPHABETICALLY.
 */

class Foo{
  String name;
  int freq;

  public Foo(String name){
    this.name = name;
    this.freq = 1;
  }
}
public class Demo{
  public static void main(String[] args) {
      ArrayList <Foo> al = new ArrayList < >();
      int index = 0;
      HashMap <String, Integer> hm = new HashMap < > ();
      String[] names = {"ac", "ba", "c", "ab", "aa", "ab", "bb", "bb","ac"};
      for(int i = 0; i < names.length; i++){
        String str = names[i];
        if(hm.containsKey(str)){
          int ind = hm.get(str);
          al.get(ind).freq += 1;
        }
        else{
          al.add(new Foo(str));
          hm.put(str, index);
          index++;
        }
      }

      Collections.sort(al, new Comparator <Foo>(){
        public int compare(Foo o1, Foo o2){
          if(o1.freq < o2.freq)
            return -1;
          else if (o1.freq > o2.freq)
            return 1;
          else{
            if(o1.name.compareTo(o2.name) < 0)
              return -1;
            else
              return 1;
          }
        }
      });

      for(Foo x : al)
        System.out.println(x.name+" "+x.freq);
  }
}
