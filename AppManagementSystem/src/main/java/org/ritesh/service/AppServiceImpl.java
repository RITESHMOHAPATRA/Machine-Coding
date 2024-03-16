package org.ritesh.service;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Device;

public class AppServiceImpl implements AppService{
    @Override
    public void uploadNewVersion(AppVersionDetails appVersionDetails) {

    }

    @Override
    public String createUpdatePatch(AppVersionDetails oldVersion, AppVersionDetails newVersion) {
        return null;
    }

    @Override
    public void releaseVersion(AppVersionDetails newVersion) {

    }

    @Override
    public boolean checkForInstall(Device device, AppVersionDetails appVersionDetails) {
        return false;
    }

    @Override
    public boolean checkForUpdates(Device device, AppVersionDetails appVersionDetails) {
        return false;
    }
}
