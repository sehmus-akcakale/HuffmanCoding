public class CodeStorage {
    private CNode head;

    private class CNode{
        String id ;
        String code;
        CNode nextStorage ;
        private CNode(String id, String code){
            this.id = id;
            this.code = code;
            this.nextStorage = null;
        }
    }
    public CodeStorage(){
        head = null;
    }
    public void put(String id, String code){
        CNode newNode = new CNode(id , code);
        if(head == null){
            head = newNode;
        }else{
            CNode iterator = head;
            while(iterator.nextStorage != null){
                iterator = iterator.nextStorage;
            }
            iterator.nextStorage = newNode;
        }
    }
    public void display(){
        if(head == null){
            return;
        }else{
            CNode iterator = head;
            while(iterator != null){
                System.out.println(iterator.id + " -> " + iterator.code);
                iterator = iterator.nextStorage;
            }
        }
    }
    public String get(String character){
        CNode iterator = head;
        while(iterator != null){
            if(iterator.id.compareTo(character) == 0){
                return iterator.code;
            }
            iterator = iterator.nextStorage;
        }
        return null;
    }

}
