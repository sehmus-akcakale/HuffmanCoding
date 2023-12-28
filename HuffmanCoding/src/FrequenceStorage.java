import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FrequenceStorage {
    private FNode head ;
    private class FNode{
        String id ;
        Integer frequence ;
        FNode nextStorage ;
        public FNode(String id, Integer frequence){
            this.id = id ;
            this.frequence = frequence;
            this.nextStorage = null;
        }
    }
    public FrequenceStorage(){
        head = null;
    }

    public static void loadDataToTheLinkedList(LinkedList linkedList , FrequenceStorage frequenceStorage){
        FNode iterator = frequenceStorage.head;
        while(iterator != null){
            TreeNode tree = new TreeNode(iterator.id, iterator.frequence);
            linkedList.sortedInsert(tree);
            iterator = iterator.nextStorage;
        }
    }

    public void findFrequences(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        String line ;
        while((line = bufferedReader.readLine()) != null){
            String[] characters = line.split("");
            for(String character : characters){
                if(containsKey(character)){
                    replace(character ,get(character) + 1) ;
                }else{
                    put(character , 1);
                }
            }
        }
    }
    private boolean containsKey(String character){
        FNode iterator = head;
        while(iterator != null) {
            if (iterator.id.equals(character)) {
                return true;
            }
            iterator = iterator.nextStorage;
        }
        return false;
    }
    private void put(String character , int value){
        FNode newNode = new FNode(character , value);
        if(head == null){
            head = newNode;
        }else{
            FNode iterator = head;
            while(iterator.nextStorage != null){
                iterator = iterator.nextStorage;
            }
            iterator.nextStorage = newNode;
        }
    }
    private int get(String id){
        FNode iterator = head;
        while(iterator != null){
            if(iterator.id.equals(id)){
                return iterator.frequence;
            }
            iterator = iterator.nextStorage;
        }
        // Means we couldnt find the id
        return -1;
    }
    private void replace(String id , int value){
        FNode iterator = head;
        while(iterator != null){
            if(iterator.id.equals(id)){
                iterator.frequence = value;
                return;
            }
            iterator = iterator.nextStorage;
        }
    }
    public void display(){
        FNode iterator = head;
        while(iterator != null){
            System.out.println(iterator.id + " -> " + iterator.frequence);
            iterator = iterator.nextStorage;
        }
    }
}
