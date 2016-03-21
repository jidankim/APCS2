public class ScoresArray {
    
    private GameEntry[] _scores;

    // pre: n > 0, n represents the size of the array
    // post: there are n GameEntries stored.
    public ScoresArray(int n) {
	_scores = new GameEntry[n];
	for (int i = 0; i < n; i++) {
	    _scores[i] = new GameEntry();
	}
    }

    public ScoresArray() {
	this(10);
    }

    // O(n)
    // post: returns true if the entry is added.
    //       returns false otherwise
    //       if the entry is added, the entries 
    //       with a lower rank are shifted down
    public boolean add(GameEntry entry) {
	int pos = numScores() - 1;
	if (entry.compareTo(_scores[pos]) < 0)
	    return false;
	else {
	    for (pos = numScores()-2; pos >= 0; pos--) {
		if (entry.compareTo(_scores[pos]) > 0)
		    break;
	    }
	    GameEntry tempIn = entry;
	    GameEntry tempOut = _scores[pos+1];
	    for (int i = pos+1; i < numScores()-1; i++) {
		_scores[i] = tempIn;
		tempOut = _scores[i+1];
		tempIn = tempOut;
	    }
	}
	return true;
    }

    public GameEntry topEntry() {
	return _scores[0];
    }
    
    public int numScores() {
	return _scores.length;
    }

    public String toString() {
	String ans = "Rank\tInitials\tScore\n";
	for (int i = 0; i < numScores(); i++) {
	    ans += (i+1) + ".\t" + _scores[i] + "\n";
	}
	return ans;
    }

    public static void main(String[] args) {
	ScoresArray s = new ScoresArray(5);
	System.out.println("scores: " + s.numScores());
	System.out.println("top entry: " + s.topEntry());
	System.out.println(s);
    }

}