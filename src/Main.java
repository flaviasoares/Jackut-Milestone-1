import easyaccept.EasyAccept;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "ISO-8859-1");

        String[] args2 = {"br.ufal.ic.p2.jackut.Facade",
                "tests/us1_1.txt", "tests/us1_2.txt",
                "tests/us2_1.txt", "tests/us2_2.txt",
                "tests/us3_1.txt", "tests/us3_2.txt",
                "tests/us4_1.txt", "tests/us4_2.txt",
        };
        EasyAccept.main(args2);
    }
}