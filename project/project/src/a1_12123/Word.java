package engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    public  static Set<String> stopWords;
    private final String prefix;
    private final String text;

    private final String suffix;

    public Word(String prefix, String text, String suffix) {
        this.prefix = prefix;
        this.text = text;
        this.suffix = suffix;
    }

    private boolean isValid(){
        return text.matches("[a-zA-Z]+(?:[-'][a-zA-Z]+)*");
    }

    public boolean isKeyword(){
        return !stopWords.contains(text) && isValid();
    }

    public String getPrefix(){
        return this.prefix;
    }

    public String getSuffix(){
        return this.suffix;
    }

    public String getText(){
        return this.text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return  false;

        Word word = (Word) obj;

        return text.equals(word.text) && prefix.equals(word.prefix) && suffix.equals(word.suffix);
    }

    @Override
    public String toString() {
        return prefix + text + suffix;
    }

    public static Word createWord(String rawText){
        if (rawText == null || rawText.isEmpty()) {
            return new Word("", "", "");
        }

        Pattern pattern = Pattern.compile("^([^a-zA-Z0-9]*)([a-zA-Z]+(?:[-'][a-zA-Z]+)*)(['s'd]*)([^a-zA-Z0-9]*)$");
        Matcher matcher = pattern.matcher(rawText);

        if (matcher.matches()) {
            String prefix = matcher.group(1);
            String text = matcher.group(2);
            String suffix = matcher.group(3) + matcher.group(4);
            return new Word(prefix, text, suffix);
        }

        return new Word("", rawText, "");
    }

    public static boolean LoadStopWords(String fileName){

            try {
                stopWords = new HashSet<>(Files.readAllLines(Paths.get(fileName)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return true;
    }
}
