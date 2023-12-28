import java.io.*;

public class HuffmanTree{
    public TreeNode huffmanTree ;

    public HuffmanTree(){
        huffmanTree = null;
    }

    public void createHuffmanTree(LinkedList linkedList){
        while(linkedList.length() > 1){
            Node first = linkedList.removeFirst();
            Node second = linkedList.removeFirst();
            TreeNode left = first.tree;
            TreeNode right = second.tree;
            TreeNode total = new TreeNode(null , right.frequence + left.frequence);
            total.left = left;
            total.right = right;
            linkedList.sortedInsert(total);
        }
        huffmanTree = linkedList.getFirst().tree;
    }
    public CodeStorage findAllCharacterCodes() {
        return findAllCharacterCodes(huffmanTree, "" , new CodeStorage());
    }

    private CodeStorage findAllCharacterCodes(TreeNode huffmanTree, String code , CodeStorage codes) {
        if (huffmanTree == null) {
            return codes;
        }
        // Preorder traversal
        if (huffmanTree.charachter != null) {
            codes.put(huffmanTree.charachter , code);
        }

        findAllCharacterCodes(huffmanTree.left, code + "0" , codes);
        findAllCharacterCodes(huffmanTree.right, code + "1" , codes);
        return codes;
    }

    public void encodeHuffmanTree(String inputPath,String outputPath , CodeStorage codes) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        String line ;
        while((line = bufferedReader.readLine()) != null){
            String[] charachters = line.split("");
            for(String character : charachters){
                if(codes.get(character) != null){
                    bufferedWriter.write(codes.get(character));
                }
            }
            bufferedWriter.write("\n");
        }
        System.out.println("Encoding Completed");
        bufferedWriter.close();
    }
    public void decodeHuffmanTree(String inputPath , String outputPath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        String line ;
        while((line = bufferedReader.readLine()) != null){
            String[] zerosAndOnes = line.split("");
            TreeNode iteratorNode = huffmanTree;
            for(String val : zerosAndOnes){
                // Which direction iterator will move on
                if(val.equals("0")){
                    iteratorNode = iteratorNode.left;
                }else{
                    iteratorNode = iteratorNode.right;
                }
                // Writing the character
                if(iteratorNode.charachter != null){
                    bufferedWriter.write(iteratorNode.charachter);
                    iteratorNode = huffmanTree;
                }
            }
            bufferedWriter.write("\n");
        }
        System.out.println("Decoding Completed");
        bufferedWriter.close();
    }
}






