package org.ritesh.respository;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Device;

import java.util.List;

public class LocalDeviceRepository implements DeviceRepository {
    @Override
    public void update(Device device, AppVersionDetails appVersionDetails, String diff) {

    }

    @Override
    public void addDevice(Device device) {

    }

    @Override
    public boolean checkForInstall(Device device, AppVersionDetails appVersionDetails) {
        return false;
    }

    @Override
    public boolean checkForUpdates(Device device, AppVersionDetails appVersionDetails) {
        return false;
    }

    @Override
    public List<Device> getAllDevices() {
        return null;
    }
}
