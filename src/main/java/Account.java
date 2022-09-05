public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if(!checkNameLength()){
            System.out.println("Имя должно содержать не менее 3 и не более 19 символов");
            return false;
        }
        if(checkNameStartsWith()){
            System.out.println("Имя не может начинаться с пробела");
            return false;
        }
        if(checkNameEndsWith()){
            System.out.println("Имя не может заканчиваться пробелом");
            return false;
        }
        if(!checkNameWhitespace()){
            System.out.println("В имени может содержаться только один пробел");
            return false;
        }
        return true;
    }

    private boolean checkNameLength(){
        return name.length() >= 3 & name.length() < 20;
    }

    private boolean checkNameWhitespace(){
        int whitespaceInName = name.length() - name.replaceAll(" ", "").length();
        return (whitespaceInName == 1)? true : false;
    }

    private boolean checkNameStartsWith(){
        return name.startsWith(" ");
    }

    private boolean checkNameEndsWith(){
        return name.endsWith(" ");
    }
}
