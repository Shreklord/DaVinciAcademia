import java.util.UUID;

public class customUUID {

    //I made this just so we had quick methods of getting UUID's
    // We might not need it if we just put it in the code everytime we need a new one.
    public String createUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }

}
