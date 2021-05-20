package P0058;

public class DictionaryMain {
    public static void main(String[] args) {
        DictionaryManager manager = new DictionaryManager();
        Validate validator = new Validate();
        manager.loadData("dictionary.txt");
        int option = 0;
        while (option != 4) {
            menu();
            option = validator.checkInputLimit(validator.sc.next());
            switch (option) {
                case 1:
                    System.out.println("--------- Add ---------");
                    String en = manager.getWord("English");
                    String vi = manager.getWord("Vietnamese");
                    if (manager.addWord(en, vi)) {
                        System.out.println("Successful");
                    } else {
                        System.out.print("Word existed, do you want to update word's meaning (Y/N): ");
                        if (validator.checkInputYN()) {
                            vi = manager.getWord("Vietnamese");
                            manager.addWord(en, vi);
                        }
                    }
                    break;
                case 2:
                    System.out.println("--------- Delete ---------");
                    System.out.println(manager.removeWord(manager.getWord("English")) ? "Successful" : "Failed");
                    break;
                case 3:
                    System.out.println("--------- Translate ---------");
                    vi = manager.translate(manager.getWord("English"));
                    System.out.println(vi.equals("") ? "This word does not exist in the dictionary" : vi);
                case 4:
                    break;
            }
        }
        manager.updateDatabase("dictionary.txt");

    }

    public static void menu() {
        System.out.println("======== Dictionary program ========");
        System.out.println("1. Add Word");
        System.out.println("2. Delete Word");
        System.out.println("3. Translate");
        System.out.println("4. Exit");
        System.out.print("Your option: ");
    }
}
