
package adapter.blockchain.blockchain.service;

public class TransactionBlob {
    private String hash;
    private String hexBlob;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHexBlob() {
        return hexBlob;
    }

    public void setHexBlob(String hexBlob) {
        this.hexBlob = hexBlob;
    }
}
