package operationalsystem;

import enums.OSType;
import exceptions.IncorrectOSVersionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class OS {
    private static final Logger LOGGER = LogManager.getLogger();
    private OSType type;
    private int version; // greater or equal to zero, default 0;

    public OS(OSType type, int version) throws IncorrectOSVersionException {
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
        version = 0;
    }

    // increase software version by one
    public void update() {
        version++;
    }

    @Override
    public String toString() {
        return "PhoneSoftware.OS{" +
                "type='" + type + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        OS os = (OS) o;
        return version == os.version && Objects.equals(type, os.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, version);
    }

    public OSType getType() {
        return type;
    }

    public void setType(OSType type) {
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
