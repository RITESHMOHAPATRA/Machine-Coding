package org.ritesh.respository;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Version;

import java.util.HashMap;
import java.util.Map;


public class LocalAppVersionDetailsRepository implements AppVersionDetailsRepository{

    private Version LATEST_VERSION = null;

    private final Map<String, AppVersionDetails> appCache;

    public LocalAppVersionDetailsRepository() {
        this.appCache = new HashMap<>();
    }

    @Override
    public void uploadNewVersion(AppVersionDetails appVersionDetails) {
        validate(appVersionDetails);
        appCache.put(appVersionDetails.getVersion().toString(), appVersionDetails);
        LATEST_VERSION = appVersionDetails.getVersion();
        System.out.println("App with version " + appVersionDetails.getVersion() + " is successfully uploaded");
    }

    private void validate(AppVersionDetails appVersionDetails) {
        if (appVersionDetails == null) {
            throw new IllegalArgumentException("Can't upload new version because AppVersionDetails is null");
        }
        if (appVersionDetails.getVersion() == null) {
            throw new IllegalArgumentException("Can't upload new version because app version is null");
        }
        if (appVersionDetails.getAppMetaData() == null) {
            throw new IllegalArgumentException("Can't upload new version because app metadata is null");
        }
        if (appVersionDetails.getFile() == null) {
            throw new IllegalArgumentException("Can't upload new version because app file is null");
        }
        if (appCache.containsKey(appVersionDetails.getVersion().toString())) {
            throw new IllegalArgumentException("App with this version is already uploaded");
        }
    }

    @Override
    public Version getLatestVersion() {
        return LATEST_VERSION;
    }
}
