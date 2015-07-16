package josephus;

public class TestKlasse {

	public static void main(String[] args) {
		JosephusProblemloeser x = new JosephusProblemloeser(40000000,50000);
		System.out.println(x.getLastManStanding());
	}

}
