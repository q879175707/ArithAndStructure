package arithAndStruct.array.object;

public class ClassDataApp {
	public static void main(String[] args) {
		int max = 100;
		ClassDataArray arr = new ClassDataArray(max);
		
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		arr.insert("", "", 24);
		
		arr.displayA();
		String searchKey = "";
		Person found;
		found = arr.find(searchKey);
		if (found != null) {
			System.out.print("Found");
			found.displayPerson();
		} else 
			System.out.println("Can't find" + searchKey);
		
		System.out.println("Deleting ");
		arr.delete("");
		
		arr.displayA();
		
	}
}
