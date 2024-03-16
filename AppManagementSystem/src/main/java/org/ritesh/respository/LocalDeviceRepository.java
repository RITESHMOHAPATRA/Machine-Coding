package org.ritesh.respository;

import org.ritesh.enums.DeviceType;
import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Device;
import org.ritesh.model.Version;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDeviceRepository implements DeviceRepository {

    private final Map<String, Device> deviceCache;

    public LocalDeviceRepository() {
        this.deviceCache = new HashMap<>();
    }
    @Override
    public void update(Device device, AppVersionDetails appVersionDetails, String diff) {
        if (!checkForInstall(device, appVersionDetails)) {
            System.out.println("Cannot update to version " + appVersionDetails.getVersion().toString() + " because OS version is not supported for device id " + device.getId());
            return;
        }
        if (deviceCache.containsKey(device.getId())) {
            Device deviceToUpdate = deviceCache.get(device.getId());
            deviceToUpdate.setAppVersion(appVersionDetails.getVersion());
            System.out.println("Device " + device.getId() + " is successfully updated with app version " + appVersionDetails.getVersion() + " and diff " + diff);
        } else {
            device.setAppVersion(appVersionDetails.getVersion());
            deviceCache.put(device.getId(), device);
            System.out.println("Device " + device.getId() + " is successfully installed with app version " + appVersionDetails.getVersion() + " and diff " + diff);
        }
    }

    @Override
    public void addDevice(Device device) {
        deviceCache.putIfAbsent(device.getId(), device);
    }

    @Override
    public boolean checkForInstall(Device device, AppVersionDetails appVersionDetails) {
        if (device.getDeviceType() == DeviceType.IOS) {
            Version minOSVersion = appVersionDetails.getAppMetaData().getMinimumSupportedIOSVersion();
            Version osVersion = device.getoSVersion();
            return minOSVersion.getMajorVersion() <= osVersion.getMajorVersion() &&
                    minOSVersion.getMinorVersion() <= osVersion.getMinorVersion() &&
                    minOSVersion.getPatchVersion() <= osVersion.getPatchVersion();
        } else if (device.getDeviceType() == DeviceType.ANDROID) {
            Version minOSVersion = appVersionDetails.getAppMetaData().getMinimumSupportedAndroidVersion();
            Version osVersion = device.getoSVersion();
            return minOSVersion.getMajorVersion() <= osVersion.getMajorVersion() &&
                    minOSVersion.getMinorVersion() <= osVersion.getMinorVersion() &&
                    minOSVersion.getPatchVersion() <= osVersion.getPatchVersion();
        }
        return false;
    }

    @Override
    public boolean checkForUpdates(Device device, AppVersionDetails appVersionDetails) {
        return false;
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceCache.values().stream().toList();
    }
}
