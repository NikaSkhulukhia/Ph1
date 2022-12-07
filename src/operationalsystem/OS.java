package operationalsystem;

import exceptions.IncorrectOSVersionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OS {
    private static final Logger LOGGER = LogManager.getLogger();
    private String type;
    private int version; // greater or equal to zero, default 0;

    public OS(String type, int version) throws IncorrectOSVersionException {
        if (version < 0) {
            LOGGER.debug("OS version" + version);
            throw new IncorrectOSVersionException("OS version must be greater or equal to zero!", "OS version not correct");
        } else {
            this.type = type;
            this.version = version;
        }
    }

    public OS() {
    }

    // Reset software version to zero
    public void reset() {
        this.version = 0;
    }

    // increase software version by one
    public void update() {
        this.version++;
    }

    @Override
    public String toString() {
        return "PhoneSoftware.OS{" +
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

    public void setVersion(int version) throws IncorrectOSVersionException {
        if (version < 0) {
            LOGGER.debug("OS version" + version);
            throw new IncorrectOSVersionException("OS version must be greater or equal to zero!", "OS version not correct");
        } else {
            this.version = version;
        }
    }
}
