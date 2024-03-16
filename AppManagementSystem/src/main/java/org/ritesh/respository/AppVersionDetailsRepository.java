package org.ritesh.respository;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Version;

public interface AppVersionDetailsRepository {
    void uploadNewVersion(AppVersionDetails appVersionDetails);
    Version getLatestVersion();
}