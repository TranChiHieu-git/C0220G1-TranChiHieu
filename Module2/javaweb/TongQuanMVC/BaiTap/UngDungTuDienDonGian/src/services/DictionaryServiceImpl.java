package services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    private static Map<String,String> mapWord =new HashMap<>();
    static {
        mapWord.put("hello","xin chao");
        mapWord.put("bye","tam biet");
        mapWord.put("school","truong hoc");
        mapWord.put("class","lop hoc");
        mapWord.put("market","cho");
        mapWord.put("super market","sieu thi");
        mapWord.put("water","nuoc");
        mapWord.put("banana","qua chuoi");
        mapWord.put("apple","qua tao");
        mapWord.put("people","con nguoi");
        mapWord.put("dog","con cho");
        mapWord.put("cat","con meo");
        mapWord.put("mouse","con chuot");
        mapWord.put("red","mau do");
        mapWord.put("yellow","mau vang");
        mapWord.put("white","mau trang");
        mapWord.put("blue","mau xanh");
    }
    @Override
    public String findWord(String word) {
        for (Map.Entry<String, String> entry : mapWord.entrySet()) {
            if (entry.getKey().equals(word)){
                return entry.getValue();
            }
        }
        return "Khong tim thay tu muon tra";
    }
}
