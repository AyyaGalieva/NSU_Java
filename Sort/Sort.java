import java.io.*;
import java.util.*;

public class Sort {
    Map<String, Integer> hashmap = new HashMap<>();
    Integer n = 0;

    public void read(String file){
        InputStreamReader reader = null;
        try {
            FileInputStream fin = new FileInputStream(file);
            reader = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(reader);

            StringBuilder word = new StringBuilder();

            String line;
            while((line = br.readLine()) != null) {
                for (char c: line.toCharArray()) {
                    if (Character.isLetterOrDigit(c))
                        word.append(c);
                    else {
                        if (word.length() != 0) {
                            if (hashmap.containsKey(word.toString())) {
                                hashmap.put(word.toString(), hashmap.get(word.toString()) + 1);
                            }
                            else {
                                hashmap.put(word.toString(), 1);
                            }
                            word.setLength(0);
                            ++n;
                        }
                    }
                }
                word.setLength(0);
            }
            fin.close();
        }
        catch(IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    public void write(String file){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashmap.entrySet());

        Comparator<Map.Entry<String, Integer>> comp = new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        };

        Collections.sort(list, comp);
        try{
        FileWriter writer = new FileWriter(file);
        for (Map.Entry<String, Integer> pair: list) {
            writer.append(pair.getKey());
            writer.append(',');
            writer.append(pair.getValue().toString());
            writer.append(',');
            Float freq = ((float)pair.getValue()/n)*100;
            writer.append(freq.toString());
            writer.append('%');
            writer.append('\n');
            writer.flush();
        }
        writer.close();}
        catch(IOException e) {
            System.err.println("Error while writing to csv_file: " + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
        Sort s = new Sort();
        s.read(args[0]);
        s.write("out.csv");
    }
}