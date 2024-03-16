package org.ritesh.service;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Device;

public interface AppService {
    void uploadNewVersion(AppVersionDetails appVersionDetails);
    String createUpdatePatch(AppVersionDetails oldVersion, AppVersionDetails newVersion);
    void releaseVersion(AppVersionDetails newVersion);
    boolean checkForInstall(Device device, AppVersionDetails appVersionDetails);
    boolean checkForUpdates(Device device, AppVersionDetails appVersionDetails);
}
