package org.ritesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

public final class AppVersionDetails {
    private final Version version;
    private final byte[] file;
    private final AppMetaData appMetaData;


    public AppVersionDetails(Version version, byte[] file, AppMetaData appMetaData) {
        this.version = version;
        this.file = file;
        this.appMetaData = appMetaData;
    }

    @Override
    public String toString() {
        return "AppVersionDetails{" +
                "version='" + version + '\'' +
                ", file=" + Arrays.toString(file) +
                ", appMetaData=" + appMetaData +
                '}';
    }

    public Version getVersion() {
        return version;
    }

    public byte[] getFile() {
        return file;
    }

    public AppMetaData getAppMetaData() {
        return appMetaData;
    }
}