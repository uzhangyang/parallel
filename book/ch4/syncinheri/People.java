package book.ch4.syncinheri;

public class People {

    String name;

    People(String name){
        this.name = name;
    }

    public synchronized String getName(){
        return name;
    }

}
