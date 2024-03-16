package org.ritesh.service;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Device;
import org.ritesh.respository.AppVersionDetailsRepository;
import org.ritesh.respository.DeviceRepository;
import org.ritesh.rollout.RolloutStrategy;

public class AppServiceImpl implements AppService{

    private final AppVersionDetailsRepository appVersionDetailsRepository;
    private final RolloutStrategy rolloutStrategy;
    private final DeviceRepository deviceRepository;

    public AppServiceImpl(AppVersionDetailsRepository appVersionDetailsRepository, RolloutStrategy rolloutStrategy, DeviceRepository deviceRepository) {
        this.appVersionDetailsRepository = appVersionDetailsRepository;
        this.rolloutStrategy = rolloutStrategy;
        this.deviceRepository = deviceRepository;
    }
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
