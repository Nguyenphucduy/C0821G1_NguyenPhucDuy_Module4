package dictionary.entity;

public class Dictionary {
    private String word;
    private String means;

    public Dictionary(String word, String means) {
        this.word = word;
        this.means = means;
    }

    public Dictionary() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }
}
