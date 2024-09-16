package cryptoapp;

import java.util.ArrayList;

public class Context {
    private final String FILE_INPUT;
    private final String FILE_OUTPUT;
    private final int SHIFT;
    private final boolean VALID;
    private final ArrayList<String> ERRORS_LIST;
    private final CryptoMethod CRYPTO_METHOD;


    public Context(
            String cryptoMethod,
            String fileInput,
            String fileOutput,
            int shift,
            boolean valid,
            ArrayList<String> errorsList
    ) {
        this.CRYPTO_METHOD = CryptoMethod.valueOf(cryptoMethod.toUpperCase());
        this.FILE_INPUT = fileInput;
        this.FILE_OUTPUT = fileOutput;
        this.SHIFT = shift;
        this.VALID = valid;
        this.ERRORS_LIST = errorsList;
    }

    public CryptoMethod getCryptoMethod() {
        return CRYPTO_METHOD;
    }

    public String getFileInput() {
        return FILE_INPUT;
    }

    public String getFileOutput() {
        return FILE_OUTPUT;
    }

    public int getShift() {
        return SHIFT;
    }

    public boolean isValid() {
        return VALID;
    }

    public ArrayList<String> getERRORS_LIST() {
        return ERRORS_LIST;
    }
}
