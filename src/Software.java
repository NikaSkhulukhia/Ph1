import java.util.IllformedLocaleException;

public class Software {
    private String type;
    Private int version; // greater or equal to zero, default 0;

    public Software(String type, int version) {
        if (version < 0) {
            throw new IllegalArgumentException("Version must be greater or equal to zero!");
        } else {
            this.type = type;
            this.version = version;
        }
    }

    public Software() {
    }

    // Reset software version to zero
    public void Reset() {
        this.version = 0;
    }

    // increase software version by one
    public void Update() {
        this.version++;
    }

    @Override
    public String toString() {
        return "Software{" +
                "type='" + type + '\'' +
                ", version=" + version +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        if (version < 0) {
            throw new IllegalArgumentException("Version must be greater or equal to zero!");
        } else {
            this.version = version;
        }
    }
}
