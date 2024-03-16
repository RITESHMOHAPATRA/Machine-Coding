package org.ritesh.model;

import org.ritesh.enums.DeviceType;

public final class Device {
    private final String id;
    private final boolean isBetaVersionEnabled;
    private Version appVersion;
    private final DeviceType deviceType;
    private final Version oSVersion;

    public Device(String id, boolean isBetaVersionEnabled, Version appVersion, DeviceType deviceType, Version oSVersion) {
        this.id = id;
        this.isBetaVersionEnabled = isBetaVersionEnabled;
        this.appVersion = appVersion;
        this.deviceType = deviceType;
        this.oSVersion = oSVersion;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", isBetaVersionEnabled=" + isBetaVersionEnabled +
                ", appVersion=" + appVersion +
                ", deviceType=" + deviceType +
                ", oSVersion='" + oSVersion + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public boolean isBetaVersionEnabled() {
        return isBetaVersionEnabled;
    }

    public Version getAppVersion() {
        return appVersion;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public Version getoSVersion() {
        return oSVersion;
    }

    public void setAppVersion(Version version) {
        this.appVersion = version;
    }
}
