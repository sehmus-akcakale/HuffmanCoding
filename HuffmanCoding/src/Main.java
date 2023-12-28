
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // Part 1 (Finding frequencies of given text)
        System.out.println("Part 1 :");
        FrequenceStorage frequenceStorage = new FrequenceStorage();
        frequenceStorage.findFrequences("letter.txt");
        frequenceStorage.display();

        // Part 2 (Keep the trees in the sorted linked list)
        System.out.println("Part 2 : ");
        LinkedList linkedList = new LinkedList();
        FrequenceStorage.loadDataToTheLinkedList(linkedList,frequenceStorage);
        System.out.println(linkedList.length());
        linkedList.display();

        // Part 3 (Construct Huffman Tree)
        System.out.println("Part 3 : ");
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffmanTree(linkedList);
        System.out.println(huffmanTree.huffmanTree.frequence);

        // Part 4 (Find the code of every  character and display them)
        System.out.println("Part 4 : ");
        CodeStorage codes = huffmanTree.findAllCharacterCodes();
        codes.display();

        // Part 5 (Encode the given source.txt)
        System.out.println("Part 5 : ");
        huffmanTree.encodeHuffmanTree("source.txt" ,"encoded.txt",codes);

        // Part 6 (Decode a given encoded.txt)
        System.out.println("Part 6 : ");
        huffmanTree.decodeHuffmanTree("encoded.txt","decoded.txt");
    }
}