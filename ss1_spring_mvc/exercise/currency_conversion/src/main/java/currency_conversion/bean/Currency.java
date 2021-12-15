package currency_conversion.bean;

public class Currency {
    private int usd;
    private int vnd;

    public Currency(int usd, int vnd) {
        this.usd = usd;
        this.vnd = vnd;
    }

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public int getVnd() {
        return vnd;
    }

    public void setVnd(int vnd) {
        this.vnd = vnd;
    }
}
