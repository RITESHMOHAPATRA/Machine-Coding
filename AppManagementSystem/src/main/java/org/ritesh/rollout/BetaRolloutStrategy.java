package org.ritesh.rollout;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Device;
import org.ritesh.respository.DeviceRepository;
import org.ritesh.util.AppUtil;

public class BetaRolloutStrategy implements RolloutStrategy {

    private final DeviceRepository deviceRepository;

    public BetaRolloutStrategy(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void rollout(AppVersionDetails appVersionDetails) {
        System.out.println(deviceRepository.getAllDevices());
        deviceRepository
                .getAllDevices()
                .stream()
                .filter(Device::isBetaVersionEnabled)
                .forEach( d -> {
                    String diff = AppUtil.createDiffPack(d.getAppVersion(), appVersionDetails.getVersion());
                    deviceRepository.update(d, appVersionDetails, diff);
                });
    }

}
