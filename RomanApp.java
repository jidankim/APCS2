import java.util.ArrayList;

public class RomanApp {

    // pre: size > 0, lower, upper
    // post: returns a list with size elements,
    // each element is a random roman object whose value is in [lower, upper)
    public static ArrayList<Roman> populate(int size, int lower, int upper) {
	ArrayList<Roman> a = new ArrayList<Roman>();
	int range = upper - lower;
	for (int i = 0; i < size; i++) {
	    Roman r = new Roman((int)(Math.random() * range) + lower);
	    a.add(r);
	}
	return a;
    }

    // pre: L.size() > 0
    // post: returns the minimum value
    public static Roman min(ArrayList<Roman> L) {
	Roman ret = L.get(0);
	for (Roman curr : L) {
	    if (ret.compareTo(curr) > 0)
		ret = curr;
	}
	return ret;
    }

    public static void main(String[] args) {
	ArrayList<Roman> romans = populate(5, 2, 100);
	System.out.println(romans);
	System.out.println("min: " + min(romans));
    }
}
