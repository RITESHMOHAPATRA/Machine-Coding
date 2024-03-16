package org.ritesh.model;

public final class AppMetaData {
    private final Version minimumSupportedAndroidVersion;
    private final Version minimumSupportedIOSVersion;

    public AppMetaData(Version minimumSupportedAndroidVersion, Version minimumSupportedIOSVersion) {
        this.minimumSupportedAndroidVersion = minimumSupportedAndroidVersion;
        this.minimumSupportedIOSVersion = minimumSupportedIOSVersion;
    }


    @Override
    public String toString() {
        return "AppMetaData{" +
                "minimumSupportedAndroidVersion='" + minimumSupportedAndroidVersion + '\'' +
                ", minimumSupportedIOSVersion='" + minimumSupportedIOSVersion + '\'' +
                '}';
    }

    public Version getMinimumSupportedAndroidVersion() {
        return minimumSupportedAndroidVersion;
    }

    public Version getMinimumSupportedIOSVersion() {
        return minimumSupportedIOSVersion;
    }
}